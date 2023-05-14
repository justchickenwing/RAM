package actions;

import gui.RamFrame;

public class Main {
	private static String ralFile = "src\\main\\java\\ram\\ralfile.txt";
	private static String memoryFile = "src\\main\\java\\ram\\memoryfile.txt";
	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        new RamFrame(ralFile, memoryFile).setVisible ( true );
	}
}
