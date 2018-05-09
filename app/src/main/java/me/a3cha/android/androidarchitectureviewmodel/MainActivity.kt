package me.a3cha.android.androidarchitectureviewmodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import me.a3cha.android.androidarchitectureviewmodel.ui.score.ScoreFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ScoreFragment.newInstance())
                    .commitNow()
        }
    }
}
