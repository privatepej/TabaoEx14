package org.acumen.training.codes;

public class NoSpecialCharException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "Invalid element value: [special characters]";
	
	public NoSpecialCharException() {}
	
	public NoSpecialCharException(String message) {
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
