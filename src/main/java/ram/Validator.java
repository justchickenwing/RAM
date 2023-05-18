package ram;
import java.util.Arrays;
import actions.Alert;
public class Validator {
	private Validator() {}
	/**
	 * Function to validate the command input.
	 * Checks every index of the program with the isValidCommand function.
	 * 
	 * @param program - ral program input
	 * @return true if valid program; false otherwise
	 */
	public static boolean isValidProgram(String[] program) {
		boolean isValid = true;
		while (isValid) {
			for (String command : program) {
				isValidCommand(command);
			}
			return true;
		}	
		return false;
	}
	/**
	 * To validate one command at a time. 
	 * The Input is one command of the program array.
	 * First the command argument gets checked, if it only contains integers.
	 * Then the String gets snipped, so just the first three letters will be validated.
	 * In a next step it compares the snipped command with the legal commands.
	 * 
	 * @param command - the command which is to validate
	 */
	public static void isValidCommand(String command) {
		String[] validCommands = {"ADD", "SUB", "LDA", "STA", "LDI", "STI", "JMP", "JMZ", "HLT"};
		try {
			String commandName = command.substring(0, 3);
			if (!Arrays.asList(validCommands).contains(commandName)) {
				Alert.show("Invalid command!\nPlease check:\n" + command);
			}
		} catch (StringIndexOutOfBoundsException e) {
			Alert.show("Invalid command!\nPlease check:\n" + command);
		}
		
		if (command.length() > 3) {
			try {
				Integer.parseInt(command.substring(4));
			} catch (IllegalArgumentException e) {
				Alert.show("Invalid command!\nPlease check:\n" + command);
			}
		}			
	}
}		

