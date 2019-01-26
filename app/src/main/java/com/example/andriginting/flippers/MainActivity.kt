package com.example.andriginting.flippers

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var animRightOut: AnimatorSet
    private lateinit var animLeftIn: AnimatorSet

    private lateinit var frontCoins: ImageView
    private lateinit var backCoins: ImageView
    private lateinit var randomPoint: TextView

    private var isBackCoinsVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        frontCoins = findViewById(R.id.coins)
        randomPoint = findViewById(R.id.random_point)
        backCoins = findViewById(R.id.coins)

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

    private fun rotateCoins(view: View){
        if (!isBackCoinsVisible){

        }
    }
}
