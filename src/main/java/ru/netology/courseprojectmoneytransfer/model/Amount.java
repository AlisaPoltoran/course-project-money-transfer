package ru.netology.courseprojectmoneytransfer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Amount {
    private int value;
    private String currency;
}
