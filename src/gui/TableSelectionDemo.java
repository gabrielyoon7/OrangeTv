package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import facade.DataEngineInterface;
import facade.UIData;

public class TableSelectionDemo extends JPanel {
    private static final long serialVersionUID = 1L;
    DefaultTableModel tableModel;
    TableController tableController;
    JTable table;
    int selectedIndex = -1;
    DataEngineInterface dataMgr;
    public TableSelectionDemo() {
    	super(new BorderLayout());
    }
    void addComponentsToPane(DataEngineInterface mgr) {
    	tableController = new TableController();
     	tableController.init(mgr);
    	JScrollPane center = new JScrollPane(tableController.table); 
    	add(center, BorderLayout.CENTER);
    }
    @SuppressWarnings("serial")
    // 매니저에서 검색된 객체들을 테이블에 보여준다. kwd가 ""면 모두 출력
    void showDetail() {
    	if (selectedIndex < 0)
    		return;
        String[] rowTexts = new String[tableModel.getColumnCount()];
        for (int i = 0; i < rowTexts.length; i++)
        	rowTexts[i] = (String)tableModel.getValueAt(selectedIndex, i);
    	DetailDialog dlg = new DetailDialog(rowTexts);
    	dlg.setup();
    	dlg.pack();
    	dlg.setVisible(true);
    }
}