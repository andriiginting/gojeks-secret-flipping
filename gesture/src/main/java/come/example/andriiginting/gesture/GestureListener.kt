package come.example.andriiginting.gesture

import android.content.Context
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import java.lang.Exception

/**
 * Created by andriiginting on 20/01/19.
 */
class GestureListener(val context: Context) : GestureDetector.SimpleOnGestureListener() {

    companion object {
        const val SWIPE_THRESHOLD = 100
        const val SWIPE_PATH_CONSTANT_VALUE = 200
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return super.onDown(e)
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        val result = false

        try {
            if (e1?.y!! > SWIPE_PATH_CONSTANT_VALUE) {
                return result
            }
        } catch (e: Exception) {
            Log.e("swipe-gesture", e.message)
        }

        return super.onFling(e1, e2, velocityX, velocityY)
    }

}
