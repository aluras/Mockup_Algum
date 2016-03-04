package com.example.aluras.mockupalgum.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.example.aluras.mockupalgum.R;

/**
 * TODO: document your custom view class.
 */
public class PercentView extends View {
    private int mStartColor = Color.GRAY;
    private int mEndColor = Color.GRAY;
    private Drawable mExampleDrawable;
    private int mValue;

    private RectShape mRect;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    public PercentView(Context context) {
        super(context);
        init(null, 0);
    }

    public PercentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PercentView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.PercentView, defStyle, 0);

        mValue = a.getInt(R.styleable.PercentView_value, mValue);

        if (a.hasValue(R.styleable.PercentView_startColor)) {
            mStartColor = a.getColor(
                    R.styleable.PercentView_startColor,
                    mStartColor);
        }

        if (a.hasValue(R.styleable.PercentView_endColor)) {
            mEndColor = a.getColor(
                    R.styleable.PercentView_endColor,
                    mEndColor);
        }

        if (a.hasValue(R.styleable.PercentView_exampleDrawable)) {
            mExampleDrawable = a.getDrawable(
                    R.styleable.PercentView_exampleDrawable);
            mExampleDrawable.setCallback(this);
        }

        a.recycle();

        // Set up a default Rect object
        mRect = new RectShape();

        // Update TextPaint and text measurements from attributes
        invalidateAndMeasurements();
    }

    private void invalidateAndMeasurements() {

      /*  mTextPaint.setTextSize(mExampleDimension);
        mTextPaint.setColor(mExampleColor);
        mTextWidth = mTextPaint.measureText(mExampleString);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        mTextHeight = fontMetrics.bottom;*/
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        Paint p = new Paint();
//        p.setColor(Color.YELLOW);
//        canvas.drawRect(0, 0, getWidth(), getHeight(), p);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        float rectLeft = 0 + paddingLeft + (contentHeight/4);
        float rectTop = (contentHeight/4) + paddingTop;
        float rectRight = contentWidth + paddingLeft - (contentHeight/4);
        float rectBottom = ((contentHeight/4) * 3) + paddingTop;
        float rectRadius = contentHeight / 4;

        Paint paintRect = new Paint();
        Shader gradient = new LinearGradient(rectLeft,rectTop,rectRight,rectBottom, mStartColor, mEndColor,Shader.TileMode.REPEAT);
        paintRect.setShader(gradient);
        canvas.drawRoundRect(rectLeft, rectTop, rectRight, rectBottom, rectRadius, rectRadius, paintRect);

        Paint paintCircle = new Paint();

        if (mValue >= 100){
            mValue = 100;
            paintCircle.setColor(getResources().getColor(R.color.ballExcced));
        }else{
            paintCircle.setColor(getResources().getColor(R.color.ball));
        }

        float circleRadius = ((contentHeight * 3)/8) ;
        float circleX = (((rectRight-rectLeft)/100)*mValue)+paddingLeft+rectRadius;
        float circleY = (getHeight()/2);

        canvas.drawCircle(circleX, circleY, circleRadius, paintCircle);

        // Draw the text.
//        canvas.drawText(mExampleString,
//                paddingLeft + (contentWidth - mTextWidth) / 2,
//                paddingTop + (contentHeight + mTextHeight) / 2,
//                mTextPaint);

        // Draw the example drawable on top of the text.
        if (mExampleDrawable != null) {
            mExampleDrawable.setBounds(paddingLeft, paddingTop,
                    paddingLeft + contentWidth, paddingTop + contentHeight);
            mExampleDrawable.draw(canvas);
        }
    }

    /**
     * Gets the Value attribute value.
     *
     * @return The Value attribute value.
     */
    public int getValue() {
        return mValue;
    }

    /**
     * Sets the view's value attribute value. In the example view
     *
     * @param value The Value attribute value to use.
     */
    public void setValue(int value) {
        mValue = value;
        invalidateAndMeasurements();
    }

    /**
     * Gets the start color attribute value.
     *
     * @return The start color attribute value.
     */
    public int getStartColor() {
        return mStartColor;
    }

    /**
     * Sets the view's start color attribute value
     *
     * @param startColor The example color attribute value to use.
     */
    public void setStartColor(int startColor) {
        mStartColor = startColor;
        invalidateAndMeasurements();
    }

    /**
     * Gets the end color attribute value.
     *
     * @return The end color attribute value.
     */
    public int getEndColor() {
        return mEndColor;
    }

    /**
     * Sets the view's end color attribute value
     *
     * @param endColor The end color attribute value to use.
     */
    public void setEndColor(int endColor) {
        mEndColor = endColor;
        invalidateAndMeasurements();
    }

    /**
     * Gets the example drawable attribute value.
     *
     * @return The example drawable attribute value.
     */
    public Drawable getExampleDrawable() {
        return mExampleDrawable;
    }

    /**
     * Sets the view's example drawable attribute value. In the example view, this drawable is
     * drawn above the text.
     *
     * @param exampleDrawable The example drawable attribute value to use.
     */
    public void setExampleDrawable(Drawable exampleDrawable) {
        mExampleDrawable = exampleDrawable;
    }
}
