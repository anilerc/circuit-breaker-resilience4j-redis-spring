package com.anilerc.publication.exception;

public class FallbackException extends RuntimeException {

    public FallbackException(Throwable cause) {
        super("Service can not be reached at the moment.", cause);
    }

}
