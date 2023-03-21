package ru.netology.courseprojectmoneytransfer.contorller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.courseprojectmoneytransfer.logger.TransactionLogger;
import ru.netology.courseprojectmoneytransfer.model.Transaction;
import ru.netology.courseprojectmoneytransfer.service.MoneyTransferService;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class MoneyTransferController {

    private final MoneyTransferService service;

    private final TransactionLogger logger = new TransactionLogger();

    public MoneyTransferController(MoneyTransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public String transfer(@Valid @RequestBody Transaction transaction) throws IOException {
        logger.log(transaction);
        return service.transfer(transaction);
    }

    @PostMapping("/confirmOperation")
    public String confirmOperation(@Valid @RequestBody String code) {
        return service.confirmOperation(code);
    }
}
