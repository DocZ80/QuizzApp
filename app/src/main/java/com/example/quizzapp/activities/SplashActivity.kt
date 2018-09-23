package com.example.quizzapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.quizzapp.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    lateinit var animation: Animation
    val SPLASH_DURATION = 2500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
    }



    fun initFunctionality() {
        splashLayout.postDelayed({
            progressBar.visibility = View.INVISIBLE
            ivSplashIcon.startAnimation(animation)

            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}

                override fun onAnimationEnd(animation: Animation) {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    this@SplashActivity.finish()
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }, SPLASH_DURATION)
    }

    override fun onResume() {
        super.onResume()
        initFunctionality()
    }


}
