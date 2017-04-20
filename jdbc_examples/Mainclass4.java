//use of execute () and getResultSet() n getUpdateCount()
package jdbc_examples;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;
public class Mainclass4
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/BECM8?";
			String filepath="F:/jdbc/JDBC PROGRAMS/new.properties";
			FileReader reader=new FileReader(filepath);
			Properties pr=new Properties();
			pr.load(reader);
			con=DriverManager.getConnection(dburl, pr);
			
			String query="select * from student";
			st=con.createStatement();
			boolean br=st.execute(query);
			
			if(br)
			{
				rs=st.getResultSet();
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
			
			System.out.println("use of getupdatecount method ");
			int count=st.getUpdateCount();
			System.out.println("the nos of row affected is  "+count);
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
				    if(st!=null)
				    {
				    	st.close();
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