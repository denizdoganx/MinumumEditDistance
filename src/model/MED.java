package model;

import java.awt.Point;
import java.util.ArrayList;


public class MED implements IMinumumEditDistance {

	private String source;
	
	private String target;
	
	private String[][] medMatrix;
	
	private int rowCount;
	
	private int columnCount;
	
	public MED(String source, String target) {
		this.source = source;
		this.target = target;
		this.rowCount = source.length() + 2;
		this.columnCount = target.length() + 2;
		this.medMatrix = new String[rowCount][columnCount];
		fillInTheMedMatrix();
	}
	

	
	@Override
	public int getMinumumEditDistance() {
		return Integer.valueOf(medMatrix[rowCount-1][columnCount-1]);
	}
	
	@Override
	public String[][] getMedMatrix() {
		return this.medMatrix;
	}

	@Override
	public Path getPath() {
		int insert = -1, delete = -1, replace = -1;
		ArrayList<Point> pathPoints = new ArrayList<>();
		int rowIndex = source.length() + 1, columnIndex = target.length() + 1;
		int cost = 0;
		pathPoints.add(new Point(rowIndex, columnIndex));
		cost += Integer.valueOf(medMatrix[rowIndex][columnIndex]);
		while(rowIndex != 1 && columnIndex != 1) {
			insert = Integer.valueOf(medMatrix[rowIndex][columnIndex-1]);
			delete = Integer.valueOf(medMatrix[rowIndex-1][columnIndex]);
			replace = Integer.valueOf(medMatrix[rowIndex-1][columnIndex-1]);
			String direction = whichOneIsSmaller(insert, delete, replace);
			if(direction.equals("insert")) {
				columnIndex--;
			}
			else if(direction.equals("delete")) {
				rowIndex--;
			}
			else {
				rowIndex--;
				columnIndex--;
			}
			cost += Integer.valueOf(medMatrix[rowIndex][columnIndex]);			
			pathPoints.add(new Point(rowIndex, columnIndex));
		}
		
		while(columnIndex != 1) {
			columnIndex--;
			cost += Integer.valueOf(medMatrix[rowIndex][columnIndex]);			
			pathPoints.add(new Point(rowIndex, columnIndex));
		}
		while(rowIndex != 1) {
			rowIndex--;
			cost += Integer.valueOf(medMatrix[rowIndex][columnIndex]);			
			pathPoints.add(new Point(rowIndex, columnIndex));
		}
		return new Path(pathPoints, pathPoints.size(), cost);
	}
	
	private String whichOneIsSmaller(int insert, int delete, int replace) {
		
		int minValue = min(insert, delete, replace);
		if(minValue == replace) {
			return "replace";
		}
		else if(minValue == delete) {
			return "delete";
		}
		else {
			return "insert";
		}
	}

	private int min(int a, int b, int c) {
		
		int min_ = a;
		
		int[] arr = {a, b, c};
		
		for(Integer num : arr) {
			if(min_ > num) {
				min_ = num;
			}
		}
		return min_;
	}
	
	private void fillInTheMedMatrix() {
		for(int i = 0;i < rowCount; i++) {
			for(int j = 0;j < columnCount; j++) {
				if(i == 0 && j == 0) {
					medMatrix[i][j] = "";
				}
				else if(i == 0 && j == 1) {
					medMatrix[i][j] = "#";
				}
				else if(i == 0) {
					medMatrix[i][j] = String.valueOf(target.charAt(j-2));
				}
				else if(i == 1 && j == 0) {
					medMatrix[i][j] = "#";
				}
				else if(j == 0) {
					medMatrix[i][j] = String.valueOf(source.charAt(i-2));
				}
				else {
					if(i == 1 && j == 1) {
						medMatrix[i][j] = "0";
					}
					else if (i == 1 || j == 1) {
						if(i == 1) {
							medMatrix[i][j] = String.valueOf(Integer.valueOf(medMatrix[i][j-1]) + 1);
						}
						if(j == 1) {
							medMatrix[i][j] = String.valueOf(Integer.valueOf(medMatrix[i-1][j]) + 1);
						}
					}
					else {
						if(medMatrix[i][0].equals(medMatrix[0][j])) {
							medMatrix[i][j] = medMatrix[i-1][j-1];
						}
						else {	
							int ins = Integer.valueOf(medMatrix[i][j-1]) + 1;
							int del = Integer.valueOf(medMatrix[i-1][j]) + 1;
							int rep = Integer.valueOf(medMatrix[i-1][j-1]) + 1;
							medMatrix[i][j] = String.valueOf(min(ins, del, rep));
						}
					}
				}
			}
		}
	}

}
