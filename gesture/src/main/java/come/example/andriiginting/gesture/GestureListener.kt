package come.example.andriiginting.gesture

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent

/**
 * Created by andriiginting on 20/01/19.
 */
class GestureListener : GestureDetector.OnGestureListener {

    override fun onShowPress(e: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDown(e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLongPress(e: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        const val SWIPE_THRESHOLD = 100
        const val SWIPE_PATH_CONSTANT_VALUE = 200
    }


    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        if (e1?.x!! - e2!!.x > 50) {
            //swipe left
            Log.d("swipe-gestures", "on swipe to the left")
            return true
        }

        if (e2.x - e1.x > 50) {
            //swipe right
            Log.d("swipe-gestures", "on swipe to the right")
            return true
        }
        return true
    }
}
