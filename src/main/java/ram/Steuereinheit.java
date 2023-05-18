package ram;

public abstract class Steuereinheit {
	private int ac;
	private Memory memory;
	/**
	 * Creates an instance of Steuereinheit and sets the ac to 0
	 * @param memory - the memory of the ram 
	 */
	public Steuereinheit(Memory memory) {
		this.ac = 0;
		this.memory = memory;
	}
	/**
	 * get the value stored in AC
	 * @return the value stored in AC
	 */
	public int getAC() {
		return ac;
	}
	/**
	 * adds the content of memory at address X to the accumulator.
	 * @param index - address which value gets added
	 */
	public void ADD(int index) {
		ac += memory.getValue(index);
	}
	/**
	 * subtracts the content of memory at address X from the accumulator.
	 * @param index - address which value gets subtracted
	 */
	public void SUB(int index) {
		ac -= memory.getValue(index);
	}
	/**
	 * loads the AC with the content of memory at address X.
	 * @param index - address which value is loaded
	 */
	public void LDA(int index) {
		ac = memory.getValue(index);
	}
	/**
	 * stores the content of the AC in memory at address X.
	 * @param index - address where the value is stored
	 */
	public void STA(int index) {
		memory.setAtIndexValue(index, ac);
	}
	/**
	 * loads the AC indirectly with the contents of memory with address X.
	 * @param index - address which value is indirectly loaded
	 */
	public void LDI(int index) {
		ac = memory.getValue(memory.getValue(index));
	}
	/**
	 * stores the contents of the AC indirectly in memory with address X.
	 * @param index - address where the value gets indirectly stored
	 */
	public void STI(int index) {
		memory.setAtIndexValue(memory.getValue(index),	ac);
	}
	/**
	 * jumps to the X marked instruction in the program.
	 * @param instruktion - number of instruction
	 */
	public void JMP(int instruktion) {
	}
	/**
	 * jumps to the X-marked instruction in the program if the AC is equal to 0.
	 * @return true if the ac is 0; otherwise false 
	 */
	public boolean JMZ() {
		if (ac == 0) {
			return true;
		}
		return false;
	}
	/**
	 * exits the program
	 * @return true if exit; otherwise false 
	 */
	public boolean HLT() {
		return false;
	}
}
