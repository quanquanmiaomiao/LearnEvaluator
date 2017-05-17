package com.shop.com.learnevaluator.evaluator;


import android.animation.TypeEvaluator;

/**
 * Created by caozhiyu on 17/5/17.
 */
public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point start, Point end) {
        float x = start.getX() + fraction * (end.getX() - start.getX());
        float y = start.getY() + fraction * (end.getY() - start.getY());
        Point point = new Point(x, y);
        return point;
    }
}
