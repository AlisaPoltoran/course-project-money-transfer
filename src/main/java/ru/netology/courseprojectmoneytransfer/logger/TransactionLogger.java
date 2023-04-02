package ru.netology.courseprojectmoneytransfer.logger;

import ru.netology.courseprojectmoneytransfer.model.Transaction;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionLogger {

    private static final Logger LOGGER = Logger.getLogger(TransactionLogger.class.getName());
    private static FileHandler fh;

    public static void log(Transaction transaction) {
        try {
            fh = new FileHandler("D:/Java/course-project-money-transfer/transactionLogs.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.addHandler(fh);
      LOGGER.log(Level.INFO, LocalDateTime.now() + transaction.toString());
    }


}
