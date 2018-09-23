package com.example.quizzapp.utilities

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.example.quizzapp.R

object AppUtilities {
    private var backPressed: Long = 0

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun tapPromptToExit(activity: Activity) {
        if (backPressed + 2500 > System.currentTimeMillis()) {
            activity.finish()
        } else {
            showToast(activity.applicationContext, activity.resources.getString(R.string.tap_again))
        }
        backPressed = System.currentTimeMillis()
    }
}