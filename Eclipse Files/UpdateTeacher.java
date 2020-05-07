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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField mod;
	private JTextField qual;
	private JTextField wh;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateTeacher frame = new UpdateTeacher();
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
	public UpdateTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Existing Teachers");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 21, 380, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(275, 81, 164, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel dsadsa = new JLabel("Last Name:");
		dsadsa.setBounds(275, 120, 164, 28);
		contentPane.add(dsadsa);
		
		JLabel lblNewLabel_3 = new JLabel("Module:");
		lblNewLabel_3.setBounds(275, 159, 164, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Qualifications:");
		lblNewLabel_4.setBounds(275, 198, 164, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Work Hours:");
		lblNewLabel_5.setBounds(275, 237, 164, 28);
		contentPane.add(lblNewLabel_5);
		
		fname = new JTextField();
		fname.setBounds(386, 81, 164, 28);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(386, 120, 164, 28);
		contentPane.add(lname);
		lname.setColumns(10);
		
		mod = new JTextField();
		mod.setBounds(386, 159, 164, 28);
		contentPane.add(mod);
		mod.setColumns(10);
		
		qual = new JTextField();
		qual.setBounds(386, 198, 164, 28);
		contentPane.add(qual);
		qual.setColumns(10);
		
		wh = new JTextField();
		wh.setBounds(386, 237, 164, 28);
		contentPane.add(wh);
		wh.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ID:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(64, 103, 141, 28);
		contentPane.add(lblNewLabel_6);
		
		id = new JTextField();
		id.setBounds(74, 142, 131, 28);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myconn=connect();
					
					String query="UPDATE teacherinfo SET first_name=?, last_name=?, module=?, qualifications=?, work_hours=? WHERE id=?";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setString(1, fname.getText());
					pst.setString(2, lname.getText());
					pst.setString(3, mod.getText());
					pst.setString(4, qual.getText());
					pst.setString(5, wh.getText());
					pst.setInt(6, Integer.parseInt(id.getText()));
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Updated Successfully");
					id.setText("");
					mod.setText("");
					fname.setText("");
					lname.setText("");
					qual.setText("");
					wh.setText("");
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
		btnNewButton.setBounds(224, 289, 89, 23);
		contentPane.add(btnNewButton);
	}

}
