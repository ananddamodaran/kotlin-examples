package com.ananddamodaran.antsmasher

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() , Contract.GameView {
    override fun showAnt(ant: Ant) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideAnt(ant: Ant) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showScore(score: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showIntroTextVisibility(visibility: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPlayerButtonVisibility(visibility: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
