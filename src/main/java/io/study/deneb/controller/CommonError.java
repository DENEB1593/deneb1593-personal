package io.study.deneb.controller;

public class CommonError {

    private int status;
    private String message;

    public CommonError(int status, Throwable e) {
        this.status = status;
        this.message = e.getLocalizedMessage();
    }
}
