package com.techelevator;

import java.util.Map;
import org.junit.*;

public class WordCountTest {
	
	private WordCount testObject;
	private Map<String, Integer> output;
	
	@Before
	public void instantiation() {
		this.testObject = new WordCount();
	}
	
	@Test
	public void input_of_null() {
		
		Map<String, Integer> output = testObject.getCount(null);
		
		Assert.assertNotNull(output);
		Assert.assertEquals(0, output.size());
	}

}
