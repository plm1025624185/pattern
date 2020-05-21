package com.plm.pattern.util.exception;

import java.io.IOException;

public class FileNotSupportException extends IOException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7456539981520074444L;

	public FileNotSupportException() {
		super();
	}
	
	public FileNotSupportException(String message) {
		super(message);
	}

}
