package com.sezzle.calculator.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorControllerTest {

    private CalculatorController controller;

    @BeforeAll
    public void setup() {
        controller = new CalculatorController();
    }

    @Test
    public void calculate_returns_correct_answer_with_all_valid_inputs() {
        String ans = controller.calculate(1.0,2.0,"+");
        assertEquals(ans, "3.0");

        ans = controller.calculate(1.0,2.0,"-");
        assertEquals(ans, "-1.0");

        ans = controller.calculate(1.0,2.0,"*");
        assertEquals(ans, "2.0");

        ans = controller.calculate(1.0,2.0,"/");
        assertEquals(ans, "0.5");
    }
}
