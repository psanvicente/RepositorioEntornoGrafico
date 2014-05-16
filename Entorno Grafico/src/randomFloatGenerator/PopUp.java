package randomFloatGenerator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 * Documentado por Pablo Sánchez Sanviente Ventana emergente para mostrar un
 * error
 * 
 * @author vith21
 * @version 2.0
 */
public class PopUp extends JFrame {

	/**
	 * Versión serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Jpanel que contiene todos los elementos del entorno gráfico
	 */
	private JPanel contentPane;

	/**
	 * Lanza la aplicación
	 * 
	 * @param message
	 */
	public static void launch(final String message) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUp frame = new PopUp(message);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame
	 * 
	 * @param mensaje
	 *            a mostrar
	 */
	public PopUp(String message) {
		setTitle("Error");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 134);
		setLocationRelativeTo(getFocusOwner());
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.disabled"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JLabel lblNewLabel = new JLabel(message);
		lblNewLabel.setFont(new Font("Garuda", Font.PLAIN, 15));

		JLabel label_imgError = new JLabel("");
		label_imgError.setIcon(new ImageIcon(PopUp.class
				.getResource("/img/iconoStop.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(label_imgError,
												GroupLayout.PREFERRED_SIZE, 94,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				18,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblNewLabel,
																				GroupLayout.PREFERRED_SIZE,
																				308,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(112)
																		.addComponent(
																				btnOk)
																		.addContainerGap()))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								gl_contentPane
										.createSequentialGroup()
										.addGap(17)
										.addComponent(lblNewLabel,
												GroupLayout.DEFAULT_SIZE, 37,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(btnOk).addContainerGap())
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(label_imgError,
												GroupLayout.PREFERRED_SIZE, 76,
												GroupLayout.PREFERRED_SIZE)
										.addGap(17)));
		contentPane.setLayout(gl_contentPane);
	}
}
