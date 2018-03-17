package com.ananddamodaran.antsmasher

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.GameView {


    private val engine: GameEngine
    private val TAG: String = "MainActivity"
    private var toolbar: Toolbar? = null
    private var playButton: FloatingActionButton? = null
    private var introText: TextView? = null
    private var gameOverText: TextView? = null
    private var scoreView: TextView? = null
    private var gameLayout: FrameLayout? = null

    init {
        Log.d(TAG, "init")
        this.engine = GameEngine()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TAG", "oncreate()")
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        playButton = findViewById<FloatingActionButton>(R.id.play_button)
        introText = findViewById<TextView>(R.id.intro_text)
        gameOverText = findViewById<TextView>(R.id.game_over)
        scoreView = findViewById<TextView>(R.id.score)
        gameLayout = findViewById<FrameLayout>(R.id.game_layout)

        playButton?.setOnClickListener { engine.onPlayButtonClicked()  }

        this.engine.onGameViewReady(this)
    }

    override fun showAnt(ant: Ant) {
        val antView = ImageView(this)
        antView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_ant))
        antView.scaleType = ImageView.ScaleType.FIT_CENTER
        antView.tag = ant
        antView.setOnClickListener{ view ->
            view?.let {
                engine.onAntClicked(view.tag as Ant)
            }

        }
        val antSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,56f,
                resources.displayMetrics)
        val layoutParams = FrameLayout.LayoutParams(antSize.toInt(),antSize.toInt())
        val screenWidth = gameLayout!!.width
        val screenHeight = gameLayout!!.height
        layoutParams.leftMargin = (ant.x * screenWidth).toInt()
        layoutParams.topMargin = (ant.y * screenHeight).toInt()
        gameLayout?.addView(antView,layoutParams)

    }

    override fun hideAnt(antToHide: Ant) {
        gameLayout?.let {
            for(i:Int in 0..gameLayout!!.childCount){
                var view = gameLayout!!.getChildAt(i)
                val ant = view.tag
                if(ant == antToHide){
                    gameLayout!!.removeView(view)
                    break
                }
            }
        }
    }

    override fun showScore(score: Int) {
        scoreView?.text = "Score: $score"
    }

    override fun showIntroTextVisibility(visibility: Boolean) {
        introText?.visibility = if(visibility) View.VISIBLE else View.INVISIBLE
    }
    override fun showGameOverTextVisibility(visibility: Boolean) {
        gameOverText?.visibility = if(visibility) View.VISIBLE else View.INVISIBLE
    }
    override fun setPlayerButtonVisibility(visibility: Boolean) {
        playButton?.visibility = if(visibility) View.VISIBLE else View.INVISIBLE
    }

    override fun clearView() {
        gameLayout?.removeAllViews()
        introText?.visibility = View.INVISIBLE
        gameOverText?.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        this.engine.onViewDestroyed()
    }
}
