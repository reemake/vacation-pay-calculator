package ru.neoflex.paycalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkerDataDTO {
    private int salary;
    private int vacationDays;
}
