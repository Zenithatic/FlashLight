package components;


import java.awt.Cursor;
import java.awt.Dimension;

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
import my_classes.TFQuestion;
import my_classes.TFQuiz;

@SuppressWarnings("serial")
public class TFQuizPanel extends JPanel{
	private TFQuiz curQuiz;
	private TFQuestion curQuestion;
	private JLabel quizTitle;
	private JTextArea titleArea;
	private JTextArea descArea;
	
	public TFQuizPanel() {
		// setup TF quiz panel
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
		back.setName("tfQuizBack");
		back.addMouseListener(new BackAdapter());
		back.setMaximumSize(new Dimension(500, 100));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setAlignmentX(0.5f);
		back.setAlignmentY(0.5f);
		
		// setup next question button
		JButton nextQ = new JButton("Next Question");
		nextQ.setName("tfNextQuestion");
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
		JLabel quizTitle2 = new JLabel("Is it true that the title matches the description below?", SwingConstants.CENTER);
		quizTitle2.setMaximumSize(new Dimension(1000, 100));
		quizTitle2.setAlignmentX(0.5f);
		quizTitle2.setVerticalTextPosition(SwingConstants.CENTER);
		quizTitle2.setFont(Main.defaultFont);
		
		// setup text area for title
		titleArea = new JTextArea();
		titleArea.setWrapStyleWord(true);
		titleArea.setLineWrap(true);
		titleArea.setMaximumSize(new Dimension(1000, 300));
		titleArea.setEditable(false);
		titleArea.setBackground(Main.color2);
		
		JPanel titleView = new JPanel();
		titleView.setAlignmentX(0.5f);
		titleView.setBackground(Main.color1);
		titleView.setMaximumSize(new Dimension(1000, 300));
		titleView.setLayout(new BoxLayout(titleView, BoxLayout.LINE_AXIS));

		titleView.add(Box.createRigidArea(new Dimension(30, 0)));
		titleView.add(titleArea);
		titleView.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup text area for desc
		descArea = new JTextArea();
		descArea.setWrapStyleWord(true);
		descArea.setLineWrap(true);
		descArea.setMaximumSize(new Dimension(1000, 300));
		descArea.setEditable(false);
		descArea.setBackground(Main.color2);
		
		JPanel descView = new JPanel();
		descView.setAlignmentX(0.5f);
		descView.setBackground(Main.color1);
		descView.setMaximumSize(new Dimension(1000, 300));
		descView.setLayout(new BoxLayout(descView, BoxLayout.LINE_AXIS));
		
		descView.add(Box.createRigidArea(new Dimension(30, 0)));
		descView.add(descArea);
		descView.add(Box.createRigidArea(new Dimension(30, 0)));
		
		// setup bottom bar panel
		JPanel botBar = new JPanel();
		botBar.setAlignmentX(0.5f);
		botBar.setBackground(Main.color1);
		botBar.setMaximumSize(new Dimension(1000, 40));
		botBar.setLayout(new BoxLayout(botBar, BoxLayout.LINE_AXIS));
		
		// create reveal answer button
		JButton reveal = new JButton("Reveal Answer");
		reveal.setName("revealAnsTF");
		reveal.addMouseListener(new QuizAdapter());
		reveal.setMaximumSize(new Dimension(1000, 50));
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
		this.add(descView);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(botBar);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
	}
	
	public void setQuiz(TFQuiz quiz) {
		curQuiz = quiz;
		quizTitle.setText("TF Quiz for folder: " + curQuiz.getFolder().getName());
		
		// setup first question
		curQuestion = quiz.getNext();
		
		titleArea.setText("Title: " + curQuestion.getTitle());
		descArea.setText("Description: " + curQuestion.getDescription());
	}
	
	public void nextQuestion() {
		curQuestion = curQuiz.getNext();
		
		if (curQuestion == null) {
			// go back to select quiz panel
			Main.getMainFrame().changePanel(Main.getMainFrame().getSelectQuizPanel());
			return;
		}
		
		titleArea.setText("Title: " + curQuestion.getTitle());
		descArea.setText("Description: " + curQuestion.getDescription());
	}
	
	public void revealAns() {
		JOptionPane.showMessageDialog(this, "Answer: " + curQuestion.getAnswer(), "Answer", JOptionPane.INFORMATION_MESSAGE);
	}
}


