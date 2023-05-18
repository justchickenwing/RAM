package actions;
import static javax.swing.JOptionPane.showMessageDialog;

public class Alert {
	private Alert() {}
	public static void show(String message) {
		showMessageDialog(null, message);
		System.exit(1);
	}
}
