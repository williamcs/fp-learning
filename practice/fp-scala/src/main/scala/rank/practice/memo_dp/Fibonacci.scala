package rank.practice.memo_dp

/**
  * The original problem statement where Fibonacci series appears for the first time in modern period is
  * a very interesting one. It was a book by Leonard of Pisa, also known as Fibonacci,
  * named Liber Abaci (1202) which brought such interesting series to the popularity.
  *
  * Fibonacci considers the growth of an idealized (biologically unrealistic) rabbit population, assuming that:
  * a newly born pair of rabbits, one male, one female, are put in a field; rabbits are able to mate at the age of
  * one month so that at the end of its second month a female can produce another pair of rabbits; rabbits
  * never die and a mating pair always produces one new pair (one male, one female) every month from the second month on.
  * The puzzle that Fibonacci posed was: how many pairs will there be in one year?
  *
  * At the end of the first month, they mate, but there is still only 1 pair.
  * At the end of the second month the female produces a new pair, so now there are 2 pairs of rabbits in the field.
  * At the end of the third month, the original female produces a second pair, making 3 pairs in all in the field.
  * At the end of the fourth month, the original female has produced yet another new pair, the female born two months
  * ago produces her first pair also, making 5 pairs.
  * At the end of the nth month, the number of pairs of rabbits is equal to the number of new pairs
  * (which is the number of pairs in month n − 2) plus the number of pairs alive last month (n − 1).
  * This is the nth Fibonacci number.
  *
  * This series can be broken down as the following series:
  * Fib0 = 0
  * Fib1 = 1
  * Fibn = Fibn-1 + Fibn-2 , n > 1
  *
  * First few elements of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377...
  *
  * You are given a list of non-negative integers. For each integer, n, in the list print nth fibonacci number modulo 10^8+7.
  *
  * Input Format
  * The first line contains an integer T, denoting the number of test-cases. T lines follow, each representing a test case.
  * In each line there is a non-negative integer, n.
  *
  * Output Format
  * For each test case, print Fib n % (10^8+7).
  *
  * Constraints
  * 1 <= T <= 10^4
  * 0 <= n <= 10^4
  *
  * Sample Input #0
  *
  * 5
  * 0
  * 1
  * 5
  * 10
  * 100
  * Sample Output #0
  *
  * 0
  * 1
  * 5
  * 55
  * 24278230
  *
  *
  */
object Fibonacci {

  val mod = math.pow(10, 8).toInt + 7

  def fib(n: Int): Long = {
    def fibTail(n: Int, a: Long, b: Long): Long = n match {
      case 0 => a
      case _ => fibTail(n - 1, b, (a + b) % mod)
    }

    fibTail(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt

    (1 to T).map(_ => scala.io.StdIn.readInt).map(n => fib(n)).map(println)

//    for (_ <- 1 to T) {
//      println(fib(scala.io.StdIn.readInt))
//    }
  }
}
