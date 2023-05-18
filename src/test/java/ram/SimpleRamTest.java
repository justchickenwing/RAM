package ram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class SimpleRamTest {
	@Test
	public void testRamConstructor() {
		int[] mem = {6, 4, 0};
		Memory testmem = new Memory(mem);
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
		int[] mem = {16, 2, 0};
		Memory addmem = new Memory(mem);
		RAM ram = new RAM(addmem, 2);
		int expected = 18;
		int actual = ram.startProgram(addition);
		assertEquals(expected, actual, "Result is 18.");
		
	}
}
