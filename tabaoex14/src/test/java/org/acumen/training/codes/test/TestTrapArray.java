package org.acumen.training.codes.test;

import org.acumen.training.codes.TrapArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTrapArray {
	private TrapArray tra;

	
	@BeforeEach 
	public void setup() {
		tra = new TrapArray();
	}
	
	@AfterEach 
	public void teardown() {
		tra = null;
	}
	
	@Test
	public void testArrayTransact() {
		tra.arrayTransact();
	}
}
