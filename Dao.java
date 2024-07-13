package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Dao 
{
	private Connection con;
	public Dao()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gecb2","root","harika@123");
			System.out.println("Connected");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//i want to store the register form details in database
	public boolean doRegister(String email,String password,String phone,String address)
	{
		boolean flag=false;
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into register(email,password,phone,address) values(?,?,?,?)");
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			pstmt.setString(3,phone);
			pstmt.setString(4,address);
			int r=pstmt.executeUpdate();
			if(r==1)
				flag=true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return flag;
	}
	
	public static void main(String[] args) {
		new Dao();
	}
}