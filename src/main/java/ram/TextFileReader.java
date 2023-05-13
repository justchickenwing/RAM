package ram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
    
    private TextFileReader() {
    }
    
    public static String[] convertFileToStringArray(String filename) {
    	String[] ral = new String[1];
    	try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
    		int index = countLines(filename);
    		ral = new String[index];
            for (int i = 0; i < index; i++) {
            	ral[i] = br.readLine();
            }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ral;
    }
    
    public static int[] convertFileToIntArray(String filename) {
    	int[] inArray = new int[1];
    	try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
    		int index = countLines(filename);
    		inArray = new int[index];
    		String line;
            for (int i = 0; i < index; i++) {
            	line = br.readLine();
            	inArray[i] = Integer.parseInt(line);
            }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return inArray;
    }
    
    public static int countLines(String filename) {
    	int counter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while (br.readLine() != null) {
			    counter++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return counter;
    }

//    public static void main(String[] args) throws Throwable {
//    	String filename = "src\\main\\java\\ram\\raltest.txt";
////    	TextFileReader.convertFileToArrayList(filename);
////    	ArrayList<String[]> ral = TextFileReader.convertFileToArrayList(filename);
////    	System.out.println(Arrays.toString(ral.get(0)));
////    	System.out.println(Arrays.toString(ral.get(1)));
////    	System.out.println(Arrays.toString(ral.get(2)));
//    	String[] arr = TextFileReader.convertFileToArrayList(filename);
//    	System.out.println(arr[1]);
//
//
//        
//    }
}