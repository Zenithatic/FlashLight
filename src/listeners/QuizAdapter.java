package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.SelectQuizPanel;
import main_pkg.Main;


public class QuizAdapter extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		SelectQuizPanel sqp = Main.getMainFrame().getSelectQuizPanel();
		String compName = e.getComponent().getName();
		
		if (compName.equals("quiz")) {
			// open select folder panel
			sqp.loadTable();
			Main.getMainFrame().changePanel(sqp);
		}
		else if (compName.equals("openMC")) {
			if (sqp.getSelected() != -1) {
				// must be of size 4 or greater
			}
		}
		else if (compName.equals("openTF")) {
			// must be of size 4 or greater
		}
	}
}
