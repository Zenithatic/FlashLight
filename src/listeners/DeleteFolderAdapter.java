package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import components.FolderManagementPanel;
import main_pkg.Main;

public class DeleteFolderAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		FolderManagementPanel fmp = Main.getMainFrame().getFolderManagementPanel();
		int selectedRow = fmp.getSelected();
		String folderName;
		
		if (selectedRow == -1) {
			return;
		}
		else {
			folderName = fmp.getFolder(selectedRow).getName();
			fmp.deleteFolder(folderName);
		}
	}	
}
