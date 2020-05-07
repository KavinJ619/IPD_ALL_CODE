import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentModules extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentModules frame = new studentModules();
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
	public studentModules() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Module 1:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel.setBounds(64, 47, 82, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Module 2:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_1.setBounds(64, 92, 82, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Module 3:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_2.setBounds(64, 140, 82, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Module 4:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_3.setBounds(64, 194, 82, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel module1 = new JLabel("");
		module1.setBounds(156, 47, 197, 22);
		contentPane.add(module1);
		
		JLabel module2 = new JLabel("");
		module2.setBounds(156, 97, 197, 22);
		contentPane.add(module2);
		
		JLabel module3 = new JLabel("");
		module3.setBounds(156, 145, 197, 22);
		contentPane.add(module3);
		
		JLabel module4 = new JLabel("");
		module4.setBounds(156, 194, 197, 22);
		contentPane.add(module4);
		
		JButton btnNewButton = new JButton("<- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentOptions student12= new StudentOptions();
				student12.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		int id=StudentLoginPage.getID();
		try {
			Connection myconn=connect();
			String query="SELECT * FROM studentmodules WHERE student_id=?";
			PreparedStatement pst=myconn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet result=pst.executeQuery();
			if (result.next()) {
				module1.setText(result.getString(2));
				module2.setText(result.getString(3));
				module3.setText(result.getString(4));
				module4.setText(result.getString(5));
			}
			else {
				JOptionPane.showMessageDialog(null, "No such ID Exists");
				
			}
		}catch (Exception e1) {
			
		}
	}
}
