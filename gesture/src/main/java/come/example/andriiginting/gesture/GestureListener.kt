package come.example.andriiginting.gesture

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent

/**
 * Created by andriiginting on 20/01/19.
 */
class GestureListener(val context: Context, val simpleOnGestureListener: GestureDetector.SimpleOnGestureListener) :
    GestureDetector.SimpleOnGestureListener() {

    companion object {
        const val SWIPE_LEFT = 0
        const val SWIPE_RIGHT = 1
    }

    val gestureDetector: GestureDetector by lazy {
        GestureDetector(context, this)
    }

    fun onTouch(event: MotionEvent){
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {

        return super.onFling(e1, e2, velocityX, velocityY)
    }
}
