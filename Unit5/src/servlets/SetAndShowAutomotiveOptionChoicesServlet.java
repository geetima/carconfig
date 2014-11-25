package servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Automotive;

public class SetAndShowAutomotiveOptionChoicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetAndShowAutomotiveOptionChoicesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the automotive object from session attribute and set the  choices based on user selection.
		Automotive auto = (Automotive) request.getSession().getAttribute("auto") ;
		if(auto != null)
		{
			Iterator<String> optionSetIter = auto.getOptionSetNamesIterator(auto.getOptionSetMap()) ;
    		if(optionSetIter != null)
			{
    			while(optionSetIter.hasNext()) 	    					
		    	{
	    			String element = optionSetIter.next();
	    			String choice = request.getParameter(element) ;
	    			if(choice != null)
	    			{
	    				try
	    				{
	    					auto.setOptionChoice(element, choice);
	    				}
	    				catch(Exception e)
	    				{
	    					System.out.print(e);
	    				}
	    			}
		    	}
			}
    		
    		// Forward request to new jsp to display details of selected auto with option choices selected and prices.
    		request.getRequestDispatcher("/showAutomotiveSelection").forward(request, response);
		}
	}
}