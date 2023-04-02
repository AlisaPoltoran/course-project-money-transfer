package ru.netology.courseprojectmoneytransfer.repository;

import org.springframework.http.ResponseEntity;
import ru.netology.courseprojectmoneytransfer.model.Code;
import ru.netology.courseprojectmoneytransfer.model.Transaction;

public interface MoneyTransferRepositoryInterface {
    ResponseEntity<String> transfer(Transaction transaction);

    ResponseEntity<String> confirmOperation(Code code);
}
