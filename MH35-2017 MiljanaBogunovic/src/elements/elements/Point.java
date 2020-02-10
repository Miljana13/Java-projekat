package elements.elements;


import java.awt.Color;
import java.awt.Graphics;


public class Point extends Selected{
	private int x;
	private int y;
	protected Color color,colorF;
	
	public Point() {

	}

	
	
	public Color getColorF() {
		return colorF;
	}



	public void setColorF(Color colorF) {
		this.colorF = colorF;
	}



	public Color getColor() {
		return color;
	}



	public Point(int x, int y) {
		this.x = x;
		// setX(x);
		this.y = y;
	}
	public Point(Color color, int x, int y) {
		this.color = color;
		// setX(x);
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		// this.x = x;
		// this.y = y;
		this.selected = selected;
	}

	public String toString() {
		// (x,y)
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point) obj;
			if(x == temp.x && y == temp.y)
				return true;
			//else
				//return false;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}
	
	public double distance(int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x1) {
		x = x1;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y+2, x, y-2);
		if(selected) {
			g.setColor(Color.blue);
			g.drawRect(x-2, y-2, 4, 4);
		}
	}

	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y = this.y + byY;
	}


	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public int compareTo(Object o) {
		if (o instanceof Point) {
			return (int) (this.distance(0, 0) - ((Point)o).distance(0, 0));
		}
		return 0;
	}
	public void setColor(Color c) {
		
		color=c;
	}
	
	public void brush(Graphics g) {
		
		g.setColor(Color.white);
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y+2, x, y-2);
	}
	public void setColorFill(Color c) {
		
		colorF=c;
	}
	
	
}


