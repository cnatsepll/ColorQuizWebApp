<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/png"
	href="https://lh3.ggpht.com/uBFmbIA5X7gkUCZLmpyxSKtkJ-zeOBq448O8VCs6pK0LVX1xrzZe_LtqjRDgLNcxrA=w300" />
<meta charset="UTF-8">
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<title>Your Results</title>
</head>
<body>
	<h1>Here are your results!</h1>

	<c:forEach var="string" items="${results}" varStatus="loop">
		<c:choose>
			<c:when test="${loop.index == results.size()-1}">
				<div class="topMarginMedium">
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

	<div class="topMarginLarge">
		<c:out value="Your scores are..." />
	</div>
	<div class="">
		<c:out value="${scores}" />
	</div>
	<div class= "bottomLinks">
		<div class="topMarginMedium">
			<a href="/">Return to the homepage</a>
		</div>
	<div class="topMarginLarge">
		<a href="https://cnatsepll.github.io/portfolio/">Visit My
			Portfolio</a>
	</div>
	</div>
</body>
</html>