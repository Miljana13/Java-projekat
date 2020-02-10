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

public class dlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	boolean isOk;
	Color color,colorF;
	private JTextField txtInnR;
	private JTextField txtOutR;
	JButton btnBoja = new JButton("Edge color");
	JButton btnBojaF = new JButton("In color");
	
	

	public JTextField getTxtInnR() {
		return txtInnR;
	}

	public void setTxtInnR(JTextField txtInnR) {
		this.txtInnR = txtInnR;
	}

	public JTextField getTxtOutR() {
		return txtOutR;
	}

	public void setTxtOutR(JTextField txtOutR) {
		this.txtOutR = txtOutR;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgDonut dialog = new dlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgDonut() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUn = new JLabel("Enter inner radius:");
			GridBagConstraints gbc_lblUn = new GridBagConstraints();
			gbc_lblUn.insets = new Insets(0, 0, 5, 5);
			gbc_lblUn.gridx = 1;
			gbc_lblUn.gridy = 0;
			contentPanel.add(lblUn, gbc_lblUn);
		}
		{
			txtInnR = new JTextField();
			GridBagConstraints gbc_txtInnR = new GridBagConstraints();
			gbc_txtInnR.insets = new Insets(0, 0, 5, 0);
			gbc_txtInnR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInnR.gridx = 3;
			gbc_txtInnR.gridy = 0;
			contentPanel.add(txtInnR, gbc_txtInnR);
			txtInnR.setColumns(10);
		}
		{
			JLabel lblSpolj = new JLabel("Enter outer radius:");
			GridBagConstraints gbc_lblSpolj = new GridBagConstraints();
			gbc_lblSpolj.insets = new Insets(0, 0, 5, 5);
			gbc_lblSpolj.gridx = 1;
			gbc_lblSpolj.gridy = 1;
			contentPanel.add(lblSpolj, gbc_lblSpolj);
		}
		{
			txtOutR = new JTextField();
			GridBagConstraints gbc_txtOutR = new GridBagConstraints();
			gbc_txtOutR.insets = new Insets(0, 0, 5, 0);
			gbc_txtOutR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtOutR.gridx = 3;
			gbc_txtOutR.gridy = 1;
			contentPanel.add(txtOutR, gbc_txtOutR);
			txtOutR.setColumns(10);
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
			
			btnBoja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Boja", color);
					btnBoja.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnBoja = new GridBagConstraints();
			gbc_btnBoja.insets = new Insets(0, 0, 5, 0);
			gbc_btnBoja.gridx = 3;
			gbc_btnBoja.gridy = 3;
			contentPanel.add(btnBoja, gbc_btnBoja);
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
					colorF = JColorChooser.showDialog(null, "Boja", color);
					btnBojaF.setBackground(colorF);
				}
			});
			GridBagConstraints gbc_btnBojaF = new GridBagConstraints();
			gbc_btnBojaF.gridx = 3;
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
						if(txtInnR.getText().trim().isEmpty() || txtOutR.getText().trim().isEmpty() || color == null) {
							isOk = false;
							//JOptionPane.showMessageDialog(null, "Morate da uneste sve parametre!");
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
