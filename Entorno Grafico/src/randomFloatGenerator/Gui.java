package randomFloatGenerator;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Gui extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField textField_MinValue;
	private JTextField textField_MaxValue;
	private JTextField textField_Precision;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//main

	
	public Gui() {
		setBackground(new Color(153,204,204));
		setResizable(false);
		setTitle("Random Float Values Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(getFocusOwner());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
		);
		
		final JTextField textPane_Amount = new JTextField();
		textPane_Amount.setBounds(6, 265, 100, 19);
		textPane_Amount.setHorizontalAlignment(JTextField.CENTER);
		textPane_Amount.setToolTipText("Use the slider");
		textPane_Amount.setBackground(new Color(204, 255, 255));
		textPane_Amount.setForeground(new Color(0, 0, 102));
		textPane_Amount.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 204)));
		textPane_Amount.setEditable(false);
		
		final JSlider slider = new JSlider();
		slider.setBounds(126, 67, 42, 217);
		slider.setToolTipText("Amount of random numbers");
		slider.setValue(0);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textPane_Amount.setText(String.valueOf(slider.getValue()));
			}
		});
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBackground(new Color(153, 204, 204));
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(5);
		slider.setMaximum(50);
		slider.setMinorTickSpacing(1);
		
		textField_MinValue = new JTextField();
		textField_MinValue.setBounds(6, 150, 100, 19);
		textField_MinValue.setHorizontalAlignment(JTextField.CENTER);
		textField_MinValue.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 204)));
		textField_MinValue.setColumns(5);
		
		textField_MaxValue = new JTextField();
		textField_MaxValue.setBounds(7, 95, 100, 19);
		textField_MaxValue.setHorizontalAlignment(JTextField.CENTER);
		textField_MaxValue.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 204)));
		textField_MaxValue.setAlignmentY(Component.TOP_ALIGNMENT);
		textField_MaxValue.setColumns(5);
		
		
		textField_Precision = new JTextField();
		textField_Precision.setBounds(6, 210, 100, 19);
		textField_Precision.setHorizontalAlignment(JTextField.CENTER);
		textField_Precision.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 204)));
		textField_Precision.setColumns(5);
		
		JLabel lbl_Amount = new JLabel("Amount");
		lbl_Amount.setBounds(29, 241, 44, 25);
		lbl_Amount.setFont(new Font("Garuda", Font.BOLD, 13));
		lbl_Amount.setToolTipText("");
		
		JLabel lbl_MaxValue = new JLabel("Max Value");
		lbl_MaxValue.setBounds(26, 73, 61, 25);
		lbl_MaxValue.setFont(new Font("Garuda", Font.BOLD, 13));
		
		JLabel lbl_MinValue = new JLabel("Min Value");
		lbl_MinValue.setBounds(26, 129, 80, 25);
		lbl_MinValue.setFont(new Font("Garuda", Font.BOLD, 13));
		
		JLabel lbl_Precision = new JLabel("Precision");
		lbl_Precision.setBounds(26, 185, 63, 25);
		lbl_Precision.setFont(new Font("Garuda", Font.BOLD, 13));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 153, 204)));
		scrollPane.setBackground(new Color(153,204,204));
		scrollPane.setBounds(192, 67, 348, 223);
		panel.add(scrollPane);
		
		final JTextPane textPane_Results = new JTextPane();
		textPane_Results.setEditable(false);
		scrollPane.setViewportView(textPane_Results);
		contentPane.setLayout(gl_contentPane);
		
		JButton btn_Generate = new JButton("Generate");
		btn_Generate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						float min= Float.parseFloat(textField_MinValue.getText());
						float max = Float.parseFloat(textField_MaxValue.getText());
						if(!RandomFloatGenerator.checkRange(min, max))
							PopUp.launch(RandomFloatGenerator.messageRange);
						else {
						int precision = Integer.valueOf(textField_Precision.getText());
						int amount = slider.getValue();
						textPane_Results.setText(RandomFloatGenerator.getGroupOfNumbers(amount,min , max, precision));
						}
					} catch(NumberFormatException n)
					{
						PopUp.launch(RandomFloatGenerator.messageNoData);
					}
				}
			}
		});
		btn_Generate.setBounds(370, 302, 100, 25);
		btn_Generate.setBackground(UIManager.getColor("Button.background"));
		btn_Generate.setFont(new Font("Garuda", Font.PLAIN, 14));
		btn_Generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float min= Float.parseFloat(textField_MinValue.getText());
					float max = Float.parseFloat(textField_MaxValue.getText());
					if(!RandomFloatGenerator.checkRange(min, max))
						PopUp.launch(RandomFloatGenerator.messageRange);
					else {
					int precision = Integer.valueOf(textField_Precision.getText());
					int amount = slider.getValue();
					textPane_Results.setText(RandomFloatGenerator.getGroupOfNumbers(amount,min , max, precision));
					}
				} catch(NumberFormatException n)
				{
					PopUp.launch(RandomFloatGenerator.messageNoData);
				}
			}
		});
		
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					textPane_Amount.setText("");
					textField_MaxValue.setText("");
					textField_MinValue.setText("");
					textField_Precision.setText("");
					slider.setValue(0);
					textPane_Results.setText("");
				}
			}
		});
		btn_Clear.setBounds(256, 302, 100, 25);
		btn_Clear.setFont(new Font("Garuda", Font.PLAIN, 14));
		btn_Clear.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_Amount.setText("");
				textField_MaxValue.setText("");
				textField_MinValue.setText("");
				textField_Precision.setText("");
				slider.setValue(0);
				textPane_Results.setText("");
				
			}
		});
		panel.add(lbl_MinValue);
		panel.add(textField_MinValue);
		panel.add(lbl_Amount);
		panel.add(textField_Precision);
		panel.add(lbl_Precision);
		panel.add(lbl_MaxValue);
		panel.add(textField_MaxValue);
		panel.add(textPane_Amount);
		panel.add(slider);
		panel.add(btn_Generate);
		panel.add(btn_Clear);
		
		JLabel lbl_header = new JLabel("");
		lbl_header.setBounds(85, 17, 455, 39);
		lbl_header.setIcon(new ImageIcon(Gui.class.getResource("/img/head.png")));
		panel.add(lbl_header);
		
		JLabel label_logo = new JLabel("");
		label_logo.setBounds(18, 6, 55, 50);
		label_logo.setIcon(new ImageIcon(Gui.class.getResource("/img/Symbol_pi.png")));
		panel.add(label_logo);
		
		JButton btn_About = new JButton("About");
		btn_About.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					Info.launch();
			}
		});
		btn_About.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info.launch();
			}
		});
		btn_About.setBackground(new Color(153,204,204));
		btn_About.setBorderPainted(false);
		btn_About.setBorder(null);
		btn_About.setBounds(529, 332, 55, 27);
		panel.add(btn_About);
		
		JButton bttn_Help = new JButton("Help");
		bttn_Help.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					Help.launch();
			}
		});
		bttn_Help.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bttn_Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help.launch();
			}
		});
		bttn_Help.setBorderPainted(false);
		bttn_Help.setBackground(new Color(153,204,204));
		bttn_Help.setBounds(0, 332, 71, 27);
		panel.add(bttn_Help);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_MaxValue, textField_MinValue, textField_Precision, slider, btn_Clear, btn_Generate, bttn_Help, btn_About, scrollPane}));
	}
}
