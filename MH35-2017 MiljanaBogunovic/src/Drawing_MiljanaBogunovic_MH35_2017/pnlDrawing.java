package Drawing_MiljanaBogunovic_MH35_2017;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import elements.elements.Circle;
import elements.elements.Point;
import elements.elements.Line;
import elements.elements.Donut;
import elements.elements.Drawing;
import elements.elements.Rectangle;
import elements.elements.Selected;



public class pnlDrawing extends JPanel {
	Object o = new Object();
	
	LinkedList<Point> copyPoints = frmDrw.points;
	LinkedList<Rectangle> copyRectangles = frmDrw.rectangles;
	LinkedList<Circle> copyCircles = frmDrw.circles;
	LinkedList<Line> copyLines = frmDrw.lines;
	LinkedList<Donut> copyDonuts = frmDrw.donuts;
	
	public pnlDrawing() {
	
		repaint();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);//pozvali smo metodu JPanela paint
		draw(g);
	} //googlajte da razumete 
		
		public void draw(Graphics g) {
				for(Point p : copyPoints) { //prolazak kroz listu tacaka
					p.draw(g); //iscrtavanje liste 
				}
				
				for(Rectangle r : copyRectangles) {
					r.draw(g);
				}
				for(Circle c : copyCircles) {
					c.draw(g);
				}
				for(Line l : copyLines) {
					l.draw(g);
				}
				for(Donut d : copyDonuts) {
					d.draw(g);
				}
				
			}
		
		

}
