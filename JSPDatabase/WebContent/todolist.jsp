<%@ page import= "java.util.*" %>

<html>

<head><title>To do List</title></head>

<body>

<!-- Setting up the form for the item input -->

<form action="todolist.jsp">

	Add a new item: <input type="text" name="theItem"/>

	<br/>
	<br/>
	<input type="submit" value="Submit"/>
	
</form>
	<br/>
<!-- Grabbing the items added into a List -->
<%
	//Get the TO DO items from the session. 
	List<String> items = (List<String>) session.getAttribute("todoList");
	
	//If the TO DO items does not exist, then create a new one.
	if (items == null){
		items = new ArrayList<String>();
		session.setAttribute("todoList", items);
	}
	
	// Check if there is no form data to add. When there is, add to the items list
	String theItem = request.getParameter("theItem");
	
	
	//Checking for null values and empty input - version 1
	if ((theItem != null) && (!theItem.trim().equals(""))){
		items.add(theItem);
	}
	
	//Version 2
	/**
	boolean isItemNotEmpty = theItem != null && theItem.trim().length() > 0;
	boolean isItemNotDuplicate = theItem != null && !items.contains(theItem.trim());
	if (isItemNotEmpty && isItemNotDuplicate) {
		
		items.add(theItem.trim());
		
		response.sendRedirect("todolist.jsp"); 
	
		{
	*/
	
%>

<!-- Display all the TO DO List from the session -->
<hr>
<b>To do Items:</b>

<ol>
<%
	for (String temp: items){
		out.println("<li>" + temp + "</li>");
	}

%>
</ol>

</body>
</html>