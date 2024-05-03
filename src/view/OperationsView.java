package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OperationsView extends JPanel {
	
	public OperationsView(ArrayList<String> operations) {
		setBorder(new EmptyBorder(25, 35, 10, 35));
		setBackground(new Color(245, 230, 200));
		setLayout(new GridLayout(1, 1, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(245, 230, 200));
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(scrollPane);
		
		JPanel holder = new JPanel();
		holder.setBackground(new Color(245, 230, 200));
		holder.setLayout(new GridLayout(0, 1, 4, 4));
		scrollPane.setViewportView(holder);
		
		for(String operation : operations) {
			holder.add(new TableCell(operation, 22));
		}
	}
}
