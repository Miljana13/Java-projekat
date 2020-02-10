package elements.elements;

import java.awt.Color;
import java.awt.Graphics;


public abstract class Selected implements Moveable, Comparable{
	protected boolean selected;
	
	public Selected() {
		
	}
	
	public Selected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	public abstract void brush(Graphics g);
	public abstract void setColor(Color c);
	public abstract void setColorFill(Color c);
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	} //metoda koja nam govori kad je krug selektovan
}

