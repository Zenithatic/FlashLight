package components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class CardTableCellRenderer extends JTextArea implements TableCellRenderer{
	
	public CardTableCellRenderer() {
		setWrapStyleWord(true);
		setLineWrap(true);
		setPreferredSize(new Dimension(300, 50));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		this.setText((String) value);
		
		if (isSelected) {
			setBackground(UIManager.getColor("Table.selectionBackground"));
		} else {
			setBackground(UIManager.getColor("Table.background"));
		}
		 
		return this;
	}
}
