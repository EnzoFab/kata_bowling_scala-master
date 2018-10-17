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

    /**
    *
    * @return
    */
    def totalScore: Int = {

      def totalScoreInt(frames: List[Frame]): Int = {
        if(frames.isEmpty) 0
        else {
          if (frames.head.isStrike) { // a strike
            // we add the score of the current frame + the score of the next one
            // if the next one is also a strike:
            //  add the score of the strike + the score of the first attempt of the next frame
            var score = frames.head.score
            if (frames.tail.nonEmpty) {
              // if there is a frame after this frame and this frame is a strike
              score = score + frames.tail.head.score
              val tail = frames.tail
              if (tail.tail.nonEmpty  && tail.head.isStrike) // the next frame is also a strike
                score = score + tail.tail.head.attempt1
            }
            score + totalScoreInt(frames.tail)
          }
          else if (frames.head.isSpare) { // the current frame is a spare
              // we add the score of the current frame + the score of the first attempt of next frame if it exists
            var score = frames.head.score
            if (frames.tail.nonEmpty) score = score + frames.tail.head.attempt1
            score + totalScoreInt(frames.tail)
          } else frames.head.score + totalScoreInt(frames.tail)
        }
      }

      totalScoreInt(frames)
    }


  override def toString = s"$name score: $totalScore"

}