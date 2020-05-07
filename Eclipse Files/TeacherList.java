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

public class TeacherList extends JFrame {

	private JPanel contentPane;
	private JLabel names;
	
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
					TeacherList frame = new TeacherList();
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
	public TeacherList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student List");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 11, 354, 74);
		contentPane.add(lblNewLabel);
		
		names = new JLabel("");
		names.setHorizontalAlignment(SwingConstants.CENTER);
		names.setBounds(10, 85, 595, 251);
		contentPane.add(names);
		
int id=TeacherOptions.getID();
		
		try {
			Connection myconn=connect();
			
			String namesList="";
			
			String query="SELECT * FROM teacherInfo WHERE id=?";
			PreparedStatement pst=myconn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet result=pst.executeQuery();
			
			
			
			if (result.next()) {	
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Something is wrong!");
			}
		}catch (Exception e1) {
			
		}
		
		
	}

}
