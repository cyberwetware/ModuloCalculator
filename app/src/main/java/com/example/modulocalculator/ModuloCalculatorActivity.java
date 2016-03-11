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
//import android.widget.TextView;
import android.os.Bundle;


public class ModuloCalculatorActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView  tv = new TextView(this);
//        ModuloCalculatorJni mJni = new ModuloCalculatorJni();
//        tv.setText("result equal " + mJni.nativeAdd(300, 500));

//        tv.setText("result equal " + mJni.nativeSubtract(700, 500));
//        tv.setText("result equal " + mJni.nativeSubtract(700, 900));

//        tv.setText("result equal " + mJni.nativeMultiply(400, 5));
//          tv.setText("result equal " + mJni.nativeMultiply(-7, 5));

//        tv.setText("result equal " + mJni.nativeModulo(15, 9));
//        tv.setText("result equal " + mJni.nativeModulo(-7, 3)); // 2
//        tv.setText("result equal " + mJni.nativeModulo(-25, 7)); // 3
//        tv.setText("result equal " + mJni.nativeModulo(25, -7)); // 3
//        tv.setText("result equal " + mJni.nativeModulo(-25, -7)); // 3
//        setContentView(tv);
    }

}
