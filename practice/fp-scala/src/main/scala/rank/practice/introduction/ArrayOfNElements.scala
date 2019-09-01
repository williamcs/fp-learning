package rank.practice.introduction

/**
  * Create an array of n integers, where the value of  is passed as an argument to the pre-filled function in your editor.
  * This challenge uses a custom checker, so you can create any array of n integers. For example,
  * if n = 4 , you could return ,[1, 1, 1, 1] , or any other array of equal length.
  *
  * Note: Code stubs are provided for almost every language in which you must either fill in a blank (i.e., ____)
  * or write your code in the area specified by comments.
  *
  * Method Signature
  *
  * Number Of Parameters: 1
  * Parameters: [n]
  * Returns: List or Vector
  * Input Format
  *
  * A single integer, n.
  *
  * Constraints
  *
  * 1 <= n <= 100
  *
  * The members returned by the list/vector/array must be integers.
  * Output Format
  *
  * The function must return an array, list, or vector of  integers. Stub code in the editor prints this to
  * stdout as a space, comma, or semicolon-separated list (depending on your submission language).
  *
  * Note: Your output need not match the Expected Output exactly; the size of your printed list is confirmed by
  * a custom checker, which determines whether or not you passed each test case.
  *
  * Sample Input 0
  *
  * 10
  * Sample Output 0
  *
  * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
  * Sample Input 1
  *
  * 3
  * Sample Output 1
  *
  * [1, 2, 3]
  */
object ArrayOfNElements {

  def f(num: Int): List[Int] = {
    val list = Range(0, num).toList

    list
  }

  def f1(num: Int): List[Int] = {
    val random = new scala.util.Random

    val list = List.fill(num)(random.nextInt(100))

    list
  }

  def fn(num: Int): List[Int] = num match {
    case 0 => Nil
    case _ => num :: fn(num - 1)
  }

  def main(args: Array[String]): Unit = {
    val num = scala.io.StdIn.readInt

    println(f(num))

    println("---------------------------")

    println(f1(num))

    println("---------------------------")

    println(fn(num))
  }
}
