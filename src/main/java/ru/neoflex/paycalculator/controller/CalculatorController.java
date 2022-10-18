package ru.neoflex.paycalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.paycalculator.dto.WorkerDataDTO;
import ru.neoflex.paycalculator.exception.IncorrectSalaryException;
import ru.neoflex.paycalculator.service.CalculatorService;

@RestController
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculate")
    int getVacationPay(@RequestBody WorkerDataDTO workerData) {
        if (workerData.getSalary() < 0)
            throw new IncorrectSalaryException();
        return calculatorService.getVacationPay(workerData.getSalary(), workerData.getVacationDays());
    }
}
