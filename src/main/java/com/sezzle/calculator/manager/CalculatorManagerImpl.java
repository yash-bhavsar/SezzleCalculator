package com.sezzle.calculator.manager;

import com.sezzle.calculator.model.Calculation;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class CalculatorManagerImpl implements ICalculatorManager {

    private static final CalculatorManagerImpl manager = new CalculatorManagerImpl();
    private final Queue<String> calculationsQueue = new LinkedList<>();

    private CalculatorManagerImpl() {}

    public static CalculatorManagerImpl getInstance() {
        return manager;
    }

    @Override
    public boolean validateCalculation(Double operand1, Double operand2, String operator) {
        return !operator.equals("/") || operand2 != 0;
    }

    @Override
    public Calculation performCalculation(Double operand1, Double operand2, String operator) {
        Calculation calc = new Calculation();
        calc.setmTimestamp(new Date());
        calc.setmValue1(operand1);
        calc.setmValue2(operand2);
        calc.setmOperator(operator);

        switch (operator) {
            case "+":
                calc.setmAnswer(operand1 + operand2);
                break;
            case "-":
                calc.setmAnswer(operand1 - operand2);
                break;
            case "*":
                calc.setmAnswer(operand1 * operand2);
                break;
            case "/":
                calc.setmAnswer(operand1 / operand2);
                break;
            default:
                calc.setmAnswer(0.0);
        }
        return calc;
    }

    @Override
    public void storeCalculation(Calculation calculation) {
        calculationsQueue.offer(calculation.toString());
        if (calculationsQueue.size() > 10) {
            calculationsQueue.poll();
        }
    }

    @Override
    public Queue<String> getAllCalculations() {
        return calculationsQueue;
    }
}
