package org.demo.app.domain;

public class Shape {

	private int id ;
//	private String color ;
	private Color color ;
	
//	public Shape(int id, String color) {
	public Shape(int id, Color color) {
		super();
		this.id = id;
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	public String getColor() {
	public Color getColor() {
		return color;
	}
//	public void setColor(String color) {
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Shape [id=" + id + ", color=" + color + "]";
	}
	
	
}
