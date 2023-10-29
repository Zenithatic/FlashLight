package components;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import listeners.BackAdapter;
import listeners.CreateFolderAdapter;
import listeners.DeleteFolderAdapter;
import listeners.ManageCardsAdapter;
import main_pkg.Main;
import my_classes.Folder;
import utils.Utils;

public class CardManagementPanel extends JPanel{
	private Folder currentFolder;
	private JScrollPane tableScrollPane;
	private JTable cardsTable;
	private JLabel title;
	
	public CardManagementPanel() {	
		// setup folder management panel
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
		back.setName("cmpBack");
		back.addMouseListener(new BackAdapter());
		back.setMaximumSize(new Dimension(333, 100));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setAlignmentX(0.5f);
		back.setAlignmentY(0.5f);
		
		// setup create folder button
		JButton createCard = new JButton("Create Card");
		createCard.setName("openCreateCardPanel");
		createCard.setMaximumSize(new Dimension(333, 100));
		createCard.setCursor(new Cursor(Cursor.HAND_CURSOR));
		createCard.setAlignmentX(0.5f);
		createCard.setAlignmentY(0.5f);
		
		// setup delete folder button
		JButton deleteSelected = new JButton("Delete Selected");
		deleteSelected.setMaximumSize(new Dimension(250, 100));
		deleteSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteSelected.setAlignmentX(0.5f);
		deleteSelected.setAlignmentY(0.5f);
		
		// add above buttons to topbar panel
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(back);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(createCard);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(deleteSelected);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup scroll panel for JTable
		JPanel cardView = new JPanel();
		cardView.setAlignmentX(0.5f);
		cardView.setBackground(Main.color1);
		cardView.setMaximumSize(new Dimension(1000, 1000));
		cardView.setLayout(new BoxLayout(cardView, BoxLayout.LINE_AXIS));
		
		// setup scroll pane
		tableScrollPane = new JScrollPane();
		
		// add table view to folder view panel
		cardView.add(Box.createRigidArea(new Dimension(30, 0)));
		cardView.add(tableScrollPane);
		cardView.add(Box.createRigidArea(new Dimension(30, 0)));
		
		this.add(title);	
		this.add(topBar);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(cardView);
		this.add(Box.createRigidArea(new Dimension(0, 30)));
	}
	
	public void setCurrentFolder(Folder folder) {
		this.currentFolder = folder;
		title.setText("Folder: " + currentFolder.getName());
		folder.reloadCards();
		refreshTable();
	}
	
	public void refreshTable() {
		String[] columnNames = {"Title", "Description"};
		cardsTable = new JTable(Utils.folderCardstoArr(currentFolder), columnNames);
		
		cardsTable.setDefaultEditor(Object.class, null);
		cardsTable.setMaximumSize(new Dimension(1000, 1000));
		
		tableScrollPane.setViewportView(null);
		tableScrollPane.setViewportView(cardsTable);
		
		cardsTable.getTableHeader().setReorderingAllowed(false);
		cardsTable.setDefaultRenderer(Object.class, new CardTableCellRenderer());
		updateRowHeights();
	}
	
	private void updateRowHeights()
	{
	    for (int row = 0; row < cardsTable.getRowCount(); row++)
	    {
	        int rowHeight = cardsTable.getRowHeight();

	        for (int column = 0; column < cardsTable.getColumnCount(); column++)
	        {
	            Component comp = cardsTable.prepareRenderer(cardsTable.getCellRenderer(row, column), row, column);
	            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height + 2 * 10);
	        }

	        cardsTable.setRowHeight(row, rowHeight);
	    }
	}
}
