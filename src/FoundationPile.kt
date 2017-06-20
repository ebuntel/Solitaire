/**
 * Created by bunte on 6/19/2017.
 */
class FoundationPile (val suit: String){
    val list: MutableList<card> = mutableListOf()

    fun reset(){list.clear()}

    fun removeCard(toRem: card) {
        list.remove(toRem)
    }

    fun addCard(ciq: card): Boolean {
        var nextValue = 0
        if(list.size > 0){
            nextValue = list.last().value + 1
        }
        if(ciq.suit == suit && ciq.value == nextValue){
            list.add(ciq)
            return true
        }else{
            return false
        }
    }

}