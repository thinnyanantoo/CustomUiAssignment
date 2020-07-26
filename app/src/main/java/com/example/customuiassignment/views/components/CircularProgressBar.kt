package com.example.customuiassignment.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.core.content.withStyledAttributes
import com.example.customuiassignment.R

class CircularProgressBar @JvmOverloads constructor(
    context : Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0)
    : ProgressBar(context, attrs, defStyleAttr){

    private val path = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mPaintProgress = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var text = "%"

    private var textBoundRect = Rect()

    private var centerX  = 0f

    private var centerY = 0f

    private  var  swipeAndgle = 0f

    private var mRectF = RectF()

    private var paintColor = Color.LTGRAY
    private var progressColor = Color.RED
    private var textColor = Color.BLACK
    private var textSize = 0.3f


    init {
        context.withStyledAttributes(attrs, R.styleable.CircularProgressBar){
            text = getString(R.styleable.CircularProgressBar_text)?: text
            paintColor = getColor(R.styleable.CircularProgressBar_paint,paintColor)
            progressColor = getColor(R.styleable.CircularProgressBar_mPaintprogress,progressColor)
            textColor = getColor(R.styleable.CircularProgressBar_textColor, textColor)
            textSize = getDimension(R.styleable.CircularProgressBar_textSize, textSize)

        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        var viewHeight = MeasureSpec.getSize(heightMeasureSpec)

        var radius = (measuredWidth.coerceAtMost(measuredHeight)).toFloat()

        path.reset()

        centerX = (viewWidth / 2).toFloat()
        centerY = (viewHeight / 2).toFloat()
        path.addCircle(centerX,centerY,radius, Path.Direction.CW)

        var smallCircleRadius = (measuredWidth.coerceAtLeast(measuredHeight)).toFloat()
        path.addCircle(centerX,centerY,smallCircleRadius, Path.Direction.CW)

        mRectF = RectF(centerX - smallCircleRadius , centerY - smallCircleRadius, centerX + smallCircleRadius, centerY + smallCircleRadius )

        textPaint.textSize = radius * 0.2f

    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 15.0f
        // paint.strokeCap = Paint.Cap.ROUND
        paint.color = paintColor

        mPaintProgress.style = Paint.Style.STROKE
        mPaintProgress.strokeWidth = 15.0f
        mPaintProgress.color = progressColor

        textPaint.style = Paint.Style.FILL
        textPaint.color = textColor
        textPaint.strokeWidth = 0.5f

        val rectangle = RectF(10f, 10f,width.minus(20f),height.minus(20f))

        canvas?.drawArc(rectangle , 0f , 360f, false, paint)

        canvas?.drawPath(path, paint)

        canvas?.drawArc(rectangle, 270f, swipeAndgle, false, mPaintProgress)

        drawTextCentered(canvas)
    }

    private fun drawTextCentered(canvas: Canvas?){
        textPaint.getTextBounds(text, 0 , text.length, textBoundRect)
        canvas?.drawText(text, centerX - textBoundRect.exactCenterX(), centerY - textBoundRect.exactCenterY(), textPaint);
    }

    override fun setProgress(progress: Int) {
        super.setProgress(progress)

        val percentage = progress * 100 / max

        swipeAndgle = (percentage * 360 / 100).toFloat()
        text = percentage.toString() + text
        invalidate()
    }

}