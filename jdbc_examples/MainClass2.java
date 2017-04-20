//statemnet with execute update()
package jdbc_examples;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MainClass2
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		try
		{
			//step1
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			//step2
			String dbUrl="jdbc:mysql://localhost:3306/BECM8?" + "user=root&password=root"; 
			con=DriverManager.getConnection(dbUrl);
			
			//step3
			String query=" insert into student "+" values(8,'yagnya','dutta','shakti') ";
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			
			//step4
			System.out.println("all row affected "+count);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
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
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

}