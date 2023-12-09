package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.ChooseFolderViewPanel;
import main_pkg.Main;

public class OpenTableAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		ChooseFolderViewPanel cfvp = Main.getMainFrame().getChooseFolderViewPanel();
		
		if (cfvp.getSelected() == -1) {
			// if no folder is selected
			return;
		}
		
		Main.getMainFrame().changePanel(Main.getMainFrame().getTableViewPanel());
		Main.getMainFrame().getTableViewPanel().setCurrentFolder(cfvp.getFolder(cfvp.getSelected()));
	}	
}
