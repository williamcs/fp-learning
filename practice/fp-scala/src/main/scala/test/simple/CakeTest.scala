package test.simple

trait CDComponent {
  val cd: CD

  class CD {
    def song = "Little Star"
  }
}

trait CDPlayerComponent {
  this: CDComponent =>
  val cdPlayer: CDPlayer

  class CDPlayer {
    def play(): Unit = println(cd.song)
  }
}

object Factory extends CDComponent with CDPlayerComponent {
  override val cd: Factory.CD = new CD
  override val cdPlayer: Factory.CDPlayer = new CDPlayer
}

object CakeTest {

  def main(args: Array[String]): Unit = {
    Factory.cdPlayer.play()
  }
}
