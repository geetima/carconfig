<%@ page import="java.util.*,model.*" %>


<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h2>Here are the details of the car you selected.</h2>


<%
     Automotive auto = (Automotive) session.getAttribute("auto");
%>
	<table border=1 >
	
	<tr>
	<td><%= auto.getMake() %> <%= auto.getModel() %></td>
	<td>Base Price</td>
	<td><%= auto.getBasePrice() %></td>
	</tr>
	
	<%  Iterator<String> optionSetIter = auto.getOptionSetNamesIterator(auto.getOptionSetMap()) ;
   		if(optionSetIter != null)
		{
   			while(optionSetIter.hasNext()) 	    	
		
	    	{
    			String element = optionSetIter.next();
    			String choice = auto.getOptionChoice(element);
    			if(choice != null )
    			{
	%>
			<tr>
				<td><%= element %></td>
				<td>
					<%= choice %>
				</td>
				<td>
					<%= auto.getOptionChoicePrice(element) %>
				</td>	
			</tr>
		
	<%
    			}
			}
		}
	%>
	
	<tr>
	<td><b>Total Price</b></td>
	<td/>
	<td><b>$<%= auto.getTotalPrice() %></b></td>
	</tr>	
	
	
		
	</table>		


</body>
</html>