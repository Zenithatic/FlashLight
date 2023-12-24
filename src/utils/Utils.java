package utils;

import java.util.ArrayList;

import my_classes.Folder;

public class Utils {
	public static String[][] folderArrListToArr(ArrayList<Folder> folders){
		String[][] converted = new String[folders.size()][1];
		
		for (int i = 0; i < folders.size(); i++) {
			String[] temp = {folders.get(i).getName()};
			converted[i] = temp;
		}
		
		return converted;
	}
	
	public static String[][] folderCardstoArr(Folder folder){
		String[][] converted = new String[folder.getCards().size()][2];
		
		for (int i = 0; i < folder.getCards().size(); i++) {
			String[] temp = {folder.getCards().get(i).getTitle(), folder.getCards().get(i).getDescription()};
			converted[i] = temp;
		}
		
		return converted;
	}
	
	public static String convertFitHTML(String string) {
		String newString = "";
		boolean addBr = false;
		
		for (int i = 0; i < string.length(); i++) {
			if (i % 60 == 0 && i != 0) {
				addBr = true;
			}
			
			if (string.charAt(i) == ' ') {
				if (addBr == true) {
					addBr = false;
					newString += "<br>";
				}
				else {
					newString += " ";
				}
			}
			else {
				newString = newString + string.charAt(i);
			}
		}
		
		return "<html>" + newString + "</html>";
	}
}
