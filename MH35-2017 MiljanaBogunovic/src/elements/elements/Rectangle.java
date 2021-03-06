package elements.elements;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Selected {
	private Point upperLeft;
	private int width;
	private int height;
	protected Color color,colorF;
	boolean fill;
	
	public Rectangle() {

	}
	

	public boolean isFill() {
		return fill;
	}


	public void setFill(boolean fill) {
		this.fill = fill;
	}


	public Rectangle(Point upperLeft, int height, int width) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}

	// Upper left point:(xUpperLeft,yUpperLeft), width = <width>, height = <height>
	public String toString() {
		return "Upper left point: "+upperLeft+", width = "+width+", height = "+height;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			return upperLeft.equals(temp.upperLeft) && width == temp.width && height == temp.height;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return (upperLeft.getX() < x && x < upperLeft.getX() + width && upperLeft.getY() < y
				&& y < upperLeft.getY() + height);
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	public int area() {
		return width * height;
	}
	
	public int volume() {
		return 2 * width + 2 * height;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}
	
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if (fill)
		{
			g.setColor(colorF);
			g.fillRect(upperLeft.getX(), upperLeft.getY(), width, height);
		}

		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() - 2, 4, 4);
			g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() - 2, 4, 4);
			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() + height - 2, 4, 4);
			g.drawRect(upperLeft.getX() + width  - 2, upperLeft.getY() + height - 2, 4, 4);
		}
	}

	
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}

	
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}

	
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int) (this.area() - ((Rectangle)o).area());
		}
		return 0;
	}
	public void brush(Graphics g) {
		
		g.setColor(Color.white);
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
	}

	
	public void setColor(Color c) {
		
		color=c;
	}
	public Color getColor() {
		return this.color = color;
	}
	public void setColorFill(Color c) {
		
		colorF=c;
	}
	public Color getColorF() {
		return this.colorF = colorF;
	}

}

