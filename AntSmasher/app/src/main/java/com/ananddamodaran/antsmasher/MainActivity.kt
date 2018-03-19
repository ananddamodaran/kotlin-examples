package com.ananddamodaran.antsmasher

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.GameView {


    private val engine: GameEngine
    private val TAG: String = "MainActivity"


    init {
        Log.d(TAG, "init")
        this.engine = GameEngine()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TAG", "oncreate()")

        play_button?.setOnClickListener { engine.onPlayButtonClicked()  }

        val d = Drawable.createFromStream(getAssets().open("bg.jpeg"), null)
        game_layout?.background = d

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
        val screenWidth = game_layout!!.width
        val screenHeight = game_layout!!.height
        layoutParams.leftMargin = (ant.x * screenWidth).toInt()
        layoutParams.topMargin = (ant.y * screenHeight).toInt()
        game_layout?.addView(antView,layoutParams)

    }

    override fun hideAnt(antToHide: Ant) {
        game_layout?.let {
            for(i:Int in 0..game_layout!!.childCount){
                var view = game_layout!!.getChildAt(i)
                val ant = view.tag
                if(ant == antToHide){
                    game_layout!!.removeView(view)
                    break
                }
            }
        }
    }

    override fun showScore(scoreValue: Int) {
        score?.text = "Score: $scoreValue"
    }

    override fun showIntroTextVisibility(visibility: Boolean) {
        intro_text?.visibility = if(visibility) View.VISIBLE else View.INVISIBLE
    }
    override fun showGameOverTextVisibility(visibility: Boolean) {
        game_over?.visibility = if(visibility) View.VISIBLE else View.INVISIBLE
    }
    override fun setPlayerButtonVisibility(visibility: Boolean) {
        play_button?.visibility = if(visibility) View.VISIBLE else View.INVISIBLE
    }

    override fun clearView() {
        game_layout?.removeAllViews()
        intro_text?.visibility = View.INVISIBLE
        game_over?.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        this.engine.onViewDestroyed()
    }
}
