package com.example.assignment3calculator;

import android.content.Context;
import android.graphics.Color;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatButton;

public class CalcButton extends AppCompatButton {
    public CalcButton(Context context, CalcButtonData data, OnClickListener onClickListener){
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        params.columnSpec = GridLayout.spec(data.col,data.colSpan, 1);
        setLayoutParams(params);
        setText(data.text);
        setOnClickListener(onClickListener);
        setPadding(24,24,24,24);
        setTextSize(20);
        if(data.type.equals("OPERATOR")){
            setBackgroundColor(getResources().getColor(R.color.operator));
        }

        if (data.type.equals("NUMBER")) {
            setBackgroundColor(getResources().getColor(R.color.number));
        }

        if (data.type.equals("CLEAR")){
            setBackgroundColor(getResources().getColor(R.color.clear));
        }

        if (data.type.equals("EQUALS")){
            setBackgroundColor(getResources().getColor(R.color.equals));
        }
    }


}
