package ram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	
	private static BufferedReader br;
    /**
     * private constructor to avoid initializing out of the class
     */
    private TextFileReader() {}
    /**
     * Reads the file and stores it in the BufferedReader.
     * 
     * @param filename - the file which has to be read.
     */
    private static void readFile(String filename) {
    	try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Memory file not found. The program will exit with an error code.");
			System.exit(1);		
		}
    }
    /**
     * Converts the file to a String Array
     * 
     * @param filename - the file which has to be converted
     * @return a String Array filled with the lines of the file.
     */
    public static String[] convertFileToStringArray(String filename) {
    	readFile(filename);
    	int index = countLines(filename);
    	String[] ral = new String[index];
        for (int i = 0; i < index; i++) {
        	try {
				ral[i] = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    	return ral;
    }
    /**
     * Converts the file to an int Array.
     * @param filename - the file which has to be converted
     * @return an int Array filled with the lines of the file.
     */
    public static int[] convertFileToIntArray(String filename) {
    	readFile(filename);
    	int index = countLines(filename);
    	int[] inArray = new int[index];
    		String line;
            for (int i = 0; i < index; i++) {
            	try {
					line = br.readLine();
					inArray[i] = Integer.parseInt(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
    	return inArray;
    }
    /**
     * Counts the number of lines in a file.
     * 
     * @param filename - the file which lines has to be counted.
     * @return number of lines.
     */
    private static int countLines(String filename) {
    	readFile(filename);
    	int counter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while (br.readLine() != null) {
			    counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return counter;
    }
}