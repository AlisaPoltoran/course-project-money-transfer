package ru.netology.courseprojectmoneytransfer.exception;

public class ErrorTransfer extends RuntimeException {
    public ErrorTransfer(String msg) {
        super(msg);
    }
}
