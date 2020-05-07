import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMenu frame = new SearchMenu();
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
	public SearchMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Menu");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(133, 32, 307, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStudent searchstud=new SearchStudent();
				searchstud.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(80, 143, 153, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Teacher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherSearch teacher123=new TeacherSearch();
				teacher123.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(335, 143, 153, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<- Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherMenu teacher=new TeacherMenu();
				teacher.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(0, 0, 123, 34);
		contentPane.add(btnNewButton_2);
	}

}
