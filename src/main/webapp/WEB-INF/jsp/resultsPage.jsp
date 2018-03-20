<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Your Results</title>
	</head>
	<body>
		<h1>Here are your results!</h1>
		<div class = "topMargin">
		<c:out value="${results}"/>
		</div>
		<div class = "topMargin">
		<a href="/">Return to the homepage</a>
		</div>
	</body>
</html>