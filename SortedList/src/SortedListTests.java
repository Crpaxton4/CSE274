import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/*Chris Paxton*/

public class SortedListTests {

	public static Integer[] getIntegerArray(int len) {
		Integer[] result = new Integer[len];
		for (int i = 0; i < len; i++) {
			result[i] = (int) (Math.random() * 10);
		}
		return result;
	}

	public static boolean check(int len) {
		SortedList<Integer> sortedList = new SortedList<>();
		Integer[] originalItems = getIntegerArray(len);
		for (int item : originalItems) {
			sortedList.add(item);
		}
		Arrays.sort(originalItems);
		Comparable<Integer>[] slOutput = sortedList.toArray(); // T [] slOutput
																// causes errors
		return Arrays.equals(originalItems, slOutput);
	}

	@Test
	public void RandomTests() {
		assertTrue(check(0));
		for (int t = 0; t < 1000; t++) {
			assertTrue(check(1));
			assertTrue(check(2));
			assertTrue(check(3));
			assertTrue(check(20));
		}
	}

	@Test
	public void RemoveTest() {
		SortedList<Integer> sortedList = new SortedList<>();
		Integer[] items = { 2, 6, 5, 7, 3, 5, 9, 3, 2, 0 };

		for (int item : items) {
			sortedList.add(item);
		}

		Integer[] expected = { 0, 2, 2, 3, 3, 5, 6, 7, 9 };
		sortedList.remove(5);

		assertTrue(Arrays.equals(expected, sortedList.toArray()));

		sortedList = new SortedList<>();
		Integer[] items2 = { 2 };

		for (int item : items2) {
			sortedList.add(item);
		}

		Integer[] expected2 = {};
		sortedList.remove(2);

		assertTrue(Arrays.equals(expected2, sortedList.toArray()));

		sortedList = new SortedList<>();
		Integer[] items3 = {};

		for (int item : items3) {
			sortedList.add(item);
		}

		Integer[] expected3 = {};
		sortedList.remove(2);

		assertTrue(Arrays.equals(expected3, sortedList.toArray()));

	}

}
