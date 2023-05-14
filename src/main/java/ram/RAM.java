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
		while (running) {
			if (!program[pc].contains("HLT")) {
				int param = Integer.parseInt(program[pc].substring(4));
				
				if (program[pc].contains("ADD")) {
					ADD(param);
					System.out.println(program[pc]);
					pc++;
				} else if (program[pc].contains("SUB")) {
					SUB(param);
					System.out.println(program[pc]);
					pc++;
				} else if (program[pc].contains("LDA")) {
					LDA(param);
					System.out.println(program[pc]);
					pc++;
				} else if (program[pc].contains("STA")) {
					STA(param);
					System.out.println(program[pc]);
					pc++;
				} else if (program[pc].contains("LDI")) {
					LDI(param);
					System.out.println(program[pc]);
					pc++;
				} else if (program[pc].contains("LDA")) {
					LDA(param);
					System.out.println(program[pc]);
					pc++;
				} else if (program[pc].contains("STI")) {
					STI(param);
					System.out.println(program[pc]);
					pc++;
				} else if (program[pc].contains("JMP")) {
					JMP(param);
					System.out.println(program[pc]);
					pc=param;
				} else if (program[pc].contains("JMZ")) {
					if (JMZ()) {
						System.out.println(program[pc]);
						pc=param;
					} else {
						pc++;
					}
				}
			} else {
				running = HLT();
			}
		}
		return getAC();
	}


	
//	public static void main(String[] args) {
//		String ralFile = "src\\main\\java\\ram\\ralfile.txt";
//		String memoryFile = "src\\main\\java\\ram\\memoryfile.txt";
//		String[] ral = TextFileReader.convertFileToStringArray(ralFile);
//		int[] mem = TextFileReader.convertFileToIntArray(memoryFile);
//		Memory memory = new Memory(mem);
//		RAM ram = new RAM(memory, 0);
//		System.out.println(ram.startProgram(ral));
//	}
//		/**
//		 * e.g. of addition program
//		 * starts on the 2. index (LDA 0)
//		 */
//		String[] addition = {
//				"LDA 2",
//				"HLT",
//				"LDA 0",
//				"ADD 1",
//				"STA 2",
//				"JMP 0"
//		};
//		Memory addmem = new Memory(4);
//		addmem.setAtIndexValue(0, 16);
//		addmem.setAtIndexValue(1, 2);
//		addmem.setAtIndexValue(2, 0);		
//		/**
//		 * e.g. of division program
//		 * starts on the 2. index (LDA 0)
//		 */
//		String[] division = {
//				"LDA 3",
//				"HLT",
//				"LDA 0",
//				"JMZ 0",
//				"SUB 1",
//				"STA 0",
//				"LDA 3",
//				"ADD 2",
//				"STA 3",
//				"JMP 2"
//		};
//		Memory divmem = new Memory(4);
//		divmem.setAtIndexValue(0, 16);
//		divmem.setAtIndexValue(1, 2);
//		divmem.setAtIndexValue(2, 1);
//		divmem.setAtIndexValue(3, 0);
//		/**
//		 * e.g. of multiply program
//		 * starts on the 2. index (LDA 0)
//		 */
//		String[] multiply = {
//				"LDA 3",
//				"HLT",
//				"LDA 1",
//				"JMZ 0",
//				"SUB 2",
//				"STA 1",
//				"LDA 3",
//				"ADD 0",
//				"STA 3",
//				"JMZ 0",
//				"JMP 2"
//		};
//		Memory mulmem = new Memory(4);
//		mulmem.setAtIndexValue(0, 5);
//		mulmem.setAtIndexValue(1, 5);
//		mulmem.setAtIndexValue(2, 1);
//		mulmem.setAtIndexValue(3, 0);
//		
//		RAM ram = new RAM(divmem, 2);
//		System.out.println(ram.startProgram(division));
////		
////		RAM addram = new RAM(0, addmem);
////		System.out.println(addram.startProgram(addition));
////		
////		RAM mulram = new RAM(0, mulmem);
////		System.out.println(mulram.startProgram(multiply));
//		
//		RAM valid = new RAM(mulmem, 2 );
//		System.out.println(Validator.isValidProgram(multiply));
//		
//	}
}
