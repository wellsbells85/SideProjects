package com.techelevator.projects.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.projects.view.Menu;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuTest {

	private ByteArrayOutputStream output;

	@Before
	public void setup() {
		output = new ByteArrayOutputStream();
	}

	@Test
	public void displays_a_list_of_menu_options_and_prompts_user_to_make_a_choice() {
		Object[] options = new Object[] { Integer.valueOf(3), "Blind", "Mice" };
		Menu menu = getMenuForTesting();

		menu.getChoiceFromOptions(options);

		String expected = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
				+ options[2].toString() + "\n\n" + "Please choose an option >>> ";
		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void returns_object_corresponding_to_user_choice() {
		Integer expected = Integer.valueOf(456);
		Integer[] options = new Integer[] { Integer.valueOf(123), expected, Integer.valueOf(789) };
		Menu menu = getMenuForTestingWithUserInput("2\n");

		Integer result = (Integer) menu.getChoiceFromOptions(options);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void redisplays_menu_if_user_does_not_choose_valid_option() {
		Object[] options = new Object[] { "Larry", "Curly", "Moe" };
		Menu menu = getMenuForTestingWithUserInput("4\n1\n");

		menu.getChoiceFromOptions(options);

		String menuDisplay = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
				+ options[2].toString() + "\n\n" + "Please choose an option >>> ";

		String expected = menuDisplay + "\n*** 4 is not a valid option ***\n\n" + menuDisplay;

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void redisplays_menu_if_user_enters_garbage() {
		Object[] options = new Object[] { "Larry", "Curly", "Moe" };
		Menu menu = getMenuForTestingWithUserInput("Mickey Mouse\n1\n");

		menu.getChoiceFromOptions(options);

		String menuDisplay = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
				+ options[2].toString() + "\n\n" + "Please choose an option >>> ";

		String expected = menuDisplay + "\n*** Mickey Mouse is not a valid option ***\n\n" + menuDisplay;

		Assert.assertEquals(expected, output.toString());
	}

	private Menu getMenuForTestingWithUserInput(String userInput) {
		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
		return new Menu(input, output);
	}

	private Menu getMenuForTesting() {
		return getMenuForTestingWithUserInput("1\n");
	}
}
