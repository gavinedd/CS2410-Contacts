package com.example.assignment3calculator;

public class Calculator {
    public static double evaluate(String expression) throws Exception {
        String[] tokens = expression.split(" ");

        if (tokens.length == 1){
            return Double.parseDouble(tokens[0]);
        }

        if (tokens.length == 2){
            throw new Exception("Two arguments");
        }

        double currentValue = Double.parseDouble(tokens[0]);
        String operation = tokens[1];
        String mode = "value";

        for (int i =2; i < tokens.length; i ++){
            if (mode.equals("value")){
                double foundValue = Double.parseDouble(tokens[i]);

                if (operation.equals("+")) {
                    currentValue = currentValue + foundValue;
                }
                if (operation.equals("-")) {
                        currentValue = currentValue - foundValue;
                }
                if (operation.equals("/")) {
                        currentValue = currentValue / foundValue;
                }
                if (operation.equals("*")) {
                        currentValue = currentValue * foundValue;
                }

                mode = "operator";

            }else{
                operation = tokens[i];
                mode = "value";
            }
        }

        return currentValue;
    }
}
