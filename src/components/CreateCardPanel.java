package components;

import java.awt.Dimension;

import javax.swing.*;

import listeners.BackAdapter;
import listeners.CreateCardAdapter;
import main_pkg.Main;

@SuppressWarnings("serial")
public class CreateCardPanel extends JPanel{
	private JLabel title;
	private JTextField name;
	private JTextField desc;
	
	public CreateCardPanel() {
		// setup create card panel
		this.setSize(Main.defaultDimension);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Main.color1);
		
		// create title label
		title = new JLabel("Create Card", SwingConstants.CENTER);
		title.setAlignmentX(0.5f);
		title.setFont(Main.titleFont);
		title.setMaximumSize(new Dimension(800, 100));
		
		// create text area
		name = new JTextField();
		name.setFont(Main.defaultFont);
		name.setAlignmentX(0.5f);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setMaximumSize(new Dimension(400, 100));
		
		// create desc area
		desc = new JTextField();
		desc.setFont(Main.defaultFont);
		desc.setAlignmentX(0.5f);
		desc.setHorizontalAlignment(SwingConstants.CENTER);
		desc.setMaximumSize(new Dimension(400, 100));
		
		// make create card button
		JButton createButton = new JButton("Create");
		createButton.addMouseListener(new CreateCardAdapter());
		createButton.setName("createCard");
		createButton.setFont(Main.defaultFont);
		createButton.setAlignmentX(0.5f);
		createButton.setMaximumSize(new Dimension(400, 100));
		
		// make cancel button
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setName("createCardBack");
		cancelButton.addMouseListener(new BackAdapter());
		cancelButton.setFont(Main.defaultFont);
		cancelButton.setAlignmentX(0.5f);
		cancelButton.setMaximumSize(new Dimension(400, 100));
		
		// add everything to main panel
		this.add(title);
		this.add(name);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(desc);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(createButton);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(cancelButton);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
	}
	
	public void changeTitle(String newTitle) {
		title.setText(newTitle);
	}
	
	public void changeNameArea(String newArea) {
		name.setText(newArea);
	}
	
	public void changeDescArea(String newArea) {
		desc.setText(newArea);
	}
	
	public String getCardName() {
		return name.getText();
	}
	
	public String getCardDesc() {
		return desc.getText();
	}
}
