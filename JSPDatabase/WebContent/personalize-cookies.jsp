<html>

<head><title>Confirmation Page</title></head>

<%
	//Read the form data
	String favoriteLang = request.getParameter("favLang");

	//create the cookie
	Cookie theCookie = new Cookie("nerdAyo.favLang", favoriteLang);
	
	//set the life span on the cookie (using number of seconds)
	theCookie.setMaxAge(60*60*24*365);
	
	//send the cookie to the browser
	response.addCookie(theCookie);
%>
<body>
	Nagode! We set your favorite language to: ${param.favLang}
	<br/><br/>
	
	<a href ="cookies-homepage.jsp"> Return to Homepage.</a>
</body>

</html>