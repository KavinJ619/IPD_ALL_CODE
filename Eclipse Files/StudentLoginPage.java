import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class StudentLoginPage extends JFrame {

	private JPanel contentPane;
	private static JTextField username;
	private JPasswordField password;
	
	public static Connection connect() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/students","root","Legal69!");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static int getID() {
		String user=username.getText();
		return Integer.parseInt(user);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLoginPage frame = new StudentLoginPage();
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
	public StudentLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(126, 136, 140, 47);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(296, 147, 163, 27);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(126, 215, 140, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Brookes Student Login");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(208, 61, 182, 64);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=username.getText();
				String pass=password.getText();
				try {
					Connection myconn=connect();
					String query="SELECT * FROM studentlogin WHERE username=? and password=?";
					
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setString(1, user);
					pst.setString(2, pass);
					ResultSet result=pst.executeQuery();
					if (result.next()) {
						JOptionPane.showMessageDialog(null, "Logged in Successfully");
						StudentOptions student1=new StudentOptions();
						student1.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Logged in unSuccessfully");
					}
				}catch (Exception e1) {
					
				}
				
				
			}
		});
		btnNewButton.setBounds(244, 278, 117, 37);
		contentPane.add(btnNewButton);
		
		password = new JPasswordField();
		password.setBounds(296, 217, 163, 27);
		contentPane.add(password);
		
		JButton btnNewButton_1 = new JButton("Forgot Your Password?");
		btnNewButton_1.setBounds(208, 342, 182, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<- Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextingJFrame student123=new TextingJFrame();
				student123.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
