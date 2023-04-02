package ru.netology.courseprojectmoneytransfer.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.netology.courseprojectmoneytransfer.model.Code;
import ru.netology.courseprojectmoneytransfer.model.Transaction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MoneyTransferRepositoryInterfaceImpl implements MoneyTransferRepositoryInterface {

    private static final Map<AtomicInteger, Transaction> transactions = new ConcurrentHashMap<>();
    private static AtomicInteger operationId = new AtomicInteger(0);

    private static final String VERIFICATION_CODE = "0000";

    @Override
    public ResponseEntity<String> transfer(Transaction transaction) {
        operationId.incrementAndGet();
        transactions.put(operationId, transaction);
        return ResponseEntity.ok(String.valueOf(operationId));
    }

    @Override
    public ResponseEntity<String> confirmOperation(Code code) {
        if (code.getCodeNumber().equals(VERIFICATION_CODE)) {
            return ResponseEntity.ok(String.valueOf(operationId));
        } else {
            return ResponseEntity.ok("0");
        }
    }
}
