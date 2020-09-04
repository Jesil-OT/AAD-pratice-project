package com.jesil.pratice.aad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class SplashScreenActivity : AppCompatActivity() {

    companion object{
        const val DELAY_MILLS = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splashScreen()

    }


    // splash Screen Handler
    private fun splashScreen(){
        Handler().postDelayed({
            startActivity(Intent(this, LeaderBoardActivity::class.java))
            finish()
        }, DELAY_MILLS.toLong())
    }
}