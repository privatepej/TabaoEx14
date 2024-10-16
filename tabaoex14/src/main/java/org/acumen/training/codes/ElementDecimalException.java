package org.acumen.training.codes;

public class ElementDecimalException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "You cannot put decimal number.";
	
	public ElementDecimalException() {}
	
	public ElementDecimalException(String message) {
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