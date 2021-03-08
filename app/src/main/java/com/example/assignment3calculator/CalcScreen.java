package com.example.assignment3calculator;

import android.content.Context;
import android.graphics.Color;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatTextView;

public class CalcScreen extends AppCompatTextView {
    public CalcScreen(Context context, CalcScreenData data) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        params.columnSpec = GridLayout.spec(data.col, data.colSpan, 1);
        setLayoutParams(params);
        setText(data.text);
        setBackgroundColor(getResources().getColor(R.color.screen));
        setTextColor(getResources().getColor(R.color.screenText));
        setTextSize(20);
    }

}