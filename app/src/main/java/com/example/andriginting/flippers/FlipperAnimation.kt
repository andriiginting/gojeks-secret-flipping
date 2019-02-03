package com.example.andriginting.flippers

import android.graphics.Camera
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.Transformation

/**
 * Created by andriiginting on 03/02/19.
 */
class FlipperAnimation(var fromView: View, var toView: View) : Animation() {
    private lateinit var camera: Camera

    private var centerX: Float? = null
    private var centery: Float? = null

    private var forward = true

    init {
        duration = 800
        fillAfter = false
        interpolator = AccelerateDecelerateInterpolator()
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        centerX = (width/2).toFloat()
        centery = (height/2).toFloat()
        camera = Camera()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        val radius = Math.PI * interpolatedTime
        var degrees = (180.0 * radius / Math.PI).toFloat()

        if (interpolatedTime >= 0.5f)
        {
            degrees -= 180.toFloat()
            fromView.visibility = View.GONE
            toView.visibility = View.VISIBLE
        }

        if (forward) degrees = -degrees

        val matrix = t?.matrix
        camera.save()
        camera.rotateY(degrees)
        camera.getMatrix(matrix)
        camera.restore()
        matrix?.preScale(-centerX!!,-centery!!)
        matrix?.postScale(-centerX!!,-centery!!)
    }

    fun reverse(){
        forward = false
        val switchView = toView
        toView = fromView
        fromView = switchView
    }
}