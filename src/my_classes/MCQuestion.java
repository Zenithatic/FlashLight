package my_classes;

import java.util.ArrayList;

public class MCQuestion extends Question{
	private ArrayList<String> options;
	
	public MCQuestion(String title, ArrayList<String> options, String answer) {
		super(title, answer);
		this.options = options;
	}
	
	public ArrayList<String> getOptions() {
		return options;
	}
}
