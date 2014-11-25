package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.FileIO;
import model.Automotive;


public class GetAutomotiveOptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Automotive auto ;
	
	//Reading the Automotive object in the init function.	
	public void init() throws ServletException 
	{	
		try
		{

			auto = new Automotive();
			 
			FileIO.readAndSetOptions(auto);
			System.out.print(auto);
		}
		catch( Exception e)
		{
			System.out.print("Exception = " + e) ;
		}
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAutomotiveOptionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Adding auto object in the session attribute so that it may accessible further in the jsp 
		request.getSession().setAttribute("auto", auto);
		
		// Forwarding the request to jsp page to send dynamically generated html response to client.
		request.getRequestDispatcher("/automotiveOptions").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
