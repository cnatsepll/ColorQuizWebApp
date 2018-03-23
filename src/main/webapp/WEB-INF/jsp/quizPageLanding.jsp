<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/png" href="https://lh3.ggpht.com/uBFmbIA5X7gkUCZLmpyxSKtkJ-zeOBq448O8VCs6pK0LVX1xrzZe_LtqjRDgLNcxrA=w300"/>
<meta charset="UTF-8">
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<title>Color Quiz</title>
</head>
<body>
	<h1>Your questions are one click away</h1>
	<div class="topMargin" >
	<c:out value="The following questions will present you with 
	a word, and will ask you how strongly, or closely you associate with it"/>
	</div>
	<div class="topMargin">
	<c:out  value="Meaning: \"How well does the shown word fit into your personality or habits?\" "/>
	</div>
	<div class="topMargin" >
	<c:out value="Use your gut and try to answer each question as quickly as possible."/>
	</div>
	<div>
	<c:url var="formAction" value="/quizPage"/>
	<form method="GET" action="${formAction}">
		<input class="topMarginMedium button" type="submit" value="Begin Quiz!" />
	</form>
	</div>
</body>
</html>