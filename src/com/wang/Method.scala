package com.wang

import java.util.Date

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/3
 */
object Method {

  def print(): Unit ={
    println("hello world")
  }

  def getMax(a:Int,b:Int):Int ={
    // scala 没有三元运算符
    // a>b?a:b
    // scala 会把 函数的最后一个执行的结果当作返回值 返回 ,因为这个特性与三元运算符不兼容
    if(a>b) a else b
  }

  /**
   *  递归函数: 递归的定义以及终止条件, 需要有返回值
   * @param args
   */
    def recursion(num:Int): Int ={
      if(num==1)
        num
      else
        num*recursion(num-1)
    }

  /**
   *  给参数设定默认值
   * @param a
   * @param b
   */
  def fun1(a:Int=5,b:Int=10): Unit ={
    println(a+b)
  }

  /**
   *  可变参数个数的函数, 不定长数组
   * @param args
   */
    def fun2(a:Int*): Unit ={
      var sum =0
      for(i<-a)
        sum+=i
      println(sum)
    }

  /**
   *  匿名函数  lambda  () => {}
   *    1. 有参数的
   *    2. 无参数的
   *    3. 有返回值的
   * @param args
   */
  private val fun3: (Int, Int) => Int = (a: Int, b: Int) => {
    a + b
  }

  /**
   *  嵌套函数
   *  需要在函数体外调用
   * @param args
   */
    def fun4(a:Int,b:Int): Int ={
      def fun5(c:Int): Int ={
        a*b*c
      }
      // 调用嵌套函数
      fun5(10)
    }

  /**
   *  偏应用函数
   *  这是一种表达式 不需要提供函数需要的所有参数,按需提供或不提供
   *  使用场景:
   *    一个参数是完全相同, 另一个参数不同
   * @param args
   */
    def log(date:Date,s:String): Unit ={
      println(s"data is ${date} , log is ${s}")
    }

  def main(args: Array[String]): Unit = {
    // print()
    // println(getMax(10, 20))
    // recursion(3)
    // fun1(1,2)
    // 有默认值的函数给 --指定参数-- 传值
    // fun1(b=2)
    // fun2(1,2,3,4,5)
    // println(fun4(1,2)) // 调用 嵌套函数

    val date = new Date()
    log(date,"log1")
    log(date,"log2")
    log(date,"log3")

    // 想要调用 log , 以上变化的是第二个参数, 第一个参数相同的,可以用偏应用函数处理, _ 可以用来替换缺失的参数列表
    val logWithDate = log(date,_:String) // 定义不变的参数
    logWithDate("log11") // 输入不同的参数
    logWithDate("log22")
    logWithDate("log33")

  }
}
