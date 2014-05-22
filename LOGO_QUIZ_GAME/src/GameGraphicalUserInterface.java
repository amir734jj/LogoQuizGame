import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameGraphicalUserInterface {
	public static final int NumberOfOptions = 4;
	public static int TotalWin = 0;
	public static int TotalLost = 0;
	public static JFrame frame;
	public static int CurrentAnswer = IconDataStructure.randInt(0,
			NumberOfOptions - 1);

	public static void initializeGUI() {
		frame = new JFrame("LOGO QUIZ GAME");
		JPanel panel = new JPanel(new FlowLayout());
		addContentToPanel(panel);
		frame.add(panel);
		frame.setSize(700, 340);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2,
				(dim.height / 2 - frame.getSize().height / 2) - 80);
	}

	public static void addContentToPanel(final JPanel panel) {
		IconOption[] array = IconDataStructure
				.getPackOfOptions(NumberOfOptions);
		JLabel img1 = new JLabel(new ImageIcon(
				array[CurrentAnswer].getIconPath()));

		JRadioButton b1 = new JRadioButton(array[0].getIconValue());
		JRadioButton b2 = new JRadioButton(array[1].getIconValue());
		JRadioButton b3 = new JRadioButton(array[2].getIconValue());
		JRadioButton b4 = new JRadioButton(array[3].getIconValue());
		final JButton next = new JButton("NEXT / SKIP");
		next.setSelected(true);
		JButton exit = new JButton("END GAME / EXIT");

		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				judgeWinORLost(0, next);
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				judgeWinORLost(1, next);
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				judgeWinORLost(2, next);
			}
		});

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				judgeWinORLost(3, next);
			}
		});

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel new_panel = new JPanel();
				frame.setVisible(false);
				frame.remove(panel);
				addContentToPanel(new_panel);
				frame.add(new_panel);
				frame.setVisible(true);
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayBye();
			}
		});

		ButtonGroup group = new ButtonGroup();
		group.add(b1);
		group.add(b2);
		group.add(b3);
		group.add(b4);
		p1.add(img1);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p2.add(next);
		p2.add(exit);
		panel.add(p1);
		panel.add(p2);
		panel.setBackground(Color.LIGHT_GRAY);
	}

	public static void sayWin() {
		TotalWin++;
		JOptionPane.showMessageDialog(null, "CORRECT !", "PROGRAM INFO",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void sayLost() {
		TotalLost++;
		JOptionPane.showMessageDialog(null, "INCORRECT !", "PROGRAM INFO",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void sayBye() {
		JOptionPane.showMessageDialog(null, "TOTAL WIN: " + TotalWin
				+ "\nTOTAL LOST: " + TotalLost, "PROGRAM INFO",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	public static void judgeWinORLost(int x, JButton signal) {
		if (CurrentAnswer == x)
			sayWin();
		else
			sayLost();

		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		signal.doClick();

	}

}
