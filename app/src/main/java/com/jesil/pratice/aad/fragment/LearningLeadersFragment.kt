package com.jesil.pratice.aad.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jesil.pratice.aad.R
import com.jesil.pratice.aad.adapter.LearningLeadersRecyclerAdapter
import com.jesil.pratice.aad.utils.DataResult.*
import com.jesil.pratice.aad.viewmodel.LearningLeadersViewModel
import fr.castorflex.android.circularprogressbar.CircularProgressBar
import fr.castorflex.android.circularprogressbar.CircularProgressDrawable
import kotlinx.android.synthetic.main.fragment_learning_leaders.*

/**
 * A simple [Fragment] subclass.
 * Use the [LearningLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class LearningLeadersFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var learningLeadersViewModel: LearningLeadersViewModel
    private val leadersRecyclerAdapter: LearningLeadersRecyclerAdapter by lazy {
        LearningLeadersRecyclerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_learning_leaders, container, false)
        view.findViewById<CircularProgressBar>(R.id.pb_learning_leaders)
        learningLeadersViewModel = ViewModelProviders.of(this).get(LearningLeadersViewModel::class.java)
        initAllData()
        return view
    }

    private fun initAllData(){
        learningLeadersViewModel.dataResult.observe(viewLifecycleOwner,
            androidx.lifecycle.Observer { learningLeadersDataResult ->
                when (learningLeadersDataResult) {
                    is Success -> {
                        leadersRecyclerAdapter.setLearningLeadersData(learningLeadersDataResult.data!!.toList())
                        recyclerViewLearningLeaders?.adapter = leadersRecyclerAdapter
                        stopLoading()
                    }
                    is Error -> {
                        Snackbar.make(
                            FrameLayoutLearningLeaders,
                            learningLeadersDataResult.error.localizedMessage,
                            Snackbar.LENGTH_INDEFINITE
                        ).show()
                        Log.d(
                            "LearningLeadersFragment",
                            learningLeadersDataResult.error.localizedMessage
                        )
                        stopLoading()
                    }
                    is Loading -> {
                        startLoading()
                    }
                }

            })
    }

    private fun startLoading(){
        pb_learning_leaders.visibility = View.VISIBLE
    }

    private fun stopLoading(){
        pb_learning_leaders.visibility = View.GONE
    }


}