package bowling
case class Player(name: String = "No Name", frames: List[Frame] = Nil) {

    /**
      * iterate the list starting from the head and
      * check if the last shot is equal to 10
      * @param listFrames
      * @return
      */
    def lastIsStrike(listFrames: List[Frame] = frames): Boolean = {
        if(listFrames.isEmpty) false
        else listFrames.head.isStrike
    }

    /**
      * iterate the list starting from the head
      * and check if check the sum of the previous shot has two round equal to 10
      * @param listFrames
      * @return
      */
    def lastIsSpare(listFrames: List[Frame] = frames): Boolean = {
        if(listFrames.isEmpty) false
        else listFrames.head.isSpare
    }

    def totalScore: Int = { // TODO

        def totalScoreInt(frames: List[Frame]): Int = {
            if(frames.isEmpty) 0
            else {
                if (lastIsStrike(frames.tail)) {
                    frameValueStrike(frames) + totalScoreInt(frames.tail)
                }
                else if (lastIsSpare(frames)) {
                    // spare:
                    // the first of the attemp1 + the score of the frame + the score of previous frame
                    frames.head.sum + frames.head.attempt1 + totalScoreInt(frames.tail)
                }
                frames.head.sum + totalScoreInt(frames.tail)
            }
        }

        totalScoreInt(frames)
    }

    private def frameValueStrike (listFrames: List[Frame]): Int = {
        if (listFrames.isEmpty) 0
        else {
            if (listFrames.head.isStrike) {
                listFrames.head.attempt1 + frameValueStrike(listFrames.tail)
            }
            else {
                listFrames.head.sum + frameValueStrike(listFrames.tail)
            }
        }
    }


    override def toString = s"$name score: $totalScore" 

}