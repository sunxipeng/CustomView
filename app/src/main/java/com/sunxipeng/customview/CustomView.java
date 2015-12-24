package com.sunxipeng.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/12/24.
 */
public class CustomView extends View {


    //初始化圆的颜色
    private int mColor = Color.RED;


    //初始化画笔
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public CustomView(Context context) {
        this(context, null);

        initView();
    }

    public CustomView(Context context, AttributeSet attrs) {

        this(context, attrs, 0);

    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.CustomView);

        mColor = a.getColor(R.styleable.CustomView_circle_color,Color.RED);

        initView();
    }


    /**
     * 初始化view
     */
    private void initView(){

       mPaint.setColor(mColor);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpechMode = MeasureSpec.getMode(widthMeasureSpec);

        int widthSpechSize = MeasureSpec.getSize(widthMeasureSpec);

        int heighSpechMode = MeasureSpec.getMode(heightMeasureSpec);

        int heighSpechSize = MeasureSpec.getSize(heightMeasureSpec);

        if(widthSpechMode == MeasureSpec.AT_MOST&& heighSpechMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(200,200);

        }else if(widthSpechMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(200,heighSpechSize);

        }else if(heighSpechMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(widthSpechSize,200);
        }

    }




    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        int width = getWidth();

        int heigh = getHeight();

        int radius = Math.min(width,heigh)/2;

        canvas.drawCircle(width/2,heigh/2,radius,mPaint);
    }
}
