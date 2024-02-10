package listeners;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

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
			
			cfvp.getFolder(cfvp.getSelected()).reloadCards();
			if (cfvp.getFolder(cfvp.getSelected()).getCards().size() == 0) {
				// too small
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(cfvp, "Folder is empty!", "Warning", JOptionPane.ERROR_MESSAGE);
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
			
			cfvp.getFolder(cfvp.getSelected()).reloadCards();
			if (cfvp.getFolder(cfvp.getSelected()).getCards().size() == 0) {
				// too small
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(cfvp, "Folder is empty!", "Warning", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			Main.getMainFrame().changePanel(Main.getMainFrame().getSlideshowViewPanel());
			Main.getMainFrame().getSlideshowViewPanel().setCurrentFolder(cfvp.getFolder(cfvp.getSelected()));
		}
	}	
}
