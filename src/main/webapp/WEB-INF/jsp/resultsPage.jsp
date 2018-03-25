<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/png"
	href="https://lh3.ggpht.com/uBFmbIA5X7gkUCZLmpyxSKtkJ-zeOBq448O8VCs6pK0LVX1xrzZe_LtqjRDgLNcxrA=w300" />
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta name="viewport" content="initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<title>Your Results</title>
</head>
<body>
	<div class="underlined"><h1>Here are your results!</h1></div>

	<c:forEach var="string" items="${results}" varStatus="loop">
		<c:choose>
			<c:when test="${loop.index == 0}">
			<div class="topMarginLarge bold">
					<c:out value="${string}" />
				</div>
			</c:when>
			<c:when test="${loop.index == results.size()-1}">
				<div class="padding topMarginMedium">
					<c:out value="For a more in-depth explanation of your result" />
					<a href="${string}">Click Here</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="topMarginMedium">
					<c:out value="${string}" />
				</div>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<div class="topMarginMedium bold">
		<c:out value="${name}, your scores are..." />
	</div>
	<div class="scores">
		<c:out value="${scores}" />
	</div>
	<div class="bottomLinks">
		<div class="topPadding topMarginLarge">
			<a href="/">Return to the Homepage</a>
		</div>
		<div class="topPadding topMarginLarge">
			<a href="https://cnatsepll.github.io/portfolio/">Visit My
				Portfolio</a>
		</div>
	</div>
</body>
</html>