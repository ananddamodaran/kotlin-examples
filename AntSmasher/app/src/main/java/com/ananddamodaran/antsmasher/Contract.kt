package com.ananddamodaran.antsmasher

/**
 * Created by anand on 3/16/18.
 */
interface Contract {
    interface GameView{
        fun showAnt(ant:Ant)
        fun hideAnt(ant:Ant)
        fun showScore(score:Int)
        fun showIntroTextVisibility(visibility:Boolean)
        fun setPlayerButtonVisibility(visibility:Boolean)
        fun clearView()

    }
    interface GameEngine{
        fun onGameViewReady(view: GameView)
        fun onViewDestroyed()
        fun onPlayButtonClicked()
        fun onAntClicked(ant:Ant)
    }
}