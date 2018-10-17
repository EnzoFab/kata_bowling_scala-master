package bowling

object Bowling {

    /**
    *@param frameScore
    *@param pinDown
    **/
    def playFrame(frameScore: List[Int] = Nil, pinDown: Int = 0): Option[List[Int]] = {
        if (pinDown > 10 ||pinDown <0){
            None
        }
        else if (frameScore.size == 2) Some(frameScore)
        else if (frameScore.size == 1 && pinDown == 10){
            Some(frameScore)
        } // strike 
        else {
            println("How many pin down ?")
            val attemptScore = readInt
            playFrame(attemptScore::frameScore, pinDown + attemptScore)
        }
    }
}
