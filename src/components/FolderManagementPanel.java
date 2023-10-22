package components;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import main_pkg.Main;
import utils.Utils;

public class FolderManagementPanel extends JPanel{
	private JTable folderTable;
	private JScrollPane tableScrollPane;
	private ArrayList<String> folders;
	
	public FolderManagementPanel() {
		// initialize folders array list
		folders = new ArrayList<String>();
		
		// load folders from file
		try {
			File dir = new File("cardsets");
			File[] dirFiles = dir.listFiles();
			
			if (dirFiles != null) {
				for (File file: dirFiles) {
					folders.add((file.getName()).replace(".txt", ""));
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
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
		
		JButton createFolder = new JButton("Create Folder");
		createFolder.setMaximumSize(new Dimension(300, 100));
		createFolder.setCursor(new Cursor(Cursor.HAND_CURSOR));
		createFolder.setAlignmentX(0.5f);
		createFolder.setAlignmentY(0.5f);
		
		JButton deleteSelected = new JButton("Delete Selected");
		deleteSelected.setMaximumSize(new Dimension(300, 100));
		deleteSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteSelected.setAlignmentX(0.5f);
		deleteSelected.setAlignmentY(0.5f);
		
		JButton openSelected = new JButton("Open Selected");
		openSelected.setMaximumSize(new Dimension(300, 100));
		openSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
		openSelected.setAlignmentX(0.5f);
		openSelected.setAlignmentY(0.5f);
		
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(createFolder);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(deleteSelected);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(openSelected);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup scroll panel for JTable
		String[] columnNames = {"Folder Name"};
		String[][] tempData = Utils.folderArrListToArr(folders);
		
		folderTable = new JTable(tempData, columnNames);
		folderTable.setDefaultEditor(Object.class, null);
		folderTable.setMaximumSize(new Dimension(1000, 1000));
		
		JPanel folderView = new JPanel();
		folderView.setAlignmentX(0.5f);
		folderView.setBackground(Main.color1);
		folderView.setMaximumSize(new Dimension(1000, 1000));
		folderView.setLayout(new BoxLayout(folderView, BoxLayout.LINE_AXIS));
		
		tableScrollPane = new JScrollPane(folderTable);
		
		folderView.add(Box.createRigidArea(new Dimension(30, 0)));
		folderView.add(tableScrollPane);
		folderView.add(Box.createRigidArea(new Dimension(30, 0)));

		
		
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(topBar);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(folderView);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
	}
	
	public void updateTable(String[][] data, String[] columnNames) {
		folderTable = new JTable(data, columnNames);
		tableScrollPane.setViewportView(null);
		tableScrollPane.setViewportView(folderTable);	
	}
}
