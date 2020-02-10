package Sort_MiljanaBogunovic_MH35_2017;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Stack_MiljanaBogunovic_MH35_2017.bin.FrmRectangle;
import elements.elements.Rectangle;

import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.awt.event.ActionEvent;

public class FrmSort extends JDialog {
	DefaultListModel<Rectangle> copy = FrmRectangle.dlm; 
	JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmSort dialog = new FrmSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmSort() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSort = new JButton("Sort");
				btnSort.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Rectangle rec = new Rectangle();
						Rectangle temp; 
						for(int i = 0; i < copy.getSize() - 1; i++) {
							rec = copy.get(i);
							for(int j = i + 1; j < copy.getSize(); j ++) {
								if(((copy.get(j).area())  > ((rec.area())))) {
									temp = copy.get(j);
									copy.set(j, rec);
									copy.set(i, temp);
								}
							}
						}
					}
				});
				btnSort.setActionCommand("OK");
				buttonPane.add(btnSort);
				getRootPane().setDefaultButton(btnSort);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(copy.isEmpty()) {
							dispose();
						}
						else {
							setVisible(false);
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				JList list = new JList();
				list.setBackground(Color.PINK);
				scrollPane.setViewportView(list);
				list.setModel(copy);
			
			 
						}
		}
	}

}
