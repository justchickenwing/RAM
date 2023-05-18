package ram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class SimpleMemoryTest {
	@Test
	public void testMemoryConstructor() {
		int[] mem = {0, 1, 3, 4};
		Memory testmem = new Memory(mem);
		int expectedLength = 4;
		int actualLength = testmem.getSpace().length;
		assertNotNull(testmem);
		assertEquals(expectedLength, actualLength, "Memory has 4 index");
	}
	@Test
	public void testMemorySetterAndGetter() {
		int[] mem = {6};
		Memory testmem = new Memory(mem);
		testmem.setAtIndexValue(0, 5);
		int expected = 5;
		int actual = testmem.getValue(0);
		assertNotNull(testmem.getValue(0));
		assertEquals(expected, actual, "Value of index 0 is 5");
	}
}
