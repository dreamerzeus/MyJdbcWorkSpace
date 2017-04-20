//inserting value into guradian  and student other info
package jdbc_examples;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Driver;
public class Assignment1
{
	public static void main(String[] args) 
	{		
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
	    Statement st1=null;
		Statement st2=null;
	    ResultSet rs1=null;
		ResultSet rs2=null;
		Connection con=null;
		try 
		{
			Driver drf= new Driver();
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/BECM8?";
			String filepath="F:/jdbc/JDBC PROGRAMS/new.properties";
			FileReader reader=new FileReader(filepath);
			Properties pr=new Properties();
			pr.load(reader);
			con=DriverManager.getConnection(dburl, pr);
			
			String query=" insert into guardian "+"value(?,?,?,?)";
			ps1=con.prepareStatement(query);
			ps1.setInt(1, Integer.parseInt(args[0]));
			ps1.setString(2, args[1]);
			ps1.setString(3, args[2]);
			ps1.setString(4, args[3]);
			int count=ps1.executeUpdate();
			

			String query2=" insert into student_otherinfo "+"value(?,?,?)";
			ps2=con.prepareStatement(query2);
			ps2.setInt(1, Integer.parseInt(args[0]));
			ps2.setString(2, args[1]);
			ps2.setString(3, args[2]);
			 count=ps2.executeUpdate();
			
			System.out.println("your profile have been updated"+count);
			if(count>0)
			{
				ps1.close();
				ps2.close();
				String query3=" select * from guardian ";
				String query4="select * from student_otherinfo";
				st1=con.createStatement();
				st2=con.createStatement();
				rs1=st1.executeQuery(query3);
				rs2=st2.executeQuery(query4);
				
				while( rs2.next())
				{
					System.out.println("guradian table ");
					int r=rs1.getInt("regno");
					String firstname=rs1.getString("gFirstName");
					String middlename=rs1.getString("gMiddleName");
				    String lastname=rs1.getString("gLastName");
					
					System.out.println("reg no "+r);
					System.out.println("first name "+firstname);
				    System.out.println("mddle name "+middlename);
				    System.out.println("last name  "+lastname);
				    System.out.println("=========");
					
					System.out.println("student other info details ");
					int reg=rs2.getInt("regno");
					String ia=rs2.getString("isAdmin");
					String pss=rs2.getString("password");
					
					System.out.println("the reg "+reg);
					System.out.println("is the fellow admin "+ia);
					System.out.println("the password is "+pss);
				}	
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
				    if(ps1!=null)
				    {
				    	ps1.close();
				    }
				    if(ps2!=null)
				    {
				    	ps2.close();
				    }
				    if(rs1!=null)
				    {
				    	rs1.close();
				    }
				    if(rs2!=null)
				    {
				    	rs2.close();
				    }
				    if(st1!=null)
				    {
				    	st1.close();
				    }
				    if(st2!=null)
				    {
				    	st2.close();
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
