package components;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	private HomePanel homePanel;
	private FolderManagementPanel folderManagementPanel;
	private CreateFolderPanel createFolderPanel;
	private CardManagementPanel cardManagementPanel;
	private CreateCardPanel createCardPanel;
	private ChooseFolderViewPanel chooseFolderViewPanel;
	private TableViewPanel tableViewPanel;
	private SlideshowViewPanel slideshowViewPanel;
	private SelectQuizPanel selectQuizPanel;
	
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
		createFolderPanel = new CreateFolderPanel();
		cardManagementPanel = new CardManagementPanel();
		createCardPanel = new CreateCardPanel();
		chooseFolderViewPanel = new ChooseFolderViewPanel();
		tableViewPanel = new TableViewPanel();
		slideshowViewPanel = new SlideshowViewPanel();
		selectQuizPanel = new SelectQuizPanel();
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
	
	public CreateFolderPanel getCreateFolderPanel() {
		return createFolderPanel;
	}

	public CardManagementPanel getCardManagementPanel() {
		return cardManagementPanel;
	}
	
	public CreateCardPanel getCreateCardPanel() {
		return createCardPanel;
	}

	public ChooseFolderViewPanel getChooseFolderViewPanel() {
		return chooseFolderViewPanel;
	}

	public TableViewPanel getTableViewPanel() {
		return tableViewPanel;
	}

	public SlideshowViewPanel getSlideshowViewPanel() {
		return slideshowViewPanel;
	}

	public SelectQuizPanel getSelectQuizPanel() {
		return selectQuizPanel;
	}
}
