package gui;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui {
    public static int width = 300, height = 300;
	static JFrame jf;
    static JPanel jp;
    static JLabel inputLabel;
    static JLabel memoryLabel;
    static JLabel ralLabel;

    public void create() {
      
        jf = new JFrame("myRAM");
        jf.setSize(width, height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        
        jp = new JPanel();
        
        inputLabel = new JLabel("Input");
        inputLabel.setLocation(0, 100);
        memoryLabel = new JLabel("Memory:");
        ralLabel = new JLabel("RAL-Befehle:");
        
        jp.add(inputLabel);
        jp.add(memoryLabel);
        jp.add(ralLabel);
        
        jf.add(jp);


        jf.setVisible(true);
    }
    
    public void fillLists() {
    	
    }
}
