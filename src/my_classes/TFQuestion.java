package my_classes;

public class TFQuestion extends Question{
	private String description;
	
	public TFQuestion(String title, String desc, String answer) {
		super(title, answer);
		this.description = desc;
	}
	
	public String getDescription() {
		return description;
	}
}
