package Stack_MiljanaBogunovic_MH35_2017.bin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import Sort_MiljanaBogunovic_MH35_2017.FrmSort;
import elements.elements.Point;
import elements.elements.Rectangle;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractListModel;

public class FrmRectangle extends JFrame{

	private JFrame frame;
	public static DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();  
	public JList list; //papir na koji nalepimo dlm rectangle
	

	public DefaultListModel<Rectangle> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<Rectangle> dlm) {
		this.dlm = dlm;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRectangle window = new FrmRectangle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmRectangle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlSouth = new JPanel();
		frame.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				DlgRectangle dr= new DlgRectangle(); 
			
				dr.setVisible(true); 
				if(dr.isOk) { 
					Rectangle r1 = new Rectangle(); 
					int flag = 0;
					try {
						r1 = new Rectangle(new Point(Integer.parseInt(dr.getTxtX().getText().toString()),Integer.parseInt(dr.getTxtY().getText().toString())),
								Integer.parseInt(dr.getTxtHeight().getText().toString()),Integer.parseInt(dr.getTxtWidth().getText().toString()));
						
						
					}catch(Exception ex) {
						flag = 1;
						JOptionPane.showMessageDialog(null, "You can not enter string for value");  
						
					}
					if(r1.getHeight() < 0 || r1.getWidth() < 0) {
						JOptionPane.showMessageDialog(null, "You need to enter positive values!");
						dr.dispose();				
					}
					else {
						if(flag == 0) { 
					dlm.addElement(r1); 
					}
						
					}
					
					
				}
			}
		});
		pnlSouth.add(btnAdd);
		
		JButton btnModificate = new JButton("Change");
		btnModificate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "The list is empty,you must add rectangle first!");
				}
				else if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Select the rectangle first!");
				}
			    
				else {
				
					Rectangle temp = dlm.elementAt(list.getSelectedIndex()); 
					DlgRectangle dlr = new DlgRectangle(); 
					
					dlr.getTxtHeight().setText(Integer.toString(temp.getHeight()));
					dlr.getTxtWidth().setText(Integer.toString(temp.getWidth()));
					dlr.getTxtX().setText(Integer.toString(temp.getUpperLeft().getX()));
					dlr.getTxtY().setText(Integer.toString(temp.getUpperLeft().getY()));
					
					dlr.setVisible(true); 
					
					if(dlr.isOk) {
						Rectangle r1 = new Rectangle();
						int flag = 0;
						try {
							r1 = new Rectangle(new Point(Integer.parseInt(dlr.getTxtX().getText().toString()),Integer.parseInt(dlr.getTxtY().getText().toString())),
								Integer.parseInt(dlr.getTxtHeight().getText().toString()),Integer.parseInt(dlr.getTxtWidth().getText().toString()));
						}catch(Exception ex) {
							flag = 1;
							JOptionPane.showMessageDialog(null, "You can not enter string for value!");
							
						}
						if(r1.getHeight() < 0 || r1.getWidth() < 0) {
							JOptionPane.showMessageDialog(null, "You need to enter positive values!");
							dlr.dispose();				
						}
						else {
						dlm.removeElementAt(list.getSelectedIndex());
						dlm.addElement(r1);
						}
						
					}
					
					
				}
			}
		});
		pnlSouth.add(btnModificate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "The list is empty! You need to add rectangle first");
				}
				else if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Select the rectangle first!");
				}
				
				else {
					Rectangle temp = dlm.elementAt(list.getSelectedIndex());
					DlgRectangle dlr = new DlgRectangle();
					
					dlr.getTxtHeight().setText(Integer.toString(temp.getHeight()));
					dlr.getTxtWidth().setText(Integer.toString(temp.getWidth()));
					dlr.getTxtX().setText(Integer.toString(temp.getUpperLeft().getX()));
					dlr.getTxtY().setText(Integer.toString(temp.getUpperLeft().getY()));
					
					dlr.setVisible(true); 
					
					if(dlr.isOkk) {
						dlm.remove(list.getSelectedIndex());
					
					}
					
				}
			}
		});
		pnlSouth.add(btnDelete);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "The list is empty add rectangles first!");
				}
				else {
					
				
					FrmSort frs = new FrmSort();
					frs.setVisible(true);
				}
				
				
			}		
						
					
	
		});
		pnlSouth.add(btnSort);
		
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
		list = new JList();
		list.setBackground(Color.PINK);
		scrollPane.setViewportView(list);
		list.setModel(dlm); 
	
	}

}
