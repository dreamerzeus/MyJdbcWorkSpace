//use of prepared statemnt and passing 1 unknown value
package jdbc_examples;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;;
public class Mainclass5 
{
	public static void main(String[] args)
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
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
			
			String query=" select * from student "+" where reg_no=? ";
			ps=con.prepareStatement(query);
			String reg=args[0];
			int reg_no1=Integer.parseInt(reg);
			ps.setInt(1,reg_no1);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println("we found..........");
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
			else
			{
				System.err.println("reg no not found");
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
				    if(ps!=null)
				    {
				    	ps.close();
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