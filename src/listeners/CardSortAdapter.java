package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.CardManagementPanel;
import components.TableViewPanel;
import main_pkg.Main;

public class CardSortAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		CardManagementPanel cmp = Main.getMainFrame().getCardManagementPanel();
		TableViewPanel tvp = Main.getMainFrame().getTableViewPanel();
		
		if (e.getComponent().getName().equals("CardSortAZ")) {
			cmp.getCurrentFolder().sortAZ(cmp.getCurrentFolder().getCards());
			cmp.refreshTable();
		}
		else if (e.getComponent().getName().equals("CardSortTime")) {
			cmp.getCurrentFolder().sortDate(cmp.getCurrentFolder().getCards());
			cmp.refreshTable();
		}
		else if (e.getComponent().getName().equals("ViewCardSortAZ")) {
			tvp.getCurrentFolder().sortAZ(tvp.getCurrentFolder().getCards());
			tvp.refreshTable();
		}
		else if (e.getComponent().getName().equals("ViewCardSortTime")) {
			tvp.getCurrentFolder().sortDate(tvp.getCurrentFolder().getCards());
			tvp.refreshTable();
		}
	}
}
