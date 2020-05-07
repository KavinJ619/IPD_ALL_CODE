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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RemoveStudent extends JFrame {

	private JPanel contentPane;
	private JTextField studID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveStudent frame = new RemoveStudent();
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
	public RemoveStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove a Student");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 23, 372, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID of student to Delete");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(138, 99, 372, 58);
		contentPane.add(lblNewLabel_1);
		
		studID = new JTextField();
		studID.setBounds(201, 168, 247, 26);
		contentPane.add(studID);
		studID.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Connection myconn=connect();
					int id=Integer.parseInt(studID.getText());
					String query1="DELETE FROM studentmodules WHERE student_id=?";
					PreparedStatement pst1;
					pst1 = myconn.prepareStatement(query1);
					pst1.setInt(1, id);
					pst1.executeUpdate();
					String query="DELETE FROM student WHERE ID=?";
					PreparedStatement pst;
					pst = myconn.prepareStatement(query);
					pst.setInt(1, id);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton.setBounds(267, 223, 109, 38);
		contentPane.add(btnNewButton);
	}
}
