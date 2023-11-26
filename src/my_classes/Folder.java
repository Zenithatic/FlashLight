package my_classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Folder {
	private String name;
	private ArrayList<Card> cards;
	
	public Folder(String name) {
		this.name = name;
		cards = new ArrayList<Card>();
	}
	
	public String getName() {
		return name;
	}
	
	public void reloadCards() {
		cards.clear();
		try {
			File file = new File("./cardsets/" + name + ".txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split("`");
				String title = data[0];
				String desc = data[1];
				long modDate = Long.parseLong(data[2]);
				
				Card card = new Card(title, desc, modDate);
				cards.add(card);
			}
			
			reader.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public void createCard(String name, String desc) {
		Card card = new Card(name, desc, System.currentTimeMillis());
		cards.add(card);
	}
	
	public void updateFile() {
		try {
			File file = new File("./cardsets/" + name + ".txt");
			
			// clear file first
			FileWriter fw = new FileWriter(file, false);
			PrintWriter pw = new PrintWriter(fw, false);
			pw.flush();
			pw.close();
			fw.close();
			
			// write cards into file
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			
			for (int i = 0; i < cards.size(); i++) {
				Card cur = cards.get(i);
				String name = cur.getTitle();
				String desc = cur.getDescription();
				long date = cur.getLastModified();
				
				bw.write(name + "`" + desc + "`" + date);
				bw.newLine();
			}
			
			bw.close();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCard(int index) {
		cards.remove(index);
	}
	
	public void sortAZ(ArrayList<Card> list) {
		if (list.size() >= 2) {
			int midIndex = list.size() / 2;
			
			ArrayList<Card> left = new ArrayList<Card>();
			left.addAll(list.subList(0, midIndex));
			
			ArrayList<Card> right = new ArrayList<Card>();
			right.addAll(list.subList(midIndex, list.size()));
			
			sortAZ(left);
			sortAZ(right);
			mergeAZ(list, left, right);
		}
	}
	
	private void mergeAZ(ArrayList<Card> parent, ArrayList<Card> left, ArrayList<Card> right) {
		// i: left index, j: right index, k: parent index
		int i = 0, j = 0, k = 0;
		
		while (i < left.size() && j < right.size()) {
			if (left.get(i).getTitle().compareTo(right.get(j).getTitle()) <= 0) {
				parent.set(k, left.get(i));
				k++; i++;
			}
			else {
				parent.set(k, right.get(j));
				k++; j++;
			}
		}
		while (i < left.size()) {
			parent.set(k, left.get(i));
			k++; i++;
		}
		while (j < right.size()) {
			parent.set(k, right.get(j));
			k++; j++;
		}
	}
	
	public void sortDate(ArrayList<Card> list) {
		if (list.size() >= 2) {
			int midIndex = list.size() / 2;
			
			ArrayList<Card> left = new ArrayList<Card>();
			left.addAll(list.subList(0, midIndex));
			
			ArrayList<Card> right = new ArrayList<Card>();
			right.addAll(list.subList(midIndex, list.size()));
			
			sortDate(left);
			sortDate(right);
			mergeDate(list, left, right);
		}
	}
	
	private void mergeDate(ArrayList<Card> parent, ArrayList<Card> left, ArrayList<Card> right) {
		// i: left index, j: right index, k: parent index
		int i = 0, j = 0, k = 0;
		
		while (i < left.size() && j < right.size()) {
			if (left.get(i).getLastModified() <= right.get(j).getLastModified()) {
				parent.set(k, left.get(i));
				k++; i++;
			}
			else {
				parent.set(k, right.get(j));
				k++; j++;
			}
		}
		while (i < left.size()) {
			parent.set(k, left.get(i));
			k++; i++;
		}
		while (j < right.size()) {
			parent.set(k, right.get(j));
			k++; j++;
		}
	}
}
