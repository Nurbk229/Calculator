package com.nurbk.ps.caluculatorproject.model;

import java.util.Stack;


public class CalculatorModel implements ICalculator {

    private static String LOG_TAG = "Model";

    private Stack<String> dataStack = new Stack<String>();
    private boolean isOperate = false;

    public static double calculate(Stack<String> stack) {
        double tmpResult = 0;

        try {
            double tmpOperand = Double.parseDouble(stack.pop());
            if (stack.isEmpty()) {
                return tmpOperand;
            }
            String tmpOperate = stack.pop();
            if (tmpOperate.equals("+")) {
                tmpResult = calculate(stack) + tmpOperand;
            } else if (tmpOperate.equals("-")) {
                tmpResult = calculate(stack) - tmpOperand;
            } else if (tmpOperate.equals("X")) {
                tmpResult = calculate(stack) * tmpOperand;
            } else if (tmpOperate.equals("/")) {
                tmpResult = calculate(stack) / tmpOperand;
            } else if (tmpOperate.equals("%")) {
                tmpResult = calculate(stack) % tmpOperand;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return tmpResult;
    }

    @Override
    public void pushOperand(String operand) {
        dataStack.add(operand);
        isOperate = false;
    }

    @Override
    public double pushOperate(String operate) {
        double tmpResult = 0;
        if (isOperate) {
            dataStack.pop();
        }
        if (operate.equals("=")) {
            tmpResult = calculate(dataStack);
            dataStack.add(String.valueOf(tmpResult));
        } else {
            Stack<String> tmpStack = (Stack<String>) dataStack.clone();
            tmpResult = calculate(tmpStack);
            dataStack.add(operate);
            isOperate = true;
        }

        return tmpResult;
    }

    @Override
    public void reset() {
        dataStack.removeAllElements();
        isOperate = false;
    }
}
