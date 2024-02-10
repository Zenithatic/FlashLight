package my_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class MCQuiz extends Quiz {
	private Stack<MCQuestion> questions;
	
	public MCQuiz(Folder folder) {
		super(folder);
		questions = new Stack<MCQuestion>();
		
		// generate 5 questions
		for (int i = 0; i < 5; i++) {
			@SuppressWarnings("unchecked")
			ArrayList<Card> cards = (ArrayList<Card>) folder.getCards().clone();
			ArrayList<String> options = new ArrayList<String>();
			
			// generate random index for random card
			int idx = (int) (Math.random() * cards.size());
			
			// get random title
			String title = cards.get(idx).getTitle();
			
			// add description as one of the options
			String ans = cards.get(idx).getDescription();
			options.add(cards.get(idx).getDescription());
			cards.remove(idx);
			
			// add 3 other random options
			for (int j = 0; j < 3; j++) {
				int randomIdx = ((int) Math.random() * cards.size());
				options.add(cards.get(randomIdx).getDescription());
				cards.remove(randomIdx);
			}
			
			// shuffle options
			Collections.shuffle(options);
			
			// create and add question
			this.addQuestion(new MCQuestion(title, options, ans));
		}
	}
	
	public MCQuestion getNext() {
		if (questions.size() >= 1) {
			return questions.pop();
		}
		else {
			return null;
		}
	}
	
	public void addQuestion(MCQuestion q) {
		questions.push(q);
	}
}
