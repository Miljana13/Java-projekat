package elements.elements;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerR;
	Color color,colorF;

	public Donut() {

	}

	public Donut(Point center, int r, int innerR) {
		super(center, r);
		this.innerR = innerR;
	}

	public Donut(Point center, int r, int innerR, boolean selected) {
		this(center, r, innerR);
		this.selected = selected;
//		super(center, r, selected);
//		this.innerR = innerR;
	}

	
	public double area() {
		return super.area() - innerR * innerR * Math.PI;
	}

	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(x, y) >= innerR;
	}

	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	// Center:(xCenter,yCenter), radius = <radius>, inner radius = <radius>
	public String toString() {
		return super.toString()+", inner radius = "+innerR;
	}

	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}
	
	
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(color);
		if(fill)
		{
			g.setColor(Color.white);
			g.fillOval(center.getX()-innerR, center.getY()-innerR, 2*innerR, 2*innerR);
		}
	
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(this.getCenter().getX() - innerR - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() + innerR - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - innerR - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() + innerR - 2, 4, 4);
		}
	}

}

