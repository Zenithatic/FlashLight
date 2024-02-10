package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main_pkg.Main;

public class BackAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		String compName = e.getComponent().getName();
		
		if (compName.equals("fmpBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getHomePanel());
		}
		else if (compName.equals("createFolderBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getFolderManagementPanel());
		}
		else if (compName.equals("cmpBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getFolderManagementPanel());
		}
		else if (compName.equals("createCardBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getCardManagementPanel());
		}
		else if (compName.equals("cfvBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getHomePanel());
		}
		else if (compName.equals("tvBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getChooseFolderViewPanel());
		}
		else if (compName.equals("svBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getChooseFolderViewPanel());
		}
		else if (compName.equals("sqBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getHomePanel());
		}
		else if (compName.equals("mcQuizBack")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getSelectQuizPanel());
		}
	}	
}
