package ru.avdey.exception;



public class ProductCheckException extends Exception {

    public ProductCheckException() {
    }

    public ProductCheckException(String message) {
        super(message);
    }

    public ProductCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductCheckException(Throwable cause) {
        super(cause);
    }

    public ProductCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
