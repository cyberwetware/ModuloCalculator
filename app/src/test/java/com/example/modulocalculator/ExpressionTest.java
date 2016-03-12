package com.example.modulocalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by domzjing@gmail.com on 12/03/16.
 */
public class ExpressionTest {

    Expression mExpression;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testEvaluate() throws Exception {
        // Expert 0 = (0 x 7945) % 7
        mExpression = new Expression("0x7935");
        assertEquals(0, mExpression.evaluate(), 0);

        // Expert 5 = (9234 + 6241) % 7
        mExpression = new Expression("9234+6241");
        assertEquals(5, mExpression.evaluate(), 0);

        // Expert 6 = (69 + 0) % 7
        mExpression = new Expression("69+0");
        assertEquals(6, mExpression.evaluate(), 0);

        // Expert 3 = (24381 - 98361) % 7
        mExpression = new Expression("24381-98361");
        assertEquals(3, mExpression.evaluate(), 0);
    }
}