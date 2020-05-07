import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class UpdateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField course;
	private JTextField id;
	private JTextField mod1;
	private JTextField mod2;
	private JTextField mod3;
	private JTextField mod4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
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
	public UpdateStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update a Student");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-84, 11, 499, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(322, 44, 133, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Course:");
		lblNewLabel_3.setBounds(322, 128, 133, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setBounds(43, 86, 133, 31);
		contentPane.add(lblNewLabel_4);
		
		fname = new JTextField();
		fname.setBounds(408, 44, 133, 31);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(408, 86, 133, 31);
		contentPane.add(lname);
		lname.setColumns(10);
		
		course = new JTextField();
		course.setBounds(408, 128, 133, 31);
		contentPane.add(course);
		course.setColumns(10);
		
		id = new JTextField();
		id.setBounds(98, 86, 133, 31);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Module 1:");
		lblNewLabel_5.setBounds(322, 173, 111, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Module 2:");
		lblNewLabel_6.setBounds(322, 215, 111, 31);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Module 3:");
		lblNewLabel_7.setBounds(322, 257, 111, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Module 4:");
		lblNewLabel_8.setBounds(322, 299, 111, 36);
		contentPane.add(lblNewLabel_8);
		
		mod1 = new JTextField();
		mod1.setBounds(408, 173, 133, 31);
		contentPane.add(mod1);
		mod1.setColumns(10);
		
		mod2 = new JTextField();
		mod2.setBounds(408, 215, 133, 31);
		contentPane.add(mod2);
		mod2.setColumns(10);
		
		mod3 = new JTextField();
		mod3.setBounds(408, 257, 133, 31);
		contentPane.add(mod3);
		mod3.setColumns(10);
		
		mod4 = new JTextField();
		mod4.setBounds(408, 302, 133, 31);
		contentPane.add(mod4);
		mod4.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Last Name:");
		lblNewLabel_9.setBounds(322, 86, 133, 31);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myconn=connect();
					
					String query="UPDATE student SET first_name=?, last_name=?, course=? WHERE ID=?";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setString(1, fname.getText());
					pst.setString(2, lname.getText());
					pst.setString(3, course.getText());
					pst.setInt(4, Integer.parseInt(id.getText()));
					pst.executeUpdate();
					
					String query1="UPDATE studentmodules SET module1=?, module2=?, module3=?, module4=? WHERE student_id=?";
					PreparedStatement pst1=myconn.prepareStatement(query1);
					pst1.setString(1, mod1.getText());
					pst1.setString(2, mod2.getText());
					pst1.setString(3, mod3.getText());
					pst1.setString(4, mod4.getText());
					pst1.setInt(5, Integer.parseInt(id.getText()));
					pst1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Updated Successfully");
					id.setText("");
					mod1.setText("");
					mod2.setText("");
					mod3.setText("");
					mod4.setText("");
					fname.setText("");
					lname.setText("");
					course.setText("");
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
		btnNewButton.setBounds(98, 261, 116, 27);
		contentPane.add(btnNewButton);
	}

}
