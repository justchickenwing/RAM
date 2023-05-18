package actions;
import ram.Memory;
import ram.RAM;
import ram.TextFileReader;

public class ClickStart {
	static String ralFile = "src\\main\\java\\ram\\ralfile.txt";
	static String memoryFile = "src\\main\\java\\ram\\memoryfile.txt";
	/**
	 * function that starts the ram-machine.
	 * action for the "start program" button.
	 * 
	 * @param sp defines the start point of the ral program.
	 * @return the value that is stored in the ac when the program is finished.
	 */
	public static int clicked(int sp) {
		String[] ral = TextFileReader.convertFileToStringArray(ralFile);
		int[] mem = TextFileReader.convertFileToIntArray(memoryFile);
		Memory memory = new Memory(mem);
		RAM ram = new RAM(memory, sp);
		return ram.startProgram(ral);
	}
}
