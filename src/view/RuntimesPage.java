package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.R;

@SuppressWarnings("serial")
public class RuntimesPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RuntimesPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 1, 5, 5));
		contentPane.setBackground(new Color(50, 40, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		TableCell listingLabel = new TableCell();
		listingLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(listingLabel);
		TableCell findingLabel = new TableCell();
		findingLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(findingLabel);
		
		if(R.listingRuntime != - 1) {
			listingLabel.setText("Runtime for listing nearest 5 items: " + R.listingRuntime / 1000000000.0 + "s.");
		}
		else {
			listingLabel.setText("Runtime for listing nearest 5 items: not run yet");
		}
		
		if(R.findingRuntime != - 1) {
			findingLabel.setText("Runtime for finding the MED value for given 2 words: " + R.findingRuntime / 1000000000.0  + "s.");
		}
		else {
			findingLabel.setText("Runtime for finding the MED value for given 2 words: not run yet");
		}
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
