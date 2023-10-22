package components;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import listeners.ManageCardsAdapter;
import main_pkg.Main;

public class HomePanel extends JPanel{
	
	public HomePanel() {
		// setup home panel
		this.setSize(Main.defaultDimension);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Main.color1);
		
		// create welcome label
		JLabel welcome = new JLabel("Welcome to FlashLight", SwingConstants.CENTER);
		welcome.setBackground(new Color(255, 255,255));
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
		manageCards.addMouseListener(new ManageCardsAdapter());
		
		// create manage cards button
		JButton viewCards = new JButton("View Cards");
		viewCards.setMaximumSize(new Dimension(400, 300));
		viewCards.setAlignmentX(0.5f);
		viewCards.setCursor(new Cursor(Cursor.HAND_CURSOR));
		viewCards.setFont(Main.titleFont);
		
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
