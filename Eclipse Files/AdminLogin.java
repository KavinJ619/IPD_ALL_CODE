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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private static JTextField username;
	private JPasswordField adminpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	
	public static int getUser() {
		return Integer.parseInt(username.getText());
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 22, 378, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(111, 111, 122, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(111, 175, 122, 25);
		contentPane.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(246, 111, 218, 25);
		contentPane.add(username);
		username.setColumns(10);
		
		adminpass = new JPasswordField();
		adminpass.setBounds(246, 177, 218, 25);
		contentPane.add(adminpass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int user=Integer.parseInt(username.getText());
				String pass=adminpass.getText();
				try {
					Connection myconn=connect();
					String query="SELECT * FROM adminlogin WHERE id=? and adminpass=?";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setInt(1, user);
					pst.setString(2, pass);
					ResultSet result=pst.executeQuery();
					if (result.next()) {
						JOptionPane.showMessageDialog(null, "Logged in Successfully");
						AdminOptions admin12=new AdminOptions();
						admin12.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Logged in unSuccessfully");
					}
				}catch (Exception e1) {
					
				}
			}
		});
		btnNewButton.setBounds(230, 259, 106, 31);
		contentPane.add(btnNewButton);
	}
}
