/**
 * Created by bunte on 6/19/2017.
 */
object GameModel {
    val deck = Deck()
    val wastePile: MutableList<card> = mutableListOf()
    val foundationPiles: Array<FoundationPile> = arrayOf(FoundationPile(clubs),
            FoundationPile(diamonds), FoundationPile(hearts), FoundationPile(spades))
    val tableauPiles = Array(7, {TableauPile()})


    fun resetGame(){
        wastePile.clear()
        foundationPiles.forEach{it.reset()}
        deck.reset()

        tableauPiles.forEachIndexed{i, tableauPile ->
            val cardsInPile: MutableList<card> = Array(i+1, {deck.drawCard()}).toMutableList()
            tableauPiles[i] = TableauPile(cardsInPile)
        }
    }

    fun onDeckTap(){
        if(deck.cardsinDeck.size > 0) {
            val drawn = deck.drawCard()
            drawn.faceUp = true
            wastePile.add(drawn)
        }else{
            deck.cardsinDeck = wastePile.toMutableList()
            wastePile.clear()
        }
    }

    fun onWasteTap(){
        if(wastePile.size > 0){
            val card = wastePile.last()
            if(playCard(card)){
                wastePile.remove(card)
            }
        }
    }

    fun onFoundationTap(foundationIndex: Int){
        val foundationPile = foundationPiles[foundationIndex]
        if(foundationPile.list.size > 0){
            val card = foundationPile.list.last()
            if(playCard(card)){
                foundationPile.removeCard(card)
            }
        }
    }

    fun onTableauTap(index: Int, cardIndex: Int){
        val tableauPile = tableauPiles[index]
        if(tableauPile.cards.size > 0){
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)
            if(playCards(cards)){
                tableauPile.removeCards(cardIndex)
            }
        }
    }

    private fun  playCards(cards: MutableList<card>): Boolean {
        if(cards.size == 1){return playCard(cards.first())}
        else{
            tableauPiles.forEach{
                if(it.addCards(cards)){return true }
            }
        }
        return false
    }


    private fun  playCard(card: card): Boolean {
        foundationPiles.forEach{
            if(it.addCard(card)){ return true }
        }
        tableauPiles.forEach{
            if(it.addCards(mutableListOf(card))){ return true }
        }
        return false
    }

    fun debugPrint(){
        var firstLine = if(wastePile.size > 0) "${wastePile.last()}" else "___"
        firstLine = firstLine.padEnd(18)
        foundationPiles.forEach{
            firstLine += if(it.list.size > 0) "${it.list.last()}" else "___"
            firstLine += "   "
        }
        println(firstLine)
        println()

        for( i in 0..12 ){
            var row = ""
            tableauPiles.forEach {
                row += if(it.cards.size > i) "${it.cards[i]}" else "   "
                row += "   "
            }
            println(row)
        }
    }

}