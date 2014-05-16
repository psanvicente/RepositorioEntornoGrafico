package randomFloatGenerator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Help extends JDialog {

	
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	
	private JButton okButton;


	public static void launch() {
		try {
			Help dialog = new Help();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Help() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Help");
		setBounds(100, 100, 427, 347);
		setBackground(new Color(153,204,204));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(153,204,204));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JTextPane textPane = new JTextPane();
			textPane.setText("This application generates random floating point numbers.\n\nRequired parameters:\n\n-Max value: Highest value of the range.\n-Min value: Lowest value of the range\n-Decimal max and min values must use a dot-Precision: Decimal places\n-Amount: Amount of numbers that are generated\r\rRestrictions:\n\n-Possible values: from -(10^9)-1 to (10^9)-1\n-Max value must be higher than Min value\n");
			textPane.setFont(new Font("Waree", Font.PLAIN, 11));
			textPane.setEditable(false);
			textPane.setBackground(new Color(153, 204, 204));
			contentPanel.add(textPane);
		}
		{
			JPanel buttonPane = new JPanel();
			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER)
							dispose();
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{okButton}));
	}

}
