package ru.netology.courseprojectmoneytransfer.controller;

import org.springframework.http.ResponseEntity;
import ru.netology.courseprojectmoneytransfer.model.Code;
import ru.netology.courseprojectmoneytransfer.model.Transaction;

public interface MoneyTransferControllerInterface {
    ResponseEntity<String> transfer(Transaction transaction);
    ResponseEntity<String> confirmOperation(Code code);
}
