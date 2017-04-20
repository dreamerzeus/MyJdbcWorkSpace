//use of transcation 
package jdbc_examples;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;
public class Mainclass10 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		PreparedStatement ps3=null;
		ResultSet rs=null;
		try 
		{
			con.setAutoCommit(false);//step`1
			
			Driver drf = new Driver();
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/BECM8?";
			String filepath="F:/jdbc/JDBC PROGRAMS/new.properties";
			FileReader reader=new FileReader(filepath);
			Properties pr=new Properties();
			pr.load(reader);
			con=DriverManager.getConnection(dburl, pr);
			
			String query1="insert into student"+"values(?,?,?,?)";
			ps1=con.prepareStatement(query1);
			ps1.setInt(1, Integer.parseInt(args[0]));
			ps1.setString(2, args[1]);
			ps1.setString(3, args[2]);
			ps1.setString(4, args[3]);
			int count1=ps1.executeUpdate();
			System.out.println("student got affected");
			
			String query2="insert into student"+"values(?,?,?,?)";
			ps2=con.prepareStatement(query1);
			ps2.setInt(1, Integer.parseInt(args[0]));
			ps2.setString(2, args[1]);
			ps2.setString(3, args[2]);
			ps2.setString(4, args[3]);
			int count2=ps2.executeUpdate();
			System.out.println("student got affected 2nd time");
			
			String query3="insert into student"+"values(?,?,?,?)";
			ps3=con.prepareStatement(query1);
			ps3.setInt(1, Integer.parseInt(args[0]));
			ps3.setString(2, args[1]);
			ps3.setString(3, args[2]);
			ps3.setString(4, args[3]);
			
			//rutime exceptions
			int i=100/0;
			
			int count3=ps3.executeUpdate();
			System.out.println("student got affected 3rd time");
			
			//if no exception
			con.commit();
			
			System.out.println("profile created");
		} 
		catch (SQLException | IOException e)
		{
			try
			{
				//if exception happens
				con.rollback();
				
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			System.err.println("profile cannot be created/");
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
				    if(ps1!=null)
				    {
				    	ps1.close();
				    }
				    if(rs!=null)
				    {
				    	rs.close();
				    }
				    if(ps2!=null)
				    {
				    	ps2.close();
				    }
				    if(ps3!=null)
				    {
				    	ps3.close();
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
