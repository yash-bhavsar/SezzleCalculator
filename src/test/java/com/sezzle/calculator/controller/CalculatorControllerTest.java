package com.sezzle.calculator.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.LinkedList;

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

    @Test
    void calculate_returns_error_when_divided_by_0() {
        String ans = controller.calculate(1.0, 0.0, "/");
        assertEquals(ans, "Failure, cannot divide by 0.");
    }

    @Test
    void getAllCalculatios_returns_latest_10_calculations() {
        //setuo
        for (int i = 0; i < 5; i++) {
            controller.calculate(1.0, 2.0, "+");
        }

        //test the return data structure is a Linked List.
        assertEquals(controller.getAllCalculations().getClass(), LinkedList.class);

        assertEquals(controller.getAllCalculations().size(), 10);

        for (int i = 0; i < 6; i++) {
            controller.calculate(3.0, 2.0, "-");
        }

        assertEquals(controller.getAllCalculations().size(), 10);
    }
}
