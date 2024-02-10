package my_classes;

import java.util.ArrayList;
import java.util.Queue;


public class TFQuiz extends Quiz {
	private Queue<TFQuestion> questions;
	
	public TFQuiz(Folder folder) {
		super(folder);
		
		// generate 5 questions
		for (int i = 0; i < 5; i++) {
			@SuppressWarnings("unchecked")
			ArrayList<Card> cards = (ArrayList<Card>) folder.getCards().clone();
			
			// generate random index for random card
			int idx = (int) Math.random() * cards.size();
			String title = cards.get(idx).getTitle();
			String desc;
			String ans;
			
			// randomly choose to make it true or false
			int oneZero = (int) Math.random() * 2;
			
			if (oneZero == 0) {
				// false
				cards.remove(idx);
				
				// find random description
				int idx2 = (int) Math.random() * cards.size();
				desc = cards.get(idx2).getDescription();
				ans = "false";
				
				// create and add question
				TFQuestion q = new TFQuestion(title, desc, ans);
				addQuestion(q);
			}
			else {
				// true
				desc = cards.get(idx).getDescription();
				ans = "true";
				
				// create and add question
				TFQuestion q = new TFQuestion(title, desc, ans);
				addQuestion(q);
			}
		}
	}
	
	public TFQuestion getNext() {
		if (questions.size() >= 1) {
			return questions.remove();
		}
		else {
			return null;
		}
	}
	
	public void addQuestion(TFQuestion q) {
		questions.add(q);
	}
}
