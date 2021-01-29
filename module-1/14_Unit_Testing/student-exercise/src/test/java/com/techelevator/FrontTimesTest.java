package com.techelevator;

import org.junit.*;

public class FrontTimesTest {
	
//	frontTimes("Chocolate", 2) → "ChoCho" 
//	frontTimes("Chocolate", 3) → "ChoChoCho" 
//	frontTimes("Abc", 3) → "AbcAbcAbc"
	
	private FrontTimes testObject;

	@Before
	public void instantiation() {
		this.testObject = new FrontTimes();
	}
	
	@Test
	public void test_string_shorter_than_three_letters_quadrapeat() {
		Assert.assertEquals("CCCC", testObject.generateString("C", 4));
	}
	
	@Test
	public void test_string_longer_than_three_letters_repeat_twice() {
		Assert.assertEquals("ChoCho", testObject.generateString("Chocolate", 2));
	}
	
	@Test
	public void test_string_longer_than_three_letters_threepeat() {
		Assert.assertEquals("ChoChoCho", testObject.generateString("Chocolate", 3));
	}
	
	@Test
	public void test_string_equal_to_three_letters_threepeat() {
		Assert.assertEquals("AbcAbcAbc", testObject.generateString("Abc", 3));
	}
	
	

}
