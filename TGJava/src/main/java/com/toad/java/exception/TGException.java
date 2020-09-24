package com.toad.java.exception;

public class TGException extends Exception {

    protected String errorMessage;
    protected String errorCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public TGException setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public TGException setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
