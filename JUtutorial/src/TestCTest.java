import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCTest {

	@Test
	public void testSetArrayList() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 1; i < 10; ++i) {
			arr.add(i);
			sum += i;
		}
		TestClass test = new TestClass();
		test.SetArrayList(arr);

		assertEquals(test.GetArray().size(), arr.size());
		assertEquals(test.getSum(), sum);
		assertTrue(arr.equals(test.GetArray()));
		assertFalse(test.GetArray().isEmpty());

	}

	@Test
	public void testGetSum() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 1; i < 10; ++i) {
			arr.add(i);
			sum += i;
		}
		TestClass test = new TestClass();
		test.SetArrayList(arr);
		
		assertEquals(sum, test.getSum());
		assertTrue(sum == test.getSum());
	}

}
