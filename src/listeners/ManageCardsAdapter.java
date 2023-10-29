package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.CardManagementPanel;
import components.FolderManagementPanel;
import main_pkg.Main;

public class ManageCardsAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		if (Main.getMainFrame().getFolderManagementPanel().getSelected() == -1) {
			// if no folder is selected
			return;
		}
		else {
			CardManagementPanel cmp = Main.getMainFrame().getCardManagementPanel();
			FolderManagementPanel fmp = Main.getMainFrame().getFolderManagementPanel();
			
			Main.getMainFrame().changePanel(cmp);
			
			cmp.setCurrentFolder(fmp.getFolder(fmp.getSelected()));
		}
	}
}
