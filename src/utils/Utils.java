package utils;

import java.util.ArrayList;

public class Utils {
	public static String[][] folderArrListToArr(ArrayList<String> arrayList){
		String[][] converted = new String[arrayList.size()][1];
		
		for (int i = 0; i < arrayList.size(); i++) {
			String[] temp = {arrayList.get(i)};
			converted[i] = temp;
		}
		
		return converted;
	}
}
