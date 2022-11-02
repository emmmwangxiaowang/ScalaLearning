package com.wang
/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/1
 */

/**
 *  class 默认实现了 get/set 和无参构造方法
 */
class Person(xname:String,xage:Int){
  var name="wang"
  var age=10
  var money=1000.0



  this.name=xname
  this.age=xage

  // 构造器的重载必须调用默认的构造器
  def this(xname:String,xage:Int,xmoney:Float){
    // 调用默认的构造器
    this(xname,xage)
    this.money=xmoney
  }

  // unit --void
  def test(): Unit ={
    // 访问伴生类的 私有属性  -- object 的属性都是静态的 所以可以通过类名. 属性 直接访问
    Person.height
  }
}

/**
 *  object 中的数据或函数都是静态的, 不能传参
 *  伴生类和伴生对象:  class 和 object 名字相同  他们之间 可以互相访问 私有变量
 */
object Person {

  private var height = 180

  def main(args: Array[String]): Unit = {
    // 变量声明 同 js var 变量   val 常量
    val H = "hello wrold"
    val person = new Person("wang",19)
    val person1 = new Person("wang", 21, 2000)


    println(person.age+person.name)
    println(person1.name+person1.age+person1.money)
    println(H)
  }
}
