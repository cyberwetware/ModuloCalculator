package com.example.android.modulocalculator;

import android.util.Log;

import com.example.android.modulocalculator.ModuloCalculatorJni;

/**
 * Created by domzjing@gmail.com on 12/03/16.
 * Simple calculation library, include expression parser and native methods invoking
 */
public class Expression {
    private final static String TAG = "Expression";

    private final static int FIXED_DIVIDEND = 7;
    private final String mExpression;
    private int mOperandX;
    private int mOperandY;
    private Character mOperator;
    ModuloCalculatorJni mNativeCalculator;

    public Expression(String expression) {
        this.mExpression = expression;

        mNativeCalculator = new ModuloCalculatorJni();
    }

    // Calculator needs two oprands in an expression
    public int evaluate() {
        int result = 0xFFFFFFFF;

        // Parse the expression, a simple expression parser implemented for the modulo calculator
        String operators[] = mExpression.split("x|-|\\+");
//        Log.d(TAG, "Operators length " + operators.length);

        if(operators.length < 2) {
            // Invalid expression
            return result;
        }

        if(mExpression.indexOf('+') > 0) {
            mOperator = '+';
        } else if(mExpression.indexOf('-') > 0) {
            mOperator = '-';
        } else if(mExpression.indexOf('x') > 0) {
            mOperator = 'x';
        }

        // Some invalid expressions will trigger the exception
        try {
            mOperandX = Integer.parseInt(operators[0]);
            mOperandY = Integer.parseInt(operators[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        switch (mOperator) {
            case '+':
                result = mNativeCalculator.nativeAdd(mOperandX, mOperandY);
                break;
            case '-':
                result = mNativeCalculator.nativeSubtract(mOperandX, mOperandY);
                break;
            case 'x':
                result = mNativeCalculator.nativeMultiply(mOperandX, mOperandY);
                break;
        }

        return mNativeCalculator.nativeModulo(result, FIXED_DIVIDEND);
    }
}
