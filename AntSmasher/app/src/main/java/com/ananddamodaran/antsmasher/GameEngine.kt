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
            val newAnt = createNewAnt()
            val isGameOver = checkIfGameIsOver()
            if(!isGameOver){

                ants.add(newAnt)
                gameView?.showAnt(newAnt)
                handler.postDelayed(this, 1500)
            }else {
                handler.removeCallbacks(this)
                gameView?.clearView()
                gameView?.showGameOverTextVisibility(true)
                gameView?.setPlayerButtonVisibility(true)
            }

        }

    }
    private fun checkIfGameIsOver(): Boolean {
        return ants.isNotEmpty()
    }
    override fun onGameViewReady(view: Contract.GameView) {
        gameView = view
        gameView?.clearView()
        gameView?.showIntroTextVisibility(true)

    }

    override fun onViewDestroyed() {
        handler.removeCallbacks(showNewAntRunnble)
        gameView = null
    }

    override fun onPlayButtonClicked() {
        gameView?.setPlayerButtonVisibility(false)
        gameView?.clearView()
        ants.clear()
        showNewAntRunnble.run()
        score = 0

    }

    override fun onAntClicked(ant: Ant) {
        ants.remove(ant)
        gameView?.hideAnt(ant)
        score ++
        gameView?.showScore(score)


    }
    private fun createNewAnt(): Ant {
        val x = getAntXposition()
        val y = getAntYposition()
        val id = ants.size + 1
        return Ant(id, x, y)
    }

    /**
     * returns Ant's vertical position as a screen height ratio, in range 0.0-1.0
     */
    private fun getAntYposition(): Double {
        return random.nextDouble()
    }

    /**
     * returns Ant's horizontal position as a screen width ratio, in range 0.0-1.0
     */
    private fun getAntXposition(): Double {
        return random.nextDouble()
    }
}