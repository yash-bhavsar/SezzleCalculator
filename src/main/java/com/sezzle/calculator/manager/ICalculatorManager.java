package com.sezzle.calculator.manager;

import com.sezzle.calculator.model.Calculation;

import java.util.Map;
import java.util.Queue;

public interface ICalculatorManager {

    boolean validateCalculation(Double operand1, Double operand2, String operator);

    /**
     * This method calculates answer for the given operands depending on the operator.
     *
     * @param operand1 operand 1 of the calculation.
     * @param operand2 operand 2 of the calculation.
     * @param operator operator for the calculation.
     * @return answer of the calculation after computing the equation.
     */
    Calculation performCalculation(Double operand1, Double operand2, String operator);

    /**
     * This method stores the calculation in a data structure.
     *
     * @param calculation Calculation that needs to be stored in the memory.
     */
    void storeCalculation(Calculation calculation);

    /**
     * This method is used to fetch 10 latest calculations.
     *
     * @return the latest 10 calculations.
     */
    Queue<String> getAllCalculations();
}
