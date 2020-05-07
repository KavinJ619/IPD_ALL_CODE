import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentLogged extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogged frame = new StudentLogged();
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
	public StudentLogged() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setBounds(33, 41, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel StudID = new JLabel("");
		StudID.setBounds(150, 41, 96, 14);
		contentPane.add(StudID);
		
		JLabel lblNewLabel_2 = new JLabel("First Name: ");
		lblNewLabel_2.setBounds(33, 75, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel name = new JLabel("");
		name.setBounds(150, 75, 168, 14);
		contentPane.add(name);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name: ");
		lblNewLabel_4.setBounds(33, 111, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel LName = new JLabel("");
		LName.setBounds(150, 111, 168, 14);
		contentPane.add(LName);
		
		JLabel lblNewLabel_6 = new JLabel("Course: ");
		lblNewLabel_6.setBounds(33, 150, 74, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel Course = new JLabel("");
		Course.setBounds(150, 150, 168, 14);
		contentPane.add(Course);
		
		JButton btnNewButton = new JButton("<- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentOptions student1=new StudentOptions();
				student1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		int id=StudentLoginPage.getID();
		try {
			Connection myconn=connect();
			String query="SELECT * FROM student WHERE ID=?";
			PreparedStatement pst=myconn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet result=pst.executeQuery();
			if (result.next()) {
				StudID.setText(Integer.toString(id));
				name.setText(result.getString(2));
				LName.setText(result.getString(3));
				Course.setText(result.getString(4));
			}
			else {
				JOptionPane.showMessageDialog(null, "No such ID Exists");
				
			}
		}catch (Exception e1) {
			
		}
	}
}
