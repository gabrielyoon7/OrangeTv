package gui;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import facade.DataEngineInterface;
import facade.UIData;
import gui.SideMenuLeftPane.MyActionListener;
import main.Main;
import media.Media;

public class TableController implements ListSelectionListener {
    DefaultTableModel tableModel;
    JTable table;
    int selectedIndex = -1;
    int subtotal = 0; // �Ұ谪 = ����� * ����
    DataEngineInterface dataMgr;
    @SuppressWarnings("serial")
	void init(DataEngineInterface mgr) {
    	dataMgr = mgr;
    	tableModel = new DefaultTableModel(mgr.getColumnNames(), 0){  //�� ���� ���ϰ� �ϴ� �κ�
    		 public boolean isCellEditable(int row, int column){
    			    return false;
    		 }
    	};
    	loadData("");
    	
    	table = new JTable(tableModel);
        ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(this);
        table.setPreferredScrollableViewportSize(new Dimension(500, 220));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        tableClick();
    }
    void tableClick() {
    	table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// ������ �ִ� ���̺� Ŭ���� �ش� ���� mediainfo�� �̵�
				if(table.getColumnCount()>=7) {
					int row = table.getSelectedRow();
					Media media = null;
					media = Main.mediaMgr.find((String) table.getModel().getValueAt(row,0));
					MainMenu.mainRank.setVisible(false);
					MainMenu.mainSearch.setVisible(false);
					MainMenu.mainMedia.clickEvent(e, media);
				}			 
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    }
    // �Ŵ������� �˻��� ��ü���� ���̺� �����ش�. kwd�� ""�� ��� ���
    void loadData(String kwd) {
    	List<?> result = dataMgr.search(kwd);
    	tableModel.setRowCount(0);
    	for (Object m : result)
    		tableModel.addRow(((UIData)m).getUiTexts());
    }
    void addRow(String[] editTexts) {  // �� �߰�, ���ο� ��ü �����ؼ� �������� �߰�
		try {
			dataMgr.addNewItem(editTexts);
		} catch (Exception ex) {  // �߰� �� ���� �߻�
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "�߰� ������ ����");
			return;
		}
		tableModel.addRow(editTexts);
    }
    // ���� ���õ� ���� SongMgr���� �����ϰ� ���̺��� ����
    void removeRow() {
    	if (selectedIndex < 0) return;
    	String key = (String)tableModel.getValueAt(selectedIndex, 0);
    	dataMgr.remove(key);
    	tableModel.removeRow(selectedIndex);
    }
    // ���� ���õ� ���� ����â�� �������� ����
    void updateRow(String[] editTexts) {
    	if (selectedIndex < 0) return;
		try {
			dataMgr.update(editTexts);
    	} catch (Exception ex) {  // SongMgr���� ���� �� ���� �߻�
			ex.printStackTrace();  
			JOptionPane.showMessageDialog(null, "���� �� ������ ����");
    		return;
    	}
    	for (int i = 0; i < editTexts.length; i++) {
    		tableModel.setValueAt(editTexts[i], selectedIndex, i);
    	}
    }
    // ���õ� ���� ����Ǹ� �� ������ ����â���� ����
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (!lsm.isSelectionEmpty()) {
        	selectedIndex = lsm.getMinSelectionIndex();
        	String[] rowTexts = new String[tableModel.getColumnCount()];
        	for (int i = 0; i < rowTexts.length; i++)
        		rowTexts[i] = (String)tableModel.getValueAt(selectedIndex, i);
        	//if(dataMgr instanceof store.GoodsManager)
        		//MainStore.bottom.moveSelectedToEdits(rowTexts);
        }
    }
    
    //subtotal �����ϴ� �޼ҵ�
    public int getSubtotal() {
    	// ���õ� ���� �Ұ谪(���� ���� * ����)�� ����	
    	int row = table.getSelectedRow();
		subtotal = Integer.parseInt((String) table.getModel().getValueAt(row, 3));
    	return subtotal;
    }
}
