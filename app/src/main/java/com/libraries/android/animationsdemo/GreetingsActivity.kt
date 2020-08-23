package com.libraries.android.animationsdemo

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_greetings.*
import kotlinx.android.synthetic.main.activity_main.*

class GreetingsActivity : AppCompatActivity(), Animator.AnimatorListener {

    private var fadeAnimator: Animator? = null
    private var textViewArray = mutableListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greetings)

        textViewArray.add(E)
        textViewArray.add(L)
        textViewArray.add(LtextView)
        textViewArray.add(O)
        greetMe.setOnClickListener {
            H.visibility = View.VISIBLE
            startGreeting(H)
        }
    }

    fun startGreeting(textView: TextView?) {

        fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha2)
        fadeAnimator?.apply {
            setTarget(textView)
            addListener(this@GreetingsActivity)
            startDelay = 100
            start()
        }
    }

    fun showE() {
        E.visibility = View.VISIBLE
        startGreeting(E)

    }

    fun showL() {
        L.visibility = View.VISIBLE
        startGreeting(L)

    }

    fun showLL() {
        LtextView.visibility = View.VISIBLE
        startGreeting(LtextView)
    }

    fun showO() {
        O.visibility = View.VISIBLE
        startGreeting(LtextView)
    }

    override fun onAnimationRepeat(animation: Animator?) {

    }

    override fun onAnimationEnd(animation: Animator?) {
        var textView = H
        when (animation) {
            fadeAnimator -> {
//                textViewArray.forEach {
//                    startGreeting(it)
//
//                }
            }
        }

        if (textView == H) {
            showE()
            textView = E
        }
        if(textView == E){
            showL()
        }
    }


override fun onAnimationCancel(animation: Animator?) {

}

override fun onAnimationStart(animation: Animator?) {

}
}
