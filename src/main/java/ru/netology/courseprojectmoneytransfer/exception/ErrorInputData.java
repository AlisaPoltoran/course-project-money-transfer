package ru.netology.courseprojectmoneytransfer.exception;

public class ErrorInputData extends RuntimeException {
    public ErrorInputData(String msg) {
        super(msg);
    }
}
