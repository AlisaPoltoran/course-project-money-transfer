package ru.netology.courseprojectmoneytransfer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.netology.courseprojectmoneytransfer.exception.ErrorInputData;
import ru.netology.courseprojectmoneytransfer.model.Code;
import ru.netology.courseprojectmoneytransfer.model.Transaction;
import ru.netology.courseprojectmoneytransfer.repository.MoneyTransferRepositoryInterfaceImpl;
import ru.netology.courseprojectmoneytransfer.repository.MoneyTransferRepositoryInterface;

@Service
public class MoneyTransferServiceInterfaceImpl implements MoneyTransferServiceInterface {
    private final MoneyTransferRepositoryInterface repository;

    public MoneyTransferServiceInterfaceImpl(MoneyTransferRepositoryInterfaceImpl repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<String> transfer(Transaction transaction) {
        if (transaction.checkTransaction()) {
            return repository.transfer(transaction);
        } else {
            throw new ErrorInputData("Error customer message: the input data is incorrect");
        }
    }

    @Override
    public ResponseEntity<String> confirmOperation(Code code) {
        if (!repository.confirmOperation(code).equals("0")) {
            return repository.confirmOperation(code);
        }
        throw new ErrorInputData("Error customer message: transaction is not confirmed");
    }
}
