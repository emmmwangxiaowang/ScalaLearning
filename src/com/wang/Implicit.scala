package com.wang

/**
 *  隐式值和隐式参数  作用域
 *
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/8
 */
object Implicit {

  /**
   *  隐式转换函数
   *    相当于 map  将一种类型 转换为另一种类型 但是调用时默认调用的
   */
  // 将 Int 类型 转换为 String 类型
  implicit def fun(a:Int): String ={
    (a+1).toString
  }

  // 将 Double 类型 转换为 Int 类型
  implicit def fun2(a:Double):Int={
    (a/2).toInt
  }

  implicit val age: Int =21.0

  /**
   *  隐式值
   *    1. 若初始化的值与 隐式值的类型不匹配,则会调用相应的隐式函数
   *    2. 一个类型的隐式值 只能存在一个! 不然编译时不知道用哪个
   */
  implicit val name: String =1  // 调用 隐式函数 fun  将 Int 类型 1 处理后转为 String 类型

  // 隐式参数
  def test(implicit str:String): Unit ={
    println(str)
  }

  def test2(implicit str:String="xw"): Unit ={
    println(str)
  }

  // 有多个参数的时候 需要将隐式参数与普通参数隔离 隐式参数放后面 进行柯里化处理
  def test3(name:String)(implicit age:Int){
    println(name+":"+age)
  }

  // 参数都是隐式参数的时候就不用进行柯里化了
  def test4(implicit name:String,age:Int): Unit ={
    println(name+":"+age)
  }

  def main(args: Array[String]): Unit = {
    test("emmm")
    test2() // 调用隐式参数为默认值的函数
    /**
     *  调用隐式参数没有默认值的函数
     *    1. 寻找隐式值类型 为 隐式参数类型的 属性
     *    2. 将隐式值作为隐式参数 入参
     */
    test2
    // 只传入普通参数 隐式参数 使用 隐式值
    test3("xw")

    // 使用隐式值作为参数
    test4
    // 正常调用
    test4("wang",21)
  }
}
