package com.wang

/**
 *  样例类:
 *
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/8
 */
case class Student(name:String,age:Int)
object Case {
  def main(args: Array[String]): Unit = {
    val student: Student = Student("xw", 21)
    println(student)
    val student2: Student =  Student("xw", 21)
    println(student2)
    // scala equals 是调用 == 表示, scala == 表示值等 不表示引用等
    println(student.equals(student2)) // true
  }
}


