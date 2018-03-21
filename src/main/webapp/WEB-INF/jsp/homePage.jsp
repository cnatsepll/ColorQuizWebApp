<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/png"
	href="https://lh3.ggpht.com/uBFmbIA5X7gkUCZLmpyxSKtkJ-zeOBq448O8VCs6pK0LVX1xrzZe_LtqjRDgLNcxrA=w300" />
<meta charset="UTF-8">
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<title>Welcome To The Color Quiz!</title>
</head>
<body>
	<h1>Welcome To The Color Quiz!</h1>

	<c:url var="formAction" value="/quizPageLanding" />
	<form method="POST" action="${formAction}">
			<div>
				<label for="inputName topMargin">Please enter your name:</label> <span><input
					required="required" type="text" name="inputName" id="value" /></span>
			</div>
			<div class="howManyQuestions topMargin">
				<c:out value="How many questions would you like to answer?:" />

				<select name="questionCount" class="tab topMargin">
					<option value="10">10</option>
					<option value="25">25</option>
					<option value="50">50</option>
					<option value="75">75</option>
					<option value="100">100</option>
				</select>
			</div>
			<div class="topMargin">
				<c:out
					value="The more questions answered, the more accurate your result will be." />
			</div>
		<div class="topMargin">
			<label for="inputName">(Optional)Please enter a word or
				sentence that best describes yourself:</label> <input type="text"
				name="selfDefinition" id="value" />
		</div>
		<input class="formSubmitButton topMargin" type="submit"
			value="Next Page" />
	</form>
</body>
</html>