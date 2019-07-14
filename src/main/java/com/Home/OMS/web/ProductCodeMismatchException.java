package com.Home.OMS.web;

public class ProductCodeMismatchException extends RuntimeException{

	 public ProductCodeMismatchException() {
	        super();
	    }

	    public ProductCodeMismatchException(final String message, final Throwable cause) {
	        super(message, cause);
	    }

	    public ProductCodeMismatchException(final String message) {
	        super(message);
	    }

	    public ProductCodeMismatchException(final Throwable cause) {
	        super(cause);
	    }
	
}
