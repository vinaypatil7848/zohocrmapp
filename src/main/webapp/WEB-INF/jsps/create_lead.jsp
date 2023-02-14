<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create lead</title>
</head>
<body>
	<h2>create leads</h2>
	<form action="saveLead" method="post">
		<pre>
			firstname<input type="text" name="firstName"/>
			lastname<input type="text" name="lastName"/>
			email<input type="text" name="email"/>
			mobile<input type="text" name="mobile"/>
			<input type="submit" value="save"/>
		</pre>
	</form>
	
	${msg}
</body>
</html>