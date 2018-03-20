<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Color Quiz</title>
</head>
<body>
	<h1>Your questions are one click away</h1>
	<div class="topMargin" >
	<c:out value="The following questions will present you with 
	a word, and will ask you how strongly, or closely you associate with it"/>
	</div>
	<div class="topMargin">
	<c:out  value="Meaning: \"How well does the shown word fit into your personality or habbits?\" "/>
	</div>
	<div class="topMargin" >
	<c:out value="Use your gut and try to answer each question as quickly as possible."/>
	</div>
	<div>
	<c:url var="formAction" value="/quizPage"/>
	<form method="GET" action="${formAction}">
		<input class="topMargin" class="formSubmitButton" type="submit" value="Begin Quiz!" />
	</form>
	</div>
</body>
</html>