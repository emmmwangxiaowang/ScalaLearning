package com.wang

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/3
 */
object HeiMethod {

  /**
   *
   * @param a
   * @param f 接受两个 Int 类型的函数
   */
  def fun1(arr:Array[Int],f:(Int,Int)=>Int)={
    var result=0
    for (elem <- arr) {
      result=f(result,elem)
    }
    result
   }
  def fun2(a:Int,b:Int):Int=a+b

  def fun4(a:Int,b:Int)=a+b

  // 函数 定义的时候 返回值用 =>
  // 函数 实现的时候 返回值用 :
  def fun3(f:(Int,Int)=>Int):(Int,Int)=>Int={
    f
  }

  /**
   *  柯里化函数
   *  从左往又执行
   * @param args
   */
  def fun5(a:Int,b:Int)(c:Int,d:Int): Int ={
    a+b+c+d
  }


  def main(args: Array[String]): Unit = {
    var arr=Array(1,2,3,4,5)
//    println(fun1(arr, fun2))
    println(fun1(arr,(a:Int,b:Int)=>a+b))

//    println(fun3((a, b) => a + b)(10, 20))
    // 使用下划线作为通配符需要注意, 此变量只被使用到一次
    println(fun3(_+_)(10, 20))

    println(fun5(1, 2)(3, 4))
  }
}

