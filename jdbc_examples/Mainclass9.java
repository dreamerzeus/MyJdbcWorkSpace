//use of callable statemnt studentupdate()
package jdbc_examples;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import com.mysql.jdbc.Driver;
public class Mainclass9
{
	public static void main(String[] args) 
	{
		Connection con=null;
		ResultSet rs=null;
		CallableStatement clstm=null;
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
			
			String query="call studentUpdateA(?,?,?,?)";
			clstm=con.prepareCall(query);
			clstm.setInt(1,Integer.parseInt(args[0]));
			clstm.setString(2,args[1]);
			clstm.setString(3,args[2]);
			clstm.setString(4,args[3]);
			
			int count=clstm.executeUpdate();
			System.out.println("row affected "+count);
			 if(count>0)
	            {
	            	clstm.close();
	            	String query1="select * from student where reg_no=?";
	            	ps=con.prepareStatement(query1);
	            	ps.setInt(1,Integer.parseInt(args[0]));
	            	rs=ps.executeQuery(); 	
	            	while(rs.next())
	            	{
	            		int reg=rs.getInt("reg_no");
	            		String first=rs.getString("first_name");
	            		String last_name=rs.getString("last_name");
						String job=rs.getString("job");
	            		System.out.println("the registration nos is .."+reg);
	            		System.out.println("the first name is ...."+first);
	            		System.out.println("last name "+last_name);
						System.out.println("job  "+job);
						System.out.println("=========");
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
				    if(clstm!=null)
				    {
				    	clstm.close();
				    }
				    if(rs!=null)
				    {
				    	rs.close();
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