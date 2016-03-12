/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.modulocalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ModuloCalculatorActivity extends Activity
{
    private final static String TAG = "ModuloCalcActivity";
    private int[] mNumberButtons = {R.id.btn_one, R.id.btn_two, R.id.btn_three,
            R.id.btn_four, R.id.btn_five,
            R.id.btn_six, R.id.btn_zero};
    private int[] mOperatorButtons = {R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply};
    private TextView mTextView;
    // In our case, only two operands are allowed in one expression
    private boolean mlastOperator = false;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mTextView = (TextView) findViewById(R.id.txtEdit);

        // Set OnclickListener to numeral buttons
        numberOnClickListenr();
        // Set OnclickListener to operator buttons
        operatorOnClickListener();
    }

    // Set OnClickListener to numeral buttons
    private void numberOnClickListenr() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
        public void onClick(View view) {
                Button button = (Button) view;
                mTextView.append(button.getText());
            }
        };
        // Register the listener to all the numeral buttons
        for(int id : mNumberButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    // Set OnClickListener to operator buttons
    private void operatorOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mlastOperator == false) {
                    Button button = (Button) view;
                    mTextView.append(button.getText());
                    // Only one operator allowed
                    mlastOperator = true;
                }
            }
        };
        // Register the listener to all the operator buttons
        for(int id : mOperatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }

        // Delete button
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
                // Clear the textView
                mTextView.setText("");
                // Reset the flag
                mlastOperator = false;
            }
        });

        //Equal button
        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intend to process the whole expression in another class
                // to separate logic functions from UI implement
                String expression = mTextView.getText().toString();
                // Calculation
                int result = (new Expression(expression)).evaluate();
//                Expression exp = new Expression(expression);
//                int result = exp.evaluate();
                if(result != 0xFFFFFFFF) {
                    // If result equals 0xFFFFFFFF, do nothing
                    mTextView.setText(Integer.toString(result));
                }
            }
        });
    }
}
