//by the use of properties file
package jdbc_examples;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.sql.ResultSet;
public class Mainclass3 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try 
		{
			Driver drf = new Driver();
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/BECM8?";
			String filepath="F:/java/JDBC PROGRAMS/new.properties";
			FileReader reader=new FileReader(filepath);
			Properties pr=new Properties();
			pr.load(reader);
			con=DriverManager.getConnection(dburl, pr);
			
			String query="select * from student";
			st=con.createStatement();
			rs=st.executeQuery(query);
			
			while(rs.next())
			{
				int reg_no=rs.getInt("reg_no");
				String first_name=rs.getString("first_name");
				String last_name=rs.getString("last_name");
				String job=rs.getString("job");
				
				System.out.println("reg no "+reg_no);
				System.out.println("first name "+first_name);
				System.out.println("last name "+last_name);
				System.out.println("job  "+job);
				System.out.println("=========");
			}
		}
		catch (SQLException | IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
				try 
			{
					if(con!=null)
					    con.close();
					if(st!=null)
						st.close();
					if(rs!=null)
						rs.close();
									
			}
				catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}
	}
}