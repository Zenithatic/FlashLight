package components;
import java.awt.Dimension;

import javax.swing.*;

public class MainFrame extends JFrame{
	
	private HomePanel homePanel;
	private FolderManagementPanel folderManagementPanel;
	
	public MainFrame() {
		// setup mainframe
		this.setSize(800, 600);
		this.setMinimumSize(new Dimension(800, 600));
		this.setTitle("FlashLight");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// setup panels
		homePanel = new HomePanel();
		this.changePanel(homePanel);
		
		folderManagementPanel = new FolderManagementPanel();
	}
	
	public void changePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.getContentPane().invalidate();
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
	
	public HomePanel getHomePanel() {
		return homePanel;
	}
	
	public FolderManagementPanel getFolderManagementPanel() {
		return folderManagementPanel;
	}
}
