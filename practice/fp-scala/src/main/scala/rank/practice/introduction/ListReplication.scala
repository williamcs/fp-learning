package rank.practice.introduction

/**
  * Given a list, repeat each element in the list  amount of times. The input and output portions will be handled
  * automatically by the grader. You need to write a function with the recommended method signature.
  *
  * Input Format
  *
  * The first line contains the integer S where S is the number of times you need to repeat the elements.
  * The next X lines each contain an integer. These are the X elements in the array.
  *
  * Output Format
  *
  * Output each element of the original list  times, each on a separate line.
  * You have to return the list/vector/array of integers. The relative positions of the values should be
  * the same as the original list provided in the input.
  *
  * Constraints
  *
  *
  *
  * Sample Input
  *
  * 3
  * 1
  * 2
  * 3
  * 4
  * Sample Output
  *
  * 1
  * 1
  * 1
  * 2
  * 2
  * 2
  * 3
  * 3
  * 3
  * 4
  * 4
  * 4
  * Recommended Method Signature
  *
  * Number Of Parameters: 2
  * Parameters: [number of times to replicate elements, list]
  * Returns: List or Vector
  * For Hackers Using Clojure
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * (fn[num lst]___________________________)
  * For Hackers Using Scala
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * def f(num:Int,arr:List[Int]):List[Int] = __________________
  * For Hackers Using Haskell
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * f n arr = ___________________
  * For Hackers Using OCaml
  *
  * This will be the outline of your function body (fill in the blank portion marked by underscores):
  *
  * let f n arr = (*Complete this function*)
  * For Hackers Using other Languages
  *
  * You have to read input from standard input and write output to standard output. Please follow the input/output
  * format mentioned above.
  *
  * NOTE: You only need to submit the code above after filling in the blanks appropriately. The input and output
  * section will be handled by us. The focus is on writing the correct function.
  */
object ListReplication {

  def f(num: Int, arr: List[Int]): List[Int] = {
    arr.flatMap(e => List.fill(num)(e))
  }

  def f1(num: Int, arr: List[Int]): List[Int] = {
    arr.flatMap(ele => {
      for (_ <- 1 to num) yield ele
    })
  }

  def fn(num: Int, arr: List[Int]): List[Int] = {
    for {
      x <- arr
      y <- 1 to num
    } yield x
  }

  def func(num: Int, arr: List[Int]): List[Int] = {
    arr match {
      case head :: tail => List.fill(num)(head) ::: func(num, tail)
      case Nil => Nil
    }
  }

  def repeatN(num: Int, item: Int, acc: List[Int]): List[Int] = {
    num match {
      case 0 => acc
      case _ => repeatN(num - 1, item, item :: acc)
    }
  }

  def func1(num: Int, arr: List[Int]): List[Int] = {
    arr.flatMap(x => repeatN(num, x, Nil))
  }

  def main(args: Array[String]): Unit = {
    val num = 3
    val arr = List(1, 2, 3, 4)

    val result = f(num, arr)
    println(result.mkString("\n"))

    println("------------------------")

    val result1 = f1(num, arr)
    println(result1.mkString("\n"))

    println("------------------------")

    val result2 = fn(num, arr)
    println(result2.mkString("\n"))

    println("------------------------")

    val result3 = func(num, arr)
    println(result3.mkString("\n"))

    println("------------------------")

    val result4 = func(num, arr)
    println(result4.mkString("\n"))
  }
}
