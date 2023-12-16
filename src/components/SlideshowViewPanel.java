package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import listeners.BackAdapter;
import listeners.CardSortAdapter;
import main_pkg.Main;
import my_classes.Folder;
import utils.Utils;

public class SlideshowViewPanel extends JPanel{
	private Folder currentFolder;
	
	private JLabel title;
	
	public SlideshowViewPanel() {	
		// setup slide show view panel
		this.setSize(Main.defaultDimension);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Main.color1);
		currentFolder = new Folder("");
		
		// setup title of panel
		title = new JLabel("Folder: " + currentFolder.getName(), SwingConstants.CENTER);
		title.setMaximumSize(new Dimension(400, 70));
		title.setAlignmentX(0.5f);
		title.setVerticalTextPosition(SwingConstants.CENTER);
		title.setFont(Main.titleFont);
		
		// setup top bar panel
		JPanel topBar = new JPanel();
		topBar.setAlignmentX(0.5f);
		topBar.setBackground(Main.color1);
		topBar.setMaximumSize(new Dimension(1000, 100));
		topBar.setLayout(new BoxLayout(topBar, BoxLayout.LINE_AXIS));
		
		// setup back button
		JButton back = new JButton("Back");
		back.setName("svBack");
		back.addMouseListener(new BackAdapter());
		back.setMaximumSize(new Dimension(500, 100));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setAlignmentX(0.5f);
		back.setAlignmentY(0.5f);
		
		// setup shuffle button
		JButton shuffle = new JButton("Shuffle");
		shuffle.setName("shuffle");
		// shuffle.addMouseListener(new BackAdapter());
		shuffle.setMaximumSize(new Dimension(500, 100));
		shuffle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		shuffle.setAlignmentX(0.5f);
		shuffle.setAlignmentY(0.5f);
		
		// add above buttons to topbar panel
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(back);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(shuffle);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup main view
		JPanel cardView = new JPanel();
		cardView.setAlignmentX(0.5f);
		cardView.setBackground(Main.color1);
		cardView.setMaximumSize(new Dimension(1000, 1000));
		cardView.setLayout(new BoxLayout(cardView, BoxLayout.LINE_AXIS));
		
		// setup card slide
		JTextArea mainCard = new JTextArea();
		mainCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainCard.setWrapStyleWord(true);
		mainCard.setLineWrap(true);
		mainCard.setEditable(false);
		mainCard.setFocusable(false);
		mainCard.setMaximumSize(new Dimension(1000, 400));
		
		// add card view to view panel
		cardView.add(Box.createRigidArea(new Dimension(30, 0)));
		cardView.add(mainCard);
		cardView.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup bottom bar
		JPanel botBar = new JPanel();
		botBar.setAlignmentX(0.5f);
		botBar.setBackground(Main.color1);
		botBar.setMaximumSize(new Dimension(1000, 100));
		botBar.setLayout(new BoxLayout(botBar, BoxLayout.LINE_AXIS));
		
		// setup previous button 
		JButton previous = new JButton("Previous");
		previous.setName("previous");
		previous.setMaximumSize(new Dimension(333, 100));
		previous.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previous.setAlignmentX(0.5f);
		previous.setAlignmentY(0.5f);
		
		// setup flip button
		JButton flip = new JButton("Flip");
		flip.setName("flip");
		flip.setMaximumSize(new Dimension(333, 100));
		flip.setCursor(new Cursor(Cursor.HAND_CURSOR));
		flip.setAlignmentX(0.5f);
		flip.setAlignmentY(0.5f);
		
		// setup next button
		JButton next = new JButton("Next");
		next.setName("next");
		next.setMaximumSize(new Dimension(333, 100));
		next.setCursor(new Cursor(Cursor.HAND_CURSOR));
		next.setAlignmentX(0.5f);
		next.setAlignmentY(0.5f);
		
		botBar.add(Box.createRigidArea(new Dimension(30, 0)));
		botBar.add(previous);
		botBar.add(Box.createRigidArea(new Dimension(30, 0)));
		botBar.add(flip);
		botBar.add(Box.createRigidArea(new Dimension(30, 0)));
		botBar.add(next);
		botBar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// add everything to panel
		this.add(title);	
		this.add(topBar);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(cardView);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(botBar);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
	}
	
	public Folder getCurrentFolder() {
		return this.currentFolder;
	}
	
	public void setCurrentFolder(Folder folder) {
		this.currentFolder = folder;
		title.setText("Folder: " + currentFolder.getName());
		folder.reloadCards();
	}
}
