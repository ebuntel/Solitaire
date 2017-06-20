/**
 * Created by bunte on 6/19/2017.
 */

fun main(args: Array<String>){
    GameModel.resetGame()
    GamePresenter.onDeckTap()
    GameModel.debugPrint()
}