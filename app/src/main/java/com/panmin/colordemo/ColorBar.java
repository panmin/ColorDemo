package com.panmin.colordemo;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by panmin on 2017/4/24.
 */

public class ColorBar extends View {
    private static final String TAG = "ColorBar";

    private int color1 = Color.parseColor("#de4444");
    private int color2 = Color.parseColor("#e48937");
    private int color3 = Color.parseColor("#e5de20");
    private int color4 = Color.parseColor("#74bc1e");
    private int color5 = Color.parseColor("#3c9c11");

    private Paint mPaint = new Paint();
    private RectF mRectF = new RectF();

    private List<Map.Entry<Float, Integer>> list = new ArrayList<>();
    public ColorBar(Context context) {
        this(context, null);
    }

    public ColorBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorBar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ColorBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        //Map.Entry<Float, Integer> entry1 = new AbstractMap.SimpleEntry<>(100f,color1);list.add(entry1);
        //Map.Entry<Float, Integer> entry2 = new AbstractMap.SimpleEntry<>(100f,color2);list.add(entry2);
        //Map.Entry<Float, Integer> entry3 = new AbstractMap.SimpleEntry<>(100f,color3);list.add(entry3);
        //Map.Entry<Float, Integer> entry4 = new AbstractMap.SimpleEntry<>(100f,color4);list.add(entry4);
        //Map.Entry<Float, Integer> entry5 = new AbstractMap.SimpleEntry<>(100f,color5);list.add(entry5);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = 0;
        float sum = list.size()*100;
        /*for (int i = 0; i < list.size(); i++) {
            Map.Entry<Float, Integer> entry = list.get(i);
            sum += entry.getKey();
        }*/

        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Float, Integer> entry = list.get(i);
            mPaint.setColor(entry.getValue());
            //mPaint.setStrokeWidth(10);
            mRectF.top = 0;
            mRectF.bottom = this.getHeight();
            mRectF.left = width;
            width += entry.getKey()/sum*(float)this.getWidth();
            mRectF.right = width;
            Log.e(TAG, "onDraw: "+sum +"     width="+width);
            canvas.drawRect(mRectF,mPaint);
        }
        canvas.save();
    }

    public void addData(float data,int color){
        Map.Entry<Float, Integer> entry1 = new AbstractMap.SimpleEntry<>(data,color);list.add(entry1);
        invalidate();
    }
}
