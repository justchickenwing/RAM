package ram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SteuereinheitTest {
	Memory testmem = new Memory(5);
	RAM ram;
	@Test
	public void testRalADD() {
		testmem.setAtIndexValue(0, 5);
		testmem.setAtIndexValue(1, 5);
		ram = new RAM(testmem, 0);
		String[] add = {"LDA 0", "ADD 1", "HLT"};
		int expected = 10;
		int actual = ram.startProgram(add);
		assertEquals(expected, actual, "Command ADD is valid");
	}
	@Test
	public void testRalSUB() {
		testmem.setAtIndexValue(0, 5);
		testmem.setAtIndexValue(1, 2);
		ram = new RAM(testmem, 0);
		String[] sub = {"LDA 0", "SUB 1", "HLT"};
		int expected = 3;
		int actual = ram.startProgram(sub);
		assertEquals(expected, actual, "Command SUB is valid");
	}
	@Test
	public void testRalLDA() {
		testmem.setAtIndexValue(0, 5);
		ram = new RAM(testmem, 0);
		String[] lda = {"LDA 0", "HLT"};
		int expected = 5;
		int actual = ram.startProgram(lda);
		assertEquals(expected, actual, "Command LDA is valid");
	}
	@Test
	public void testRalSTA() {
		testmem.setAtIndexValue(0, 5);
		ram = new RAM(testmem, 0);
		String[] sta = {"STA 0", "HLT"};
		ram.startProgram(sta);
		int expected = 0;
		int actual = testmem.getValue(0);
		assertEquals(expected, actual, "Command STA is valid");
	}
	@Test
	public void testRalLDI() {
		testmem.setAtIndexValue(0, 2);
		testmem.setAtIndexValue(1, 1);
		testmem.setAtIndexValue(2, 5);
		ram = new RAM(testmem, 0);
		String[] ldi = {"LDI 0", "HLT"};
		int expected = 5;
		int actual = ram.startProgram(ldi);
		assertEquals(expected, actual, "Command LDI is valid");
	}
	@Test
	public void testRalSTI() {
		testmem.setAtIndexValue(0, 2);
		testmem.setAtIndexValue(1, 1);
		testmem.setAtIndexValue(2, 5);
		ram = new RAM(testmem, 0);
		String[] sti = {"STI 0", "HLT"};
		ram.startProgram(sti);
		int expected = 0;
		int actual = testmem.getValue(2);
		assertEquals(expected, actual, "Command STI is valid");
	}
	@Test
	public void testRalJMP() {
		testmem.setAtIndexValue(0, 5);
		testmem.setAtIndexValue(1, 2);
		ram = new RAM(testmem, 0);
		String[] jmp = {"JMP 2", "LDA 0", "LDA 1", "HLT"};
		int expected = 2;
		int actual = ram.startProgram(jmp);
		assertEquals(expected, actual, "Command JMP is valid");
	}
	@Test
	public void testRalJMZ() {
		testmem.setAtIndexValue(0, 5);
		testmem.setAtIndexValue(1, 2);
		ram = new RAM(testmem, 0);
		String[] jmz = {"JMZ 2", "LDA 0", "LDA 1", "HLT"};
		int expected = 2;
		int actual = ram.startProgram(jmz);
		assertEquals(expected, actual, "Command JMZ is valid");
	}
	@Test
	public void testRalHLT() {
		testmem.setAtIndexValue(0, 5);
		ram = new RAM(testmem, 0);
		String[] hlt = {"HLT"};
		int expected = 0;
		int actual = ram.startProgram(hlt);
		assertEquals(expected, actual, "Command HLT is valid");
	}
}
