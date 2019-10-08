package rank.practice.introduction

object ListLength {

  def f(arr: List[Int]): Int = {
    arr.zipWithIndex.map(_._2).map(_ => 1).sum
  }

  def f1(arr: List[Int]): Int = {
    arr.map(_ => 1).sum
  }

  def f2(arr: List[Int]): Int = {
    arr.fold(0)((x, _) => x + 1)
  }

  def f3(arr: List[Int]): Int = {
    arr.map(_ => 1).reduce((a, b) => a + b)
  }

  def f4(arr: List[Int]): Int = {
    def loop(arr: List[Int], acc: Int): Int = {
      if (arr.isEmpty) acc
      else loop(arr.tail, acc + 1)
    }

    loop(arr, 0)
  }

  def f5(arr: List[Int]): Int = {
    arr.foldLeft(0)({case (acc, i) => acc + 1})
  }

  def main(args: Array[String]): Unit = {
    val arr = List(2, 5 ,1 ,4, 3, 7, 8, 6, 0, 9)

    val result = f(arr)
    println("The result is: " + result)

    println("----------------------------")

    val result1 = f1(arr)
    println("The result1 is: " + result1)

    println("----------------------------")

    val result2 = f2(arr)
    println("The result2 is: " + result2)

    println("----------------------------")

    val result3 = f3(arr)
    println("The result3 is: " + result3)

    println("----------------------------")

    val result4 = f4(arr)
    println("The result4 is: " + result4)

    println("----------------------------")

    val result5 = f5(arr)
    println("The result4 is: " + result5)
  }
}
