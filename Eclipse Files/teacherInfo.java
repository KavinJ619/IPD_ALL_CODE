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

public class teacherInfo extends JFrame {

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
					teacherInfo frame = new teacherInfo();
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
	public teacherInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher Information");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 27, 326, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(101, 108, 154, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(101, 147, 154, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Module:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(101, 186, 154, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Qualifications:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(101, 225, 154, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Working Hours:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(101, 264, 154, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ID: ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(10, 335, 32, 25);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("<- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherMenu teacher=new TeacherMenu();
				teacher.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel first = new JLabel("");
		first.setBounds(265, 108, 253, 28);
		contentPane.add(first);
		
		JLabel last = new JLabel("");
		last.setBounds(265, 147, 253, 28);
		contentPane.add(last);
		
		JLabel module = new JLabel("");
		module.setBounds(264, 186, 253, 28);
		contentPane.add(module);
		
		JLabel qual = new JLabel("");
		qual.setBounds(265, 225, 253, 28);
		contentPane.add(qual);
		
		JLabel hours = new JLabel("");
		hours.setBounds(265, 264, 253, 25);
		contentPane.add(hours);
		
		JLabel tid = new JLabel("");
		tid.setBounds(51, 337, 89, 20);
		contentPane.add(tid);
		
		int id=TeacherOptions.getID();
		
		try {
			Connection myconn=connect();
			String query="SELECT * FROM teacherInfo WHERE id=?";
			
			PreparedStatement pst=myconn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet result=pst.executeQuery();
			if (result.next()) {	
				first.setText(result.getString(3));
				last.setText(result.getString(4));
				module.setText(result.getString(2));
				qual.setText(result.getString(5));
				hours.setText(result.getString(6));
				tid.setText(result.getString(1));
			}
			else {
				JOptionPane.showMessageDialog(null, "Something is wrong!");
			}
		}catch (Exception e1) {
			
		}
	}
}
