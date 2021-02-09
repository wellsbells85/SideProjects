package com.techelevator;

import org.junit.*;

public class NonStartTest {
	
//		GetPartialString("Hello", "There") → "ellohere"
//    	GetPartialString("java", "code") → "avaode"
//    	GetPartialString("shotl", "java") → "hotlava"
	
	private NonStart testObject;
	
	@Before
	public void instantiation() {
		this.testObject = new NonStart();
	}
	
	@Test
	public void test_hello_and_there() {
		Assert.assertEquals("ellohere", testObject.getPartialString("Hello", "There"));
	}
	
	@Test
	public void test_java_and_code() {
		Assert.assertEquals("avaode", testObject.getPartialString("Java", "code"));
	}
	
	@Test
	public void test_shotl_and_java() {
		Assert.assertEquals("hotlava", testObject.getPartialString("shotl", "Java"));
	}
	
	@Test
	public void test_null_breaks_code() {
		Assert.assertNull(testObject.getPartialString(null , null));
	}
	

}
