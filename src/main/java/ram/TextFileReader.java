package ram;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import actions.Alert;
public class TextFileReader {
	private static BufferedReader br;
	private File file;
	
    public TextFileReader(File file) {
    	this.file = file;
    }
    /**
     * Reads the file and stores it in the BufferedReader.
     * 
     * @param filename - the file which has to be read.
     */
    private void readFile() {
    	try {
			br = new BufferedReader(new FileReader(file.getPath()));
		} catch (FileNotFoundException e) {
			Alert.show("File not found:\n" + file.getPath());	
		}
    }
    /**
     * Counts the number of lines in a file.
     * 
     * @param filename - the file which lines has to be counted.
     * @return number of lines.
     */
    private int countLines() {
    	readFile();
    	int counter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
			while (br.readLine() != null) {
			    counter++;
			}
		} catch (IOException e) {
			Alert.show("Invalid file!\nPlease check your file:\n" + file.getPath());
		}
    	return counter;
    }
    /**
     * Converts the file to a String Array
     * 
     * @param filename - the file which has to be converted
     * @return a String Array filled with the lines of the file.
     */
    public String[] convertFileToStringArray() {
    	readFile();
    	int index = countLines();
    	String[] ral = new String[index];
        for (int i = 0; i < index; i++) {
        	try {
				ral[i] = br.readLine();
			} catch (IOException e) {
				Alert.show("Invalid file!\nPlease check your file:\n" + file.getPath());
			}
        }
    	return ral;
    }
    /**
     * Converts the file to an int Array.
     * @param filename - the file which has to be converted
     * @return an int Array filled with the lines of the file.
     */
    public int[] convertFileToIntArray() {
    	readFile();
    	int index = countLines();
    	int[] inArray = new int[index];
    		String line;
            for (int i = 0; i < index; i++) {
            	try {
					line = br.readLine();
					inArray[i] = Integer.parseInt(line);
				} catch (IOException e) {
					Alert.show("Invalid memory! Please check your file.");
				} catch (NumberFormatException e) {
					Alert.show("Invalid format!\nPlease check your memoy-file.");
				}
            }
    	return inArray;
    }
}