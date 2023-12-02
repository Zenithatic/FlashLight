package listeners;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main_pkg.Main;

public class ViewFolderAdapter extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().getName().equals("view1")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getChooseFolderViewPanel());
			Main.getMainFrame().getChooseFolderViewPanel().loadTable();
		}
	}	
}
