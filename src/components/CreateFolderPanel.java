package components;

import java.awt.Dimension;

import javax.swing.*;

import listeners.BackAdapter;
import listeners.CreateFolderAdapter;
import main_pkg.Main;

public class CreateFolderPanel extends JPanel{
	JTextField name;
	JLabel title;
	
	public CreateFolderPanel() {
		// setup folder management panel
		this.setSize(Main.defaultDimension);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Main.color1);
		
		// create title label
		title = new JLabel("Create Folder", SwingConstants.CENTER);
		title.setAlignmentX(0.5f);
		title.setFont(Main.titleFont);
		title.setMaximumSize(new Dimension(800, 100));
		
		// create text area
		name = new JTextField();
		name.setFont(Main.defaultFont);
		name.setAlignmentX(0.5f);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setMaximumSize(new Dimension(400, 100));
		
		// make create folder button
		JButton createButton = new JButton("Create");
		createButton.addMouseListener(new CreateFolderAdapter());
		createButton.setName("createFolder");
		createButton.setFont(Main.defaultFont);
		createButton.setAlignmentX(0.5f);
		createButton.setMaximumSize(new Dimension(400, 100));
		
		// make cancel folder button
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setName("createFolderBack");
		cancelButton.addMouseListener(new BackAdapter());
		cancelButton.setFont(Main.defaultFont);
		cancelButton.setAlignmentX(0.5f);
		cancelButton.setMaximumSize(new Dimension(400, 100));
		
		// add everything to main panel
		this.add(title);
		this.add(name);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(createButton);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(cancelButton);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
	}
	
	public String getText() {
		return name.getText().trim();
	}
	
	public void setTitleText(String text) {
		title.setText(text);
	}
	
	public void setFieldText(String text) {
		name.setText(text);
	}
}
