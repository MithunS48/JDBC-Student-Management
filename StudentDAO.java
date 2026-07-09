import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	DBConnection con=new DBConnection();
	Connection c=con.getConnection();
	
	public void addStudent(Student s)
	{
		String sql="Insert into student values(?,?,?)";
		
		try {
			
			
			
			
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, s.getId());
	        ps.setString(2, s.getName());
	        ps.setInt(3, s.getAge());
	        int i=ps.executeUpdate();
	        
	        if(i>0)System.out.println("student data inserted");
	        
	       
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void viewStudent()
	{
		String sql="Select *from student";
		try {
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet re=ps.executeQuery();
			System.out.println("ID "+"age "+"name");
			while(re.next())
			{
				System.out.println(re.getInt("ID")
								+"  "+re.getInt("age")+"  "
								+re.getString("name") );

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
	}

	public void searchById(int id)
	{
		String sql="select age,name from student where id=?";
		try {
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet re=ps.executeQuery();
			System.out.println("age "+"name");
			while(re.next())
			{
				System.out.println(+re.getInt("age")+"  "
								+re.getString("name") );

			}

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}

	}

	public void updateStudent(Student s) {

    String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";

    try {

        PreparedStatement ps = c.prepareStatement(sql);

        ps.setString(1, s.getName());
        ps.setInt(2, s.getAge());
        ps.setInt(3, s.getId());

        int row = ps.executeUpdate();

        if (row > 0) {
            System.out.println("Student Updated Successfully");
        } else {
            System.out.println("Student Not Found");
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
public void deleteStudent(int id) {

    String sql = "DELETE FROM student WHERE id = ?";

    try {

        PreparedStatement ps = c.prepareStatement(sql);

        ps.setInt(1, id);

        int row = ps.executeUpdate();

        if (row > 0) {
            System.out.println("Student Deleted Successfully");
        } else {
            System.out.println("Student Not Found");
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
	
}

}
