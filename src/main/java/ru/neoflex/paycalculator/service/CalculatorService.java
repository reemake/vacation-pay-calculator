package ru.neoflex.paycalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int getVacationPay(int workerSalary, int workerVacationDays) {
        return (int) (workerSalary / 29.3 * workerVacationDays);
    }
}
