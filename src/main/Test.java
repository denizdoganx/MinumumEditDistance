package main;

import javax.swing.JOptionPane;

import io.FileOperations;
import util.R;
import view.StartPage;

public class Test {

	public static void main(String[] args) {
		
		FileOperations fileOperations = FileOperations.getInstance();
		if(fileOperations.isFileNameRight()) {
			R.lines = fileOperations.getAllLinesFromGivenFile();
			new StartPage();
		}
		else {
			JOptionPane.showMessageDialog(null, "FileName must be vocabulary_tr.txt and your file has to be in the project folder.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
