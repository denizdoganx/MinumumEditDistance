package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class MedMatrixObject {

	int medValue;
	
	String[][] medMatrix;
	
	Path path;
	
	ArrayList<String> operations;

	
	public MedMatrixObject(int medValue, String[][] medMatrix, Path path) {
		this.medValue = medValue;
		this.medMatrix = medMatrix;
		this.path = path;
		this.operations = new ArrayList<>();
		generateOperations();
	}

	public int getMedValue() {
		return medValue;
	}

	public void setMedValue(int medValue) {
		this.medValue = medValue;
	}

	public String[][] getMedMatrix() {
		return medMatrix;
	}

	public void setMedMatrix(String[][] medMatrix) {
		this.medMatrix = medMatrix;
	}

	public Path getPath() {
		return path;
	}

	public void setAllPaths(Path path) {
		this.path = path;
	}

	public ArrayList<String> getOperations() {
		return operations;
	}

	private void generateOperations() {
		ArrayList<Point> points = this.path.getPattern();
		Collections.reverse(points);
		Point current, next;
		for(int i = 0;i < points.size() - 1; i++) {
			
			current = points.get(i);
			next = points.get(i + 1);
			
			if(!medMatrix[current.x][current.y].equals(medMatrix[next.x][next.y])) {
				if(current.x != next.x && current.y != next.y) {
					operations.add("Substitution " + medMatrix[next.x][0].toUpperCase() + " with " + medMatrix[0][next.y].toUpperCase());
				}
				else if(current.x != next.x) {
					operations.add("Deletion " + medMatrix[next.x][0].toUpperCase());
				}
				else {
					operations.add("Insertion " + medMatrix[0][next.y].toUpperCase());
				}
			}			
		}

	}
}
