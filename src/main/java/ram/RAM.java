package ram;

public class RAM extends Steuereinheit {
	private boolean running;
	private int pc;
	/**
	 * The starting point of the program is defined by the constructor. 
	 * 
	 * @param ac
	 * @param memory
	 */
	public RAM(Memory memory, int startPoint) {
		super(memory);
		this.running = true;
		this.pc = startPoint;
	}
	/**
	 * Function to start the program
	 * @param program String Array with the RAL commands
	 * @return result of the program
	 */
	public int startProgram(String[] program) {
		Validator.isValidProgram(program);
		return runProgram(program);
	}
	/**
	 * Function to run the program
	 * @param programString Array with the RAL commands
	 * @return result of the program
	 */
	private int runProgram(String[] program) {
		System.out.println("_oO- START -Oo_");
		System.out.println("|             |");
		while (running) {
			if (!program[pc].contains("HLT")) {
				int param = Integer.parseInt(program[pc].substring(4));
				
				if (program[pc].contains("ADD")) {
					ADD(param);
					System.out.println("|    " + program[pc] + "    |");
					pc++;
				} else if (program[pc].contains("SUB")) {
					SUB(param);
					System.out.println("|    " + program[pc] + "    |");
					pc++;
				} else if (program[pc].contains("LDA")) {
					LDA(param);
					System.out.println("|    " + program[pc] + "    |");
					pc++;
				} else if (program[pc].contains("STA")) {
					STA(param);
					System.out.println("|    " + program[pc] + "    |");
					pc++;
				} else if (program[pc].contains("LDI")) {
					LDI(param);
					System.out.println("|    " + program[pc] + "    |");
					pc++;
				} else if (program[pc].contains("LDA")) {
					LDA(param);
					System.out.println("|    " + program[pc] + "    |");
					pc++;
				} else if (program[pc].contains("STI")) {
					STI(param);
					System.out.println("|    " + program[pc] + "    |");
					pc++;
				} else if (program[pc].contains("JMP")) {
					JMP();
					System.out.println("|    " + program[pc] + "    |");
					pc=param;
				} else if (program[pc].contains("JMZ")) {
					if (JMZ()) {
						System.out.println("|    " + program[pc] + "    |");
						pc=param;
					} else {
						pc++;
					}
				}
			} else {
				System.out.println("|    " + program[pc] + "      |");
				System.out.println("|             |");
				System.out.println("°---- END ----°");
				running = HLT();
			}
		}
		return getAC();
	}
}
