package listeners;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JOptionPane;

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
			folderName = fmp.getFolder(selectedRow);
			Toolkit.getDefaultToolkit().beep();
			int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete folder " + folderName + "?",  "CONFIRM", JOptionPane.YES_NO_OPTION);
			
			if (confirmed == JOptionPane.YES_OPTION){		
				try {
					File dir = new File("./cardsets");
					
					File[] dirFiles = dir.listFiles();
					
					if (dirFiles != null) {
						for (File file: dirFiles) {
							if (file.getName().equals(folderName + ".txt")) {
								file.delete();
								fmp.reloadTable();
								return;
							}
						}
					}
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else {
				return;
			}
		}
	}	
}
