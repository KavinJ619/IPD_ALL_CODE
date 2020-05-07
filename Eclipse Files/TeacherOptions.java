import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TeacherOptions extends JFrame {

	private JPanel contentPane;
	private static JTextField tusername;
	private JPasswordField tpassword;
	
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
		String user=tusername.getText();
		return Integer.parseInt(user);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherOptions frame = new TeacherOptions();
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
	public TeacherOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Brookes Teacher Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setBounds(172, 11, 244, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=tusername.getText();
				String password=tpassword.getText();
				try {
					Connection myconn=connect();
					String query="SELECT * FROM teacherlogin WHERE id=? and tpassword=?";
					
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setString(1, username);
					pst.setString(2, password);
					ResultSet result=pst.executeQuery();
					if (result.next()) {
						JOptionPane.showMessageDialog(null, "Logged in Successfully");
						TeacherMenu student1=new TeacherMenu();
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
		btnNewButton.setBounds(237, 231, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<- Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextingJFrame testing=new TextingJFrame();
				testing.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(-2, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(135, 90, 89, 25);
		contentPane.add(lblNewLabel_1);
		
		tusername = new JTextField();
		tusername.setBounds(264, 92, 193, 22);
		contentPane.add(tusername);
		tusername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(135, 157, 89, 25);
		contentPane.add(lblNewLabel_2);
		
		tpassword = new JPasswordField();
		tpassword.setBounds(264, 159, 193, 23);
		contentPane.add(tpassword);
	}
}
