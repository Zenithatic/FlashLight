package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main_pkg.Main;

public class BackAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		Main.getMainFrame().changePanel(Main.getMainFrame().getHomePanel());
	}	
}
