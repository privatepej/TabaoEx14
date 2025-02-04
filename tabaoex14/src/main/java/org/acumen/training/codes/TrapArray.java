package org.acumen.training.codes;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrapArray {
	
    private static final Logger LOGGER = LogManager.getLogger("LOGGER3");

	private int[] array;

	public void arrayTransact() {
		LOGGER.info("TrapArray starts.");
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				int sizeInput = getValidatedInput(scanner, "Enter the Array Size: ");

				if (sizeInput > 0) {
					array = new int[sizeInput];
                    LOGGER.info("Array of {} integers created.", sizeInput);
					for (int i = 0; i < sizeInput; i++) {
						array[i] = getValidatedInputArray(scanner, "Enter the value: ");
					}
					while (true) {
	                    int index = getValidatedIndex(scanner, "Enter the Index that you want to view: ", sizeInput);
	                    System.out.printf("The Value in index %d is %d %n", index, array[index]); // Formatted output
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getValidatedInput(Scanner scanner, String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("e")) {
				System.out.println("Goodbye");
				System.exit(0);
			}
			try {
				if (input.matches("[1-9]+")) {
					int size = Integer.parseInt(input);
					return size;
				} else if(input.equals("0")) {
					LOGGER.error("Invalid element value: [0 is not allowed]");
					throw new NoZeroException();
				}
				else if (input.matches(".*[a-zA-Z].*" ) && input.length() == 1) {
					LOGGER.error("Invalid element value: [character].");
					throw new ElementCharException();
				} else if (input.matches(".*[a-zA-Z].*") && input.length() > 1) {
					LOGGER.error("Invalid element value: [string]");
					throw new NoStringException();
				} else if (input.matches("[0-9]*\\.[0-9]+")) {
					LOGGER.error("You cannot put decimal number.");
					throw new ElementDecimalException();
				} else if (input.matches(".*[^\\w\\s-].*")){
					LOGGER.error("Invalid element value: [special characters]");
					throw new NoSpecialCharException();
				} else if (input.length() == 1 && input.equals("-")) {
					LOGGER.error("Invalid element value: [special characters]");
					throw new NoSpecialCharException();
				} else
					LOGGER.error("cannot be negative.");
					throw new InvalidSizeException();
				} catch (ElementCharException 
					| ElementDecimalException 
					| InvalidSizeException 
					| NoStringException 
					| NoSpecialCharException 
					| NoZeroException e) {
		        	LOGGER.fatal(e.getMessage());
			}
		}
	}

	private int getValidatedInputArray(Scanner scanner, String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("e")) {
				System.out.println("Goodbye");
				return -1;
			}
			try {
				if (input.matches("[0-9]+")) {
					return Integer.parseInt(input);
				} else if (input.matches(".*[a-zA-Z].*" ) && input.length() == 1) {
					LOGGER.error("Invalid element value: [character].");
					throw new ElementCharException();
				} else if (input.matches(".*[a-zA-Z].*") && input.length() > 1) {
					LOGGER.error("Invalid element value: [string]");
					throw new NoStringException();
				} else if (input.matches("[0-9]*\\.[0-9]+")) {
					LOGGER.error("You cannot put decimal number.");
					throw new ElementDecimalException();
				} else if (input.matches(".*[^\\w\\s-].*")){
					LOGGER.error("Invalid element value: [special characters]");
					throw new NoSpecialCharException();
				} else if (input.length() == 1 && input.equals("-")) {
					LOGGER.error("Invalid element value: [special characters]");
					throw new NoSpecialCharException();
				} else
					LOGGER.error("cannot be negative.");
					throw new InvalidSizeException();
				} catch (ElementCharException 
					| ElementDecimalException 
					| InvalidSizeException 
					| NoStringException 
					| NoSpecialCharException e) {
		        	LOGGER.fatal(e.getMessage());
			}
		}
	}

	private int getValidatedIndex(Scanner scanner, String prompt, int arraySize) {
	    while (true) {
	        System.out.print(prompt);
	        String input = scanner.nextLine();

	        if (input.equalsIgnoreCase("e")) {
	            System.out.println("Goodbye");
	            System.exit(0);
	        }
	        try {
	            int index = Integer.parseInt(input);
	            if (index < 0 || index >= arraySize) {
	            	LOGGER.error("Invalid index is not within the range of the array.");
	                throw new BadIndexException();
	            }
	            return index; 
	        } catch (NumberFormatException e) {
	        	LOGGER.fatal(e.getMessage());
	        } catch (BadIndexException e) {
	        	LOGGER.fatal(e.getMessage());
	        }
	    }
	}

}

