package com.example.assignment3calculator;

public class CalcButtonData {
    public String text;
    public int row;
    public int col;
    public int colSpan;
    public String type;

    public CalcButtonData(String text, int row, int col, int colSpan, String type){
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.type = type;
    }
}
