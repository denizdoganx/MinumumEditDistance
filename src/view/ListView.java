package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dal.MedDal;
import model.MedObject;
import util.CenteredTableCellRenderer;

@SuppressWarnings("serial")
public class ListView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	private JTable table;

	DefaultTableModel model;
	
	private CenteredTableCellRenderer cellModel;
	
	private MedDal medDal;
	
	public ListView(String word, int n) {
		this.medDal = MedDal.getInstance();
		cellModel = new CenteredTableCellRenderer();
		
		
		setBorder(new EmptyBorder(25, 35, 35, 35));
		setBackground(new Color(245, 230, 200));
		setLayout(new GridLayout(1, 1, 5, 5));
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(57);
		table.setFont(new Font("Tahoma", Font.BOLD, 24));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Word", "MED Value"
			}
		));
		
		model = (DefaultTableModel) table.getModel();
		
		scrollPane.setViewportView(table);
		
		initTable(word, n);
	}

	private void initTable(String word, int n) {
	
		MedObject[] candidates = medDal.executeForNItemWithGivenWord(word, n);
		for(int i = 0;i < table.getColumnModel().getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(cellModel);
		}
		
		for(MedObject c : candidates) {
			Object[] row = { c.getWord(), c.getMed()};
			model.addRow(row);
		}
	}
	
}
