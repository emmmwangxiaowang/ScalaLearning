package com.wang

import scala.collection.immutable

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/1
 */
object loop {
  def main(args: Array[String]): Unit = {
    // 判断
//    println("请输入年龄")
//    val age = StdIn.readInt()
//    if(age>18)
//      println("已成年")
//    else
//      println("未成年")

    /**
     *  循环
     *  to  都包
     *  until 包前不包后
     *  <-  遍历
     */
    // 1 - 10
    println(1 to 10)
    //
    println(1 until 10)
    // 1 - 10  步长为2
    println(1 until 10 ,2 )

    for(i<-1 until 10){
      println(i)
    }

    println()

    for(i<-1 to 10){
      println(i)
    }

    println()

    /**
     *  for 循环中可以追加 if 判断条件
     */
    for (i<- 1 to (100,2) if i>3 && i<70 ){
      // 等效
      // if(i>3 && i<70)
      println(i)
    }

    /**
     *  99 乘法表
     */
    for(i<-1 to 9; j <- 1 to i){
      val m = i * j
//      print(j+"*"+i+"="+m+"\t")
      // s 表示 插值字符串输出
      print(s"$j*$i=$m\t")
      if(i==j){
        println()
      }
    }

    /**
     *  for { 循环体和过滤条件 } yield { 变量或表达式 }
     *  类似 filter 和 map 的 集合 if 作为 过滤条件 yield 作为 返回值
     */
    // yield 后面是的返回值是 int 类型,  所以 收集后的集合中 "泛型" 为 Int
    val ints: immutable.Seq[Int] = for (i <- 1 to 10 if i > 5) yield i+10
    // yield 后面的返回值是 String 类型, 所以 收集后的集合中 "泛型" 为 String
    val strings: immutable.Seq[String] = for (i <- 1 to 10 if i > 5) yield i.toString

    val int2: immutable.Seq[Int] = for (i <- 1 to 10 if i > 5) yield 2

    ints.foreach(println)
    for (elem <- ints) {
      println(elem)
    }

    for(i<-int2){
      println(i)
    }

  }



}
