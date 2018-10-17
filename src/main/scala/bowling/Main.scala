package bowling
object Main extends App {
    def play (player: Player, frameCount: Int = 0): Player = {
      println(player)

      if (frameCount > 10) player
        else if(frameCount == 10 && !player.lastIsStrike()) player
      else if (frameCount == 10 && player.lastIsStrike()){
        println("extra frame")
        val optionList: Option[List[Int]] = Bowling.playFrame(Nil)
        if(optionList.isEmpty) {
          println("Invalid number of pin")
          play(player, frameCount)
        } else {
          val l = optionList.get
          var frame: Frame = null
          if (l.size == 2) {
            frame = Frame(l.head, l(1))
          } else {
            frame = Frame(l.head)
          }
          val cpPlayer = player.copy(frames =  player.frames :+ frame)
          // concat two list
          play(cpPlayer, frameCount + 1)
        }
      }
      else {
        val optionList: Option[List[Int]] = {
          Bowling.playFrame(Nil)
        }
        if(optionList.isEmpty) {
          println("Invalid number of pin down")
          play(player, frameCount)
        } else {
          val l = optionList.get
          var frame: Frame = null
          if (l.size == 2) {
            frame = Frame(l.head, l(1))
          } else {
            frame = Frame(l.head)
          }
          val cpPlayer = player.copy(frames = player.frames :+ frame)
          // concat two list
          play(cpPlayer, frameCount + 1)
        }
      }
    }

  val name = readLine("Player name: \n")
  var player = Player(name)

  player = play(player)
  println("end of game")
}