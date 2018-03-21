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
					<option value="150">150</option>
					<option value="200">200</option>
					<option value="250">250</option>
					<option value="300">300</option>
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
<footer class="footer">
<p >Huge shoutout to these fantastic Color Pie enthusiasts and their wonderful resources.</p>
<a class ="padding" href="https://www.lesserwrong.com/posts/KbaJsfBtdpGv7EKbC/the-mtg-color-wheel">Lesser Wrong: Color Wheel</a>
<a class ="padding" href="https://magic.wizards.com/en/articles/archive/making-magic/pie-fights-2016-11-14">MTG Wizards</a>
<a class ="padding" href="http://sarpadianempiresvol-viii.tumblr.com/">Sarpadian Empires</a>
<p>Without them this quiz would not be possible.</p>

</footer>
</html>