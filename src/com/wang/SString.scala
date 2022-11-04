package com.wang

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2022/11/4
 */
object SString {
  def main(args: Array[String]): Unit = {
    /**
     *  字符串 String & StringBuilder & StringBuffer
     *  都是 java 的 API
     *  总结:
     *    1.操作少量数据:适用 String
     *    2.单线程操作字符串缓冲区下操作大量数据:适用 StringBuilder
     *    3.多线程操作字符串缓冲区下操作大量数据:适用 StringBuffer
     */
    var str ="abcd"
    var str2 = "ABCD"
    println(str.toUpperCase().compareTo(str2))

    val builder = new StringBuilder("abcd")

    val str1 = builder.append("efdsf").append(" ").append("a")
    println(builder)
    // 当使用 + 对 StringBuilder 操作的时候, 是新生成了一个 String 对象对结果进行处理
    val str3 = builder.+("dsa")
    println(str3)
    // 结果和上一个结果一样
    println(builder)
    println(builder.toString().contains("b"))

  }
}
