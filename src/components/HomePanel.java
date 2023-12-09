package components;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import listeners.ManageFoldersAdapter;
import listeners.ViewFolderAdapter;
import main_pkg.Main;

public class HomePanel extends JPanel{
	
	public HomePanel() {
		// setup home panel
		this.setSize(Main.defaultDimension);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Main.color1);
		
		// create welcome label
		JLabel welcome = new JLabel("Welcome to FlashLight", SwingConstants.CENTER);
		welcome.setMaximumSize(new Dimension(400, 100));
		welcome.setAlignmentX(0.5f);
		welcome.setVerticalTextPosition(SwingConstants.CENTER);
		welcome.setFont(Main.titleFont);
		
		// create manage cards button
		JButton manageCards = new JButton("Manage Cards");
		manageCards.setMaximumSize(new Dimension(400, 300));
		manageCards.setAlignmentX(0.5f);
		manageCards.setCursor(new Cursor(Cursor.HAND_CURSOR));
		manageCards.setFont(Main.titleFont);
		manageCards.addMouseListener(new ManageFoldersAdapter());
		
		// create view cards button
		JButton viewCards = new JButton("View Cards");
		viewCards.setName("view1");
		viewCards.setMaximumSize(new Dimension(400, 300));
		viewCards.setAlignmentX(0.5f);
		viewCards.setCursor(new Cursor(Cursor.HAND_CURSOR));
		viewCards.setFont(Main.titleFont);
		viewCards.addMouseListener(new ViewFolderAdapter());
		
		// add components to panel
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(welcome);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(manageCards);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(viewCards);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
	}
}
