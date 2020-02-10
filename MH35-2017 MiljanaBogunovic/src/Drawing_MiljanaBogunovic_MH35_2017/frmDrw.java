package Drawing_MiljanaBogunovic_MH35_2017;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics;

import elements.elements.Circle;
import elements.elements.Donut;
import elements.elements.Line;
import elements.elements.Point;
import elements.elements.Rectangle;
import elements.elements.Selected;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmDrw {

	private JFrame frmLetsDraw;
	private pnlDrawing pnl =new pnlDrawing();
	boolean isOk = false,isOkB=false; 
	static LinkedList<Point> points = new LinkedList<Point>(); 
	static LinkedList<Rectangle> rectangles = new LinkedList<Rectangle>();
	static LinkedList<Circle> circles = new LinkedList<Circle>();
	static LinkedList<Line> lines = new LinkedList<Line>();
	static LinkedList<Donut> donuts = new LinkedList<Donut>();
	private int x,y,x1,y1, xC, yC, xL, yL;
	boolean selC,selP,selL,selR,selD;
	private Color colorP , colorR , colorC , colorL , colorD;
	private Color colorRF, colorCF, colorDF;
	Circle c,c1;
	Line l,l1;
	Point Pp,Pp1;
	Donut d,d1;
	Rectangle r,r1;
	int i;
	
	Object obj;
	Graphics graphics = pnl.getGraphics();
	Selected o;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDrw window = new frmDrw();
					window.frmLetsDraw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmDrw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLetsDraw = new JFrame();
		frmLetsDraw.setTitle("Let's draw!");
		frmLetsDraw.setBounds(100, 100, 900, 500);
		frmLetsDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnl.setBackground(Color.WHITE);
		frmLetsDraw.getContentPane().add(pnl, BorderLayout.CENTER);
		
		pnl.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			
				x = e.getX();
				y = e.getY();
				System.out.println(x);
				System.out.println(y);
			}
		});
		
		JPanel pnlDugmici = new JPanel();
		frmLetsDraw.getContentPane().add(pnlDugmici, BorderLayout.SOUTH);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x == 0 && y == 0) {
					JOptionPane.showMessageDialog(null, "You must to click on the canvas first!");
				}
				else {
				dlgCircle dc = new dlgCircle();
				dc.setVisible(true);
				if(dc.isOk ==true) {
					Circle c1 = new Circle();
					int flag = 0;
					
					try {
						c1 = new Circle(new Point(x,y),
								Integer.parseInt(dc.getTxtBoja().getText().toString()));
					
						
					}catch(Exception ex) {
						flag = 1;
						JOptionPane.showMessageDialog(null, "You can not enter string to be value of radius ");
						
					}
					if(c1.getR() < 0 ) {
						JOptionPane.showMessageDialog(null, "You need to enter all positive values !");
						dc.dispose();				
					}
					else {
						if(flag == 0) {
							colorC = dc.color; 
							colorCF = dc.colorF; 
							c1.setColor(colorC);
							if(colorCF != null) {
								c1.setFill(true);
								c1.setColorFill(colorCF);
							}
							circles.add(c1);
							selC = false; 
							pnl.repaint(); 
					}
						
					}
				}
				}
			}
		});
		pnlDugmici.add(btnCircle);
		
		JButton btnPoint = new JButton("Point");
		
			btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x == 0 && y == 0) {
					JOptionPane.showMessageDialog(null, "You must to click on the canvas first!");
				}
				else{
					dlgPoint dp = new dlgPoint();
				
				dp.setVisible(true);
				if(dp.isOk) {
					
					colorP = dp.getColor();
					Point p1 = new Point();
					p1.setX(x);
					p1.setY(y);
					p1.setColor(colorP);
					points.add(p1);
					selP =false; 
					pnl.repaint();	
					
				}
				}
			}
		});
			
		pnlDugmici.add(btnPoint);
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x == 0 && y == 0) {
					JOptionPane.showMessageDialog(null, "You must to click on the canvas first!");
				}
				else {
				dlgLine dl = new dlgLine();
				dl.setVisible(true);
				if(dl.isOk) {
				colorL = dl.color;
				Line l1 = new Line();
					
				int flag = 0;
				try {
					l1 = new Line(new Point(x,y),
							new Point(Integer.parseInt(dl.getTxtX().getText().toString()),Integer.parseInt(dl.getTxtY().getText().toString())));
					
					
				}catch(Exception ex) {
					flag = 1;
					JOptionPane.showMessageDialog(null, "You cannot enter string to be value");
					
				}
				if(l1.getEndPoint().getX() < 0 || l1.getEndPoint().getY() < 0) {
					JOptionPane.showMessageDialog(null, "You must enter all positive values");
					dl.dispose();				
				}
				else {
					if(flag == 0) {
						l1.setColor(colorL);
						lines.add(l1);
						selL = false;
						pnl.repaint();
				}
				
				}
				}
				}
				
			}
		});
		pnlDugmici.add(btnLine);
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x == 0 && y == 0) {
					JOptionPane.showMessageDialog(null, "You must to click on the canvas first!");
				}
				else {
				dlgDonut dd = new dlgDonut();
				dd.setVisible(true);
				if(dd.isOk) {
					Donut d1 = new Donut();
					int flag = 0;
					try {
						d1 = new Donut(new Point(x,y),
								Integer.parseInt(dd.getTxtOutR().getText().toString()),Integer.parseInt(dd.getTxtInnR().getText().toString()));
						
						
					}catch(Exception ex) {
						flag = 1;
						JOptionPane.showMessageDialog(null, "You can not enter string to be value");
						
					}
					if(d1.getR() < 0 || d1.getInnerR() < 0) {
						JOptionPane.showMessageDialog(null, "You must enter all positive values");
						dd.dispose();				
					}
					
					else {
						if(flag == 0) {
							colorDF = dd.colorF;
							colorD = dd.color;
							d1.setColor(colorD);
							if(colorDF != null) {
								d1.setFill(true);
								d1.setColorFill(colorDF);
								selD = false;
								donuts.add(d1);
								pnl.repaint();
							}
							
							selD = false;
							donuts.add(d1);
							pnl.repaint();
							
							
					}
						
					}
				}
				}
			}
		});
		pnlDugmici.add(btnDonut);
		
		JButton btnRect = new JButton("Rectangle");
		btnRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x == 0 && y == 0) {
					JOptionPane.showMessageDialog(null, "You must to click on the canvas first!");
				}
				else {
				dlgRectangle dr = new dlgRectangle();
				dr.setVisible(true);
				if(dr.isOk) {
					
					Rectangle r1 = new Rectangle();
						
					int flag = 0;
					try {
						r1 = new Rectangle(new Point(x,y),
								Integer.parseInt(dr.getTxtHeight().getText().toString()),Integer.parseInt(dr.getTxtWidth().getText().toString()));
						
						
					}catch(Exception ex) {
						flag = 1;
						JOptionPane.showMessageDialog(null, "You can not enter string to be value");
						
					}
					if(r1.getHeight() < 0 || r1.getWidth() < 0) {
						JOptionPane.showMessageDialog(null, "You need to enter all positive values!");
						dr.dispose();				
					}
					else {
						if(flag == 0) {
							colorR = dr.color;
							colorRF = dr.colorF;
							r1.setColor(colorR);
							if(colorRF != null) {
								r1.setFill(true);
								r1.setColorFill(colorRF);
							}
							
							selR = false; 
							rectangles.add(r1);
							pnl.repaint();
					
					}
						
					}
				}
				}
			}
		});
		pnlDugmici.add(btnRect);
		
		JPanel pnlOpcije = new JPanel();
		frmLetsDraw.getContentPane().add(pnlOpcije, BorderLayout.EAST);
		GridBagLayout gbl_pnlOpcije = new GridBagLayout();
		gbl_pnlOpcije.columnWidths = new int[]{0, 0};
		gbl_pnlOpcije.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlOpcije.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlOpcije.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOpcije.setLayout(gbl_pnlOpcije);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(points.isEmpty() && circles.isEmpty() && rectangles.isEmpty() && lines.isEmpty() && donuts.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must draw elements first!");
				}
				else {
					pnl.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							
							x1 = e.getX();
							y1 = e.getY();
							System.out.println(x1);
							System.out.println(y1);
							Point p = new Point(x1,y1); 
							
							if(selC == false) {
								c = new Circle();
								Iterator<Circle> it = circles.iterator();
								while(it.hasNext()) {
									c = it.next();
									c.setSelected(false);
									if(c.contains(p)) {
										c.setSelected(true);
										selC = true;
										pnl.repaint();
										
									}
								}
							}
							if(selP == false) {
								Pp = new Point();
								Iterator<Point> itP = points.iterator();
								while(itP.hasNext()) {
									Pp = itP.next();
									Pp.setSelected(false);
									if(Pp.contains(p.getX(),p.getY())) {
										Pp.setSelected(true);
										selP = true;
										pnl.repaint();
									}
								}
							}
							if(selR == false) {
								r = new Rectangle();
								Iterator<Rectangle> itR = rectangles.iterator();
								while(itR.hasNext()) {
									r = itR.next();
									r.setSelected(false);
									if(r.contains(p)) {
										r.setSelected(true);
										selR = true;
										pnl.repaint();
									}
								}
							}
							if(selL == false) {
								l = new Line();
								Iterator<Line> itL = lines.iterator();
								while(itL.hasNext()) {
									l = itL.next();
									l.setSelected(false);
									if(l.contains(x1, y1)) {
										l.setSelected(true);
										selL = true;
										pnl.repaint();
									}
								}
							}
							if(selD == false) {
								d = new Donut();
								Iterator<Donut> itD = donuts.iterator();
								while(itD.hasNext()) {
									d = itD.next();
									d.setSelected(false);
									if(d.contains(p.getX(),p.getY())) {
										d.setSelected(true);
										selD = true;
										pnl.repaint();
									}
								}
							}
						
						}
					
					});
				}
			}
		});
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect.gridx = 0;
		gbc_btnSelect.gridy = 0;
		pnlOpcije.add(btnSelect, gbc_btnSelect);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rectangles.isEmpty() && points.isEmpty() && donuts.isEmpty() && lines.isEmpty() && circles.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must draw elements first!");
				}
				else if(selL == false && selR == false && selP == false && selD ==false && selC == false) {
					JOptionPane.showMessageDialog(null, "This option is not available without selected object");
				}
				else {
					if(selC == true) {
						Delete(c);
					}
					if(selP == true) {
						Delete(Pp);
					}
					if(selL == true) {
						Delete(l);
					}
					if(selD == true) {
						Delete(d);
					}
					if(selR == true) {
						Delete(r);
					}
				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 3;
		pnlOpcije.add(btnDelete, gbc_btnDelete);
		
		JButton btnModifie = new JButton("Modificate");
		btnModifie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rectangles.isEmpty() && points.isEmpty() && donuts.isEmpty() && lines.isEmpty() && circles.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must draw elements first!");
				}
				else if(selL == false && selR == false && selP == false && selD ==false && selC == false) {
					JOptionPane.showMessageDialog(null, "This option is not available without selected object");
				}
				
				if(selL == true) {
					Modificate(l);
				}
				if(selC == true) {
					Modificate(c);
					
				}
				if(selR) {
					Modificate(r);
				}
				
				if(selP) {
					Modificate(Pp);
				}
				if(selD) {
					Modificate(d);
				}
				
				
			}
		});
		GridBagConstraints gbc_btnModifie = new GridBagConstraints();
		gbc_btnModifie.gridx = 0;
		gbc_btnModifie.gridy = 4;
		pnlOpcije.add(btnModifie, gbc_btnModifie);
		
		
	}
	
	public void Delete(Circle c) {
		if(c.isSelected() == true) {

			int replay = JOptionPane.showConfirmDialog(null,"Do you want to delete selected object?", "Delete",JOptionPane.YES_NO_OPTION);
			if(replay == JOptionPane.YES_OPTION) {
			circles.remove(c);
			pnl.repaint();
			}
			else {
				selC = false;
				c.setSelected(selC);
			}
		
		}
	}
	public void Delete(Line l) {
		if(l.isSelected() == true) {
		
			int replay = JOptionPane.showConfirmDialog(null,"Do you want to delete selected object?", "Delete",JOptionPane.YES_NO_OPTION);
			if(replay == JOptionPane.YES_OPTION) {
				lines.remove(l);
				pnl.repaint();
			}
			else {
				selL = false;
				c.setSelected(selL);
			}
			
			
			
		}
	}
	public void Delete(Rectangle r) {
		if(r.isSelected() == true) {
		
			int replay = JOptionPane.showConfirmDialog(null,"Do you want to delete selected object?", "Delete",JOptionPane.YES_NO_OPTION);
			if(replay == JOptionPane.YES_OPTION) {
				rectangles.remove(r);
				pnl.repaint();
			}
			else {
				selR = false;
				c.setSelected(selR);
			}
			
			
		}
	}
	public void Delete(Donut d) {
		if(d.isSelected() == true) {
		
			int replay = JOptionPane.showConfirmDialog(null,"Do you want to delete selected object?", "Delete",JOptionPane.YES_NO_OPTION);
			if(replay == JOptionPane.YES_OPTION) {
				donuts.remove(d);
				pnl.repaint();
			}
			else {
				selD = false;
				c.setSelected(selD);
			}
			
			
		}
	}
	public void Delete(Point Pp) {
		if(Pp.isSelected() == true) {
			int replay = JOptionPane.showConfirmDialog(null,"Do you want to delete selected object?", "Delete",JOptionPane.YES_NO_OPTION);
			if(replay == JOptionPane.YES_OPTION) {
				points.remove(Pp);
				pnl.repaint();
			}
			else {
				selP = false;
				c.setSelected(selP);
			}
			
			
		}
	}
	
	public void Modificate(Point Pp) {
		if(Pp.isSelected()==true) {
			
			dlgPoint dp = new dlgPoint();
			dp.btnBoja.setBackground(Pp.getColor());
			dp.setColor(Pp.getColor());
			
			dp.setVisible(true);
			dp.setModal(true);
			Pp.setColor(dp.getColor());
			Pp.setSelected(false);
			pnl.repaint();
			
		}
		
		
	}
	
	
	public void Modificate(Line l) {
		
		if(l.isSelected()==true) {
			dlgLine dl = new dlgLine();
		
			dl.getTxtX().setText(Integer.toString(l.getEndPoint().getX()));;
			dl.getTxtY().setText(Integer.toString(l.getEndPoint().getY()));
			dl.btnBoja.setBackground(l.getColor());

			dl.color = l.getColor();
			dl.setVisible(true);
		
			int flag = 0;
			try {
				l.setEndPoint(new Point(Integer.parseInt(dl.getTxtX().getText()),Integer.parseInt(dl.getTxtY().getText())));
				}catch(Exception ex) {
					flag = 1;
					JOptionPane.showMessageDialog(null, "You can not enter string as value");
					
				}
			if(l.getEndPoint().getX() < 0 || l.getEndPoint().getY() < 0) {
				JOptionPane.showMessageDialog(null, "You must enter all positive values!");
				dl.dispose();				
				}
			else {
				if(flag == 0) {
					l.setColor(dl.color);
					l.setSelected(false);
					selL = false;
					pnl.repaint();
				}
				
				}
				
			}
			
	}
	
	public void Modificate(Circle c) {
		if(c.isSelected() == true) {
			dlgCircle dc = new dlgCircle();
			
			dc.getTxtBoja().setText(Integer.toString(c.getR()));
			dc.btnBojaIvice.setBackground(c.getColor());
			dc.color = c.getColor();
			dc.colorF = c.getColorF();
			dc.btnBojaF.setBackground(c.getColorF());
			dc.setVisible(true);
			dc.setModal(true);
				int r = Integer.parseInt(dc.getTxtBoja().getText().toString());
				try {
				c.setR(r);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Radius can not be negative value");
				}
				c.setColor(dc.color);
				c.setFill(true);
				c.setColorFill(dc.colorF);
				selC = false;
				c.setSelected(false);
				pnl.repaint();
				
			}
		
	}
	
	public void Modificate(Rectangle r) {
		if(r.isSelected() == true) {
			dlgRectangle dr =  new dlgRectangle();
			dr.getTxtHeight().setText(Integer.toString(r.getHeight()));
			dr.getTxtWidth().setText(Integer.toString(r.getWidth()));
			dr.btnBoja.setBackground(r.getColor());
			dr.btnBojaF.setBackground(r.getColorF());
			dr.color = r.getColor();
			dr.colorF = r.getColorF();
			
			dr.setVisible(true);
			dr.setModal(true);
			int flag =0;
			try {
				r.setHeight(Integer.parseInt(dr.getTxtHeight().getText()));
				r.setWidth(Integer.parseInt(dr.getTxtWidth().getText()));
			}catch(Exception e) {
				flag =1;
				JOptionPane.showMessageDialog(null, "You can not enter string !");
			}
			if(flag == 0) {
				r.setColor(dr.color);
				r.setFill(true);
				r.setColorFill(dr.colorF);
				selR = false;
				r.setSelected(false);
		
				pnl.repaint();
			}
		}
	}
	
	public void Modificate(Donut d) {
		if(d.isSelected() == true) {
			dlgDonut dd = new dlgDonut();
			
			dd.getTxtInnR().setText(Integer.toString(d.getInnerR()));
			dd.getTxtOutR().setText(Integer.toString(d.getR()));
			dd.btnBoja.setBackground(d.getColor());
			dd.color = d.getColor();
			dd.colorF = d.getColorF();
			dd.btnBojaF.setBackground(d.getColorF());
			dd.setVisible(true);
			dd.setModal(true);
				 
				int flag = 0;
				try {
					d.setInnerR(Integer.parseInt(dd.getTxtInnR().getText().toString()));
					d.setR(Integer.parseInt(dd.getTxtOutR().getText().toString()));
				} catch(Exception e) {
					flag = 1;
					JOptionPane.showMessageDialog(null, "Radius can not be string");
				}
				if(flag == 0) {
				d.setColor(dd.color);
				d.setFill(true);
				d.setColorFill(dd.colorF);
				selD = false;
				d.setSelected(false);
				pnl.repaint();
				}
			}
		
	}

	


}
