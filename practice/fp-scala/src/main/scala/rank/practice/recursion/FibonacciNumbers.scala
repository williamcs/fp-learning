package rank.practice.recursion

object FibonacciNumbers {

  def fibonacci(n: Int): Int = {
    def fib(n: Int, a: Int, b: Int): Int = n match {
      case 1 => a
      case 2 => b
      case _ => fib(n - 1, b, a + b)
    }

    fib(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(fibonacci(scala.io.StdIn.readInt))
  }
}
