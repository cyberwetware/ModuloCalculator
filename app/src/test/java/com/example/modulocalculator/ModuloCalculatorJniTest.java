package com.example.modulocalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by domzjing@gmail.com on 12/03/16.
 */
public class ModuloCalculatorJniTest {

    private ModuloCalculatorJni mNativeCalculator;

    @Before
    public void setUp() throws Exception {
         mNativeCalculator = new ModuloCalculatorJni();
    }

    @Test
    public void testNativeAdd() throws Exception {
        // Expect: 52 = 17 + 35
        assertEquals(52, mNativeCalculator.nativeAdd(17, 35), 0);
    }

    @Test
    public void testNativeSubtract() throws Exception {
        // Expect: 221 = 572 - 793
        assertEquals(221, mNativeCalculator.nativeSubtract(700, 500), 0);
    }

    @Test
    public void testNativeMultiply() throws Exception {
        // Expect: 450080 = 485 x 928
        assertEquals(450080, mNativeCalculator.nativeMultiply(485, 928), 0);
    }

    @Test
    public void testNativeModulo() throws Exception {
        // Expect: 5 = (4982 - 7595) % 7
        assertEquals(5, mNativeCalculator.nativeModulo(4982, 7595), 0);
    }
}