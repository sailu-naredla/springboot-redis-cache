package com.redis.exception;

/**
 * Signals that the exception thrown when there is no data found in the Cache
 *
 */

public class CacheServiceException extends RuntimeException {

    private static final long serialVersionUID = -8225120617128299135L;

    public CacheServiceException(String message) {
        super(message);
    }

    public CacheServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CacheServiceException(Throwable throwable) {
        super(throwable);
    }
}
