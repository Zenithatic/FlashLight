package main_pkg;
import java.awt.*;

import components.MainFrame;

public class Main{
	// set static fields
	private static MainFrame mainFrame;
	
	// set static final fields
	private final static Dimension defaultDimension = new Dimension(800, 600);
	private final static Font defaultFont = new Font("Arial", Font.PLAIN, 24);
	private final static Font titleFont = new Font("Arial", Font.PLAIN, 32);
	private final static Color color1 = new Color(255, 255, 204);
	
	// main method
	public static void main(String[] args) {
		mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
	
	// getter method for mainFrame
	public static MainFrame getMainFrame() {
		return mainFrame;
	}
	
	// getter method for defaultDimension
	public static Dimension getDefaultDimension() {
		return defaultDimension;
	}
	
	// getter method for defaultFont
	public static Font getDefaultFont() {
		return defaultFont;
	}
	
	// getter method for titleFont
	public static Font getTitlefont() {
		return titleFont;
	}
	
	// getter methods for colors
	public static Color getColor1() {
		return color1;
	}
}
