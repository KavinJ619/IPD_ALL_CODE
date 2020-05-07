import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TeacherMenu extends JFrame {

	private JPanel contentPane;
	
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherMenu frame = new TeacherMenu();
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
	public TeacherMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 27, 234, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Personal Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherInfo teacher1=new teacherInfo();
				teacher1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(209, 111, 144, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Student List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherList teacher1=new TeacherList();
				teacher1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(209, 180, 144, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMenu search=new SearchMenu();
				search.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(209, 249, 144, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("<- Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherOptions teacher12=new TeacherOptions();
				teacher12.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(0, 0, 131, 33);
		contentPane.add(btnNewButton_3);
	}

}
