import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StudentLoggedIn extends JFrame {

	private JPanel contentPane;
	private static JTextField studID;
	
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
		int id=Integer.parseInt(studID.getText());
		return id;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLoggedIn frame = new StudentLoggedIn();
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
	public StudentLoggedIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Student ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(158, 70, 151, 30);
		contentPane.add(lblNewLabel);
		
		studID = new JTextField();
		studID.setBounds(187, 111, 94, 20);
		contentPane.add(studID);
		studID.setColumns(10);
		
		
		
		JButton StudLogin = new JButton("Login");
		StudLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(studID.getText());
				try {
					Connection myconn=connect();
					String query="SELECT * FROM student WHERE ID=?";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setInt(1, id);
					ResultSet result=pst.executeQuery();
					if (result.next()) {
						JOptionPane.showMessageDialog(null, "Logged in Successfully");
						StudentLogged student=new StudentLogged();
						student.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "No such ID Exists");
						studID.setText("");
					}
				}catch (Exception e1) {
					
				}
				
			}
		});
		StudLogin.setBounds(187, 160, 94, 30);
		contentPane.add(StudLogin);
	}
}
