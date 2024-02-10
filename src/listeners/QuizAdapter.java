package listeners;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import components.SelectQuizPanel;
import main_pkg.Main;
import my_classes.MCQuestion;
import my_classes.MCQuiz;
import my_classes.TFQuestion;
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
			MCQuestion curQ = quiz.getNext();
			
			while (curQ != null) {
				System.out.println("Title: " + curQ.getTitle() + ", options:");
				for (int i = 0; i < curQ.getOptions().size(); i++) {
					System.out.println(curQ.getOptions().get(i));
				}
				System.out.print("Answer: " + curQ.getAnswer());
				System.out.println("\n");
				
				curQ = quiz.getNext();
			}
			
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
			TFQuestion curQ = quiz.getNext();
			
			while (curQ != null) {
				System.out.println("Title: " + curQ.getTitle());
				System.out.println("Desc: " + curQ.getDescription());
				System.out.println("Answer: " + curQ.getAnswer());
				System.out.println("\n");
				
				curQ = quiz.getNext();
			}
			
		}
	}
}
