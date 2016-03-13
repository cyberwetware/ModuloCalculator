package com.example.android.modulocalculator;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.modulocalculator.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/**
 * Created by domzjing@gmail.com on 13/03/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ModuloCalcUIAutomationTest {
//    private String mExpressionA = "abc";
//    private String mExpectResultA = "5";

    @Rule
    public ActivityTestRule<ModuloCalculatorActivity> mModuloCalcActivityTestRule =
            new ActivityTestRule<>(ModuloCalculatorActivity.class);

    @Before
    public void initExpressions() {
//        mExpressionA = "152-875";
    }

    @Test
    public void invalidExpression() {
        // Type expression string, then press the equal button
//        onView(withId(R.id.txtEdit)).perform(typeText(mExpressionA), null);

        // Expect 2 = (5 * 6) % 7
        onView(withId(R.id.btn_five)).perform(click());
        onView(withId(R.id.btn_multiply)).perform(click());
        onView(withId(R.id.btn_six)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        // Check that the result in TextView
        onView(withId(R.id.txtEdit)).check(matches(withText("2")));
//        onView(withId(R.id.txtEdit)).check(ViewAssertions.matches(isDisplayed()));
    }
}
