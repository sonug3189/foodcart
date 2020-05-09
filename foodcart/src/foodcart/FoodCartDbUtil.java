package foodcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class FoodCartDbUtil 
{
	public static List<Food> getFoodList() throws ClassNotFoundException,SQLException 
	{
		ArrayList<Food>food=new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcart","root","root123");
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcart","root","root123");
		
		Statement st=con.createStatement();
		String query="select* from foodcart";
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next())
		{
			int id=rs.getInt(1);
			String item=rs.getString(2);
			int price=rs.getInt(3);
			Food f=new Food(id,item,price);
			food.add(f);
		}
		
		return food;
	}
}
