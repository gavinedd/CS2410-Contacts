package com.example.assignment3calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//   Make an array list of the data for the buttons that need to be made
    private final ArrayList<CalcButtonData> calcButtonData = new ArrayList<CalcButtonData>(){
        {
            add(new CalcButtonData("C", 0,3,1,"CLEAR"));
            add(new CalcButtonData("7", 1,0,1,"NUMBER"));
            add(new CalcButtonData("8", 1,1,1,"NUMBER"));
            add(new CalcButtonData("9", 1,2,1,"NUMBER"));
            add(new CalcButtonData("/", 1,3,1,"OPERATOR"));
            add(new CalcButtonData("4", 2,0,1,"NUMBER"));
            add(new CalcButtonData("5", 2,1,1,"NUMBER"));
            add(new CalcButtonData("6", 2,2,1,"NUMBER"));
            add(new CalcButtonData("*", 2,3,1,"OPERATOR"));
            add(new CalcButtonData("1", 3,0,1,"NUMBER"));
            add(new CalcButtonData("2", 3,1,1,"NUMBER"));
            add(new CalcButtonData("3", 3,2,1,"NUMBER"));
            add(new CalcButtonData("-", 3,3,1,"OPERATOR"));
            add(new CalcButtonData("0", 4,0,2,"NUMBER"));
            add(new CalcButtonData(".", 4,2,1,"NUMBER"));
            add(new CalcButtonData("+", 4,3,1,"OPERATOR"));
            add(new CalcButtonData("=", 5,0,4,"EQUALS"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridLayout calcLayout = new GridLayout(this);
        calcLayout.setId(R.id.calcLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        calcLayout.setLayoutParams(params);
        calcLayout.setColumnCount(4);

        CalcScreen calcScreen = new CalcScreen(this, new CalcScreenData("",0,0,3));
        calcScreen.setId(R.id.calcscreen);
        calcLayout.addView(calcScreen);

        for(CalcButtonData data: calcButtonData){
            CalcButton button = new CalcButton(this, data, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(data.type.equals("CLEAR")){
                        calcScreen.setText("");
                    }

                    if(data.type.equals("EQUALS")){
                        try {
                            double result = Calculator.evaluate((String) calcScreen.getText());
                            calcScreen.setText(result + "");
                        } catch (Exception e){
                            calcScreen.setText("INVALID EXPRESSION");
                        }
                    }

                    if(data.type.equals("OPERATOR")){
                        if (calcScreen.getText().equals("INVALID EXPRESSION")){calcScreen.setText("");}
                        calcScreen.setText(calcScreen.getText() + " " + data.text + " ");
                    }

                    if (data.type.equals("NUMBER")) {
                        if (calcScreen.getText().equals("INVALID EXPRESSION")){calcScreen.setText("");}
                        calcScreen.setText(calcScreen.getText() + data.text);
                    }
                }
            });
            calcLayout.addView(button);
        }
        setContentView(calcLayout);
    }
}