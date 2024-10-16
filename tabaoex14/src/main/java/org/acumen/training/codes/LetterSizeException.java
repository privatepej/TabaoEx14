package org.acumen.training.codes;

public class LetterSizeException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "LetterSizeException.";
	
	public LetterSizeException() {}
	
	public LetterSizeException(String message) {
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
