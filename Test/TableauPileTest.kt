import org.junit.Test

import org.junit.Assert.*

/**
 * Created by bunte on 6/19/2017.
 */
class TableauPileTest {
    @Test
    fun addCards() {
        val tp = TableauPile(mutableListOf(card(12,spades)))
        val cards = mutableListOf(card(11, hearts))

        tp.addCards(cards)

        assertEquals(2,tp.cards.size)
    }

    @Test
    fun removeCards() {
        val tp = TableauPile(mutableListOf(card(4, clubs), card(3, diamonds), card(2, spades)))

        tp.removeCards(1)

        assertEquals(mutableListOf(card(4, clubs, true)), tp.cards)

    }

}