package ru.neoflex.paycalculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.neoflex.paycalculator.dto.WorkerDataDTO;
import ru.neoflex.paycalculator.service.CalculatorService;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void calculationSucceedWithStatus200Test() throws Exception {

        WorkerDataDTO workerData = new WorkerDataDTO(65000, 14);
        int vacationPay = (int) (workerData.getSalary() / 29.3 * workerData.getVacationDays());
        Mockito.when(calculatorService.getVacationPay(Mockito.anyInt(), Mockito.anyInt())).thenReturn(vacationPay);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(workerData))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test(expected = RuntimeException.class)
    public void calculationFailedWithStatus422Test() throws Exception {

        WorkerDataDTO workerData = new WorkerDataDTO(-65000, 14);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(workerData))
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
