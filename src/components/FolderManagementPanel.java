package components;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import listeners.BackAdapter;
import listeners.CreateFolderAdapter;
import listeners.DeleteFolderAdapter;
import main_pkg.Main;
import utils.Utils;

public class FolderManagementPanel extends JPanel{
	private JTable folderTable;
	private JScrollPane tableScrollPane;
	private ArrayList<String> folders;
	
	public FolderManagementPanel() {
		// initialize folders array list
		folders = new ArrayList<String>();
		
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
		
		JButton back = new JButton("Back");
		back.setName("fmpBack");
		back.addMouseListener(new BackAdapter());
		back.setMaximumSize(new Dimension(250, 100));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setAlignmentX(0.5f);
		back.setAlignmentY(0.5f);
		
		JButton createFolder = new JButton("Create Folder");
		createFolder.setName("openCreatePanel");
		createFolder.addMouseListener(new CreateFolderAdapter());
		createFolder.setMaximumSize(new Dimension(250, 100));
		createFolder.setCursor(new Cursor(Cursor.HAND_CURSOR));
		createFolder.setAlignmentX(0.5f);
		createFolder.setAlignmentY(0.5f);
		
		JButton deleteSelected = new JButton("Delete Selected");
		deleteSelected.addMouseListener(new DeleteFolderAdapter());
		deleteSelected.setMaximumSize(new Dimension(250, 100));
		deleteSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteSelected.setAlignmentX(0.5f);
		deleteSelected.setAlignmentY(0.5f);
		
		JButton openSelected = new JButton("Open Selected");
		openSelected.setMaximumSize(new Dimension(250, 100));
		openSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
		openSelected.setAlignmentX(0.5f);
		openSelected.setAlignmentY(0.5f);
		
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
		
		tableScrollPane = new JScrollPane();
		reloadTable();
		
		folderView.add(Box.createRigidArea(new Dimension(30, 0)));
		folderView.add(tableScrollPane);
		folderView.add(Box.createRigidArea(new Dimension(30, 0)));

		
		
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(topBar);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(folderView);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
	}
	
	// method to refresh the folder table
	public void reloadTable() {
		folders.clear();
		
		// load folders from file
		try {
			File dir = new File("./cardsets");
			
			// create directory if it does not exist
			if (!dir.exists()) {
				dir.mkdir();
			}
			
			File[] dirFiles = dir.listFiles();
			
			if (dirFiles != null) {
				for (File file: dirFiles) {
					folders.add((file.getName()).replace(".txt", ""));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] columnNames = {"Folder Name"};
		folderTable = new JTable(Utils.folderArrListToArr(folders), columnNames);
		
		folderTable.setDefaultEditor(Object.class, null);
		folderTable.setMaximumSize(new Dimension(1000, 1000));
		
		tableScrollPane.setViewportView(null);
		tableScrollPane.setViewportView(folderTable);	
	}
	
	public int createFolder(String name) {
		folders.add(name);
		
		try {
			if (name.length() == 0) {
				return 1;
			}
			
			PrintWriter writer = new PrintWriter("./cardsets/" + name + ".txt");
			writer.close();
			reloadTable();
			return 0;
		} catch (FileNotFoundException e) {
			return 2;
		}
	}
	
	public boolean hasFolder(String name) {
		return folders.contains(name);
	}
	
	public int getSelected() {
		return folderTable.getSelectedRow();
	}
	
	public String getFolder(int id) {
		return folders.get(id);
	}
}
