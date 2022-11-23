package com.example.customviewproject1123

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * TODO: document your custom view class.
 */
class ProgressView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var startImage : ImageView
    private lateinit var endImage : ImageView
    private lateinit var currentImage : ImageView

    //att
    private var progressBarColor : Int = 0
    private var progressBaseBarColor : Int = 0
    private var maxStep : Int = 0
    private var nowStep : Int = 0


    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = context.theme.obtainStyledAttributes(attrs,R.styleable.ProgressView,0,0)
            progressBarColor = typedArray.getInt(R.styleable.ProgressView_progressBarColor,R.color.teal_200)
            progressBaseBarColor =typedArray.getInt(R.styleable.ProgressView_progressBarColor,R.color.purple_700)
            maxStep =typedArray.getInt(R.styleable.ProgressView_maxStep,9)
            nowStep =typedArray.getInt(R.styleable.ProgressView_nowStep,0)
        }
        View.inflate(context, R.layout.sample_progcess_view, this)
        startImage  = findViewById(R.id.startImage)
        endImage    = findViewById(R.id.endImage)
        currentImage    = findViewById(R.id.currentImage)

        val ta = context.obtainStyledAttributes(attrs, R.styleable.ProgressView)
        try {
            val drawableIdStart = ta.getResourceId(R.styleable.ProgressView_image, 0)
            if (drawableIdStart != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableIdStart)
                startImage.setImageDrawable(drawable)
            }
            val drawableIdEnd = ta.getResourceId(R.styleable.ProgressView_image2, 0)
            if (drawableIdEnd != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableIdEnd)
                endImage.setImageDrawable(drawable)
            }
            val drawableIdCurrent = ta.getResourceId(R.styleable.ProgressView_image3, 0)
            if (drawableIdCurrent != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableIdCurrent)
                currentImage.setImageDrawable(drawable)
            }
        } finally {
            ta.recycle()
        }
    }

    fun setMaxStep(max : Int){
        maxStep = max
        invalidate()
    }

    fun setNowStep(value : Int){
        nowStep = value
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centreX= startImage.x + startImage.width / 2
        val centreY= startImage.y + startImage.height / 2
        val endCentreX= endImage.x + endImage.width / 2
        val encCentreY= endImage.y + endImage.height / 2
        val currentCentreX= currentImage.x + currentImage.width / 2
        val currentCentreY= currentImage.y + currentImage.height / 2

        currentImage.x = currentCentreX * 3

        val newCurrentImageX = currentImage.x + currentImage.width / 2

        val allLength = (centreX + newCurrentImageX) / maxStep

        canvas.apply {
            drawLine(
                centreX,centreY,
                endCentreX ,centreY,
                Paint().apply {
                    color = Color.BLACK
                    strokeWidth = 5f
                }
            )

            drawLine(
                centreX,centreY,
                newCurrentImageX ,centreY,
                Paint().apply {
                    color = Color.RED
                    strokeWidth = 5f
                }
            )

            drawLine(
                centreX,centreY,
                allLength ,200f,
                Paint().apply {
                    color = Color.GREEN
                    strokeWidth = 5f
                }
            )
        }

//        currentImage.。 。


    }

}