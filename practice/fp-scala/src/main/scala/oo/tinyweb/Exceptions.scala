package oo.tinyweb

class RenderingException(e: Exception) extends RuntimeException(e) {
}

class ControllerException(var statusCode: Int) extends RuntimeException {
  def getStatusCode: Int = statusCode
}
