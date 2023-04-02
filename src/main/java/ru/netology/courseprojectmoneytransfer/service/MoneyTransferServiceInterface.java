package ru.netology.courseprojectmoneytransfer.service;

import org.springframework.http.ResponseEntity;
import ru.netology.courseprojectmoneytransfer.model.Code;
import ru.netology.courseprojectmoneytransfer.model.Transaction;

public interface MoneyTransferServiceInterface {
    ResponseEntity<String> transfer(Transaction transaction);
    ResponseEntity<String> confirmOperation(Code code);
}
