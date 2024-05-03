package model;

import java.awt.Point;
import java.util.ArrayList;

public class Path {

	private ArrayList<Point> pattern;
	private int length;
	private int cost;
	public Path(ArrayList<Point> pattern, int length, int cost) {
		this.pattern = pattern;
		this.length = length;
		this.cost = cost;
	}
	public ArrayList<Point> getPattern() {
		return pattern;
	}
	public void setPattern(ArrayList<Point> pattern) {
		this.pattern = pattern;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
