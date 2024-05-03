package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.R;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StartPage extends JFrame {

	private JPanel contentPane;
	private JPanel navbar;
	private JPanel sidebar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JPanel matrix_pane;
	private JPanel exitbar;
	protected JPanel footer;
	private JButton btnNewButton_4;

	/**
	 * Create the frame.
	 */
	public StartPage() {
		setTitle("NLP Assignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1000);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(245, 230, 200));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sidebar = new JPanel();
		sidebar.setBackground(new Color(245, 230, 200));
		sidebar.setBounds(10, 11, 270, 686);
		contentPane.add(sidebar);
		sidebar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NLP Assignment 2");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 250, 120);
		sidebar.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("List nearest 5 words");
		btnNewButton.setBackground(new Color(50, 40, 50));
		btnNewButton.setForeground(new Color(200, 220, 230));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StartPage.this.navbar.removeAll();
				StartPage.this.navbar.revalidate();
				StartPage.this.fillInTheNavbarForList();
				StartPage.this.navbar.repaint();
				
				StartPage.this.matrix_pane.removeAll();
				StartPage.this.matrix_pane.revalidate();
				StartPage.this.matrix_pane.repaint();
				
				StartPage.this.footer.removeAll();
				StartPage.this.footer.revalidate();
				StartPage.this.footer.repaint();
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 142, 250, 70);
		sidebar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Find the MED value for given 2 words");
		btnNewButton_1.setBackground(new Color(50, 40, 50));
		btnNewButton_1.setForeground(new Color(200, 220, 230));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage.this.navbar.removeAll();
				StartPage.this.navbar.revalidate();
				StartPage.this.fillInTheNavbarForFinding();
				StartPage.this.navbar.repaint();
				
				StartPage.this.matrix_pane.removeAll();
				StartPage.this.matrix_pane.revalidate();
				StartPage.this.matrix_pane.repaint();
				
				StartPage.this.footer.removeAll();
				StartPage.this.footer.revalidate();
				StartPage.this.footer.repaint();
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 223, 250, 70);
		sidebar.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Show Last Runtimes");
		btnNewButton_3.setBackground(new Color(50, 40, 50));
		btnNewButton_3.setForeground(new Color(200, 220, 230));
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RuntimesPage();
			}
		});
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(10, 304, 250, 70);
		sidebar.add(btnNewButton_3);
		
		navbar = new JPanel();
		navbar.setBackground(new Color(245, 230, 200));
		navbar.setBounds(290, 11, 884, 75);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		matrix_pane = new JPanel();
		matrix_pane.setBackground(new Color(245, 230, 200));
		matrix_pane.setLayout(new GridLayout(1, 1, 0, 0));
		matrix_pane.setBounds(290, 97, 884, 600);
		contentPane.add(matrix_pane);
		
		footer = new JPanel();
		footer.setBackground(new Color(245, 230, 200));
		footer.setLayout(new GridLayout(1, 1, 0, 0));
		footer.setBounds(290, 708, 884, 242);
		contentPane.add(footer);
		
		exitbar = new JPanel();
		exitbar.setBackground(new Color(245, 230, 200));
		exitbar.setBounds(10, 708, 270, 242);
		contentPane.add(exitbar);
		exitbar.setLayout(null);
		
		btnNewButton_4 = new JButton("EXIT");
		btnNewButton_4.setBackground(new Color(50, 40, 50));
		btnNewButton_4.setForeground(new Color(200, 220, 230));
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StartPage.this.dispose();
			}
		});
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(10, 160, 250, 70);
		exitbar.add(btnNewButton_4);
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void fillInTheNavbarForList() {
		JLabel lblNewLabel_1 = new JLabel("Word :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(65, 8, 67, 56);
		navbar.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(142, 10, 239, 53);
		navbar.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Search for n items :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(391, 10, 183, 53);
		navbar.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setText("5");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(584, 8, 60, 56);
		navbar.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBackground(new Color(50, 40, 50));
		btnNewButton_2.setForeground(new Color(200, 220, 230));
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String word = textField.getText().toLowerCase();
				String n = textField_1.getText();
				
				StartPage.this.matrix_pane.removeAll();
				StartPage.this.matrix_pane.revalidate();
				long startTime = System.nanoTime();
				StartPage.this.matrix_pane.add(new ListView(word, Integer.valueOf(n)));
				long endTime =  System.nanoTime();
				
				R.listingRuntime = endTime - startTime;
				
				StartPage.this.matrix_pane.repaint();
				

			}
		});
		
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(654, 8, 119, 56);
		navbar.add(btnNewButton_2);
	}
	
	private void fillInTheNavbarForFinding() {
		JLabel lblNewLabel_3 = new JLabel("Source :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(121, 11, 82, 53);
		navbar.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setBounds(204, 11, 156, 53);
		navbar.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Target :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(378, 11, 76, 53);
		navbar.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(453, 11, 156, 53);
		navbar.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBackground(new Color(50, 40, 50));
		btnNewButton_2.setForeground(new Color(200, 220, 230));
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String source = textField_2.getText().toLowerCase();
				String target = textField_3.getText().toLowerCase();
				
				StartPage.this.matrix_pane.removeAll();
				StartPage.this.matrix_pane.revalidate();
				
				long startTime = System.nanoTime();
				FindingView findingView = new FindingView(source, target);
				long endTime = System.nanoTime();
				
				R.findingRuntime = endTime - startTime;
				
				StartPage.this.matrix_pane.add(findingView);
				StartPage.this.matrix_pane.repaint();
				
				
				StartPage.this.footer.removeAll();
				StartPage.this.footer.revalidate();
				StartPage.this.footer.add(new OperationsView(findingView.getOperations()));
				StartPage.this.footer.repaint();
				
			}
		});
		
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(619, 11, 120, 53);
		navbar.add(btnNewButton_2);
	}
}
