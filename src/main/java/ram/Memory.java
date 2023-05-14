package ram;

public class Memory {
	private int[] space;
	/**
	 * Creates an instance of Memory with an int[n]
	 * 
	 * @param n - number of index
	 */
	public Memory(int n) {
		space = new int[n];
	}
	/**
	 * Creates an instance of Memory with an int[n]
	 * 
	 * @param memory - the int[] space
	 */
	public Memory(int[] memory) {
		space = memory;
	}
	/**
	 * returns the value stored in the index
	 * 
	 * @param index - index of the desired value
	 * @return value stored in the index
	 */
	public int getValue(int index) {
		return space[index];
	}
	/**
	 * stores the value in the array with the desired index
	 * 
	 * @param index - index where the value has to be stored
	 * @param value - value that has to be stored
	 */
	public void setAtIndexValue(int index, int value) {
		space[index] = value;
	}
	/**
	 * get the number of index
	 * 
	 * @return the number of index
	 */
	public int[] getSpace() {
		return space;
	}
}
