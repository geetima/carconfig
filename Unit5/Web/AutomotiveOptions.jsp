<%@ page import="java.util.*,model.*" %>

<html>
<head>
<title>Basic Car Choice</title>
</head>
<body>
	<h1>Basic Car Choice</h1>

	<form method="post" action="setAndShowAutomotiveOptions">
		<table border="1">
			<%
    			Automotive auto = (Automotive) session.getAttribute("auto");
				ArrayList<String> optionsetlist = (ArrayList<String>) session.getAttribute("optlist");
			%>
			<tr>
				<td><b>Make/Model:</b></td>
				<td><input type="text" name="make/model" size="20" value="<%= auto.getMake() %> <%= auto.getModel() %>" readonly></td>
			</tr>
			<%  
			Iterator<String> optionSetIter = auto.getOptionSetNamesIterator(auto.getOptionSetMap()) ;
	   		if(optionSetIter != null)
			{
	   			while(optionSetIter.hasNext()) 	    	
			
		    	{
	    			String element = optionSetIter.next();		    		
			%>
					<tr>
						<td><b><%=element%>:</b>
						</td>
						<td>
						<select name="<%=element%>">
						<% 
						ArrayList<String> optNameList = auto.getOptionNames(element) ;
						for(int i=0 ; i < optNameList.size() ; i++)
						{
							String optName = optNameList.get(i) ;
						%>
							<option value="<%=optName%>"><%=optName%></option>
						<%
						}
						%>
						</select>
						
						</td>	
					</tr>
				
			<%
					}
				}
			%>		
				<tr>
				<td/>
				<td align="right"><input type="submit" value="Done"></td>
			</tr>
		</table>
	</form>
</html>