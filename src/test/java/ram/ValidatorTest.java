package ram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
	@Test
	public void testValidProgram() {
		/**
		 * e.g. of division program
		 * starts with 2. index (LDA 0)
		 */
		String[] division = {
		"LDA 3",
		"HLT",
		"LDA 0",
		"JMZ 0",
		"SUB 1",
		"STA 0",
		"LDA 3",
		"ADD 2",
		"STA 3",
		"JMP 2"
		};
		boolean expected = true;
		boolean actual = Validator.isValidProgram(division);
		assertEquals(expected, actual, "Program is valid");
	}
}
