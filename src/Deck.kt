import java.util.*

/**
 * Created by bunte on 6/18/2017.
 */
class Deck {


    val deck: Array<card> = Array(52, {card(it % 13, getSuit(it))})
    var cardsinDeck: MutableList<card> = deck.toMutableList()

    fun drawCard(): card = cardsinDeck.removeAt(0)

    fun reset() {
        cardsinDeck = deck.toMutableList()
        cardsinDeck.forEach{it.faceUp = false}
        Collections.shuffle(cardsinDeck)
    }

    private fun getSuit(i: Int): String = when(i/13) {
            0 -> clubs
            1 -> diamonds
            2 -> hearts
            else -> spades
        }
}