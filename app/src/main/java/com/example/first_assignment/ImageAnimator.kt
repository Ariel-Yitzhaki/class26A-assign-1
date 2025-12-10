package com.example.first_assignment

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView


class ImageAnimator(
    private val image1: ImageView,
    private val image2: ImageView,
    private val image3: ImageView,
    private val image4: ImageView,
    private val reachedBottom: () -> Unit
) {
    private var currentIndex = 0
    //looper ensures the handler runs on the main thread
    private val handler = Handler(Looper.getMainLooper())
    private var cycleCount = 0

    fun start() {
        currentIndex = 0
        cycleCount = 0
        animateBomb()
    }

    private fun animateBomb() {
        if (cycleCount < 4) {
            if (currentIndex > 0) {
                when(currentIndex - 1) {
                    0 -> image1.visibility = View.INVISIBLE
                    1 -> image2.visibility = View.INVISIBLE
                    2 -> image3.visibility = View.INVISIBLE
                    3 -> image4.visibility = View.INVISIBLE
                }
            }

            when(currentIndex) {
                0 -> image1.visibility = View.VISIBLE
                1 -> image2.visibility = View.VISIBLE
                2 -> image3.visibility = View.VISIBLE
                3 -> image4.visibility = View.VISIBLE
            }

            currentIndex = (currentIndex + 1) % 4
            cycleCount++
            val delay: Long = if (cycleCount == 4){
                reachedBottom()
                400
            } else 800
            handler.postDelayed({ animateBomb() }, delay)
        } else {
            image4.visibility = View.INVISIBLE
        }
    }
}


