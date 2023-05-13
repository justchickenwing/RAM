package ram;

public abstract class Steuereinheit {
	
	private int ac;
	private Memory memory;
	
	public Steuereinheit(Memory memory) {
		this.ac = 0;
		this.memory = memory;
	}
	
	public int getAC() {
		return ac;
	}
	
	public void ADD(int index) {
		ac += memory.getValue(index);
	}
	
	public void SUB(int index) {
		ac -= memory.getValue(index);
	}
	
	public void LDA(int index) {
		ac = memory.getValue(index);
	}
	
	public void STA(int index) {
		memory.setAtIndexValue(index, ac);
	}
	
	public void LDI(int index) {
		ac = memory.getValue(memory.getValue(index));
	}
	
	public void STI(int index) {
		memory.setAtIndexValue(memory.getValue(index),	ac);
	}
	
	public void JMP(int instruktion) {
	}
	
	public boolean JMZ() {
		if (ac == 0) {
			return true;
		}
		return false;
	}
	
	public boolean HLT() {
		return false;
	}

}
