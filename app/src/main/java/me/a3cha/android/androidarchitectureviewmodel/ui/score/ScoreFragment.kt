package me.a3cha.android.androidarchitectureviewmodel.ui.score

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.view.*
import me.a3cha.android.androidarchitectureviewmodel.R

class ScoreFragment : Fragment(), View.OnClickListener {
    companion object {
        fun newInstance() = ScoreFragment()
    }

    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWidgetView(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        displayScoreForTeamA(viewModel.scoreTeamA)
        displayScoreForTeamB(viewModel.scoreTeamB)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnReset -> {
                resetScore()
            }

            R.id.btnTeamAPlusOne -> {
                addScoreForTeamA(1)
            }

            R.id.btnTeamAPlusThree -> {
                addScoreForTeamA(3)
            }

            R.id.btnTeamAPlusFive -> {
                addScoreForTeamA(5)
            }

            R.id.btnTeamBPlusOne -> {
                addScoreForTeamB(1)
            }

            R.id.btnTeamBPlusThree -> {
                addScoreForTeamB(3)
            }

            R.id.btnTeamBPlusFive -> {
                addScoreForTeamB(5)
            }
        }
    }

    private fun setupWidgetView(view: View) {
        // setup reset button
        view.btnReset.setOnClickListener(this)

        // setup button of team A
        view.btnTeamAPlusOne.setOnClickListener(this)
        view.btnTeamAPlusThree.setOnClickListener(this)
        view.btnTeamAPlusFive.setOnClickListener(this)

        // setup button of team B
        view.btnTeamBPlusOne.setOnClickListener(this)
        view.btnTeamBPlusThree.setOnClickListener(this)
        view.btnTeamBPlusFive.setOnClickListener(this)
    }

    private fun addScoreForTeamA(score: Int) {
        viewModel.scoreTeamA = viewModel.scoreTeamA + score
        displayScoreForTeamA(viewModel.scoreTeamA)
    }

    private fun addScoreForTeamB(score: Int) {
        viewModel.scoreTeamB = viewModel.scoreTeamB + score
        displayScoreForTeamB(viewModel.scoreTeamB)
    }

    private fun displayScoreForTeamA(scoreTeamA: Int) {
        tvTeamAScore.text = scoreTeamA.toString()
    }

    private fun displayScoreForTeamB(scoreTeamB: Int) {
        tvTeamBScore.text = scoreTeamB.toString()
    }

    private fun resetScore() {
        viewModel.scoreTeamA = 0
        viewModel.scoreTeamB = 0

        displayScoreForTeamA(viewModel.scoreTeamA)
        displayScoreForTeamB(viewModel.scoreTeamB)
    }
}
