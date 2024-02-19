package my_classes;

public class Question {
	private String title;
	private String answer;
	
	public Question(String t, String a) {
		title = t;
		answer = a;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAnswer() {
		return answer;
	}
}

