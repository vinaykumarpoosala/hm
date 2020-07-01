package com.hms.exceptions;

public class ApplicationException extends RuntimeException {

    /**
	 * remove if not worked
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException(String message){
        super(message);

    }
}