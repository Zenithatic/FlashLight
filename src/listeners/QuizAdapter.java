package listeners;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import components.MCQuizPanel;
import components.SelectQuizPanel;
import components.TFQuizPanel;
import main_pkg.Main;
import my_classes.MCQuiz;
import my_classes.TFQuiz;


public class QuizAdapter extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		SelectQuizPanel sqp = Main.getMainFrame().getSelectQuizPanel();
		String compName = e.getComponent().getName();
		
		if (compName.equals("quiz")) {
			// open select folder panel
			sqp.loadTable();
			Main.getMainFrame().changePanel(sqp);
		}
		else if (compName.equals("openMC")) {
			if (sqp.getSelected() == -1) {
				return;
			}
			
			sqp.getFolder(sqp.getSelected()).reloadCards();
			if (sqp.getFolder(sqp.getSelected()).getCards().size() <= 3) {
				// too small
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(sqp, "Need 4 cards to create quiz!", "Warning", JOptionPane.ERROR_MESSAGE);
				return;
			}
				
			MCQuiz quiz = new MCQuiz(sqp.getFolder(sqp.getSelected()));
			
			MCQuizPanel mcqp = Main.getMainFrame().getMcQuizPanel();
			mcqp.setQuiz(quiz);
			Main.getMainFrame().changePanel(Main.getMainFrame().getMcQuizPanel());

			
			
		}
		else if (compName.equals("openTF")) {
			if (sqp.getSelected() == -1) {
				return;
			}
			
			sqp.getFolder(sqp.getSelected()).reloadCards();
			if (sqp.getFolder(sqp.getSelected()).getCards().size() <= 3) {
				// too small
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(sqp, "Need 4 cards to create quiz!", "Warning", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			TFQuiz quiz = new TFQuiz(sqp.getFolder(sqp.getSelected()));
			
			TFQuizPanel tfqp = Main.getMainFrame().getTfQuizPanel();
			tfqp.setQuiz(quiz);
			Main.getMainFrame().changePanel(Main.getMainFrame().getTfQuizPanel());
			
		}
		else if (compName.equals("mcNextQuestion")) {
			Main.getMainFrame().getMcQuizPanel().nextQuestion();
		}
		else if (compName.equals("revealAnsMC")) {
			Main.getMainFrame().getMcQuizPanel().revealAns();
		}
		else if (compName.equals("tfNextQuestion")) {
			Main.getMainFrame().getTfQuizPanel().nextQuestion();
		}
		else if (compName.equals("revealAnsTF")) {
			Main.getMainFrame().getTfQuizPanel().revealAns();
		}
	}
}
