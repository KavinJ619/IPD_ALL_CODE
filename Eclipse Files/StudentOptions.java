import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentOptions frame = new StudentOptions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 298, 806, 166);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Student Information");
		btnNewButton.setBounds(154, 82, 170, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("<- Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextingJFrame student2=new  TextingJFrame();
				student2.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Current Modules");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentModules student12=new studentModules();
				student12.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(413, 82, 170, 42);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogged student1=new StudentLogged();
				student1.setVisible(true);
				setVisible(false);
			}
		});
	}
}
