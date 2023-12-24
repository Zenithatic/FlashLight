package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main_pkg.Main;


public class PreviousNextAdapter extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		String buttonName = e.getComponent().getName();
		
		if (buttonName.equals("next")){
			Main.getMainFrame().getSlideshowViewPanel().next();
		}
		else if (buttonName.equals("previous")){
			Main.getMainFrame().getSlideshowViewPanel().previous();
		}
	}
}
