package org.acumen.training.codes;

public class NoStringException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "Invalid element value: [string]";
	
	public NoStringException() {}
	
	public NoStringException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(this.message);
	}

}
