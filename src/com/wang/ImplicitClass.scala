package com.wang

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/8
 */
object ImplicitClass {

  /**
   *  隐式类
   *    1. 不能定义在最外层
   *    2. 就像是 对 参数的代理类一样, 初始化类之后,也会拥有隐式类中的 属性/方法
   */
  implicit class demo(bird: Bird){
    def fly(): Unit ={
      println(bird.name+" flying")
    }
  }

  def main(args: Array[String]): Unit = {
    val bird = new Bird("杜鹃")
    bird.fly()
  }
}

class Bird(xname:String){
  val name: String =xname
}


