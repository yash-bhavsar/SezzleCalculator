package com.sezzle.calculator.controller;


import com.sezzle.calculator.manager.CalculatorManagerImpl;
import com.sezzle.calculator.manager.ICalculatorManager;
import com.sezzle.calculator.model.Calculation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@RestController
public class CalculatorController {

    private final ICalculatorManager manager = CalculatorManagerImpl.getInstance();

//    CalculatorController () {
//        manager = new CalculatorManagerImpl();
//    }

//    @RequestMapping("/")
//    public String index() {
//        return "Greetings from Yash Bhavsar!";
//    }

    @PostMapping("/api/sezzle/calculator/calculate")
    public String calculate(@RequestParam Double mValue1, @RequestParam Double mValue2, @RequestParam String mOperator) {
        if (manager.validateCalculation(mValue1, mValue2, mOperator)) {
            Calculation calc = manager.performCalculation(mValue1, mValue2, mOperator);
            manager.storeCalculation(calc);
            return calc.getmAnswer().toString();
        } else {
            return "Failure, cannot divide by 0.";
        }
    }

    @GetMapping("/api/sezzle/calculator/getAllCalculations")
    public Queue<String> getAllCalculations() {
        return manager.getAllCalculations();
    }
}
