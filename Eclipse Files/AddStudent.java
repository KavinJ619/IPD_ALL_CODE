import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

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
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add a Student");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(42, 11, 499, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(38, 66, 133, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Course:");
		lblNewLabel_3.setBounds(38, 150, 133, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setBounds(38, 192, 133, 31);
		contentPane.add(lblNewLabel_4);
		
		fname = new JTextField();
		fname.setBounds(132, 66, 133, 31);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(132, 108, 133, 31);
		contentPane.add(lname);
		lname.setColumns(10);
		
		course = new JTextField();
		course.setBounds(132, 150, 133, 31);
		contentPane.add(course);
		course.setColumns(10);
		
		id = new JTextField();
		id.setBounds(132, 192, 133, 31);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Module 1:");
		lblNewLabel_5.setBounds(322, 66, 111, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Module 2:");
		lblNewLabel_6.setBounds(322, 108, 111, 31);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Module 3:");
		lblNewLabel_7.setBounds(322, 150, 111, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Module 4:");
		lblNewLabel_8.setBounds(322, 189, 111, 36);
		contentPane.add(lblNewLabel_8);
		
		mod1 = new JTextField();
		mod1.setBounds(408, 66, 133, 31);
		contentPane.add(mod1);
		mod1.setColumns(10);
		
		mod2 = new JTextField();
		mod2.setBounds(408, 108, 133, 31);
		contentPane.add(mod2);
		mod2.setColumns(10);
		
		mod3 = new JTextField();
		mod3.setBounds(408, 150, 133, 31);
		contentPane.add(mod3);
		mod3.setColumns(10);
		
		mod4 = new JTextField();
		mod4.setBounds(408, 192, 133, 31);
		contentPane.add(mod4);
		mod4.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Last Name:");
		lblNewLabel_9.setBounds(38, 108, 133, 31);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myconn=connect();
					String query="INSERT INTO student(ID, First_Name, Last_Name, Course)VALUES(?,?,?,?)";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id.getText()));
					pst.setString(2, fname.getText());
					pst.setString(3, lname.getText());
					pst.setString(4, course.getText());
					pst.executeUpdate();
					String query1="INSERT INTO studentmodules(student_id,module1,module2, module3, module4)VALUES(?,?,?,?,?)";
					PreparedStatement pst1=myconn.prepareStatement(query1);
					pst1.setInt(1, Integer.parseInt(id.getText()));
					pst1.setString(2, mod1.getText());
					pst1.setString(3, mod2.getText());
					pst1.setString(4, mod3.getText());
					pst1.setString(5, mod4.getText());
					pst1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added Successfully");
					id.setText("");
					mod1.setText("");
					mod2.setText("");
					mod3.setText("");
					mod4.setText("");
					fname.setText("");
					lname.setText("");
					course.setText("");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton.setBounds(229, 271, 133, 31);
		contentPane.add(btnNewButton);
	}
}
