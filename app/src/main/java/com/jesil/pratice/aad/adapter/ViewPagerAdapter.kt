package com.jesil.pratice.aad.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jesil.pratice.aad.R
import com.jesil.pratice.aad.fragment.LearningLeadersFragment
import com.jesil.pratice.aad.fragment.SkillLeadersFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    companion object {
        const val GET_COUNT = 2
        lateinit var context : Context
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LearningLeadersFragment()
            }
            1 -> {
                SkillLeadersFragment()
            }
            else
            -> {
                LearningLeadersFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return context.getString(R.string.learning_leaders)
            }
            1 -> {
                return context.getString(R.string.skill_iq_leaders)
            }
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return GET_COUNT
    }

}