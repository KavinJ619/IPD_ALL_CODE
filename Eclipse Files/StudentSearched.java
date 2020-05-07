import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentSearched extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSearched frame = new StudentSearched();
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
	public StudentSearched() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(62, 50, 145, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(62, 111, 145, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 170, 145, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Modules:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(62, 215, 145, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel studentID = new JLabel("");
		studentID.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setBounds(0, 331, 145, 34);
		contentPane.add(studentID);
		
		JLabel fname = new JLabel("");
		fname.setBounds(217, 50, 301, 34);
		contentPane.add(fname);
		
		JLabel lname = new JLabel("");
		lname.setBounds(217, 111, 301, 34);
		contentPane.add(lname);
		
		JLabel course = new JLabel("");
		course.setBounds(217, 170, 301, 34);
		contentPane.add(course);
		
		JLabel mod1 = new JLabel("");
		mod1.setBounds(217, 226, 301, 23);
		contentPane.add(mod1);
		
		JLabel mod2 = new JLabel("");
		mod2.setBounds(217, 260, 301, 23);
		contentPane.add(mod2);
		
		JLabel mod3 = new JLabel("");
		mod3.setBounds(217, 294, 301, 23);
		contentPane.add(mod3);
		
		JLabel mod4 = new JLabel("");
		mod4.setBounds(217, 331, 301, 23);
		contentPane.add(mod4);
		
		JButton btnNewButton = new JButton("<- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStudent student1=new SearchStudent();
				student1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 113, 34);
		contentPane.add(btnNewButton);
		
		int id=SearchStudent.getID();
		
		try {
			Connection myconn=connect();

			String query="SELECT * FROM student WHERE ID=?";
			PreparedStatement pst=myconn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet result=pst.executeQuery();
			if (result.next()) {
				fname.setText(result.getString(2));
				lname.setText(result.getString(3));
				course.setText(result.getString(4));
				studentID.setText(result.getString(1));
				
			}
			else {
				JOptionPane.showMessageDialog(null, "No such ID Exists");
			}
			
			String query1="SELECT * FROM studentmodules WHERE student_id=?";
			PreparedStatement pst1=myconn.prepareStatement(query1);
			pst1.setInt(1, id);
			ResultSet result1=pst1.executeQuery();
			if (result1.next()) {
				mod1.setText(result1.getString(2));
				mod2.setText(result1.getString(3));
				mod3.setText(result1.getString(4));
				mod4.setText(result1.getString(5));
			}
			else {
				JOptionPane.showMessageDialog(null, "No such ID Exists");
				
			}
		}catch(Exception ex) {
			
		}
	}

}
