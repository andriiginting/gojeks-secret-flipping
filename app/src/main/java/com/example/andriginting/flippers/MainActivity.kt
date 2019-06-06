package com.example.andriginting.flippers

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.example.andriginting.flippers.utils.isGone

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var animRightOut: AnimatorSet
    private lateinit var animLeftIn: AnimatorSet
    private var isVisible: Boolean? = false

    private lateinit var frontCoins: View
    private lateinit var backCoins: View
    private lateinit var point: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        frontCoins = findViewById(R.id.front_layout)
        backCoins = findViewById(R.id.back_layout)
        point = findViewById(R.id.front_random_point)

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

    private fun flipCoins() {
        isVisible = if (!isVisible!!) {
            animRightOut.setTarget(frontCoins)
            animLeftIn.setTarget(backCoins)
            animRightOut.start()
            randomPoint()
            animLeftIn.start()
            true
        } else {
            animRightOut.setTarget(backCoins)
            animLeftIn.setTarget(frontCoins)
            animRightOut.start()
            animLeftIn.start()
            false

        }
    }

    private fun randomPoint(){
        val randomPoint = listOf(10,20,30,55,45)
        for(i in 0..5){
            point.text = randomPoint[Random().nextInt(randomPoint.size)].toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_points_available -> {
                flipCoins()
            }
        }

        return true
    }

}
