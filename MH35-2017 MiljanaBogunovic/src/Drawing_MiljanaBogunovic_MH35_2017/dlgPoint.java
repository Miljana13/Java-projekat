package Drawing_MiljanaBogunovic_MH35_2017;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elements.elements.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;

public class dlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	boolean isOk;
	private Color color ;
	JButton btnBoja = new JButton("Color");
	
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgPoint dialog = new dlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgPoint() {
		setModal(true);
		setBounds(100, 100, 364, 122);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblBoja = new JLabel("Select color:");
			GridBagConstraints gbc_lblBoja = new GridBagConstraints();
			gbc_lblBoja.insets = new Insets(0, 0, 5, 5);
			gbc_lblBoja.gridx = 1;
			gbc_lblBoja.gridy = 1;
			contentPanel.add(lblBoja, gbc_lblBoja);
		}
		{
			
			btnBoja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Boja", color);
					btnBoja.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnBoja = new GridBagConstraints();
			gbc_btnBoja.insets = new Insets(0, 0, 5, 5);
			gbc_btnBoja.gridx = 3;
			gbc_btnBoja.gridy = 1;
			contentPanel.add(btnBoja, gbc_btnBoja);
		}
		{
			
			clsColors colors = new clsColors();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(color == null) {
							isOk = false;
							
							dispose();
									
						}
						else {
							
							isOk = true;
							setVisible(false);
						}
						
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
