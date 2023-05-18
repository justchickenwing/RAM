package gui;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import actions.ClickStart;
import ram.File;
import ram.TextFileReader;

public class RamFrame extends JFrame {
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
    private JButton startButton = new JButton();
    private JLabel outputLabel = new JLabel();
    
	private String[] ralArray;
	private String[] memArray;
	Dimension dimension = new Dimension(100, 200);
 
	private int ac = 0;
	private int sp;
	private ClickStart cs = new ClickStart();
	/**
	 * Constructor of the RamFrame.
	 * @param ralFile path of the file where the ral commands are stored
	 * @param memoryFile path of the file where the memory is stored
	 */
    public RamFrame() {
    	// Read the input
    	ralArray = new TextFileReader(File.ralFile).convertFileToStringArray();
        memArray = new TextFileReader(File.memoryFile).convertFileToStringArray();
        // Frame conf
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("myRAM");
        setLocationRelativeTo(null);
        // Layout of the panels
        contentPanel.setLayout( new BoxLayout(
                contentPanel, BoxLayout.Y_AXIS ) );
        memYPanel.setLayout( new BoxLayout(
        		memYPanel, BoxLayout.Y_AXIS ) );
        ralYPanel.setLayout( new BoxLayout(
        		ralYPanel, BoxLayout.Y_AXIS ) );
        // set Label Text
        inputLabel.setText ( "Input" );
        memLabel.setText( "Memory:" );
        ralLabel.setText( "RAL-Befehle:" );
        outputLabel.setText ( "Output = ");
        // put the array of the file in a list
        final JList<Object> ralList = new JList<Object>(ralArray);
        JList<Object> memList = new JList<Object>(memArray);
        ralList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        memList.setEnabled(false);
        // listener to set the start point of the program
        ralList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				sp = ralList.getSelectedIndex();
			}
		});
        // set a default selection of the ral list
        ralList.setSelectedIndex(0);
        // panel ui config
        memYPanel.setPreferredSize(dimension);
        memYPanel.setBackground(Color.white);
        ralYPanel.setPreferredSize(dimension);
        ralYPanel.setBackground(Color.white);

        contentPanel.add (inputLabel);
        memYPanel.add(memLabel);
        // make the list scrollable
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
        
        startButton.setText("start program");
        // action click button
        startButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent evt) {
            	ac = cs.clicked(sp);
            	outputLabel.setText("Output = " + ac) ;
            }
        });
        contentPanel.add(startButton);
        
        contentPanel.add(outputLabel);
        
        this.getContentPane().add(contentPanel);

        pack();
    }
}
