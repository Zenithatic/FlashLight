package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.ChooseFolderViewPanel;
import main_pkg.Main;

public class OpenViewAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		ChooseFolderViewPanel cfvp = Main.getMainFrame().getChooseFolderViewPanel();
		
		
		if (e.getComponent().getName().equals("openTable")) {
			if (cfvp.getSelected() == -1) {
				// if no folder is selected
				return;
			}
			
			Main.getMainFrame().changePanel(Main.getMainFrame().getTableViewPanel());
			Main.getMainFrame().getTableViewPanel().setCurrentFolder(cfvp.getFolder(cfvp.getSelected()));
		}
		else {
			if (cfvp.getSelected() == -1) {
				// if no folder is selected
				return;
			}
			
			Main.getMainFrame().changePanel(Main.getMainFrame().getSlideshowViewPanel());
			Main.getMainFrame().getSlideshowViewPanel().setCurrentFolder(cfvp.getFolder(cfvp.getSelected()));
		}
	}	
}
