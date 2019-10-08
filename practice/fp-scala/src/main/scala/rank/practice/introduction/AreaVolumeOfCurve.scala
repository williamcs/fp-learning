package rank.practice.introduction

/**
  * Definite Integrals via Numerical Methods
  *
  * This relates to definite integration via numerical methods.
  *
  * Consider the algebraic expression given by:
  *
  * (a1)x^b1 + (a2)x^b2 + (a3)x^b3......(an)x^bn
  *
  * For the purpose of numerical computation, the area under the curve y = f(x) between the limits a and b can be computed
  * by the Limit Definition of a Definite Integral (https://www.math.ucdavis.edu/~kouba/CalcTwoDIRECTORY/defintdirectory/).
  *
  * Here is some background about areas and volume computation.
  *
  * Using equal subintervals of length = 0.001 , you need to:
  *
  * 1. Evaluate the area bounded by a given polynomial function of the kind described above, between the given limits of L and R.
  *
  * 2. Evaluate the volume of the solid obtained by revolving this polynomial curve around the x-axis.
  *
  * A relative error margin of 0.01 will be tolerated.
  *
  * Input Format
  *
  * The first line contains N integers separated by spaces, which are the values of a1, a2 ... aN.
  * The second line contains N integers separated by spaces, which are the values of b1, b2... bN.
  * The third line contains two space separated integers, L and R, the lower and upper range limits in
  * which the integration needs to be performed, respectively.
  *
  * Constraints
  * -1000 <= a <= 1000
  * -20 <= b <= 20
  * 1 <= L < R <= 20
  *
  * Output Format
  *
  * The first line should contain the area between the curve and the x-axis, bound between the specified limits.
  * The second line should contain the volume of the solid obtained by rotating the curve around the x-axis, between the specified limits.
  *
  * Sample Input
  *
  * 1 2 3 4 5
  * 6 7 8 9 10
  * 1 4
  * Explanation
  *
  * The algebraic expression represented by:
  * (1)x^6 + (2)x^7 + (3)x^8 + (4)x^9 + (5)x^10
  *
  * We need to find the area of the curve enclosed under this curve, between the limits x = 1 and 4.
  * We also need to find the volume of the solid formed by revolving this curve around the x-axis between the limits x = 1 and 4.
  *
  * Sample Output
  *
  * 2435300.3
  * 26172951168940.8
  * Scoring
  *
  * All test cases are weighted equally. You need to clear all the tests in a test case.
  *
  */
object AreaVolumeOfCurve {

  // This function will be used while invoking "Summation" to compute
  // The area under the curve.
  def f(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    // Fill Up this function body
    // To compute the value of the function
    // For the given coefficients, powers and value of x
    coefficients.zip(powers).foldLeft(0.0) {
      case (acc, (c, p)) => acc + c * math.pow(x, p)
    }
  }

  def f1(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    coefficients.zip(powers).map(a => a._1 * math.pow(x, a._2)).sum
  }

  // This function will be used while invoking "Summation" to compute
  // The Volume of revolution of the curve around the X-Axis
  // The 'Area' referred to here is the area of the circle obtained
  // By rotating the point on the curve (x,f(x)) around the X-Axis
  def area(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    // Fill Up this function body
    // To compute the area of the circle on revolving the point
    // (x,f(x)) around the X-Axis
    // For the given coefficients, powers and value of x
    math.Pi * math.pow(f(coefficients, powers, x), 2)
  }

  // This is the part where the series is summed up
  // This function is invoked once with func = f to compute the area 	     // under the curve
  // Then it is invoked again with func = area to compute the volume
  // of revolution of the curve
  def summation(func: (List[Int], List[Int], Double) => Double,
                upperLimit: Int, lowerLimit: Int,
                coefficients: List[Int],
                powers: List[Int]): Double = {
    // Fill up this function
    val step = 0.001
    val subIntervals = lowerLimit.toDouble to upperLimit by step
    subIntervals
      .foldLeft(0.0) { case (acc, x) => acc + func(coefficients, powers, x) * step }
  }

  def summation1(func: (List[Int], List[Int], Double) => Double,
                upperLimit: Int, lowerLimit: Int,
                coefficients: List[Int],
                powers: List[Int]): Double = {
    // Fill up this function
    val step = 0.001
    val subIntervals = lowerLimit.toDouble to upperLimit by step
    subIntervals.map(x => func(coefficients, powers, x) * step).sum
  }

  def main(args: Array[String]): Unit = {
    val coefficients = List(1, 2, 3, 4, 5)
    val powers = List(6, 7, 8, 9, 10)
    val lowerLimit = 1
    val upperLimit = 4

    val areaValue = summation(f, upperLimit, lowerLimit, coefficients, powers)
    println("The are is: " + areaValue)

    val volumeValue = summation1(area, upperLimit, lowerLimit, coefficients, powers)
    println("The volume is: " + volumeValue)
  }
}
