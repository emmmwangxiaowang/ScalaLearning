package com.wang

/**
 *  继承  多继承 用 with 连接
 *
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/1
 */
object Cat extends AAA with BBB {
//  override def eat: Unit = super.eat

  override def eat222(): Unit = super.eat222()

}

trait AAA{

  def eat: Unit ={
    println("AAA eat")
  }
}

trait BBB {
  def eat222(): Unit ={
    println("BBB eat")
  }
}
