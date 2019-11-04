package com.auction.services;

public class MyServiceException extends RuntimeException {

	public MyServiceException() {
	}

	public MyServiceException(String message) {
		super(message);
	}

	public MyServiceException(Throwable cause) {
		super(cause);
	}

	MyServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
