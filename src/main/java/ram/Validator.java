package ram;

import java.util.Arrays;

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
				isValid = isValidCommand(command);
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
	 * @return true if valid command; false otherwise
	 */
	public static boolean isValidCommand(String command) {
		if (command.length() >= 3) {
			String commandName = command.substring(0, 3);
			if (command.length() > 3) {
				String commandArgu = command.substring(4);
				if (!commandArgu.matches("\\d+")) {
					System.err.println("The input is invalid. The program will exit with an error code.");
					System.exit(1);
				}
			}
			String[] validCommands = {"ADD", "SUB", "LDA", "STA", "LDI", "STI", "JMP", "JMZ", "HLT"};
			if (Arrays.asList(validCommands).contains(commandName)) {
				return true;
			}
		}
		throw new IllegalArgumentException(
				"Unknown command: " + command
		);
	}	
}
