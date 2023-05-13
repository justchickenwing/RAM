package ram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class SimpleRamTest {
	@Test
	public void testMemoryConstructor() {
		Memory testmem = new Memory(4);
		int expectedLength = 4;
		int actualLength = testmem.getSpace().length;
		assertNotNull(testmem);
		assertEquals(expectedLength, actualLength, "Memory has 4 index");
	}
	@Test
	public void testMemorySetterAndGetter() {
		Memory testmem = new Memory(1);
		testmem.setAtIndexValue(0, 5);
		int expected = 5;
		int actual = testmem.getValue(0);
		assertNotNull(testmem.getValue(0));
		assertEquals(expected, actual, "Value of index 0 is 5");
	}
	@Test
	public void testRamConstructor() {
		Memory testmem = new Memory(4);
		RAM ram = new RAM(testmem, 2);
		assertNotNull(ram);
	}
	@Test
	public void testRalProgram() {
		/**
		 * e.g. of addition program
		 * starts on the 2. index (LDA 0)
		 */
		String[] addition = {
				"LDA 2",
				"HLT",
				"LDA 0",
				"ADD 1",
				"STA 2",
				"JMP 0"
		};
		Memory addmem = new Memory(4);
		addmem.setAtIndexValue(0, 16);
		addmem.setAtIndexValue(1, 2);
		addmem.setAtIndexValue(2, 0);
		RAM ram = new RAM(addmem, 2);
		int expected = 18;
		int actual = ram.startProgram(addition);
		assertEquals(expected, actual, "Result is 18.");
		
	}
}
