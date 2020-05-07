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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField wh;
	private JTextField mod;
	private JTextField qual;
	private JTextField id;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher frame = new AddTeacher();
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
	public AddTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add a Teacher");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(106, 11, 349, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, 73, 154, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(35, 109, 154, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Work Hours:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(35, 145, 154, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Module:");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(35, 181, 154, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Qualifications");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(35, 217, 154, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ID:");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(35, 257, 154, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password:");
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(35, 293, 154, 20);
		contentPane.add(lblNewLabel_7);
		
		fname = new JTextField();
		fname.setBounds(199, 73, 154, 25);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(199, 113, 154, 25);
		contentPane.add(lname);
		lname.setColumns(10);
		
		wh = new JTextField();
		wh.setBounds(199, 149, 154, 25);
		contentPane.add(wh);
		wh.setColumns(10);
		
		mod = new JTextField();
		mod.setBounds(199, 185, 154, 25);
		contentPane.add(mod);
		mod.setColumns(10);
		
		qual = new JTextField();
		qual.setBounds(199, 221, 154, 25);
		contentPane.add(qual);
		qual.setColumns(10);
		
		id = new JTextField();
		id.setBounds(199, 257, 154, 25);
		contentPane.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(199, 295, 154, 18);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Add Teacher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myconn=connect();
					String query="INSERT INTO teacherlogin(id, tpassword)VALUES(?,?)";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id.getText()));
					pst.setString(2, pass.getText());
					pst.executeUpdate();
					String query1="INSERT INTO teacherinfo(id,module,first_name, last_name, qualifications, work_hours)VALUES(?,?,?,?,?,?)";
					PreparedStatement pst1=myconn.prepareStatement(query1);
					pst1.setInt(1, Integer.parseInt(id.getText()));
					pst1.setString(2, mod.getText());
					pst1.setString(3, fname.getText());
					pst1.setString(4, lname.getText());
					pst1.setString(5, qual.getText());
					pst1.setString(6, wh.getText());
					pst1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added Successfully");
					id.setText("");
					mod.setText("");
					fname.setText("");
					lname.setText("");
					qual.setText("");
					wh.setText("");
					pass.setText("");
				}
				catch(Exception ex) {
					
				}
			}
		});
		btnNewButton.setBounds(393, 277, 136, 36);
		contentPane.add(btnNewButton);
	}

}
