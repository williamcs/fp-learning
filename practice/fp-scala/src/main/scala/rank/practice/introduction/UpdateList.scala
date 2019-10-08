package rank.practice.introduction

/**
  * Update the values of a list with their absolute values. The input and output portions will be handled
  * automatically during grading. You only need to write a function with the recommended method signature.
  *
  * Input Format
  *
  * There are N integers, each on a separate line. These are the N elements of the input array.
  *
  * Output Format
  *
  * Output the absolute value of N integers, each on a separate line in the same input order.
  *
  * Sample Input
  *
  * 2
  * -4
  * 3
  * -1
  * 23
  * -4
  * -54
  * Sample Output
  *
  * 2
  * 4
  * 3
  * 1
  * 23
  * 4
  * 54
  * Constraints
  *
  * The list will have no more than  integers.
  * Each integer, , in the list: .
  *
  * Recommended Method Signature
  *
  * Number Of Parameters: 1
  * Parameters: [list]
  * Returns: List or Vector
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
  * f arr = ___________________
  * For Hackers Using other Languages
  *
  * You have to read input from standard input and write output to standard output.
  * Please follow the input/output format mentioned above.
  *
  * NOTE: You only need to submit the code above after filling in the blanks appropriately.
  * The input and output section will be handled by us. The focus is on writing the correct function.
  */
object UpdateList {

  def f(arr: List[Int]): List[Int] = {
//    arr.map(x => x * x.sign)
//    arr.map(Math.abs)
    arr.map(x => if (x < 0) -x else x)
  }

  def f1(arr: List[Int]): List[Int] = {
    def absList(absed: List[Int], unabsed: List[Int]): List[Int] = {
      unabsed match {
        case Nil => absed
        case x :: xs => {
          x match {
            case v if v < 0 => absList(absed :+ v * -1, xs)
            case v => absList(absed :+ v, xs)
          }
        }
      }
    }

    absList(Nil, arr)
  }

  def f2(arr: List[Int]): List[Int] = {
    def loop(arr: List[Int], acc: List[Int]): List[Int] = arr match {
      case Nil => Nil
      case h :: tail => h.abs :: loop(arr.tail, acc)
    }

    loop(arr, List())
  }

  /*
  def f3(arr: List[Int]): List[Int] = {
    def run(i: Int, res: List[Int]): List[Int] = arr.length match {
      case `i` => res
      case _ => run(i + 1, res :+ arr(i) * arr(i).sign)
    }

    run(0, List.empty[Int])
  }*/

  def main(args: Array[String]): Unit = {
    val arr = List(2, -4, 3, -1, 23, -4, -54)

    val result = f(arr)
    println("The result is: " + result)

    println("-------------------------")

    val result1 = f1(arr)
    println("The result1 is: " + result1)

    println("-------------------------")

    val result2 = f2(arr)
    println("The result2 is: " + result2)

    println("-------------------------")

    /*
    val result3 = f3(arr)
    println("The result3 is: " + result3)*/
  }
}
