package com.example.first_assignment

import android.view.View
import android.widget.ImageView

class LivesController(
    private val lives1: ImageView,
    private val lives2: ImageView,
    private val lives3: ImageView
) {
    private val lives = arrayOf(lives1, lives2, lives3)

    fun removeLives(index: Int) {
        if (index >= 0) {
            lives[index].visibility = View.INVISIBLE
        }
    }

}