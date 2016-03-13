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
package com.example.android.modulocalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.modulocalculator.R;


public class ModuloCalculatorActivity extends Activity
{
    private final static String TAG = "ModuloCalcActivity";

    private int[] mNumberButtons = {R.id.btn_one, R.id.btn_two, R.id.btn_three,
            R.id.btn_four, R.id.btn_five,
            R.id.btn_six, R.id.btn_zero};
    private int[] mOperatorButtons = {R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply};
    private TextView mTextView;
    // Indicator of contents in TextView
    private boolean mEmptyText;

    // In our case, only two operands are allowed in one expression
    private boolean mlastOperator;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain TextView object
        this.mTextView = (TextView) findViewById(R.id.textEdit);

        // Set OnclickListener to numeral buttons
        numberOnClickListenr();
        // Set OnclickListener to operator buttons
        operatorOnClickListener();

        this.mlastOperator = false;
        this.mEmptyText = true;
    }

    // Set OnClickListener to numeral buttons
    private void numberOnClickListenr() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;

                if(mEmptyText == true)
                    // Clean the contents on the TextView
                    mTextView.setText(button.getText());
                else {
                    mTextView.append(button.getText());
                }
                mEmptyText = false;
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
                if(mEmptyText == true) {
                    // Avoid operator as first character
                    return;
                }
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
                mEmptyText = true;
            }
        });

        //Equal button
        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intend to process the whole expression in another class
                // to separate logic functions from UI implement
                String expression = mTextView.getText().toString();
                if(expression == null || expression.trim().length() == 0) {
                   // Do nothing for empty expression
                    return ;
                }

                // Calculation
                int result = (new Expression(expression)).evaluate();
                if(result != 0xFFFFFFFF) {
                    // If result equals 0xFFFFFFFF, do nothing
                    mTextView.setText(Integer.toString(result));
                    // Clear the flag for the next expression
                    mEmptyText = true;
                    mlastOperator = false;
                }
            }
        });
    }
}
