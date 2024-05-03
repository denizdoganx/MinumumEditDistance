package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TableCell extends JLabel {
	
	private void init() {
		this.setOpaque(true);
		this.setBackground(new Color(255, 255, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setFont(new Font("Tahoma", Font.BOLD, 28));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public TableCell() {
		init();
	}
	
	public TableCell(String text) {

		this.setText(text);
		init();
	}
	
	public TableCell(String text, int fontsize) {

		this.setText(text);
		init();
		this.setFont(new Font("Tahoma", Font.BOLD, fontsize));
	}


}
