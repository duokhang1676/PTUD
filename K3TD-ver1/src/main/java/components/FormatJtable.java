package components;

import java.awt.Component;
import java.awt.Font;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class FormatJtable {
	
	public static void setCellEditable(JTable tb) {
		for (int i = 0; i < tb.getColumnCount(); i++) {
			tb.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()) {
				@Override
				public boolean isCellEditable(EventObject e) {
					// Trả về false để ngăn chặn chỉnh sửa trực tiếp
					return false;
				}
			});
		}
	}
	
	public static void setFontJtable(JTable tb) {
		JTableHeader tableHeader = tb.getTableHeader();
    	tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Thiết lập font cho mỗi ô
                component.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // Thay đổi font theo yêu cầu
                
                return component;
            }
        };
        
        // Áp dụng renderer cho từng cột trong JTable
        for (int i = 0; i < tb.getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
	}
	
	
}
