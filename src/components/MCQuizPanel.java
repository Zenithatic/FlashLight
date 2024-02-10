package components;


import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import listeners.BackAdapter;
import listeners.QuizAdapter;
import main_pkg.Main;
import my_classes.MCQuestion;
import my_classes.MCQuiz;

@SuppressWarnings("serial")
public class MCQuizPanel extends JPanel{
	private MCQuiz curQuiz;
	private MCQuestion curQuestion;
	private JLabel quizTitle;
	private JTextArea titleArea;
	private JTextArea optionArea;
	
	public MCQuizPanel() {
		// setup MC quiz panel
		this.setSize(Main.defaultDimension);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Main.color1);
		
		// setup title
		quizTitle = new JLabel("", SwingConstants.CENTER);
		quizTitle.setMaximumSize(new Dimension(400, 100));
		quizTitle.setAlignmentX(0.5f);
		quizTitle.setVerticalTextPosition(SwingConstants.CENTER);
		quizTitle.setFont(Main.titleFont);
		
		// setup top bar panel
		JPanel topBar = new JPanel();
		topBar.setAlignmentX(0.5f);
		topBar.setBackground(Main.color1);
		topBar.setMaximumSize(new Dimension(1000, 100));
		topBar.setLayout(new BoxLayout(topBar, BoxLayout.LINE_AXIS));
		
		// setup back button
		JButton back = new JButton("Back");
		back.setName("mcQuizBack");
		back.addMouseListener(new BackAdapter());
		back.setMaximumSize(new Dimension(500, 100));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setAlignmentX(0.5f);
		back.setAlignmentY(0.5f);
		
		// setup next question button
		JButton nextQ = new JButton("Next Question");
		nextQ.setName("mcNextQuestion");
		nextQ.addMouseListener(new QuizAdapter());
		nextQ.setMaximumSize(new Dimension(500, 100));
		nextQ.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextQ.setAlignmentX(0.5f);
		nextQ.setAlignmentY(0.5f);
		
		// add above buttons to topbar panel
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(back);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		topBar.add(nextQ);
		topBar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup 2nd title
		JLabel quizTitle2 = new JLabel("Which of these options matches the title?", SwingConstants.CENTER);
		quizTitle2.setMaximumSize(new Dimension(1000, 100));
		quizTitle2.setAlignmentX(0.5f);
		quizTitle2.setVerticalTextPosition(SwingConstants.CENTER);
		quizTitle2.setFont(Main.defaultFont);
		
		// setup text area for title
		titleArea = new JTextArea();
		titleArea.setWrapStyleWord(true);
		titleArea.setLineWrap(true);
		titleArea.setMaximumSize(new Dimension(1000, 100));
		titleArea.setEditable(false);
		titleArea.setBackground(Main.color2);
		
		JPanel titleView = new JPanel();
		titleView.setAlignmentX(0.5f);
		titleView.setBackground(Main.color1);
		titleView.setMaximumSize(new Dimension(1000, 100));
		titleView.setLayout(new BoxLayout(titleView, BoxLayout.LINE_AXIS));
		
		titleView.add(Box.createRigidArea(new Dimension(30, 0)));
		titleView.add(titleArea);
		titleView.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup text area for options
		optionArea = new JTextArea();
		optionArea.setWrapStyleWord(true);
		optionArea.setLineWrap(true);
		optionArea.setMaximumSize(new Dimension(1000, 600));
		optionArea.setEditable(false);
		optionArea.setBackground(Main.color2);
		
		JPanel optionView = new JPanel();
		optionView.setAlignmentX(0.5f);
		optionView.setBackground(Main.color1);
		optionView.setMaximumSize(new Dimension(1000, 1000));
		optionView.setLayout(new BoxLayout(optionView, BoxLayout.LINE_AXIS));
		
		optionView.add(Box.createRigidArea(new Dimension(30, 0)));
		optionView.add(optionArea);
		optionView.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup bottom bar panel
		JPanel botBar = new JPanel();
		botBar.setAlignmentX(0.5f);
		botBar.setBackground(Main.color1);
		botBar.setMaximumSize(new Dimension(1000, 40));
		botBar.setLayout(new BoxLayout(botBar, BoxLayout.LINE_AXIS));
		
		// create reveal answer button
		JButton reveal = new JButton("Reveal Answer");
		reveal.setName("revealAnsMC");
		reveal.addMouseListener(new QuizAdapter());
		reveal.setMaximumSize(new Dimension(1000, 40));
		reveal.setCursor(new Cursor(Cursor.HAND_CURSOR));
		reveal.setAlignmentX(0.5f);
		reveal.setAlignmentY(0.5f);
		
		botBar.add(Box.createRigidArea(new Dimension(30, 0)));
		botBar.add(reveal);
		botBar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// add components to panel
		this.add(quizTitle);
		this.add(topBar);
		this.add(quizTitle2);
		this.add(titleView);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(optionView);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(botBar);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
	}
	
	public void setQuiz(MCQuiz quiz) {
		curQuiz = quiz;
		quizTitle.setText("MC Quiz for folder: " + curQuiz.getFolder().getName());
		
		// setup first question
		curQuestion = quiz.getNext();
		
		titleArea.setText("Title: " + curQuestion.getTitle());
		
		ArrayList<String> options = curQuestion.getOptions();
		optionArea.setText(
			"a) " + options.get(0) + "\n\n" + 
			"b) " + options.get(1) + "\n\n" + 
			"c) " + options.get(2) + "\n\n" + 
			"d) " + options.get(3) + "\n\n"
		);
	}
	
	public void nextQuestion() {
		curQuestion = curQuiz.getNext();
		
		if (curQuestion == null) {
			// go back to select quiz panel
			Main.getMainFrame().changePanel(Main.getMainFrame().getSelectQuizPanel());
			return;
		}
		
		titleArea.setText("Title: " + curQuestion.getTitle());
		
		ArrayList<String> options = curQuestion.getOptions();
		optionArea.setText(
			"a) " + options.get(0) + "\n\n" + 
			"b) " + options.get(1) + "\n\n" + 
			"c) " + options.get(2) + "\n\n" + 
			"d) " + options.get(3) + "\n\n"
		);
	}
	
	public void revealAns() {
		JOptionPane.showMessageDialog(this, "Answer: " + curQuestion.getAnswer(), "Answer", JOptionPane.INFORMATION_MESSAGE);
	}
}


