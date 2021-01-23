package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JTextField;

//@SuppressWarnings("serial")
/*class BottomPane extends JPanel implements ActionListener {
	JTextField edits[];
	int columnCount;

	void init(int columnCount) {
		this.columnCount = columnCount;
		edits = new JTextField[columnCount];
		setLayout(new FlowLayout());
		for (int i = 0; i < columnCount; i++) {
			edits[i] = new JTextField("", 10);
			add(edits[i]);
		}
		JButton editBtn = new JButton("장바구니 추가");
		editBtn.setActionCommand("추가");
		editBtn.addActionListener(this);
		add(editBtn);

		/*setLayout(new FlowLayout());
		JButton buttons[] = new JButton[2];
		String btnTexts[] = { "추가", "삭제" };
		for (int i = 0; i < 2; i++) {
			buttons[i] = new JButton(btnTexts[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}

	void clearEdits() {
		for (JTextField edit : edits)
			edit.setText("");
	}
	// 편집창의 내용을 배열에 넣어 돌려줌. 항목의 추가나 수정시 사용할 데이터
	String[] getEditTexts() {
		String[] editTexts = new String[columnCount+1];
		editTexts[0] = edits[0].getText();
		editTexts[1] = edits[1].getText();
		editTexts[2] = edits[3].getText();
		int n = Integer.parseInt(editTexts[1]);
		n = n*Integer.parseInt(editTexts[2]);
		editTexts[3] = n+"";
		/*for (int i = 0; i < columnCount; i++)
			editTexts[i] = edits[i].getText();
		return editTexts;
	}
	// 현재 선택된 행의 데이터를 편집창에 하나씩 넣어줌
    void moveSelectedToEdits(String[] rowTexts) {
    	for (int i = 0; i < rowTexts.length; i++) {
    		edits[i].setText(rowTexts[i]);
    	}
	}*/
	/*public void actionPerformed(ActionEvent e) {
		String[] editTexts = getEditTexts();
		clearEdits();
		TableController tableController = MainStore.basketTable.tableController;
		switch (e.getActionCommand()) {
		case "추가":
			tableController.addRow(editTexts);
			break;
		/*case "Done":
    		tableController.updateRow(editTexts);
    		break;
		case "삭제":
    		tableController.removeRow();
    		break;*/
    /*	default: break;
		}
		tableController.table.clearSelection();
	}*/

