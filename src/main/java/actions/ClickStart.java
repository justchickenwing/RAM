package actions;
import ram.File;
import ram.Memory;
import ram.RAM;
import ram.TextFileReader;

public class ClickStart {
	private String[] ral;
	private int[] mem;
	private Memory memory;
	private RAM ram;
	/**
	 * function that starts the ram-machine.
	 * action for the "start program" button.
	 * 
	 * @param sp defines the start point of the ral program.
	 * @return the value that is stored in the ac when the program is finished.
	 */
	public int clicked(int sp) {
		ral = new TextFileReader(File.ralFile).convertFileToStringArray();
		mem = new TextFileReader(File.memoryFile).convertFileToIntArray();
		memory = new Memory(mem);
		ram = new RAM(memory, sp);
		return ram.startProgram(ral);
	}
}
