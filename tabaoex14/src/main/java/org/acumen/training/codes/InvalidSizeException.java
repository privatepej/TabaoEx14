package org.acumen.training.codes;

public class InvalidSizeException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "cannot be negative.";
	
	public InvalidSizeException() {}
	
	public InvalidSizeException(String message) {
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
