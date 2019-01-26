package com.example.andriginting.flippers

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var animRightOut: AnimatorSet
    private lateinit var animLeftIn: AnimatorSet

    private lateinit var frontCoins: ImageView
    private lateinit var randomPoint: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.navigationIcon = resources.getDrawable(R.drawable.gopoints)
        setSupportActionBar(toolbar)

        frontCoins = findViewById(R.id.coins)
        randomPoint = findViewById(R.id.random_point)

        loadAnimations()
        changeViewState()

    }

    private fun changeViewState() {
        val spinnerTimes = 8000
        val viewScale = resources.displayMetrics.density.times(spinnerTimes)
        frontCoins.cameraDistance = viewScale

    }

    @SuppressLint("ResourceType")
    private fun loadAnimations() {
        animRightOut = AnimatorInflater.loadAnimator(this, R.anim.coin_animator) as AnimatorSet
        animLeftIn = AnimatorInflater.loadAnimator(this, R.anim.in_coin_animator) as AnimatorSet
    }

}
