package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.border.EmptyBorder;


import dal.MedDal;
import model.MedMatrixObject;
import model.Path;


@SuppressWarnings("serial")
public class FindingView extends JPanel {

	/**
	 * Create the panel.
	 */
	private MedDal medDal;
	private JScrollPane scrollPane;
	private JPanel holder;
	private TableCell[][] allCellInTheScreen;
	private MedMatrixObject m;
	
	public FindingView(String source, String target) {
		
		allCellInTheScreen = new TableCell[source.length() + 2][target.length() + 2];
		
		this.medDal = MedDal.getInstance();
		setBorder(new EmptyBorder(25, 35, 10, 35));
		setBackground(new Color(245, 230, 200));
		setLayout(new GridLayout(1, 1, 5, 5));
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(245, 230, 200));
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(scrollPane);
		
		holder = new JPanel();
		holder.setBackground(new Color(245, 230, 200));
		holder.setLayout(new GridLayout(source.length() + 2, target.length() + 2, 5, 5));
		scrollPane.setViewportView(holder);
		
		initScreen(source, target);
	}

	private void initScreen(String source, String target) {
		this.m = medDal.executeForMedTable(source, target);
		String[][] matrix = m.getMedMatrix();
		Path path = m.getPath();
		
		for(int i = 0;i < matrix.length; i++) {
			for(int j = 0;j < matrix[0].length; j++) {
				TableCell tableCell = new TableCell(matrix[i][j]);
				allCellInTheScreen[i][j] = tableCell;
				holder.add(tableCell);
			}
		}
		
		paintPath(path);
	}
	
	public ArrayList<String> getOperations(){
		return this.m.getOperations();
	}
	
	private void paintPath(Path pathToBePaint) {
		
		for(Point point : pathToBePaint.getPattern()) {
			allCellInTheScreen[point.x][point.y].setForeground(new Color(227, 101, 29));
		}
	}
}
