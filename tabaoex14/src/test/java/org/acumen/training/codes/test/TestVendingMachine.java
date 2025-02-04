package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.acumen.training.codes.Coin;
import org.acumen.training.codes.VendingMachine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestVendingMachine {
	private VendingMachine vendingMachine;

	@BeforeEach
	public void setup() {
		vendingMachine = new VendingMachine();
	}

	@AfterEach
	public void teardown() {
		vendingMachine = null;
	}

	@Order(1)
	@RepeatedTest(2)
	@ParameterizedTest
	@ValueSource(strings = { "PENNY", "1", "DIME", "0", "HALFDOLLAR", "f" })
	public void testInsertValidCoin(String data) {
		Coin coin = new Coin(data);
		vendingMachine.insert(coin);
		
	}
	
	@Order(2)
	@RepeatedTest(2)
    public void testReturnCoinsLogs() {
        Coin quarter = new Coin("QUARTER");
        vendingMachine.insert(quarter);
        vendingMachine.returnCoins();

      
    }
	
	@Order(3)
	@RepeatedTest(2)
    public void testVendLogs() {
		Coin coin = new Coin("QUARTER");
        vendingMachine.insert(coin);
        vendingMachine.insert(coin);
        assertThrows(Exception.class, () -> {
            vendingMachine.vend();
        });
    }
	
	@Order(4)
	@RepeatedTest(2)
    public void testMixedCoin() {
		Coin quarter = new Coin("QUARTER");
        vendingMachine.insert(quarter);
        Coin halfDollar = new Coin("HALFDOLLAR");
        vendingMachine.insert(halfDollar);
        assertThrows(Exception.class, () -> {
            vendingMachine.vend();
        });
    }

}
