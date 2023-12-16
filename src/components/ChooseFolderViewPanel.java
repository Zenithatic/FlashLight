package components;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import listeners.BackAdapter;
import listeners.CreateFolderAdapter;
import listeners.DeleteFolderAdapter;
import listeners.ManageCardsAdapter;
import listeners.OpenViewAdapter;
import main_pkg.Main;
import my_classes.Folder;
import utils.Utils;

public class ChooseFolderViewPanel extends JPanel{
	private JTable folderTable;
	private JScrollPane tableScrollPane;
	private ArrayList<Folder> folders;
	
	public ChooseFolderViewPanel() {
		// initialize folders array list
		folders = new ArrayList<Folder>();
		
		// setup choose folder view panel
		this.setSize(Main.defaultDimension);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Main.color1);
		
		// setup top bar panel
		JPanel topBar = new JPanel();
		topBar.setAlignmentX(0.5f);
		topBar.setBackground(Main.color1);
		topBar.setMaximumSize(new Dimension(1000, 100));
		topBar.setLayout(new BoxLayout(topBar, BoxLayout.LINE_AXIS));
		
		// setup back button
		JButton back = new JButton("Back");
		back.setName("cfvBack");
		back.addMouseListener(new BackAdapter());
		back.setMaximumSize(new Dimension(250, 100));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setAlignmentX(0.5f);
		back.setAlignmentY(0.5f);
		
		// setup open slideshow button
		JButton openSlide = new JButton("Open in slideshow view");
		openSlide.setName("openSlide");
		openSlide.addMouseListener(new OpenViewAdapter());
		openSlide.setMaximumSize(new Dimension(250, 100));
		openSlide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		openSlide.setAlignmentX(0.5f);
		openSlide.setAlignmentY(0.5f);
		
		// setup open table view button
		JButton openTable = new JButton("Open in table view");
		openTable.setName("openTable");
		openTable.addMouseListener(new OpenViewAdapter());
		openTable.setMaximumSize(new Dimension(250, 100));
		openTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		openTable.setAlignmentX(0.5f);
		openTable.setAlignmentY(0.5f);
		
		// add above buttons to topbar panel
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(back);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(openSlide);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(openTable);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup scroll panel for JTable
		JPanel folderView = new JPanel();
		folderView.setAlignmentX(0.5f);
		folderView.setBackground(Main.color1);
		folderView.setMaximumSize(new Dimension(1000, 1000));
		folderView.setLayout(new BoxLayout(folderView, BoxLayout.LINE_AXIS));
		
		// setup scroll pane
		tableScrollPane = new JScrollPane();
		loadTable();
		
		// add table view to folder view panel
		folderView.add(Box.createRigidArea(new Dimension(30, 0)));
		folderView.add(tableScrollPane);
		folderView.add(Box.createRigidArea(new Dimension(30, 0)));

		// add everything to main panel
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(topBar);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(folderView);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
	}
	
	// method to load the folder table from file system
	public void loadTable() {
		folders.clear();
		
		// load folders from file
		try {
			File dir = new File("./cardsets");
			
			// create directory if it does not exist
			if (!dir.exists()) {
				dir.mkdir();
			}
			
			// load folders into array list
			File[] dirFiles = dir.listFiles();
			
			if (dirFiles != null) {
				for (File file: dirFiles) {
					folders.add(new Folder(file.getName().replace(".txt", "")));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		refreshTable();
	}
	
	// method to simply update table view
	public void refreshTable() {
		String[] columnNames = {"Folder Name"};
		folderTable = new JTable(Utils.folderArrListToArr(folders), columnNames);
		
		folderTable.setDefaultEditor(Object.class, null);
		folderTable.setMaximumSize(new Dimension(1000, 1000));
		
		tableScrollPane.setViewportView(null);
		tableScrollPane.setViewportView(folderTable);	
		folderTable.getTableHeader().setReorderingAllowed(false);
	}
	
	public boolean hasFolderName(String name) {
		for (int i = 0; i < folders.size(); i++) {
			if (folders.get(i).getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getSelected() {
		return folderTable.getSelectedRow();
	}
	
	public Folder getFolder(int id) {
		return folders.get(id);
	}
}
