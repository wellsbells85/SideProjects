package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;

public class StackAndQueueExercisesTest {
	StackAndQueueExercises exercises = new StackAndQueueExercises();

	@Test
	public void reverseList() {
		String failureMessage = compareArrayLists(
				new ArrayList<String>(Arrays.asList("green", "yellow", "blue", "green", "purple")),
				exercises.reverseList(
						new ArrayList<String>(Arrays.asList("purple", "green", "blue", "yellow", "green"))));
		if (failureMessage != null) {
			fail("Input: reverseList(new ArrayList<Object>(Arrays.asList(\"purple\", \"green\", \"blue\", \"yellow\", \"green\" )))"
					+ failureMessage);
		}

		failureMessage = compareArrayLists(
				new ArrayList<String>(
						Arrays.asList("way", "the", "all", "jingle", "bells", "jingle", "bells", "jingle")),
				exercises.reverseList(new ArrayList<String>(
						Arrays.asList("jingle", "bells", "jingle", "bells", "jingle", "all", "the", "way"))));
		if (failureMessage != null) {
			fail("Input: reverseList(new ArrayList<Object>(Arrays.asList(\"jingle\", \"bells\", \"jingle\", \"bells\", \"jingle\", \"all\", \"the\", \"way\")))"
					+ failureMessage);
		}
	}
	
	@Test
	public void boardingGate() {
		List<Integer> trialList = exercises
				.boardingGate(new ArrayList<Integer>(Arrays.asList(1, 13, 43, 22, 8, 11, 30, 2, 4, 14, 21)));
		String failureMessage = compareArrayLists(
				new ArrayList<Integer>(Arrays.asList(1, 8, 2, 4, 13, 11, 14, 22, 30, 21)), trialList);
		if (failureMessage != null) {
			fail("Input: boardingGate([1, 13, 43, 22, 8, 11, 30, 2, 4, 14, 21])" + failureMessage);
		}

		trialList = exercises
				.boardingGate(new ArrayList<Integer>(Arrays.asList(29, 19, 9, 21, 11, 1, 0, 25, 15, 5, 31)));
		failureMessage = compareArrayLists(new ArrayList<Integer>(Arrays.asList(9, 1, 5, 19, 11, 15, 29, 21, 25)),
				trialList);
		if (failureMessage != null) {
			fail("Input: boardingGate([29, 19, 9, 21, 11, 1, 0, 25, 15, 5, 31])" + failureMessage);
		}

		trialList = exercises.boardingGate(new ArrayList<Integer>(Arrays.asList(0, -1, 44, 31, 17, 7, 27, 16, 26, 6)));
		failureMessage = compareArrayLists(new ArrayList<Integer>(Arrays.asList(7, 6, 17, 16, 27, 26)), trialList);
		if (failureMessage != null) {
			fail("Input: boardingGate([0, -1, 44, 31, 17, 7, 27, 16, 26, 6])" + failureMessage);
		}
	}
	
	/*
	 * Compares two ArrayLists, and returns a null failure message if the lists are equal.
	 * Otherwise, if the lists are not equal, returns a failure message explaining why.
	 * Note, method returns with failure message on the first problem.
	 *
	 * Comparisons:
	 * 		Neither String ArrayList may be null.
	 * 		Both String ArrayLists must be the same length,
	 * 			and the strings must be in the same order.
	 */
	private String compareArrayLists(List<?> expectedList, List<?> actualList) {
		String failureMessage = null;
		if ((expectedList == null) || (actualList == null)) {
			failureMessage = expectedList == null ? "expectedList is null " : "";
			failureMessage = actualList == null ? "actualList is null" : "";
			return failureMessage.trim();
		}
		if (expectedList.size() != actualList.size()) {
			failureMessage = "array lengths differed, expected.length=" + expectedList.size() + " actual.length="
					+ actualList.size();
			return failureMessage;
		}
		int i = 0;
		for (Object expectedString : expectedList) {
			if (!expectedString.equals(actualList.get(i))) {
				failureMessage = "array elements at index " + i + " differ, expected:<" + expectedString + "> but was:<"
						+ actualList.get(i) + ">";
				return failureMessage;
			}
			i++;
		}
		return failureMessage;
	}

}
