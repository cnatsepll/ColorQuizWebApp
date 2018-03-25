<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/png" href="https://lh3.ggpht.com/uBFmbIA5X7gkUCZLmpyxSKtkJ-zeOBq448O8VCs6pK0LVX1xrzZe_LtqjRDgLNcxrA=w300"/>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta name="viewport" content="initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<title>Color Quiz</title>
</head>
<body>
	<h1>Your questions are just one click away...</h1>
	<div class="topMarginLarge" >
	<c:out value="The following questions will present you with 
	a word, and will ask you how strongly, or closely you associate with it."/>
	</div>
	<div class="topMarginMedium">
	<c:out  value="Meaning: \"How well does the shown word fit into your personality or habits?\" "/>
	</div>
	<div class="topMarginMedium" >
	<c:out value="Use your gut and try to answer each question as quickly as possible."/>
	</div>
	<div>
	<c:url var="formAction" value="/quizPage"/>
	<form method="GET" action="${formAction}">
		<input class="topMarginLarge button" type="submit" value="Begin Quiz!" />
	</form>
	</div>
</body>
</html>