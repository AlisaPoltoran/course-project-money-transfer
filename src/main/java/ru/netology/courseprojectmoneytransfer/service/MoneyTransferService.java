package ru.netology.courseprojectmoneytransfer.service;

import org.springframework.stereotype.Service;
import ru.netology.courseprojectmoneytransfer.model.Transaction;
import ru.netology.courseprojectmoneytransfer.repository.MoneyTransferRepository;

@Service
public class MoneyTransferService {
    private final MoneyTransferRepository repository;

    public MoneyTransferService(MoneyTransferRepository repository) {
        this.repository = repository;
    }

    public String transfer(Transaction transaction) {
        return repository.transfer(transaction);
    }

    public String confirmOperation(String code) {
        return repository.confirmOperation(code);
    }

}
