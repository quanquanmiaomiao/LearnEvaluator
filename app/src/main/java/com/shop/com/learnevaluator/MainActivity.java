package com.shop.com.learnevaluator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shop.com.learnevaluator.evaluator.AnimView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new AnimView(this));
    }
}
