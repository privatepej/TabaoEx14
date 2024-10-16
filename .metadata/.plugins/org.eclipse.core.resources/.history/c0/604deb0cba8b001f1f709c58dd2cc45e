package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChekcStr {
	
	private static final Logger LOGGER = LogManager.getLogger("LOGGER2");

	
	public ChekcStr() {
		LOGGER.info("Instantiated Class ChekcStr");
	}

	public String convert(String str) {
		LOGGER.info("Start of convert with params: {}",str);
        String result = binarise(total(str));
        LOGGER.info("End of convert, returning: {}", result);
		return binarise(total(str));
	}

	public int total(String str) {
		LOGGER.info("Start of total with params: {}",str);
		if (str == "") {
            LOGGER.info("End of total, returning: 0");
            return 0;
		}
			
		if (str.length() == 1) {
			int value = ((int) (str.charAt(0)));
            LOGGER.info("End of total, returning: {}", value);
            return value;
		}
		int value = ((int) (str.charAt(0))) + total(str.substring(1));
        LOGGER.info("End of total, returning: {}", value);
		return value;

	}

	public String binarise(int givenstrvalue) {
		LOGGER.info("Start of convert with params: {}",givenstrvalue);
		if (givenstrvalue == 0) {
            LOGGER.info("End of binarise, returning: ''");
            return "";
		}
		String result = (givenstrvalue % 2 == 1 ? "1" : "0") + binarise(givenstrvalue / 2);
        LOGGER.info("End of binarise, returning: {}", result);
        return result;
	}

}