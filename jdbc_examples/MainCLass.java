///using statement and executequery()
package jdbc_examples;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MainCLass 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try 
		{
			//load the driver
			//we are creating the object of driver class by importing com.mysql.jdbc.Driver
			//pass ref of the driver in drivermanager class of java and registring it by register()
			Driver drvref = new Driver();
			DriverManager.registerDriver(drvref);
			
			//get db connection via driver
			//getting drivermanager url from manual and passing the string to getconnection() present inside driver manger
			//such that the return type is connection of connection interface
			//line 25 con showing runtime poly getconnection abstr
			String dbUrl="jdbc:mysql://localhost:3306/BECM8?" + "user=root&password=root"; 
			con=DriverManager.getConnection(dbUrl);
			
			//issue sql quiries via connection
			String query="select * from student ";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			//processing all sql query
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
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//close all jdbc object
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
