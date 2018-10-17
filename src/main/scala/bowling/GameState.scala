package bowling

case class GameState(player1: Player, player2: Player) {
    def getWinner() : Option[Player] = {
        if (player1.totalScore > player2.totalScore) Some(player1)
        else if (player2.totalScore > player1.totalScore) Some(player2)
        else None // there is no winner

    } 
}