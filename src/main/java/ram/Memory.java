package ram;

public class Memory {
	private int[] memory;
	/**
	 * Creates an instance of Memory with an int[n]
	 * 
	 * @param memory - the int[] space
	 */
	public Memory(int[] memory) {
		this.memory = memory;
	}
	/**
	 * returns the value stored in the index
	 * 
	 * @param index - index of the desired value
	 * @return value stored in the index
	 */
	public int getValue(int index) {
		return memory[index];
	}
	/**
	 * stores the value in the array with the desired index
	 * 
	 * @param index - index where the value has to be stored
	 * @param value - value that has to be stored
	 */
	public void setAtIndexValue(int index, int value) {
		memory[index] = value;
	}
	/**
	 * get the number of index
	 * 
	 * @return the number of index
	 */
	public int[] getSpace() {
		return memory;
	}
}
