package org.acumen.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Coin {
	public static final int PENNY = 1;
	public static final int NICKEL = 5;
	public static final int DIME = 10;
	public static final int QUARTER = 25;
	public static final int HALFDOLLAR = 50;
	public static final int SILVERDOLLAR = 100;
	public static final int INVALID = 0;
	private int value;
    private static final Logger LOGGER = LogManager.getLogger("LOGGER4");


	public Coin(String coin) {
		LOGGER.info("Start Coin.");
		String toUpperCoin = coin.toUpperCase();
		if (toUpperCoin.equals("PENNY"))
			value = PENNY;
		else if (toUpperCoin.equals("NICKEL"))
			value = NICKEL;
		else if (toUpperCoin.equals("DIME"))
			value = DIME;
		else if (toUpperCoin.equals("QUARTER"))
			value = QUARTER;
		else if (toUpperCoin.equals("HALFDOLLAR"))
			value = HALFDOLLAR;
		else if (toUpperCoin.equals("SILVERDOLLAR"))
			value = SILVERDOLLAR;
		else
			value = INVALID;
		LOGGER.info("Value Coin: {}.",value);

	}

	public int getValue() {
		LOGGER.info("start getValue");
		return value;
	}

	public String toString() {
		LOGGER.info("start toString");

		String returnValue = new String(Integer.toString(value));
		LOGGER.info("toString: {}.",returnValue);

		LOGGER.info("end toString");
		return returnValue;
	}
}