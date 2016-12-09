package com.up366.mobile.common.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.TextView;

import com.up366.common.utils.DPUtils;

/**
 * Created by win on 2016/12/8.
 */
public class CircleDialogView extends TextView {
    private final Paint p;
    private final RectF oval2;
    private Rect targetRect;
    private float strokeWidth = 15;
    private float textStrokeWidth = 10;


    public CircleDialogView(Context context) {
        super(context);
        p = new Paint();
        //画椭圆，把oval改一下
        oval2 = new RectF(0, 0, DPUtils.dp2px(45), DPUtils.dp2px(45));// 设置个新的长方形，扫描测量
        targetRect = new Rect();
//        oval2.set(0, 100, 250, 130);
        p.setTextSize(getTextSize());
        p.setColor(getTextColors().getDefaultColor());
        p.setColor(0xffff4444);
        p.setTextAlign(Paint.Align.CENTER);
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 创建画笔
        p.setColor(0x33ff0000);
        canvas.drawOval(oval2, p);
        int width = getWidth();
        int height = getHeight();
        targetRect.set(0, 0, width, height);
        p.setColor(Color.WHITE);
        p.setStrokeWidth(textStrokeWidth);
        p.setStyle(Paint.Style.FILL);
        p.setTextSize(50);
        Paint.FontMetricsInt fontMetrics = p.getFontMetricsInt();
        // 转载请注明出处：http://blog.csdn.net/hursing
        int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        // 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
        canvas.drawText(getText().toString(), targetRect.centerX(), baseline, p);
    }
}
