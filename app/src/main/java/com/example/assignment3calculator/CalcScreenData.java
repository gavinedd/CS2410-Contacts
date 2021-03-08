package com.example.assignment3calculator;

public class CalcScreenData {
    public String text;
    public int row;
    public int col;
    public int colSpan;

    public CalcScreenData(String text, int row, int col, int colSpan){
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
    }
}
