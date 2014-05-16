package randomFloatGenerator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class Info extends JDialog {

	
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	
	private JButton okButton;

	
	public static void launch() {
		try {
			Info dialog = new Info();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Info() {
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("About");
		setBounds(100, 100, 315, 238);
		setBackground(new Color(153,204,204));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(153,204,204));
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(75, 25, 206, 141);
			textPane.setText("Random Float Values Generator\nVersion: 1.0\r\n\r\nJava Aplication designed by:\r\n\nAntonio León Alcaide \r\nJosé Manuel Gonzalez  Peña\r\n\r\nCreative Commons");
			textPane.setEditable(false);
			textPane.setBackground(new Color(153, 204, 204));
			contentPanel.add(textPane);
		}
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Info.class.getResource("/img/Symbol_pi.png")));
		label.setBounds(12, 64, 57, 50);
		contentPanel.add(label);
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
