package com.libraries.android.animationsdemo

import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_vector_drawable.*


class VectorDrawablesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector_drawable)

        var isChecked = true
        avdImage.setOnClickListener {
            if (isChecked)
                checkToClose()
            else
                closeToCheck()

            isChecked = !isChecked
        }

    }

    private fun closeToCheck() {
        avdImage.setImageResource(R.drawable.avd_close_to_check)
        val avdCheckToClose = avdImage.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }

    private fun checkToClose() {
        avdImage.setImageResource(R.drawable.avd_check_to_close)
        val avdCheckToClose = avdImage.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()

    }
}
