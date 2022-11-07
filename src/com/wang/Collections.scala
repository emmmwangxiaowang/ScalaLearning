package com.wang

import scala.collection.{immutable, mutable}
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Set
import scala.collection.mutable.Map

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/4
 */
object Collections {
  def main(args: Array[String]): Unit = {
    /**
     *  数组
     */
    val arr1: Array[Int] = Array(1, 2, 3)
    val arr2: Array[Int] = new Array[Int](5)
    // 第一种遍历方式
    for(i<-arr1){
      println(i)
    }
    println()
    // 第二种方式  foreach  终结操作
    arr1.foreach(a=>println(a+10))

    println()
    // 二维数组  外层数组存放内层数组首地址
    val arr3 = new Array[Array[Int]](4)
    arr3(0)=Array(1,2,3,4)
    arr3(1)=Array(2,2)
    arr3(2)=Array(3,2)
    arr3(3)=Array(4,2)
    for (elem <- arr3) {
      // 将字符串(广义) 以某种形式分隔  mkString( "begin" , "," , "end")
      println(elem.mkString("Array(", ", ", ")"))
      elem.foreach(println)
    }

    val arr4: Array[String] = Array("h", "e", "l")
    val arr5 = Array("l", "o")
    val strings: Array[String] = Array.concat(arr4, arr5)
    println(strings.mkString(""))
    //创建5个数组,每个数组中都填充 {} 指定的元素  -/---
    Array.fill(5){
      (1,2,3,4,5)
    }.foreach(println)
    println("-----")
    val arr6 = Array.fill(1,2,3)(2)
    for (elem <- arr6) {
      elem.foreach(println)
    }

    val arrayBuffer = ArrayBuffer[String]("1","2","3")

    arrayBuffer.append("4","5")
    arrayBuffer.foreach(print)
    println()

    // 尾插
    arrayBuffer.+=("6");
    // 头插
    arrayBuffer.+=:("0");
    arrayBuffer.foreach(print)

    println("list-----")
    /**
     *  数组
     */
    val list: List[Int] = List(1, 2, 3, 4)

    println("数组")
    // filter 过滤
    list.filter(x=>x>3).foreach(print)

    println()
    // 统计满足条件的元素有多少个
    val i = list.count(a => a > 2)
    println(i)

    println()

    /**
     * map & flatMap
     *  map 将流中的元素进行调整 一进一出
     *  flatMap 将流中的元素变成逻辑中的基本元素,不会进行封装,所以一般是 一进多出
     */
    list.map(a=>a + " ").foreach(print)
    val list2: List[String] = List("sanguo yanyi", "shuihu zhuan", "honglou meng", "xiyou ji")
    // 将 流中的元素 从 String 类型 转换为 Array 类型 一进一出(原有4个元素,map 之后为4个数组)
    val list3: List[Array[String]] = list2.map(x => x.split(" "))
    println(list3.count(a => true)+" map")
    list3.foreach(a=>a.foreach(println))

    // 将 流中的元素从 String 变成  String, 经过拆分之后的元素也变为单个元素进入流
    val list4: List[String] = list2.flatMap(x => x.split(" "))
    println()
    println(list4.count(a => true)+" flatMap")

    /**
     *  缓存数组
     */
    val listBuffer = ListBuffer[Int](1, 2, 3, 4)
    listBuffer.append(5,6,7,8,9)
    listBuffer.+=:(0) // 头插 -- 反常插入 头插  多一个 :
    listBuffer.+=(10) // 尾插 -- 正常插入 尾插
    listBuffer.foreach(println)

    println("set----")
    /**
     *  Set
     *  无序,去重
     */
    val set: Set[Int] = Set(1, 2, 2, 3)
    set.foreach(println)

    println("交集-----")
    // set 的 交并差
    val set2: Set[Int] = Set( 2,4,5)
    val set3: Set[Int] = set2.union(set)
    set3.foreach(println) // 1,2,3,4,5
    println("差集----")
    set2.diff(set).foreach(println) // 4,5
    println("交集---")
    set2.intersect(set).foreach(println) // 2
    println()
    // 可以通过 符号替代
    // & == intersect
    (set & set2).foreach(println)
    // &~ == diff  交集与差集互反 所以 差集在 & 后加一个 ~
    (set &~ set2).foreach(println)

    // 第一个参数  头部, 第二个参数  分隔符, 第三个参数 尾部
    println(set2.mkString("Set(", ", ", ")"))

    // 缓存set
    val set5= Set[Int](1, 2, 3, 3, 4, 5)
    set5.add(7)
    set5.add(6)
    // set5.+=:(0)  set 无序 所以没有头尾插之分 以默认的 尾插来插入
    set5.+=(10)
    set5.foreach(a=>print(a+" "))


    println("Map---------")
    /**
     *  Map
     */
    val map: Map[String, Any] = Map("name" -> "xw", "age" -> 21, ("color", "yellow"))
    map.foreach(a=>{
      // _1 表示 key
      print(a._1+" ")
      // _2 表示 value
      println(a._2)
    })

    val option: Option[Any] = map.get("name")
    // option 各种操作最后返回的都是一个option对象 调用 get 方法获取其中的值
    val maybeString = option.map(a => a.toString).orElse(Option.apply("没有这个值"))

    val option1: Option[Any] = map.get("addr")
    val maybeString2: Option[String] = option1.map(a => a.toString).orElse(Option.apply("没有这个值"))
    //  val value: Any = option1.getOrElse("没有这个值")  同上
    println(maybeString2)

    val value: Any = map.getOrElse("addr", "gz")
    println(value)

    // map 的遍历
//    val keySet: Predef.Set[String] = map.keySet
    val keySet = map.keys
    keySet.foreach(a=>{
      println(a+" : " + map.get(a).get)
    })

    // Iterable 实现了 iterator 接口  可以遍历
    val values: Iterable[Any] = map.values
    // values.iterator.next()
    for (elem <- map.valuesIterator) {
      println(elem)
    }

    println("map-----------------merge")

    val map1: Map[String, Any] = Map("name" -> "xw", "age" -> 21, ("addr", "gz"))
    val map2: Map[String, Any] = Map("name" -> "xj", "age" -> 20, ("addr", "cq"))
    // Map 的合并
    // 键相同 会做值覆盖
    val map3 = map1.++:(map2)
    map3.foreach(a=>{
      println(a._1+":"+a._2)
    })

    // java 集合都可以转成流 所以 基本的操作都有
    map1.map(a=>a._1+":"+a._2+" emm").foreach(println)

    // 可变长 map
    val map4: mutable.Map[String, Any] = Map(("name", "xw"), ("age", 21))
    // 添加元素
    map4+=(("addr","gz"))
    map4-=("name")
    map4.foreach(println)
    // 删除元素


    /**
     *  Tuple
     *   元素的组合 每个元素都有确定的类型,需要显式指定
     */
    val tuple: (String, Int) = new Tuple2[String,Int]("xw", 21)
    println("tuple-----------")

    tuple.productIterator.foreach(println)
    val lists: immutable.Seq[(String, Any)] = List(Tuple2("name", 21), Tuple2("name", "xj"))
    lists.foreach(println)
    println("swap")
    lists.foreach(a=>{
      if(a._1.eq("name")) {
        // 只有 两个元素的组合有 swap 方法 返回的是一个新的 tuple ,对原 tuple 没有影响
        println(a.swap.toString())
      }
    })
    lists.foreach(println)

  }

}
