package actions;

import gui.Gui;
import gui.RamFrame;
import ram.Memory;
import ram.RAM;
import ram.TextFileReader;

public class Main {
	static Gui g;
	static String ralFile = "src\\main\\java\\ram\\ralfile.txt";
	static String memoryFile = "src\\main\\java\\ram\\memoryfile.txt";
	
	public static void main(String[] args) {
		
		String[] ral = TextFileReader.convertFileToStringArray(ralFile);
		int[] mem = TextFileReader.convertFileToIntArray(memoryFile);
		Memory memory = new Memory(mem);
		RAM ram = new RAM(memory, 0);
		System.out.println(ram.startProgram(ral));

        new RamFrame().setVisible ( true );

	}

}
