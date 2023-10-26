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
import main_pkg.Main;
import my_classes.Folder;
import utils.Utils;

public class FolderManagementPanel extends JPanel{
	private JTable folderTable;
	private JScrollPane tableScrollPane;
	private ArrayList<Folder> folders;
	
	public FolderManagementPanel() {
		// initialize folders array list
		folders = new ArrayList<Folder>();
		
		// setup folder management panel
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
		back.setName("fmpBack");
		back.addMouseListener(new BackAdapter());
		back.setMaximumSize(new Dimension(250, 100));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setAlignmentX(0.5f);
		back.setAlignmentY(0.5f);
		
		// setup create folder button
		JButton createFolder = new JButton("Create Folder");
		createFolder.setName("openCreatePanel");
		createFolder.addMouseListener(new CreateFolderAdapter());
		createFolder.setMaximumSize(new Dimension(250, 100));
		createFolder.setCursor(new Cursor(Cursor.HAND_CURSOR));
		createFolder.setAlignmentX(0.5f);
		createFolder.setAlignmentY(0.5f);
		
		// setup delete folder button
		JButton deleteSelected = new JButton("Delete Selected");
		deleteSelected.addMouseListener(new DeleteFolderAdapter());
		deleteSelected.setMaximumSize(new Dimension(250, 100));
		deleteSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteSelected.setAlignmentX(0.5f);
		deleteSelected.setAlignmentY(0.5f);
		
		// setup open selected folder button
		JButton openSelected = new JButton("Open Selected");
		openSelected.setMaximumSize(new Dimension(250, 100));
		openSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
		openSelected.setAlignmentX(0.5f);
		openSelected.setAlignmentY(0.5f);
		
		// add above buttons to topbar panel
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(back);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(createFolder);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(deleteSelected);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(openSelected);
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
	}
	
	public int createFolder(String name) {	
		if (name.length() == 0) {
			return 1;
		}
		else {
			try {
				PrintWriter writer = new PrintWriter("./cardsets/" + name + ".txt");
				writer.close();
			}
			catch (Exception e) {
				return 2;
			}
			
			folders.add(new Folder(name));
			refreshTable();
			return 0;
		}
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
	
	public void deleteFolder(String name) {
		// ask user to confirm deletion
		Toolkit.getDefaultToolkit().beep();
		int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete folder " + name + "?",  "CONFIRM", JOptionPane.YES_NO_OPTION);
		
		if (confirmed == JOptionPane.YES_OPTION){		
			try {
				File dir = new File("./cardsets");
				
				File[] dirFiles = dir.listFiles();
				
				// remove folder from file system and arraylist
				if (dirFiles != null) {
					for (File file: dirFiles) {
						if (file.getName().equals(name + ".txt")) {
							file.delete();
							
							for (int i = 0; i < folders.size(); i++) {
								if (folders.get(i).getName().equals(name)) {
									folders.remove(i);
									break;
								}
							}
								
							refreshTable();
							return;
						}
					}
				}
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else {
			return;
		}
	}
}
