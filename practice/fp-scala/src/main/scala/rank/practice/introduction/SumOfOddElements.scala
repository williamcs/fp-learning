package rank.practice.introduction

/**
  * You are given a list. Return the sum of odd elements from the given list.
  * The input and output portions will be handled automatically.
  * You need to write a function with the recommended method signature.
  *
  * Constraints
  *
  * The list will have 1 - 100 elements.
  * Each element will be an integer X where -100 <= X <= 100.
  *
  * Sample Input
  *
  * 3
  * 2
  * 4
  * 6
  * 5
  * 7
  * 8
  * 0
  * 1
  * Sample Output
  *
  * 16
  * Explanation
  *
  * Sum of odd elements is 3 + 5 + 7 + 1 = 16
  *
  * Method Signature
  *
  * Number Of Parameters: 1
  * Parameters: [list]
  * Returns: Number
  * For Hackers Using Clojure
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * (fn[lst]___________________________)
  * For Hackers Using Scala
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * def f(arr:List[Int]):Int = __________________
  * For Hackers Using Haskell
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * f arr = ______________________
  * For Hackers Using other Languages
  *
  * You have to read input from standard input and write output to standard output.
  * Please follow the input/output format mentioned above.
  *
  * NOTE: You only need to submit the code above after filling in the blanks appropriately.
  * The input and output section will be handled by us. The focus is on writing the correct function.
  */
object SumOfOddElements {

  def f(arr: List[Int]): Int = {
    arr.filter(_ % 2 != 0).sum
  }

  def f1(arr: List[Int]): Int = {
    arr.filter(_ % 2 != 0).reduce(_ + _)
  }

  def f2(arr: List[Int]): Int = {
    arr.filter(_ % 2 != 0).reduceLeft(_ + _)
  }

  def main(args: Array[String]): Unit = {
    val arr = List(11, 25, 18, -1, 26, -20, -19, 23, -24, -8)

    val result = f(arr)
    println("The result is: " + result)

    println("--------------------------------")

    val result1 = f1(arr)
    println("The result1 is: " + result1)

    println("--------------------------------")

    val result2 = f2(arr)
    println("The result2 is: " + result2)

    println("--------------------------------")

  }

}
