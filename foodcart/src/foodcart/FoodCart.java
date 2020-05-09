package foodcart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/FoodCart")
public class FoodCart extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//request.setAttribute("foodItems", foodItems);
		
		List<Food> foodItems = null;
		try {
			foodItems = FoodCartDbUtil.getFoodList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("foodItems", foodItems);


		RequestDispatcher dispatcher= request.getRequestDispatcher("show-food.jsp");
		dispatcher.forward(request,response);
	}

	

}
