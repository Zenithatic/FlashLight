package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main_pkg.Main;


public class FlipAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		Main.getMainFrame().getSlideshowViewPanel().flip();
	}	
}
