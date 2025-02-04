package org.acumen.training.codes.test;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.acumen.training.codes.ChekcStr;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestChekcStr {

	private ChekcStr Cstr;

	
	@BeforeEach 
	public void setup() {
		Cstr = new ChekcStr();
	}
	
	@AfterEach 
	public void teardown() {
		Cstr = null;
	}
	@Order(1)
	@RepeatedTest(30)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9,10}) 
	public void testBinarise1to10(int data) {
		String[] expected = {"1","10","11","100","101","110","111","1000","1001","1010"};
        String actual = Cstr.binarise(data);
        assertEquals(expected[data - 1], actual);
	}
	@Order(2)
	@ParameterizedTest
	@ValueSource(chars = {'a','b','c','d','e'}) 
	public void testBinariseAtoE(char data) {
		String[] expected = {"1000011","0100011","1100011","0010011","1010011"};
        String actual = Cstr.binarise(data);
        assertEquals(expected[data - 97 ], actual);
	}
	
	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9,10}) 
	public void testBinarise1to10Rainy(int data) {
	    String[] expected = {"0","a","12","101","110","111","1001","1010","1011","1100"};
	    String actual = Cstr.binarise(data);
	    assertNotEquals(expected[data - 1], actual);
	}
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(chars = {'a','b','c','d','e'}) 
	public void testBinariseAtoERainy(char data) {
	    String[] expected = {"1000001","0100001","1100001","0010001","1010001"};
	    String actual = Cstr.binarise(data);
	    assertNotEquals(expected[data - 97], actual);
	}
	
	@Order(5)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9,10}) 
	public void testBinariseNotMoreThan10(int data) {
		int expected = 10;
	    String actual = Cstr.binarise(data);
	    assertTrue(actual.length() <= expected);
	}
	
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9,10}) 
	public void testBinariseCheckEmpty(int data) {
	    String actual = Cstr.binarise(data);
	    assertTrue(actual.length() > 0);
	}
	
	@Order(7)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9,10}) 
	public void testBinariseCheckEmptyRainy(int data) {
	    String actual = Cstr.binarise(data);
	    assertFalse(actual.isEmpty());
	}
	
	@Order(8)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9,10}) 
	public void testBinariseCheckEmptyRainy2(int data) {
		int expected = 10;
	    String actual = Cstr.binarise(data);
	    assertFalse(actual.length() >= expected);
	}
	
	
	@Order(9)
	@ParameterizedTest
	@ValueSource(strings = {"1","2","3","4","5","6","7","8","9","10"}) 
	public void testTotalAscii(String data) {
		int[] expected = {49,50,51,52,53,54,55,56,57,97};
	    int actual = Cstr.total(data);
	    assertEquals(expected[Integer.parseInt(data) - 1],actual);
	}
	
	@Order(10)
	@ParameterizedTest
	@ValueSource(strings = {"1"," ","3","4","5","6","7","8","9","10"}) 
	public void testTotalAsciiEmptyStringRainy(String data) {
		int[] expected = {49,0,51,52,53,54,55,56,57,97};
	    int actual = Cstr.total(data);
	    assertDoesNotThrow(() -> {
		    assertEquals(expected[Integer.parseInt(data) - 1],actual);
		}, "need try catch..");
	}
	
	@Order(11)
	@ParameterizedTest
	@ValueSource(strings = " ") 
	public void testTotalAsciiEmptyString(String data) {
		int expected = 32;
	    int actual = Cstr.total(data);
	    assertEquals(expected,actual);
	}
	
	@Order(12)
	@ParameterizedTest
	@ValueSource(strings = "\n10001111\n") 
	public void testTotalAsciiWhiteSpace(String data) {
		int expected = 409;
	    int actual = Cstr.total(data);
	    assertEquals(expected,actual);
	}
	
	@Order(13)
	@ParameterizedTest
	@ValueSource(strings = "      ") 
	public void testTotalAsciiEmptyStringRainy2(String data) {
		int expected = 0;
	    int actual = Cstr.total(data);
	    assertNotEquals(expected,actual);
	}
	
	@Order(14)
	@ParameterizedTest
	@ValueSource(strings = {"1","2","3","4","5","6","7","8","9","10"}) 
	public void testTotalAsciiRainy(String data) {
		int[] expected = {1,2,3,4,5,6,7,8,9,10};
	    int actual = Cstr.total(data);
	    assertNotEquals(expected[Integer.parseInt(data) - 1],actual);
	}
	
	@Order(15)
	@ParameterizedTest
	@ValueSource(strings = {"1","2","3","4","5","6","7","8","9","10"}) 
	public void testTotalCheckEmpty(String data) {
	    int actual = Cstr.total(data);
	    assertTrue(actual > 0); 
	}
	
	
	@Order(16)
	@ParameterizedTest
	@ValueSource(strings = {"1","2","3","4","5","6","7","8","9","10"}) 
	public void testTotalCheckEmptyRainy(String data) {
	    int actual = Cstr.total(data);
	    assertFalse(actual < 0); 
	}
	
	@Order(17)
	@ParameterizedTest
	@ValueSource(strings = " ") 
	public void testTotalWhiteSpace(String data) {
		int expected = 0;
	    int actual = Cstr.total(data);
	    assertTrue(actual > expected); 
	}

	@Order(18)
	@ParameterizedTest
	@ValueSource(strings = " ") 
	public void testTotalWhiteSpaceRainy(String data) {
		int expected = 0;
	    int actual = Cstr.total(data);
	    assertFalse(actual < expected); 
	}
	
	
	@Order(19)
	@ParameterizedTest
	@ValueSource(strings = {"1","2","3","4","5","6","7","8","9","10"}) 
	public void testConvertChar1to10(String data) {
		String[] expected = {"110001","110010","110011","110100","110101","110110","110111","111000","111001","111010"};
	    String actual = Cstr.convert(data);
	    assertEquals(expected ,actual);
	}
	
	@Order(20)
	@ParameterizedTest
	@ValueSource(strings = {"1","2","3","4","5","6","7","8","9","10"}) 
	public void testConvertChar1to10Rainy(String data) {
		String[] expected = {"110001","110010","110011","110100","110101","110110","110111","111000","111001","111010"};
	    String actual = Cstr.convert(data);
	    assertNotEquals(expected ,actual);
	}
	
	@Order(21)
	@ParameterizedTest
	@ValueSource(strings = "0") 
	public void testConvertChar0(String data) {
		String expected = "110000";
	    String actual = Cstr.convert(data);
	    assertEquals(expected ,actual);
	}
	
	@Order(22)
	@ParameterizedTest
	@ValueSource(strings = "0") 
	public void testConvertChar0Rainy(String data) {
		String expected = "0";
	    String actual = Cstr.convert(data);
	    assertNotEquals(expected ,actual);
	}
	
	
	@Order(23)
	@ParameterizedTest
	@ValueSource(strings = " ") 
	public void testConvertCharSpace(String data) {
		String expected = "100000";
	    String actual = Cstr.convert(data);
	    assertEquals(expected ,actual);
	}
	
	@Order(24)
	@ParameterizedTest
	@ValueSource(strings = " ") 
	public void testConvertCharSpaceRainy(String data) {
		String expected = " ";
	    String actual = Cstr.convert(data);
	    assertNotEquals(expected ,actual);
	}
	
	
	@Order(25)
	@ParameterizedTest
	@ValueSource(strings = " ") 
	public void testConvertTrueSpace(String data) {
		int expected = 1;
	    String actual = Cstr.convert(data);
	    assertTrue(actual.length() > expected); 
	}
	
	@Order(26)
	@ParameterizedTest
	@ValueSource(strings = " ") 
	public void testConvertTrueSpaceRainy(String data) {
		int expected = 0;
	    String actual = Cstr.convert(data);
	    assertFalse(actual.length() == expected); 
	}
	
}
