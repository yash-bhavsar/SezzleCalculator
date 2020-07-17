package com.sezzle.calculator.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculationTest {

    private Calculation calculation;

    @BeforeAll
    public void setup() {
        calculation = new Calculation();
    }

    @Test
    void test_getters_and_setters() {
        //setup
        Date d = new Date();
        calculation.setmValue1(1.0);
        calculation.setmValue2(2.0);
        calculation.setmOperator("+");
        calculation.setmAnswer(3.0);
        calculation.setmTimestamp(d);

        //test
        assertEquals(calculation.getmAnswer(), 3.0);
        assertEquals(calculation.getmOperator(), "+");
        assertEquals(calculation.getmValue1(), 1.0);
        assertEquals(calculation.getmValue2(), 2.0);
        assertEquals(calculation.getmTimestamp(), d);
    }
}
