package com.wang

/**
 * trait 具体和抽象函数
 *    多继承下, 存在相同名称的属性,需要在实现类中重写对应的属性
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/8
 */
object Trait {
  def main(args: Array[String]): Unit = {
    val human = new Human()
    human.play()
    human.learn()

    val point1 = new Point(1, 2)
    val point2 = new Point(1, 3)
    println(point1.isEqual(point2))
  }
}

trait Play{
  val name = "xw"
  val age = 21
  def play()
}

trait Study{
  val name = "xy"
  val money = 200
  def learn(): Unit ={
    println("learning")
  }
}

class Human extends Play with Study{

  // name 重复 重写
  override val name: String = "yang"

  override def play(): Unit = {
    println("human")
  }
}
/**
 *  坐标轴上的点比较
 * */
trait Equal{
  def isEqual(x:Any):Boolean
  def isNotEqual(x:Any): Boolean ={
    !isEqual(x)
  }
}

class Point(x:Int,y:Int) extends Equal{
  // 坐标
  val xx = x
  val yy = y

  // scala 中判断一个对象是否是某个类的实例化对象
  override def isEqual(p: Any): Boolean = {
    if(p.isInstanceOf[Point]) {
      val point: Point = p.asInstanceOf[Point]
      x==point.xx && y==point.yy
    }else{
      false
    }
  }
}