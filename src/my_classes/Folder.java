package my_classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
				String[] data = line.split(",");
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
}
