package com.sezzle.calculator.manager;


import com.sezzle.calculator.model.Calculation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorManagerImplTest {

    CalculatorManagerImpl manager;

    @BeforeAll
    void setup() {
        manager = CalculatorManagerImpl.getInstance();
    }

    @Test
    void validateCalculation_returns_true_when_calculation_is_valid() {
        //test
        assertTrue(manager.validateCalculation(1.0,1.0,"/"));
    }

    @Test
    void validateCalculation_returns_false_when_calculation_is_not_valid() {
        //test
        assertFalse(manager.validateCalculation(1.0, 0.0, "/"));
    }

    @Test
    void performCalculation_returns_calculation_object_after_performing_calculation() {
        //setup
        Calculation calc = manager.performCalculation(1.0,1.0, "+");

        //test
        assertEquals(calc.getmAnswer(), 2.0);
    }

    @Test
    void storeCalculation_stores_the_calculation_in_queue() {
        //setup
        Calculation calc = manager.performCalculation(1.0,1.0, "+");
        manager.storeCalculation(calc);

        //test
        assertEquals(manager.getAllCalculations().size(), 1);
    }

    @Test
    void getAllCalculations_returns_linked_list_of_latest_10_calculations() {
        //setup
        for (int i = 0; i < 12; i++) {
            Calculation calc = new Calculation();
            calc.setmTimestamp(new Date());
            manager.storeCalculation(calc);
        }

        //test
        assertEquals(manager.getAllCalculations().size(), 10);
    }
}
