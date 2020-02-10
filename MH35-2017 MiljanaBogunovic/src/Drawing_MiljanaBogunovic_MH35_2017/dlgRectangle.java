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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHeight;
	private JTextField txtWidth;
	public Color color ,colorF;
	boolean isOk;
	JButton btnBoja = new JButton("Edge color");
	JButton btnBojaF = new JButton("In color");
	
	
	

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgRectangle dialog = new dlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgRectangle() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblHeight = new JLabel("Enter height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 0;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 3;
			gbc_txtHeight.gridy = 0;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Enter width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 1;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 3;
			gbc_txtWidth.gridy = 1;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblBoja = new JLabel("Select edge color:");
			GridBagConstraints gbc_lblBoja = new GridBagConstraints();
			gbc_lblBoja.insets = new Insets(0, 0, 5, 5);
			gbc_lblBoja.gridx = 1;
			gbc_lblBoja.gridy = 2;
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
			gbc_btnBoja.gridy = 2;
			contentPanel.add(btnBoja, gbc_btnBoja);
		}
		{
			JLabel lblBojaF = new JLabel("Select inner color:");
			GridBagConstraints gbc_lblBojaF = new GridBagConstraints();
			gbc_lblBojaF.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaF.gridx = 1;
			gbc_lblBojaF.gridy = 3;
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
			gbc_btnBojaF.gridy = 3;
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
						if(color == null ||txtWidth.getText().trim().isEmpty() || txtHeight.getText().trim().isEmpty()) {
							isOk = false;
							//JOptionPane.showMessageDialog(null, "Morate podesiti sve parametre!");
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
