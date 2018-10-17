package bowling
case class Frame(attempt1: Int, attempt2: Int = 0){

  /**
    * true if the first attempt of the frame equal 10
    * @return
    */
  def isStrike: Boolean = attempt1 == 10

  /**
    * true if the sum of the attempt are equal to ten
    * @return
    */
  def isSpare: Boolean = !isStrike && attempt1 + attempt2 == 10

  def score: Int = attempt1 + attempt2

  def getLastAttempt: Int = {
    if (isStrike) attempt1
    else attempt2
  }
}