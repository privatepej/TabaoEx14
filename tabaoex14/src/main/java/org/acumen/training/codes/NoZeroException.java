package org.acumen.training.codes;

public class NoZeroException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "Invalid element value: [0 is not allowed]";
	
	public NoZeroException() {}
	
	public NoZeroException(String message) {
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
