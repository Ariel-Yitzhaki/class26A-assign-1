package com.example.first_assignment

import android.view.View
import android.widget.ImageView

class CarController(
    car1: ImageView,
    car2: ImageView,
    car3: ImageView
) {
    private val cars = arrayOf(car1, car2, car3)

    fun moveCar(currentIndex: Int, newIndex: Int) {
        cars[currentIndex].visibility = View.INVISIBLE
        cars[newIndex].visibility = View.VISIBLE
    }
}