package com.techelevator;

import org.junit.*;

public class StringBitsTest {
	
//	GetBits("Hello") → "Hlo" 
//	GetBits("Hi") → "H" 
//	GetBits("Heeololeo") → "Hello"
	
	private StringBits testObject;
	
	@Before
	public void instantiation() {
		this.testObject = new StringBits();
	}
	
	@Test
	public void test_null() {
		Assert.assertEquals("", testObject.getBits(null));
	}
	
	@Test
	public void test_hello() {
		Assert.assertEquals("Hlo", testObject.getBits("Hello"));
	}
	
	@Test
	public void test_hi() {
		Assert.assertEquals("H", testObject.getBits("Hi"));
	}
	
	@Test
	public void test_heeololeo() {
		Assert.assertEquals("hello", testObject.getBits("heeololeo"));
	}

}
