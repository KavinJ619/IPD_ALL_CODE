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

public class AdminOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOptions frame = new AdminOptions();
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
	public AdminOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Options");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(119, 29, 312, 45);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Teacher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminTeacherOptions admin1=new AdminTeacherOptions();
				admin1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(86, 146, 163, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminStudentOptions admin2=new AdminStudentOptions();
				admin2.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(285, 146, 161, 35);
		contentPane.add(btnNewButton_1);
	}

}
