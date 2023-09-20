package main;
import javax.swing.*;


public class Main extends JFrame{
	private static final long serialVersionUID = 1554119310077614846L;

	public static void main(String[] args) {
		Main mainFrame = new Main();
		mainFrame.setVisible(true);
	}
	
	public Main() {
		this.setSize(800, 600);
		this.setTitle("FlashLight");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
