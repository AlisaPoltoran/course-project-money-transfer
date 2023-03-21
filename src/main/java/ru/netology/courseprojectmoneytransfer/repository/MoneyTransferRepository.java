package ru.netology.courseprojectmoneytransfer.repository;

import org.springframework.stereotype.Repository;
import ru.netology.courseprojectmoneytransfer.model.Transaction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MoneyTransferRepository {

    private static final Map<Integer, Transaction> transactions = new ConcurrentHashMap<>();
    private static int operationId = 0;

    public String transfer(Transaction transaction) {
        operationId++;
        transactions.put(operationId, transaction);
        return Integer.toString(operationId);
    }

    public String confirmOperation(String code) {
      return String.valueOf(operationId);
    }
}
