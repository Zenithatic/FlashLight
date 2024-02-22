package main_pkg;
import java.awt.*;
import java.util.Locale;

import components.MainFrame;

public class Main{
	// set static fields
	private static MainFrame mainFrame;
	
	// set static final fields
	public final static Dimension defaultDimension = new Dimension(800, 600);
	public final static Font defaultFont = new Font("Microsoft Yahei", Font.PLAIN, 24);
	public final static Font titleFont = new Font("Microsoft Yahei", Font.PLAIN, 32);
	public final static Color color1 = new Color(255, 255, 204);
	public final static Color color2 = new Color(238, 238, 123);
	
	// main method
	public static void main(String[] args) {
		mainFrame = new MainFrame();
		Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
		mainFrame.setVisible(true);
	}
	
	// getter method for mainFrame
	public static MainFrame getMainFrame() {
		return mainFrame;
	}
}
