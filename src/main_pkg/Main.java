package main_pkg;
import java.awt.*;

import components.MainFrame;
import utils.Utils;

public class Main{
	// set static fields
	private static MainFrame mainFrame;
	
	// set static final fields
	public final static Dimension defaultDimension = new Dimension(800, 600);
	public final static Font defaultFont = new Font("Arial", Font.PLAIN, 24);
	public final static Font titleFont = new Font("Arial", Font.PLAIN, 32);
	public final static Color color1 = new Color(255, 255, 204);
	public final static Color color2 = new Color(255, 255, 179);
	
	// main method
	public static void main(String[] args) {
		mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
	
	// getter method for mainFrame
	public static MainFrame getMainFrame() {
		return mainFrame;
	}
}
