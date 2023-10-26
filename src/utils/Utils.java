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
}
