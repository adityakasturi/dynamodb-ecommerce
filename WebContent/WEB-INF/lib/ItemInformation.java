

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemInformation
 */
@WebServlet("/ItemInformation")
public class ItemInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//DynamoDBConnect db = new DynamoDBConnect();
		/*
		parser p = new parser();
		ArrayList<String> specs= p.getObjects(db.getItemJSON(38796));
		
		 String h = request.getParameter("data");		
		//String value = request.getParameter("test");
				//String value2 = request.getParameter("ghj");
		 request.setAttribute("details", specs);
     	
     	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/ProductDetails.jsp");
     	RequetsDispatcherObj.forward(request, response);
		 
		 
		 //response.getWriter().append(h);
		  * 
		  */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		DynamoDBConnect db = new DynamoDBConnect();
		DynamoDBTest a = new DynamoDBTest();
		
		parser p = new parser();
		String h = request.getParameter("data");	
		NewProductInfo specs= p.getObjects(a.check(Integer.parseInt(h)));
		specs.setId(h);
		 
		//String value = request.getParameter("test");
				//String value2 = request.getParameter("ghj");
		 request.setAttribute("details", specs);
     	
     	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/ProductDetails.jsp");
     	RequetsDispatcherObj.forward(request, response);
		
		
		
	}

}
