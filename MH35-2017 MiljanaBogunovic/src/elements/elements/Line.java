package elements.elements;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Selected{
	private Point startPoint;
	private Point endPoint;
	protected Color color,colorF;
	
	public Line() {

	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}

	// (xStartPoint,yStartpoint)-->(xEndPoint,yEndpoint)
	public String toString() {
		return startPoint+"-->"+endPoint;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp = (Line) obj;
			return startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint);
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y) + endPoint.distance(x, y)) - length() < 2;
	}

	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}

	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(this.getStartPoint().getX() - 2, this.getStartPoint().getY() - 2, 4, 4);
			g.drawRect(this.getEndPoint().getX() - 2, this.getEndPoint().getY() - 2, 4, 4);
		}
	}

	
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}

	
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.length() - ((Line)o).length());
		}
		return 0;
	}
	public void brush(Graphics g) {
		
		g.setColor(Color.white);
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
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
}

