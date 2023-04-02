package ru.netology.courseprojectmoneytransfer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.courseprojectmoneytransfer.logger.TransactionLogger;
import ru.netology.courseprojectmoneytransfer.model.Code;
import ru.netology.courseprojectmoneytransfer.model.Transaction;
import ru.netology.courseprojectmoneytransfer.service.MoneyTransferServiceInterfaceImpl;
import ru.netology.courseprojectmoneytransfer.service.MoneyTransferServiceInterface;

@RestController
public class MoneyTransferControllerInterfaceImpl implements MoneyTransferControllerInterface {

    private final MoneyTransferServiceInterface service;

    private final TransactionLogger logger = new TransactionLogger();

    public MoneyTransferControllerInterfaceImpl(MoneyTransferServiceInterfaceImpl service) {
        this.service = service;
    }

    @Override
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody Transaction transaction) {
        logger.log(transaction);
        return service.transfer(transaction);
    }

    @Override
    @PostMapping("/confirmOperation")
    public ResponseEntity<String> confirmOperation(@RequestBody Code code) {
        return service.confirmOperation(code);
    }
}
