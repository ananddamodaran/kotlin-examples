package com.ananddamodaran.antsmasher

import android.os.Handler
import java.util.*

/**
 * Created by anand on 3/17/18.
 */
class GameEngine : Contract.GameEngine {
    private var gameView: Contract.GameView? = null

    private val handler: Handler = Handler()

    private var ants: MutableList<Ant> = ArrayList<Ant>()

    private val random: Random = Random()

    private var score :Int = 0


    private val showNewAntRunnble = object : Runnable {
        override fun run() {
            if(ants.isNotEmpty()){
                handler.removeCallbacks(this)
                gameView?.clearView()
                gameView?.showGameOverTextVisibility(true)
                gameView?.setPlayerButtonVisibility(true)
            }else {
                val ant = Ant((ants.size + 1).toLong(), random.nextFloat(), random.nextFloat())
                ants.add(ant)
                gameView?.showAnt(ant)
                handler.postDelayed(this, 1500)
            }

        }

    }

    override fun onGameViewReady(view: Contract.GameView) {
        gameView = view
    }

    override fun onViewDestroyed() {
        gameView = null
    }

    override fun onPlayButtonClicked() {
        gameView?.setPlayerButtonVisibility(false)
        gameView?.clearView()
        ants.clear()
        showNewAntRunnble.run()

    }

    override fun onAntClicked(ant: Ant) {
        ants.remove(ant)
        gameView?.hideAnt(ant)
        score++
        gameView?.showScore(score)


    }
}