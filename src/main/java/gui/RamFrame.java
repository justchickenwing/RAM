package gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import ram.TextFileReader;

public class RamFrame extends javax.swing.JFrame {
    /**
	 * Declare a serialVersionUID to verify that 
	 * the sender and receiver of a serialized 
	 * object have loaded classes for that object 
	 * that are compatible with respect to serialization.
	 */
	private static final long serialVersionUID = -4933807437428170291L;
	private JPanel contentPanel = new JPanel();
    private JSplitPane midXPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private JPanel memYPanel = new JPanel();
    private JPanel ralYPanel = new JPanel();
    private JLabel inputLabel = new JLabel();
    private JLabel memLabel = new JLabel();
    private JLabel ralLabel = new JLabel();
    private JLabel outputLabel = new JLabel();
	private String[] ralArray;
	private String[] memArray;
	Dimension dimension = new Dimension(100, 200);
 
	/**
	 * Constructor of the RamFrame.
	 * @param ralFile path of the file where the ral commands are stored
	 * @param memoryFile path of the file where the memory is stored
	 * @param ac the displayed output of the program
	 */
    public RamFrame(String ralFile, String memoryFile, int ac) {
    	ralArray = TextFileReader.convertFileToStringArray(ralFile);
        memArray = TextFileReader.convertFileToStringArray(memoryFile);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("myRAM");
        
        contentPanel.setLayout( new BoxLayout(
                contentPanel, BoxLayout.Y_AXIS ) );
        memYPanel.setLayout( new BoxLayout(
        		memYPanel, BoxLayout.Y_AXIS ) );
        ralYPanel.setLayout( new BoxLayout(
        		ralYPanel, BoxLayout.Y_AXIS ) );
        
        inputLabel.setText ( "Input" );
        memLabel.setText( "Memory:" );
        ralLabel.setText( "RAL-Befehle:" );
        outputLabel.setText ( "Output = " + ac ) ;
        
        JList<Object> ralList = new JList<Object>(ralArray);
        JList<Object> memList = new JList<Object>(memArray);
        memYPanel.setPreferredSize(dimension);
        memYPanel.setBackground(Color.white);
        ralYPanel.setPreferredSize(dimension);
        ralYPanel.setBackground(Color.white);
        
        contentPanel.add (inputLabel);

        memYPanel.add(memLabel);
        JScrollPane memScrollPane = new JScrollPane();
        memScrollPane.setViewportView(memList);
        memYPanel.add(memScrollPane);
        ralYPanel.add(ralLabel);
        JScrollPane ralScrollPane = new JScrollPane();
        ralScrollPane.setViewportView(ralList);
        ralYPanel.add(ralScrollPane);
        
        midXPanel.setRightComponent(ralYPanel);
        midXPanel.setLeftComponent(memYPanel);
        contentPanel.add(midXPanel);
        
        contentPanel.add (outputLabel);
        
        this.getContentPane().add(contentPanel);

        pack();
    }
}
