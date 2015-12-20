

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateNewRecord
 */
@WebServlet("/CreateNewRecord")
public class CreateNewRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewRecord() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String rec = request.getParameter("record");
//		response.getWriter().append("Served at: ").append(rec);
		
		String attributes[] = rec.split(",");
		ArrayList<String> insertNames = new ArrayList<String>();
		ArrayList<String> insertValues = new ArrayList<String>();
		for(int i=0;i<attributes.length;i++){
			String array[] = attributes[i].split(":");
			insertNames.add(array[0]);
			insertValues.add(array[1]);
		}
		
		DynamoDBConnect dynamo = new DynamoDBConnect();
		
		dynamo.putItem(insertNames, insertValues);
		
		ArrayList<ProductInfo> temp = new ArrayList<ProductInfo>();
    	ArrayList<String> names = dynamo.getAllItems("Name");
    	ArrayList<String> ids = dynamo.getAllItems("Id");
    	ArrayList<String> price = dynamo.getAllItems("Price");
    	
    	for(int i=0;i<10;i++){
    		temp.add(new ProductInfo(names.get(i), ids.get(i), price.get(i)));
    	}
    	
    	request.setAttribute("info", temp);
    	
    	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/Items.jsp");
    	RequetsDispatcherObj.forward(request, response);
    	
	}

}
