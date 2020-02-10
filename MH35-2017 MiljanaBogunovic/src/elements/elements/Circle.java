package elements.elements;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Selected {
	protected Point center;
	protected int r;
	protected Color color,colorF;
	boolean fill = false;
	
	
	
	public Circle() {

	}
	
	

	public boolean isFill() {
		return fill;
	}



	public void setFill(boolean fill) {
		this.fill = fill;
	}



	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}

	public Circle(Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}

	// Center:(xCenter,yCenter), radius = <radius>
	public String toString() {
		return "Center: "+center+", radius = "+r;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle temp = (Circle) obj;
			return center.equals(temp.center) && r == temp.r;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= r;
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	public double area() {
		return r * r * Math.PI;
	}
	
	public double volume() {
		return 2 * r * Math.PI;
	}

	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getR() {
		return r;
	}
	
	public void setR(int r) throws Exception {
		if(r < 0) {
			throw new Exception("You can not set radius to negative value!");
		} else {
			this.r = r;
		}
	}


	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawOval(center.getX() - r, center.getY() - r, 2 * r, r + r);
		if (fill)
		{
			g.setColor(colorF);
			g.fillOval(center.getX() - r, center.getY() - r, 2 * r, r + r);
		}
		if (selected) { //ovde proverava metodu iz selected da li je selektovan ili ne
			g.setColor(Color.blue);
			g.drawRect(center.getX() - r - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + r - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - r - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + r - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
		}
	}

	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		center.moveBy(byX, byY);
	}

	
	public void moveTo(int x, int y) {
		
		center.moveTo(x, y);
	}

	
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (int) (this.area() - ((Circle) o).area());
		}
		return 0;
	}
	public void setColor(Color c) {
		
		color=c;
	}
	public Color getColor() {
		
		return this.color= color;
	}
	public void brush(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(center.getX() - r, center.getY() - r, 2 * r, r + r);
	}
	public void setColorFill(Color c) {
		
		colorF=c;
	}
	
	public Color getColorF() {
		return this.colorF = colorF;
	}


}
