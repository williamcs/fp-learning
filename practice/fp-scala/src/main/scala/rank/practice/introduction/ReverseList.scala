package rank.practice.introduction

/**
  * You are given a list of N elements. Reverse the list without using the reverse function.
  * The input and output portions will be handled automatically. You need to write a function with
  * the recommended method signature.
  *
  * Input Format
  *
  * Each element, X, of the list is displayed on a separate line.
  *
  * Output Format
  *
  * The output is the reverse of the input list.
  *
  * Sample Input
  *
  * 19
  * 22
  * 3
  * 28
  * 26
  * 17
  * 18
  * 4
  * 28
  * 0
  * Sample Output
  *
  * 0
  * 28
  * 4
  * 18
  * 17
  * 26
  * 28
  * 3
  * 22
  * 19
  * Method Signature
  *
  * Number Of Parameters: 1
  * Parameters: [list]
  * Returns: List or Vector
  * Constraints
  * 1 <= N <= 100
  * 0 <= X <= 100
  *
  * For Hackers Using Clojure
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * (fn[lst]___________________________)
  * For Hackers Using Scala
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * def f(arr:List[Int]):List[Int] = __________________
  * For Hackers Using Haskell
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * rev l = __________________
  * For Hackers Using other Languages
  *
  * You have to read input from standard input and write output to standard output.
  * Please follow the input/output format mentioned above.
  *
  * NOTE: You only need to submit the code above after filling in the blanks appropriately.
  * The input and output section will be handled by us. The focus is on writing the correct function.
  */
object ReverseList {

  def f(arr: List[Int]): List[Int] = arr match {
    case Nil => Nil
    case head :: tail => f(tail) ::: List(head)
  }

  def f1(arr: List[Int]): List[Int] = {
    val sq = for (i <- arr.size - 1 to 0 by -1) yield arr(i)
    sq.toList
  }

  def f2(arr: List[Int]): List[Int] = {
    var lst = List[Int]()

    for (i <- 0 until arr.length) {
      lst = arr(i) :: lst
    }

    lst
  }

  def main(args: Array[String]): Unit = {
    val arr = List(1, 2, 3, 4, 5)

    val result = f(arr)
    println(result)

    val result1 = f1(arr)
    println(result1)

    val result2 = f2(arr)
    println(result2)
  }
}
