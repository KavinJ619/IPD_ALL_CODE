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

public class AdminStudentOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStudentOptions frame = new AdminStudentOptions();
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
	public AdminStudentOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Teacher Options");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 25, 472, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add a student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent student=new AddStudent();
				student.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(95, 121, 177, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove a Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveStudent student1=new RemoveStudent();
				student1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(302, 121, 177, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update an Existing Student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent student2=new UpdateStudent();
				student2.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(196, 197, 177, 46);
		contentPane.add(btnNewButton_2);
	}

}
