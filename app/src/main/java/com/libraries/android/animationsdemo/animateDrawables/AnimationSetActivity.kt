package com.libraries.android.animationsdemo.animateDrawables

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.libraries.android.animationsdemo.R
import kotlinx.android.synthetic.main.activity_drawables.*

class AnimationSetActivity : AppCompatActivity() {
    lateinit var boyRunningAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_set)
    }

    override fun onStart() {
        super.onStart()
        targetImage.setBackgroundResource(R.drawable.girl_walking_animation_set)
        boyRunningAnimation = targetImage.background as AnimationDrawable
        boyRunningAnimation.start()
    }

    // Button click event handler
    fun startStopAnimation(view: View) {
        if (boyRunningAnimation.isRunning) boyRunningAnimation.stop() else boyRunningAnimation.start()
    }
}
