package listeners;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main_pkg.Main;

public class ManageCardsAdapter extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		Main.getMainFrame().changePanel(Main.getMainFrame().getFolderManagementPanel());
	}	
}
