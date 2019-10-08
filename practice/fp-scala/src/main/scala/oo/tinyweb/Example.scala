package oo.tinyweb

import scala.util.Random

object Example {

  def greetingViewRenderer(model: Map[String, List[String]]): String = {
    "<h1>Friendly Greetings:</h1>\n%s".format(
      model
        getOrElse("greetings", List[String]())
        map renderGreeting
        mkString "\n")
  }

  private def renderGreeting(greeting: String): String = "<h2>%s</h2>".format(greeting)

  def greetingView = new FunctionView(greetingViewRenderer)

  def handleGreetingRequest(request: HttpRequest): Map[String, List[String]] = {
    Map("greetings" -> request.body.split(",").toList.map(makeGreeting))
  }

  private def random = new Random()

  private def greetings = Vector("Hello", "Greetings", "Salutations", "Hola")

  private def makeGreeting(name: String): String = {
    "%s, %s".format(greetings(random.nextInt(greetings.size)), name.trim)
  }

  def greetingController = new FunctionController(greetingView, handleGreetingRequest)

  private def loggingFilter(request: HttpRequest): HttpRequest = {
    println("In Logging Filter - request for path: %s".format(request.path))
    request
  }

  def main(args: Array[String]): Unit = {
    def tinyWeb = new TinyWeb(
      Map("/greeting" -> greetingController),
      List(loggingFilter))

    def testHttpRequest = HttpRequest(body = "Mike, Joe, John, Steve", path = "/greeting")

    val requestResult = tinyWeb.handleRequest(testHttpRequest)

    println(requestResult.get.body)
  }

}
