<html>

<head><title>Training Portal</title></head>
<body>
<!-- Read the favorite programming language cookie -->

<%
	//the default, i.e. if there are no cookies
	String favoriteLang = "Java";

	//get the cookies from the browser
	Cookie[] theCookies = request.getCookies();
	
	//Find the favorite langauge cookie
	if(theCookies != null){
		for (Cookie tempCookie : theCookies){
			if ("nerdAyo.favLang".equals(tempCookie.getName())){
				favoriteLang = tempCookie.getValue();
				break;
				
			}
		}
	}
%>

<!-- Showing the personalized message -->
<h4> New Books for <%= favoriteLang%> </h4>

<ul>
<li> </li>
<li> </li>
<li> </li>
<li> </li>

</ul>





</body>
</html>