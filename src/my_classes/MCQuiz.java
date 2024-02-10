package my_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;


public class MCQuiz extends Quiz {
	private Queue<MCQuestion> questions;
	
	public MCQuiz(Folder folder) {
		super(folder);
		
		// generate 5 questions
		for (int i = 0; i < 5; i++) {
			@SuppressWarnings("unchecked")
			ArrayList<Card> cards = (ArrayList<Card>) folder.getCards().clone();
			ArrayList<String> options = new ArrayList<String>();
			
			// generate random index for random card
			int idx = (int) Math.random() * cards.size();
			
			// get random title
			String title = cards.get(idx).getTitle();
			
			// add description as one of the options
			String ans = cards.get(idx).getDescription();
			options.add(cards.get(idx).getDescription());
			cards.remove(idx);
			
			// add 3 other random options
			for (int j = 0; j < 3; j++) {
				int randomIdx = (int) Math.random() * cards.size();
				options.add(cards.get(randomIdx).getDescription());
				cards.remove(randomIdx);
			}
			
			// shuffle options
			Collections.shuffle(options);
			
			// create and add question
			MCQuestion q = new MCQuestion(title, options, ans);
			addQuestion(q);
		}
	}
	
	public MCQuestion getNext() {
		if (questions.size() >= 1) {
			return questions.remove();
		}
		else {
			return null;
		}
	}
	
	public void addQuestion(MCQuestion q) {
		questions.add(q);
	}
}
