package ru.netology.courseprojectmoneytransfer.exception;

public class ErrorConfirmation extends RuntimeException {
    public ErrorConfirmation (String msg) {
        super(msg);
    }
}
