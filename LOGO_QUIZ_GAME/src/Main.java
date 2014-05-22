import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	public static String DataBasePATH = null;

	public static void main(String[] args) {
		try {
			JOptionPane.showMessageDialog(null,
					"PLEASE SELECT DATABASE FODLER", "PROGRAM INFO",
					JOptionPane.INFORMATION_MESSAGE);
			IconDataStructure.initializeIconDataStructure();
			DataBasePATH = initializeDataBase();
			IconDataStructure.LoadDataBase(DataBasePATH);
			System.out.println(DataBasePATH);
			System.out.println(IconDataStructure.toStringOverrided());
			GameGraphicalUserInterface.initializeGUI();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "INVALID DATABASE FODLER",
					"PROGRAM INFO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static String initializeDataBase() {

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
		}
		return null;

	}
}
