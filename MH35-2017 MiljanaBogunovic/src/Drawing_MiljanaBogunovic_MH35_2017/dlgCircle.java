package Drawing_MiljanaBogunovic_MH35_2017;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	boolean isOk;
	private JTextField txtBoja; 
	Color color,colorF;
	JButton btnBojaIvice = new JButton("Out color");
	JButton btnBojaF = new JButton("In color");
	

	public JTextField getTxtBoja() {
		return txtBoja;
	}

	public void setTxtBoja(JTextField txtBoja) {
		this.txtBoja = txtBoja;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgCircle dialog = new dlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgCircle() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRadius = new JLabel("Enter Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 1;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtBoja = new JTextField();
			GridBagConstraints gbc_txtBoja = new GridBagConstraints();
			gbc_txtBoja.insets = new Insets(0, 0, 5, 0);
			gbc_txtBoja.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBoja.gridx = 5;
			gbc_txtBoja.gridy = 1;
			contentPanel.add(txtBoja, gbc_txtBoja);
			txtBoja.setColumns(10);
		}
		{
			JLabel lblBoja = new JLabel("Select edge color:");
			GridBagConstraints gbc_lblBoja = new GridBagConstraints();
			gbc_lblBoja.insets = new Insets(0, 0, 5, 5);
			gbc_lblBoja.gridx = 1;
			gbc_lblBoja.gridy = 3;
			contentPanel.add(lblBoja, gbc_lblBoja);
		}
		{
			
			btnBojaIvice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Color", color); 
					btnBojaIvice.setBackground(color); 
				}
			});
			GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
			gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 0);
			gbc_btnBojaIvice.gridx = 5;
			gbc_btnBojaIvice.gridy = 3;
			contentPanel.add(btnBojaIvice, gbc_btnBojaIvice);
		}
		{
			JLabel lblBojaF = new JLabel("Select inner color:");
			GridBagConstraints gbc_lblBojaF = new GridBagConstraints();
			gbc_lblBojaF.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaF.gridx = 1;
			gbc_lblBojaF.gridy = 4;
			contentPanel.add(lblBojaF, gbc_lblBojaF);
		}
		{
			
			btnBojaF.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorF = JColorChooser.showDialog(null, "Color", color);
					btnBojaF.setBackground(colorF);
				}
			});
			GridBagConstraints gbc_btnBojaF = new GridBagConstraints();
			gbc_btnBojaF.gridx = 5;
			gbc_btnBojaF.gridy = 4;
			contentPanel.add(btnBojaF, gbc_btnBojaF);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtBoja.getText().trim().isEmpty() || color == null || colorF == null) {
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
