package com.shop.com.learnevaluator.evaluator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by caozhiyu on 17/5/17.
 */
public class AnimView extends View {

    public static final float RADIUS = 80.0f;
    private Point point;
    private Paint paint;

    public AnimView(Context context) {
        super(context);
        init();
    }

    public AnimView(Context context, AttributeSet set) {
        super(context, set);
        init();
    }

    public AnimView(Context context, AttributeSet set, int defStyleAttr) {
        super(context, set, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
    }

    private void drawCircle(Canvas canvas) {
        float x = point.getX();
        float y = point.getY();
        canvas.drawCircle(x, y, RADIUS, paint);
    }

    private void startAnimation() {
        Point start = new Point(RADIUS, RADIUS);
        Point end = new Point(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                point = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(3001);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (point == null) {
            point = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }
}
