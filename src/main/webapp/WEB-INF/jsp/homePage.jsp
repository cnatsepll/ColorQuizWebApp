<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Welcome To The Color Quiz!</title>
	</head>
	<body>
		<h1>Welcome To The Color Quiz!</h1>

<c:url var="formAction" value="/quizPage" />
<form method="GET" action="${formAction}">
	<div class="formInputGroup">
		<label for="inputName">Please enter your name:</label> <input type="text"
			name="inputName" id="value" />
	</div>
	<input class="formSubmitButton" type="submit" value="Begin Quiz"/>
</form>
	</body>
</html>