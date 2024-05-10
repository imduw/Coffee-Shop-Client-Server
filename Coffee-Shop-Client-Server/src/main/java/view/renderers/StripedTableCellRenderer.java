package view.renderers;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

 public class StripedTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set background color for odd rows
        if (row % 2 == 1) {
            c.setBackground(new Color(35,38,39)); 
        } else {
            c.setBackground(new Color(20,23,24)); 
        }
		return c;
	}
	

}
