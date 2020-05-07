import java.sql.*;
import java.util.*;
public class Lecturer {
	
	public static Database students;
	
	public static void display(String courseName) {
		try {
			Connection conn=students.connect();
			String query="SELECT * FROM StudentData";
			PreparedStatement ps=conn.prepareStatement(query);
		
			ResultSet result=ps.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		display("Comp");
	}

}
