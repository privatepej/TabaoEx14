package org.acumen.training.codes;

public class BadIndexException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "Invalid index is not within the range of the array.";
	
	public BadIndexException() {}
	
	public BadIndexException(String message) {
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