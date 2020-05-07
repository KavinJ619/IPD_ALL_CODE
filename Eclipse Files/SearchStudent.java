import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SearchStudent extends JFrame {

	private JPanel contentPane;
	private static JTextField student_ID;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchStudent frame = new SearchStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int getID() {
		int id=Integer.parseInt(student_ID.getText());
		return id;
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
	public SearchStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter ID of student:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(87, 26, 250, 37);
		contentPane.add(lblNewLabel);
		
		student_ID = new JTextField();
		student_ID.setHorizontalAlignment(SwingConstants.CENTER);
		student_ID.setBounds(107, 107, 230, 20);
		contentPane.add(student_ID);
		student_ID.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myconn=connect();
					
					int id=Integer.parseInt(student_ID.getText());
					
					String query="SELECT * FROM student WHERE ID=?";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setInt(1, id);
					ResultSet result=pst.executeQuery();
					if (result.next()) {
						JOptionPane.showMessageDialog(null, "Login Successfull");
						StudentSearched student1=new StudentSearched();
						student1.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "No such ID Exists");
					}
				}catch (Exception ex) {
					
				}
			}
		});
		btnNewButton.setBounds(159, 161, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("<- Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMenu student1=new SearchMenu();
				student1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
