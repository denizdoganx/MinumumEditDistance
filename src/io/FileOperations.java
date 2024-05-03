package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import util.R;

public class FileOperations {

	private static FileOperations instance = null;
	private File file;
	private FileOperations() {
		this.file = new File(R.fileName);
	}
	
	public static FileOperations getInstance() {
		if(instance == null) {
			instance = new FileOperations();
		}
		return instance;
	}
	
	public boolean isFileNameRight() {
		return this.file.exists();
	}
	
	public ArrayList<String> getAllLinesFromGivenFile() {
		ArrayList<String> lines = null;
		try {
			FileReader fr = new FileReader(file, Charset.forName("ISO-8859-9"));
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			lines = new ArrayList<>();
			while((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
