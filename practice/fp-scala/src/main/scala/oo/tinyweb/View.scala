package oo.tinyweb

trait View {
  def render(model: Map[String, List[String]]): String
}

class FunctionView(viewRender: Map[String, List[String]] => String) extends View {
  override def render(model: Map[String, List[String]]): String = {
    try {
      viewRender(model)
    } catch {
      case e: Exception => throw new RenderingException(e)
    }
  }
}
