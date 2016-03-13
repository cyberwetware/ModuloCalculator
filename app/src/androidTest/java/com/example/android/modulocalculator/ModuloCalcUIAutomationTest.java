package com.example.android.modulocalculator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.modulocalculator.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by domzjing@gmail.com on 13/03/16
 * UI Automation testing for Modulo Calculator
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ModuloCalcUIAutomationTest {

    @Rule
    public ActivityTestRule<ModuloCalculatorActivity> mModuloCalcActivityTestRule =
            new ActivityTestRule<>(ModuloCalculatorActivity.class);

    @Before
    public void initExpressions() {
    }

    @Test
    public void validSubtractExpression() {
        // Expect 4 = (145 - 505 ) % 7
        // Type expression string, then press the equal button
        onView(withId(R.id.btn_one)).perform(click());
        onView(withId(R.id.btn_four)).perform(click());
        onView(withId(R.id.btn_five)).perform(click());
        onView(withId(R.id.btn_subtract)).perform(click());
        onView(withId(R.id.btn_five)).perform(click());
        onView(withId(R.id.btn_zero)).perform(click());
        onView(withId(R.id.btn_five)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());

        // Check that the result in TextView
        onView(withId(R.id.textEdit)).check(matches(withText("4")));
    }

//    @Test
//    public void invalidAddExpression() {
//        // Invalid expression (214 + ) % 7
//        // Type expression string, then press the equal button
//        onView(withId(R.id.btn_two)).perform(click());
//        onView(withId(R.id.btn_one)).perform(click());
//        onView(withId(R.id.btn_four)).perform(click());
//        onView(withId(R.id.btn_add)).perform(click());
//        onView(withId(R.id.btn_equal)).perform(click());
//
//        // Check that the result in TextView
//        onView(withId(R.id.textEdit)).check(matches(withText("4")));
//    }

    @Test
    public void validAddExpression() {
        // Expect 3 = (451 + 406) % 7
        // Type expression string, then press the equal button
        onView(withId(R.id.btn_four)).perform(click());
        onView(withId(R.id.btn_five)).perform(click());
        onView(withId(R.id.btn_one)).perform(click());
        onView(withId(R.id.btn_add)).perform(click());
        onView(withId(R.id.btn_four)).perform(click());
        onView(withId(R.id.btn_zero)).perform(click());
        onView(withId(R.id.btn_six)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());

        // Check that the result in TextView
        onView(withId(R.id.textEdit)).check(matches(withText("3")));
    }

    @Test
    public void validMultiplyExpression() {
        // Expect 2 = (5 * 6) % 7
        // Type expression string, then press the equal button
        onView(withId(R.id.btn_five)).perform(click());
        onView(withId(R.id.btn_multiply)).perform(click());
        onView(withId(R.id.btn_six)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());

        // Check that the result in TextView
        onView(withId(R.id.textEdit)).check(matches(withText("2")));
    }

    @Test
    public void invalidMultiplyExpression() {
        // Expect 3307227286 = 52162 x 63403, correct result should be 3307227286,
        // but on 32 bits system the largest positive value of an integer
        // is 2147483647
        onView(withId(R.id.btn_five)).perform(click());
        onView(withId(R.id.btn_two)).perform(click());
        onView(withId(R.id.btn_one)).perform(click());
        onView(withId(R.id.btn_six)).perform(click());
        onView(withId(R.id.btn_two)).perform(click());
        onView(withId(R.id.btn_multiply)).perform(click());
        onView(withId(R.id.btn_six)).perform(click());
        onView(withId(R.id.btn_three)).perform(click());
        onView(withId(R.id.btn_four)).perform(click());
        onView(withId(R.id.btn_zero)).perform(click());
        onView(withId(R.id.btn_three)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());

        // Check that the result in TextView
        onView(withId(R.id.textEdit)).check(matches(withText("2")));
    }
}
