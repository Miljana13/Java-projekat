package Stack_MiljanaBogunovic_MH35_2017.bin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {
	boolean isOk; 
	boolean isOkk; 

	private final JPanel contentPanel = new JPanel();
	private JTextField txtWidth;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtHeight;
	
	
	

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{148, 46, 86, 0};
		gbl_contentPanel.rowHeights = new int[]{20, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblHeigth = new JLabel("Enter Height:");
			GridBagConstraints gbc_lblHeigth = new GridBagConstraints();
			gbc_lblHeigth.anchor = GridBagConstraints.EAST;
			gbc_lblHeigth.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeigth.gridx = 0;
			gbc_lblHeigth.gridy = 0;
			contentPanel.add(lblHeigth, gbc_lblHeigth);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtheight = new GridBagConstraints();
			gbc_txtheight.insets = new Insets(0, 0, 5, 0);
			gbc_txtheight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtheight.gridx = 2;
			gbc_txtheight.gridy = 0;
			contentPanel.add(txtHeight, gbc_txtheight);
			txtHeight.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Enter Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 1;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 2;
			gbc_txtWidth.gridy = 1;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblPointX = new JLabel("Enter X coordinate:");
			GridBagConstraints gbc_lblPointX = new GridBagConstraints();
			gbc_lblPointX.anchor = GridBagConstraints.EAST;
			gbc_lblPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblPointX.gridx = 0;
			gbc_lblPointX.gridy = 2;
			contentPanel.add(lblPointX, gbc_lblPointX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 2;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblPointY = new JLabel("Enter Y coordinate:");
			GridBagConstraints gbc_lblPointY = new GridBagConstraints();
			gbc_lblPointY.anchor = GridBagConstraints.EAST;
			gbc_lblPointY.insets = new Insets(0, 0, 0, 5);
			gbc_lblPointY.gridx = 0;
			gbc_lblPointY.gridy = 3;
			contentPanel.add(lblPointY, gbc_lblPointY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 2;
			gbc_txtY.gridy = 3;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtWidth.getText().trim().isEmpty() || txtHeight.getText().trim().isEmpty() || txtX.getText().trim().isEmpty() || txtY.getText().isEmpty()) {
							isOk = false; 
							dispose(); 
						}
						else {
							isOk = true; 
							setVisible(false); 
						}
						
						
					}
				});
				{
					JButton btnDelete = new JButton("Delete");
					btnDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(isOk == true) { 
								isOkk = false; 
							}
							else {
								isOkk = true;
								setVisible(false);
							}
						}
					});
					buttonPane.add(btnDelete);
				}
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
