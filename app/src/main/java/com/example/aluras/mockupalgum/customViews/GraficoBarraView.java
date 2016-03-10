package com.example.aluras.mockupalgum.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.aluras.mockupalgum.R;

/**
 * TODO: document your custom view class.
 */
public class GraficoBarraView extends View {
    private int mClosedColor = Color.GRAY;
    private int mSizePercent = 100;


    public GraficoBarraView(Context context) {
        super(context);
        init(null, 0);
    }

    public GraficoBarraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GraficoBarraView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.GraficoBarraView, defStyle, 0);

        a.recycle();

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        float rectLeft = paddingLeft;
        float rectTop = paddingTop;
        float rectRight = (contentWidth*(mSizePercent/100)) + paddingLeft;
        float rectBottom = contentHeight + paddingTop;

        Paint paintRect = new Paint();
        paintRect.setColor(mClosedColor);

        canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, paintRect);

    }

    public int getmClosedColor() {
        return mClosedColor;
    }

    public void setmClosedColor(int mClosedColor) {
        this.mClosedColor = mClosedColor;
    }

    public int getmSizePercent() {
        return mSizePercent;
    }

    public void setmSizePercent(int mSizePercent) {
        this.mSizePercent = mSizePercent;
    }
}
