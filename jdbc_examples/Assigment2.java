//using scanner
package jdbc_examples;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;
public class Assigment2
{
	
	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		ResultSet rs1=null;
		ResultSet rs2=null;
		Statement st1=null;
		Statement st2=null;
		PreparedStatement ps=null;
		Connection con=null;
		try
		{	
			Driver drf	= new Driver();
			DriverManager.registerDriver(drf);
			
			String dburl="jdbc:mysql://localhost:3306/BECM8?";
			String filepath="F:/jdbc/JDBC PROGRAMS/new.properties";
			FileReader reader=new FileReader(filepath);
			Properties pr=new Properties();
		    pr.load(reader);
			con=DriverManager.getConnection(dburl, pr);
			
			String query=" insert into guardian "+"value(?,?,?,?)";
			ps=con.prepareStatement(query);
			System.out.println("input data for guradian table");
			System.out.println("enter the reg nos ");
			int a=sc1.nextInt();
			ps.setInt(1,(a));
			System.out.println("enter guradian first name");
			String b=sc1.next();
			ps.setString(2, b);
			System.out.println("enter the guardian middle name");
			String c=sc1.next();
			ps.setString(3, c);
			System.out.println("enter the guradian last name ");
			String d=sc1.next();
			ps.setString(4, d);
			int count1=ps.executeUpdate();
			
			ps.close();
			String query2=" insert into student_otherinfo "+"value(?,?,?)";
			ps=con.prepareStatement(query2);
			System.out.println("input data for student_other info table");
			System.out.println("enter the reg nos ");
			int e=sc1.nextInt();
			ps.setInt(1,(e));
			System.out.println("enter whther  admin/not ");
			String f=sc1.next();
			ps.setString(2, f);
			System.out.println("enter the password");
			String g=sc1.next();
			ps.setString(3, g);
			
			int count=ps.executeUpdate();
			if(count1==1)
			{
				String query3=" select * from guardian ";
				st1=con.createStatement();
				rs1=st1.executeQuery(query3);
				
				while( rs1.next())
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
				}
			}
			if(count==1)
			{
				String query4="select * from student_otherinfo";
				st2=con.createStatement();
				rs2=st2.executeQuery(query4);
                 
				while(rs2.next())
				{
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
				    if(ps!=null)
				    {
				    	ps.close();
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
				    sc1.close();
				    	
				    
				} 
				
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}