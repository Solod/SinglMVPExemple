package com.solodilov.evgen.singlmvpexemple;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class CustomText extends View {
    private String mText;
    Paint p = new Paint();

    public CustomText(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CustomText, defStyle, 0);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.GREEN);
        p.setTextSize(50);
        canvas.drawText(mText, 150, 525, p);
    }

    public void setText(String s) {
        mText = s;
        invalidate();
    }
}
