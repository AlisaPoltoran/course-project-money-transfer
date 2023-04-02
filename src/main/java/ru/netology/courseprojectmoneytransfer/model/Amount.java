package ru.netology.courseprojectmoneytransfer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class Amount {
    @Min(value = 1)
    private int value;
    @NotNull
    private String currency;

    private final double COMMISSION = 0.01;

    public double calcCommission() {
        return this.value * COMMISSION;
    }
}
