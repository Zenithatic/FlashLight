package my_classes;

public class Card {
	private String title;
	private String description;
	private long lastModified;
	
	public Card(String title, String description, long lastModified) {
		this.title = title;
		this.description = description;
		this.lastModified = lastModified;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public long getLastModified() {
		return lastModified;
	}
}
