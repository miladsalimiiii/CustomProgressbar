package com.milad.customprogressbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.os.Handler
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import java.util.*

class SolidCircularProgressbar(context: Context?, attrs: AttributeSet?) :
    AppCompatImageView(context,attrs) {

    private val mHandler = Handler()
    private var mTimeInterval = 0
    private var mColor = 0
    private var mIsStroke=false
    private val mLocations = IntArray(2)
    private val mPaint = Paint(Paint.DITHER_FLAG)

    init {
        if (attrs!=null) {
            val typedArray =
                getContext().obtainStyledAttributes(attrs, R.styleable.SolidCircularProgressbar)
            mColor = typedArray.getColor(
                R.styleable.SolidCircularProgressbar_color,
                Color.RED
            )
            mTimeInterval=typedArray.getInteger(R.styleable.SolidCircularProgressbar_timeInterval,30000)
            mIsStroke=typedArray.getBoolean(R.styleable.SolidCircularProgressbar_isStroke,false)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mTimeInterval == 0) return
        val now = Calendar.getInstance()
        val seconds = now[Calendar.SECOND]
        val mStartAngel = (((seconds % (mTimeInterval / 1000)).toFloat()
                / (mTimeInterval / 1000)) * 360).toInt()
        mPaint.color = mColor
        mPaint.style = Paint.Style.FILL
        if (mIsStroke)
        mPaint.style = Paint.Style.STROKE
        getLocationOnScreen(mLocations)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas!!.drawArc(
                0f,
                0f,
                width.toFloat(),
                height.toFloat(),
                -90f,
                mStartAngel.toFloat(),
                true,
                mPaint
            )
        } else {
            val oval = RectF()
            oval[0f, 0f, width.toFloat()] = height.toFloat()
            canvas!!.drawArc(oval, -90f, mStartAngel.toFloat(), true, mPaint)
        }
        updatePainting()
    }

    private fun updatePainting() {
        mHandler.postDelayed(
            { this.invalidate() },
            mTimeInterval / 360.toLong()
        )
    }

    fun setTimeInterval(otpGenerationPeriodInSeconds: Int) {
        mTimeInterval = otpGenerationPeriodInSeconds
    }

//    fun setColor(color:Color){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            mColor=color.toArgb()
//        }
//    }
}