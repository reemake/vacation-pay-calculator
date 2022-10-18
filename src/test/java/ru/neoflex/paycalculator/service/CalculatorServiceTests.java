package ru.neoflex.paycalculator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.neoflex.paycalculator.dto.WorkerDataDTO;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CalculatorServiceTests {

    @Autowired
    CalculatorService calculatorService;

    @Test
    public void calculateVacationPayTest() {

        WorkerDataDTO workerData = new WorkerDataDTO(65000, 14);

        int expectedVacationPay = 31058;
        int actualVacationPay = calculatorService.getVacationPay(workerData.getSalary(), workerData.getVacationDays());

        assertEquals(expectedVacationPay, actualVacationPay);
    }
}
