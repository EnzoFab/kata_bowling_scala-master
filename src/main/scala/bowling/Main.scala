package bowling
object Main extends App {
    def play (player: Player, frameCount: Int = 0): Player = {
        if (frameCount > 10) player
        else if(frameCount == 10 && !player.lastIsStrike()) player
        else if (frameCount == 10 && player.lastIsStrike()){
              val optionList: Option[List[Int]] = Bowling.playFrame(Nil, 0)
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
                val cpPlayer = player.copy(frames = frame :: player.frames)
                    // concat two list
                play(cpPlayer, frameCount + 1)
            }
         }
         else {
             val optionList: Option[List[Int]] = Bowling.playFrame(Nil, 0)
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
               val cpPlayer = player.copy(frames = frame :: player.frames)
               // concat two list
               play(cpPlayer, frameCount + 1)
            }
         }
       
    }

    val name = readLine("Player name: \n")
    var player = Player(name)

    player = play(player, 0)

    println(player)
}