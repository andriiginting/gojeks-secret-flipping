package com.example.andriginting.flippers

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.GestureDetector
import android.view.View
import come.example.andriiginting.gesture.GestureListener

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var animRightOut: AnimatorSet
    private lateinit var animLeftIn: AnimatorSet

    private lateinit var frontCoins: View
    private lateinit var backCoins: View

    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        gestureDetector = GestureDetector(baseContext, GestureListener())

        frontCoins = findViewById(R.id.front_layout)
        backCoins = findViewById(R.id.back_layout)

        loadAnimations()
        changeViewState()
    }

    private fun changeViewState() {
        val spinnerTimes = 8000
        val viewScale = resources.displayMetrics.density.times(spinnerTimes)
        frontCoins.cameraDistance = viewScale
        backCoins.cameraDistance = viewScale
    }

    @SuppressLint("ResourceType")
    private fun loadAnimations() {
        animRightOut = AnimatorInflater.loadAnimator(this, R.anim.coin_animator) as AnimatorSet
        animLeftIn = AnimatorInflater.loadAnimator(this, R.anim.in_coin_animator) as AnimatorSet
    }

}
