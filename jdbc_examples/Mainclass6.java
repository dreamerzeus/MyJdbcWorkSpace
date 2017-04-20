//using prepared statemnts and adding values multiple
package jdbc_examples;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class Mainclass6 
{
	public static void main(String[] args) 
	{		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try 
		{
			Driver drf=new Driver();
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/BECM8";
			String filepath="F:/jdbc/JDBC PROGRAMS/new.properties";
			FileReader reader=new FileReader(filepath);
			Properties pr=new Properties();
			pr.load(reader);
			con=DriverManager.getConnection(dburl, pr);
			
			String query=" insert into student "+"value(?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(args[0]));
			ps.setString(2, args[1]);
			ps.setString(3, args[2]);
			ps.setString(4, args[3]);
			int count=ps.executeUpdate();
			
			System.out.println("your profile have been updated"+count);
			
			if(count>0)
			{
				ps.close();
				String query1=" select * from student "+" where reg_no=? ";
				ps=con.prepareStatement(query1);
				
				String reg=args[0];
				int reg_no1=Integer.parseInt(reg);
				ps.setInt(1,reg_no1);
				rs=ps.executeQuery();
				
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
					System.out.println("=========");
				}
			}
		} 
		catch (SQLException | IOException e) 
		{
			System.out.println("cant u");
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
				    if(ps!=null)
				    {
				    	ps.close();
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