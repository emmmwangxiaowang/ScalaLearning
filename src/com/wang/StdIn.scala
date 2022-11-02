package com.wang

import scala.io.StdIn

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/1
 */
object test {
  def main(args: Array[String]): Unit = {
    println("请输入姓名")

    val name = StdIn.readLine()

    println("请输入年龄")

    var age = StdIn.readInt()
    printf("您输入的姓名是%s,年龄是%d",name,age)
  }
}
