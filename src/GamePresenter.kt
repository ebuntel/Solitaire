/**
 * Created by bunte on 6/20/2017.
 */
object GamePresenter {

    var view: Gameview? = null

    fun setGameView(gameView: Gameview){
        view = gameView
    }

    fun onDeckTap(){
        GameModel.onDeckTap()
        view?.update()
    }

    fun onWasteTap(){
        GameModel.onWasteTap()
        view?.update()

    }

    fun onFoundationTap(foundationIndex: Int){
        GameModel.onFoundationTap(foundationIndex)
        view?.update()
    }

    fun onTableauTap(tableauIndex: Int, cardIndex: Int){
        GameModel.onTableauTap(tableauIndex, cardIndex)
        view?.update()
    }
}
