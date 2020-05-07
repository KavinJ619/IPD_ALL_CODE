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
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class AdminTeacherOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTeacherOptions frame = new AdminTeacherOptions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Connection connect() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/students","root","Legal69!");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	/**
	 * Create the frame.
	 */
	public AdminTeacherOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Teacher Options");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 22, 356, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add a teacher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher teacher=new AddTeacher();
				teacher.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(86, 133, 143, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove a teacher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveTeacher teacher1=new RemoveTeacher();
				teacher1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(272, 133, 143, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Existing Teacher");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTeacher teacher12=new UpdateTeacher();
				teacher12.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(169, 203, 167, 35);
		contentPane.add(btnNewButton_2);
	}

}
