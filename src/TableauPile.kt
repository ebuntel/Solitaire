/**
 * Created by bunte on 6/19/2017.
 */
class TableauPile(var cards: MutableList<card> = mutableListOf()) {
    init {
        if(cards.size > 0) {
            cards.last().faceUp = true
        }
    }

    fun addCards(newCards: MutableList<card>): Boolean{
        if(cards.size > 0){
            if (newCards.first().value == cards.last().value - 1
                    && suitCheck(newCards.first(), cards.last())) {
                cards.addAll(newCards)
                return true
            }
        }else if(newCards.first().value == 12){
            cards.addAll(newCards)
            return true
        }
        return false
    }

    fun removeCards(tappedIndex: Int){
        for (i in tappedIndex..cards.lastIndex){
            cards.removeAt(tappedIndex)
        }
        if(cards.size > 0){
            cards.last().faceUp = true
        }
    }

    private fun  suitCheck(c1: card, c2: card): Boolean {
        if((redsuits.contains(c1.suit) && (blacksuits.contains(c2.suit)))
                || (blacksuits.contains(c1.suit) && redsuits.contains(c2.suit))){
            return true
        }
        return false
    }
}