package com.example.hostelspring.exception;

public class NoSuchEntityException extends IllegalArgumentException{
    public NoSuchEntityException() {
        super();
    }

    public NoSuchEntityException(String s) {
        super(s);
    }
}
