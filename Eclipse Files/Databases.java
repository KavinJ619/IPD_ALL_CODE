


import java.sql.*;
import java.util.*;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Database {
	
	public static Connection connect() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/students","root","Legal69!");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void add(String fname, String lname, int id, String course) {
		String sql="INSERT INTO student(First_Name, Last_Name,ID, Course)VALUES(?,?,?,?)";
		try (Connection conn=this.connect()){
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setInt(3, id);
			statement.setString(4, course);
			statement.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void remove(int id) {
		String sql="DELETE FROM student WHERE id=?";
		try (Connection conn=this.connect()){
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(String fname, String lname, int id, String course) {
		String sql="UPDATE student SET First_Name = ?, Last_Name = ?, Course=? WHERE id = ?";
		try (Connection conn=this.connect()){
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, course);
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	public static void main(String[] args) {		
		Database data=new Database();
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Student or Teacher");
		
		String choice=scan.next();
		
		if (choice.equals("s")) {
			try {
				Connection myconn=connect();
				System.out.println("Decide Action: Add, Delete, Update or View");
				String choice1= scan.next();
				
				if (choice1.equals("view")) {
					System.out.println("Enter student ID");
					int studID=scan.nextInt();
					
					String query="SELECT * FROM student WHERE ID="+studID;
					PreparedStatement ps=myconn.prepareStatement(query);
					
					ResultSet result=ps.executeQuery(query);
					try {
						while (result.next()) {
							System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
						}
					}catch (Exception e) {
						System.out.println(e);
					}
					
					
				}
				
				else if (choice1.equals("add")) {
					System.out.println("ID of new student: ");
					int id=scan.nextInt();
					System.out.println("First name of new student: ");
					String fname=scan.next();
					System.out.println("Last Name of new student: ");
					String lname=scan.next();
					System.out.println("Course of new student: ");
					String course=scan.next();
					
					String query="INSERT INTO student(First_Name, Last_Name,ID, Course)VALUES(?,?,?,?)";
					PreparedStatement statement=myconn.prepareStatement(query);
					statement.setString(1, fname);
					statement.setString(2, lname);
					statement.setInt(3, id);
					statement.setString(4, course);
					statement.executeUpdate();
					
				}
				
				else if (choice1.equals("delete")) {
					System.out.println("Enter ID of student to remove: ");
					int id=scan.nextInt();
					String sql="DELETE FROM student WHERE id=?";
					PreparedStatement statement=myconn.prepareStatement(sql);
					statement.setInt(1, id);
					statement.executeUpdate();
				}
				
				else if (choice1.equals("update")) {
					String sql="UPDATE student SET First_Name = ?, Last_Name = ?, Course=? WHERE id = ?";
					System.out.println("Enter ID to update: ");
					int id=scan.nextInt();
					System.out.println("Enter First name to update: ");
					String fname=scan.next();
					System.out.println("Enter Last Name to update: ");
					String lname=scan.next();
					System.out.println("Enter Course to update: ");
					String course=scan.next();
					PreparedStatement ps=myconn.prepareStatement(sql);
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, course);
					ps.setInt(4, id);
					ps.executeUpdate();
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		

		
	}
}

