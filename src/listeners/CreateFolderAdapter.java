package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.CreateFolderPanel;
import components.FolderManagementPanel;
import main_pkg.Main;

public class CreateFolderAdapter extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().getName().equals("openCreatePanel")) {
			Main.getMainFrame().changePanel(Main.getMainFrame().getCreateFolderPanel());
			Main.getMainFrame().getCreateFolderPanel().setTitleText("Create Folder");
			Main.getMainFrame().getCreateFolderPanel().setFieldText("");
		}
		else if (e.getComponent().getName().equals("createFolder")) {
			FolderManagementPanel fmp = Main.getMainFrame().getFolderManagementPanel();
			CreateFolderPanel cfp = Main.getMainFrame().getCreateFolderPanel();
			
			String folderToCreate = Main.getMainFrame().getCreateFolderPanel().getText();
			
			if (fmp.hasFolderName(folderToCreate)) {
				cfp.setTitleText("Error: Folder already exists.");
			}
			else {
				int error = fmp.createFolder(folderToCreate);
				
				if (error == 0) {
					cfp.setTitleText("Folder: " + folderToCreate + " created.");
				}
				else if (error == 1){
					cfp.setTitleText("Error: Name too short.");
				}
				else if (error == 2) {
					cfp.setTitleText("Error: Invalid symbols in name.");
				}
				
				cfp.setFieldText("");
			}
		}
	}
}
