package com.example.modulocalculator;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by domzjing@gmail.com on 12/03/16.
 * Simple calculation library
 */
public class Expression {
    private final static String TAG = "Expression";

    private final static int FIXED_DIVIDEND = 7;
    private final String mExpression;
    private int mOperandX;
    private int mOperandY;
    private Character mOperator;
//    private int mOperandCount;

    public Expression(String expression) {
        if(expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("Empty expression");
        }

        this.mExpression = expression;
    }
    // Calculator needs two oprands in an expression
    public int evaluate() {
        int result = 0xFFFFFFFF;

        // Parse the expression, a simple expression parser implemented for the modulo calculator
//        String operators[] = this.mExpression.split("x|-|\\+");
        String operators[] = mExpression.split("x|-|\\+");
//        Log.d(TAG, "Original expression length: " + expression.trim().length());
//        Log.d(TAG, "Original expression:" + expression);

//        Log.d(TAG, "Token + " + expression.indexOf('+'));
//        Log.d(TAG, "Token - " + expression.indexOf('-'));
//        Log.d(TAG, "Token x " + expression.indexOf('x'));

//        Log.d(TAG, "Operators length " + operators.length);
//        mOperandCount = operators.length;
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
//FIXME
//        if(mOperator != '+' && mOperator != '-' && mOperator != 'x') {
//            // Invalid expression
//            return result;
//        }

//        for(int i=0; i<operators.length; i++)
//            Log.d(TAG, "Operator " + i + "=" + operators[i]);
        try {
            mOperandX = Integer.parseInt(operators[0]);
            mOperandY = Integer.parseInt(operators[1]);
        } catch (NumberFormatException e) {
            // TODO
            e.printStackTrace();
        }
        // Calculator needs two oprands in an expression
//        if(mOperandCount < 2 || mOperator == '=') {
//            // Invalid expression
//            return result;
//        }

        ModuloCalculatorJni nativeCalculator = new ModuloCalculatorJni();

        switch (mOperator) {
            case '+':
                result = nativeCalculator.nativeAdd(mOperandX, mOperandY);
                Log.d(TAG, "Expression " + mOperandX + " + " + mOperandY + " = " + result);
                break;
            case '-':
                result = nativeCalculator.nativeSubtract(mOperandX, mOperandY);
                Log.d(TAG, "Expression " + mOperandX + " - " + mOperandY + " = " + result);
                break;
            case 'x':
                result = nativeCalculator.nativeMultiply(mOperandX, mOperandY);
                Log.d(TAG, "Expression " + mOperandX + " x " + mOperandY + " = " + result);
                break;
        }

//        mOperandCount = '=';
        result = nativeCalculator.nativeModulo(result, FIXED_DIVIDEND);
        Log.d(TAG, "Expression " + result + " mod " + FIXED_DIVIDEND + " = " + result);
//        return nativeCalculator.nativeMultiply(result, FIXED_DIVIDEND);
        return result;
    }
}
