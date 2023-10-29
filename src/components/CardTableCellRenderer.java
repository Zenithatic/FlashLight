package components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class CardTableCellRenderer extends JTextArea implements TableCellRenderer{
	
	public CardTableCellRenderer() {
		setWrapStyleWord(true);
		setLineWrap(true);
		setPreferredSize(new Dimension(300, 40));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		this.setText((String) value);
		return this;
	}

}
