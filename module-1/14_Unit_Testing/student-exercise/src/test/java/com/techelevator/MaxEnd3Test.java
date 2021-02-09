package com.techelevator;

import org.junit.*;

public class MaxEnd3Test {
	
	private MaxEnd3 testObject;
	int[] input;
	int[] output;
	
	@Before
	public void instantiation() {
		this.testObject = new MaxEnd3();
	}
	
	@Test
	public void null_input_breaks_code() {
		input = null;
		
		output = testObject.makeArray(input);
		
		Assert.assertNull(output);
	}
	
	

}
