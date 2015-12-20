

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteItem
 */
@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String id = (String)request.getParameter("dl");
		DynamoDBConnect db =  new DynamoDBConnect();
		db.deleteItem(Integer.valueOf(id));
		
		
		
		
		

        
        	ArrayList<ProductInfo> temp = new ArrayList<ProductInfo>();
        	ArrayList<String> names = db.getAllItems("Name");
        	ArrayList<String> ids = db.getAllItems("Id");
        	ArrayList<String> price = db.getAllItems("Price");
        	
        	for(int i=0;i<10;i++){
        		temp.add(new ProductInfo(names.get(i), ids.get(i), price.get(i)));
        	}
        	
        	
//        	temp.add(new ProductInfo("MacBook","1","$900"));
//        	temp.add(new ProductInfo("Books","4","$56"));
//        	temp.add(new ProductInfo("GiftCard","7","$100"));
        	
        	
        	request.setAttribute("info", temp);
        	
        	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/Items.jsp");
        	RequetsDispatcherObj.forward(request, response);

		
		
		
		
		
		
		
		
	}

}
