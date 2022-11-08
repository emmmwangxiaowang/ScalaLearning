package com.wang

/**
 *  通过 list 中 map 和 collect 来体现偏函数的区别
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/8
 */
object PartialFunction {

  // [Any , Int] 表示入参为 Any 类型, 出参为 Int 类型  ,类似 MR 可以实现联调
  def MyTest: PartialFunction[Any,Int] = {
    // 入参是 Any 类型, 但是 只处理 int 类型的参数(感兴趣的数据)
    case i: Int => i+1
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 3, 5, "wang")

    // map 参数非偏函数,需要对所有的数据都有对应的处理方式,不然报错
    // list.map(MyTest).foreach(println)
    // collect 的参数是一个偏函数, 只处理对应的数据
    list.collect(MyTest).foreach(println)
  }
}
