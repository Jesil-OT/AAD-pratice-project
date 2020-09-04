package com.jesil.pratice.aad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.jesil.pratice.aad.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_leader_board.*

class LeaderBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader_board)

        val toolbarLeaderBoardActivity =
            findViewById<androidx.appcompat.widget.Toolbar?>(R.id.toolbarLeaderBoardActivity)
        setSupportActionBar(toolbarLeaderBoardActivity)
        supportActionBar?.title = ""

        viewPager?.adapter = ViewPagerAdapter(supportFragmentManager)
        tabLayout?.setupWithViewPager(viewPager)
    }

}
