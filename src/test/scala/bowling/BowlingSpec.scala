//package bowling

import org.scalatest.{FunSpec, Matchers}
import bowling.{Bowling, Frame, Player}

class BowlingSpec extends FunSpec with Matchers {
    describe("Method playFrame") {
        it("Any roll with more than 10 pins down don't give any score ") {
            assert(Bowling.playFrame(pinDown = 12).isEmpty)
        }
        it("Any roll with less than 0 pins down don't give any socre") {
            assert(Bowling.playFrame(pinDown = -1).isEmpty)
        }
    }
    describe("A Frame") {
        it("Should be a strike"){
            assert(Frame(10).isStrike)
        }
        it("Should be a spare") {
            assert(Frame(5, 5).isSpare)
        }
        it("Souldn't be a strike nor a spare") {
            val frame = Frame(4, 5)
            assert(!frame.isStrike && !frame.isSpare)
        }
    }

    describe("Player") {
        describe("Frame") {
            it("Should be a strike") {
                var listFrame: List[Frame] = Nil

                listFrame = Frame(5, 3) :: listFrame
                listFrame = Frame(10) :: listFrame

                assert(Player(frames = listFrame).lastIsStrike())

            }

            it("Should be a spare") {
                var listFrame: List[Frame] = Nil

                listFrame = Frame(5, 3) :: listFrame
                listFrame = Frame(5, 5) :: listFrame

                assert(Player(frames = listFrame).lastIsSpare())
            }

            it("Shouldn't be a strike nor a spare") {
                var listFrame: List[Frame] = Nil

                listFrame = Frame(5, 3) :: listFrame
                listFrame = Frame(5, 4) :: listFrame

                val p = Player(frames = listFrame)

                assert(!p.lastIsStrike() && !p.lastIsSpare())
            }
        }

        describe("PlayerScore") {
            it("Should be less or equal to 300") {
                val f = Frame(10)
                val listFrame = f :: f :: f :: f :: f :: f :: f :: f :: f :: f :: f :: Nil

                assert(Player(frames = listFrame).totalScore == 300)
            }
        }
    }

}
