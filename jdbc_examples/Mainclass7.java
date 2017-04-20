//using callable statemenst and calling getAllStudent()
package jdbc_examples;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;
public class Mainclass7 
{	
	public static void main(String[] args)
	{
		Connection con=null;
		CallableStatement clstmt=null;
		ResultSet rs=null;
		try
		{
			Driver drf = new Driver();
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/BECM8?";
			String filepath="F:/jdbc/JDBC PROGRAMS/new.properties";
			FileReader reader=new FileReader(filepath);
			Properties pr=new Properties();
			pr.load(reader);
			con=DriverManager.getConnection(dburl, pr);
			
			String query="call getAllStudent";
			clstmt=con.prepareCall(query);
			rs=clstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println("we found..........");
				int r=rs.getInt("reg_no");
				String first_name=rs.getString("first_name");
				String last_name=rs.getString("last_name");
				String job=rs.getString("job");
				
				System.out.println("reg no "+r);
				System.out.println("first name "+first_name);
				System.out.println("last name "+last_name);
				System.out.println("job  "+job);
				System.out.println("-----------------");
			}
		}
		catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			{
				try 
				{
					if(con!=null)
					{
					    con.close();
					}
				    if(clstmt!=null)
				    {
				    	clstmt.close();
				    }
				    if(rs!=null)
				    {
				    	rs.close();
				    }
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}

}
