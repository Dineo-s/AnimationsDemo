package com.libraries.android.animationsdemo

import android.animation.*
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/*
 using AnimatorInflater is an example of using xml to apply animation
 */
class MainActivity : AppCompatActivity(), Animator.AnimatorListener {

    private var rotateAnimator: Animator? = null
    private var translateAnimator: Animator? = null
    private var scaleAnimator: Animator? = null
    private var fadeAnimator: ObjectAnimator? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun rotateAnimation(view: View) {

        rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun scaleAnimation(view: View) {

        scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
        scaleAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun translateAnimation(view: View) {

        translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun fadeAnimation(view: View) {
// not using XML
        fadeAnimator = ObjectAnimator.ofFloat(targetImage, "alpha", 1.0f, 0.0f)
        fadeAnimator?.apply {
            duration = 1500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    // Implementation of AnimatorListener interface
    override fun onAnimationStart(animation: Animator?) {

        when (animation) {
            rotateAnimator -> Toast.makeText(this, "Rotate Animation Started", Toast.LENGTH_SHORT)
                .show()
            fadeAnimator -> Toast.makeText(this, "Fade Animation Started", Toast.LENGTH_SHORT)
                .show()
            translateAnimator -> Toast.makeText(
                    this, "Translate Animation Started", Toast.LENGTH_SHORT
                )
                .show()
            scaleAnimator -> Toast.makeText(this, "Scale Animation Started", Toast.LENGTH_SHORT)
                .show()
            else -> Toast.makeText(this, "Some Animation Started", Toast.LENGTH_SHORT)
                .show()
        }

        Toast.makeText(this, "Animation Started", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationRepeat(animation: Animator?) {

        Toast.makeText(this, "Animation Repeated", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(animation: Animator?) {

        if (animation == rotateAnimator) {
            fadeAnimation(targetImage)
        }
    }

    override fun onAnimationCancel(animation: Animator?) {
        Toast.makeText(this, "Animation Cancelled", Toast.LENGTH_SHORT).show()
    }

    fun setFromXML(view: View) {
        val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
        animator.apply {
            setTarget(targetImage)
            start()
        }
    }

    fun setFromCode(view: View) {
        //xml representation set.xml
        // Root Animator Set
        val rootSet = AnimatorSet()

// Flip Animation
        val flip = ObjectAnimator.ofFloat(targetImage, "rotationX", 0.0f, 360.0f)
        flip.duration = 500

// Child Animator Set
        val childSet = AnimatorSet()

// Scale Animations
        val scaleX = ObjectAnimator.ofFloat(targetImage, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500
        scaleX.interpolator = OvershootInterpolator()

        val scaleY = ObjectAnimator.ofFloat(targetImage, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500
        scaleX.interpolator = OvershootInterpolator()


        rootSet.playSequentially(flip, childSet)
        childSet.playTogether(scaleX, scaleY)

        //Alternative is to chain animations
        rootSet.start()
    }


}
