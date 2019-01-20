package com.example.andriginting.flippers

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var animRightOut: AnimatorSet
    private lateinit var animLeftIn: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    private fun changeViewState() {
        val d = 8000
        val viewScale = resources.displayMetrics.density.times(d)
    }

    @SuppressLint("ResourceType")
    private fun loadAnimations(){
        animRightOut = AnimatorInflater.loadAnimator(this, R.anim.coin_animator) as AnimatorSet
        animLeftIn = AnimatorInflater.loadAnimator(this, R.anim.in_coin_animator) as AnimatorSet
    }

}
