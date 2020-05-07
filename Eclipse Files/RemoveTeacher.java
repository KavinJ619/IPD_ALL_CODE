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

public class RemoveTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveTeacher frame = new RemoveTeacher();
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
	public RemoveTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove a Teacher");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 27, 415, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID of Teacher to Delete");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(164, 98, 251, 37);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(188, 146, 197, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myconn=connect();
					
					String query="DELETE FROM teacherinfo WHERE id=?";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id.getText()));
					pst.executeUpdate();
					
					String query2="DELETE FROM teacherlogin WHERE id=?";
					PreparedStatement pst2=myconn.prepareStatement(query2);
					pst2.setInt(1, Integer.parseInt(id.getText()));
					pst2.executeUpdate();
					JOptionPane.showMessageDialog(null, "Removed Successfully");
					id.setText("");
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
				
			}
		});
		btnNewButton.setBounds(239, 198, 89, 23);
		contentPane.add(btnNewButton);
	}

}
