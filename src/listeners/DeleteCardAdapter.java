package listeners;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import components.CardManagementPanel;
import main_pkg.Main;

public class DeleteCardAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		CardManagementPanel cmp = Main.getMainFrame().getCardManagementPanel();
		int selectedRow = cmp.getSelectedRow();

		if (selectedRow == -1) {
			return;
		}
		else {
			Toolkit.getDefaultToolkit().beep();
			int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected card?",  "CONFIRM", JOptionPane.YES_NO_OPTION);
			
			if (confirmed == JOptionPane.YES_OPTION) {
				cmp.getCurrentFolder().deleteCard(selectedRow);
				cmp.getCurrentFolder().updateFile();
				cmp.refreshTable();
			}
		}
	}	
}
