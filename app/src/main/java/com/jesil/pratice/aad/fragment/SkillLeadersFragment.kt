package com.jesil.pratice.aad.fragment

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.jesil.pratice.aad.R
import com.jesil.pratice.aad.adapter.SkillLeadersIqRecyclerAdapter
import com.jesil.pratice.aad.utils.DataResult
import com.jesil.pratice.aad.viewmodel.SkillLeadersViewModel
import fr.castorflex.android.circularprogressbar.CircularProgressBar
import kotlinx.android.synthetic.main.fragment_learning_leaders.*
import kotlinx.android.synthetic.main.fragment_skill_leaders.*
import kotlin.Error

/**
 * A simple [Fragment] subclass.
 * Use the [SkillLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class SkillLeadersFragment : Fragment() {

    companion object{
        private val TAG = this::class.simpleName
    }

    private lateinit var skillLeadersViewModel : SkillLeadersViewModel
    private val skillIqAdapter : SkillLeadersIqRecyclerAdapter by lazy {
        SkillLeadersIqRecyclerAdapter(requireContext().applicationContext)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_skill_leaders, container, false)
        view.findViewById<CircularProgressBar>(R.id.pb_skill_leaders)
        skillLeadersViewModel = ViewModelProviders.of(this).get(SkillLeadersViewModel::class.java)
        initDataFromServer()

        return view
    }

    private fun initDataFromServer() {
        skillLeadersViewModel.dataResult.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataResult.Success -> {
                    skillIqAdapter.setSkillIqData(result.data!!.toList())
                    recyclerViewSkillIq?.adapter = skillIqAdapter
                    Log.d(TAG, result.data.toString())
                    stopLoading()
                }
                is DataResult.Error -> {
                    Snackbar.make(
                        FrameLayoutSkillIq,
                        result.error.message.toString(),
                        Snackbar.LENGTH_INDEFINITE
                    ).show()
                    Log.e(TAG, result.error.message.toString())
                    stopLoading()
                }
                is DataResult.Loading -> {
                    startLoading()
                }
            }
        })
    }

    private fun startLoading(){
        pb_skill_leaders.visibility = View.VISIBLE
    }

    private fun stopLoading(){
        pb_skill_leaders.visibility = View.GONE
    }
}