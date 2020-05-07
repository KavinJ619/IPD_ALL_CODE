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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TeacherSearch extends JFrame {

	private JPanel contentPane;
	private static JTextField tid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherSearch frame = new TeacherSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int getID() {
		int id=Integer.parseInt(tid.getText());
		return id;
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
	public TeacherSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter ID of Teacher:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(57, 11, 308, 46);
		contentPane.add(lblNewLabel);
		
		tid = new JTextField();
		tid.setBounds(106, 94, 229, 20);
		contentPane.add(tid);
		tid.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myconn=connect();
					
					int id=Integer.parseInt(tid.getText());
					
					String query="SELECT * FROM teacherinfo WHERE id=?";
					PreparedStatement pst=myconn.prepareStatement(query);
					pst.setInt(1, id);
					ResultSet result=pst.executeQuery();
					if (result.next()) {
						JOptionPane.showMessageDialog(null, "Login Successfull");
						TeacherSearched student1=new TeacherSearched();
						student1.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "No such ID Exists");
					}
				}catch (Exception ex) {
					
				}
				
			}
		});
		btnNewButton.setBounds(161, 146, 89, 23);
		contentPane.add(btnNewButton);
	}

}
