package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import components.MainFrame;
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
			String folderToCreate = Main.getMainFrame().getCreateFolderPanel().getText();
			
			if (Main.getMainFrame().getFolderManagementPanel().hasFolder(folderToCreate)) {
				Main.getMainFrame().getCreateFolderPanel().setTitleText("Error: Folder already exists.");
			}
			else {
				int error = Main.getMainFrame().getFolderManagementPanel().createFolder(folderToCreate);
				
				if (error == 0) {
					Main.getMainFrame().getCreateFolderPanel().setTitleText("Folder: " + folderToCreate + " created.");
				}
				else if (error == 1){
					Main.getMainFrame().getCreateFolderPanel().setTitleText("Error: Name too short.");
				}
				else if (error == 2) {
					Main.getMainFrame().getCreateFolderPanel().setTitleText("Error: Invalid symbols in name.");
				}
				
				Main.getMainFrame().getCreateFolderPanel().setFieldText("");
			}
		}
	}
}
