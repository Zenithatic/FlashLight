package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.CardManagementPanel;
import components.CreateCardPanel;

import main_pkg.Main;

public class CreateCardAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().getName().equals("openCreateCardPanel")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getCreateCardPanel());
			Main.getMainFrame().getCreateCardPanel().changeTitle("Create Card");
			Main.getMainFrame().getCreateCardPanel().changeNameArea("Name");
			Main.getMainFrame().getCreateCardPanel().changeDescArea("Description");
		}
		else if (e.getComponent().getName().equals("createCard")) {
			CardManagementPanel cmp = Main.getMainFrame().getCardManagementPanel();
			CreateCardPanel ccp = Main.getMainFrame().getCreateCardPanel();
			
			String name = ccp.getCardName();
			String desc = ccp.getCardDesc();
			
			if (name.length() == 0 || desc.length() == 0) {
				ccp.changeTitle("Invalid name / description.");
			}
			else {
				cmp.getCurrentFolder().createCard(name, desc);
				ccp.changeTitle("Successfully created card " + name + ".");
				Main.getMainFrame().getCardManagementPanel().getCurrentFolder().updateFile();
				cmp.refreshTable();
			}
		}
	}
}
