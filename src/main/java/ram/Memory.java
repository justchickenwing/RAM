package ram;

public class Memory {
	private int[] space;
	
	public Memory(int n) {
		space = new int[n];
	}
	
	public Memory(int[] memory) {
		space = memory;
	}
	
	public int getValue(int index) {
		return space[index];
	}
	
	public void setAtIndexValue(int index, int value) {
		space[index] = value;
	}
	
	public int[] getSpace() {
		return space;
	}
}
