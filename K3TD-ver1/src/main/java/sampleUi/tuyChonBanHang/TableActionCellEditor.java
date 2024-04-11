package sampleUi.tuyChonBanHang;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor{
	TableActionEvent event;
	public TableActionCellEditor(TableActionEvent event) {
		super(new JCheckBox());
		this.event = event;

	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		PanelTuyChon action = new PanelTuyChon();
		action.initEvent(event, row);
		action.setBackground(table.getSelectionBackground());
		return action;
	}
}
