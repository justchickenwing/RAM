package actions;
import ram.File;
import ram.Memory;
import ram.RAM;
import ram.TextFileReader;

public class ClickStart {
	/**
	 * function that starts the ram-machine.
	 * action for the "start program" button.
	 * 
	 * @param sp defines the start point of the ral program.
	 * @return the value that is stored in the ac when the program is finished.
	 */
	public static int clicked(int sp) {
		String[] ral = TextFileReader.convertFileToStringArray(File.ralFile.getPath());
		int[] mem = TextFileReader.convertFileToIntArray(File.memoryFile.getPath());
		Memory memory = new Memory(mem);
		RAM ram = new RAM(memory, sp);
		return ram.startProgram(ral);
	}
}
