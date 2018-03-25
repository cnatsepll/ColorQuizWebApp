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
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<title>Welcome To The Color Quiz!</title>
</head>
<body>
	<h1>Welcome To The Color Quiz!</h1>
	<div class="container">
		<c:url var="formAction" value="/quizPageLanding" />
		<form method="POST" action="${formAction}">
			<div class="topMarginLarge">
				<label for="inputName">Please enter your name:</label> <span><input
					required="required" type="text" maxlength="200" name="inputName"
					id="value" class="inputText" /></span>
			</div>
			<div class="topMarginMedium">
				<c:out
					value="The more questions answered, the more accurate your result will be." />
			</div>
			<div class="smallText">
				<c:out value="(Quiz time is roughly 3 seconds per question)" />
			</div>
			<div class="howManyQuestions topMarginMedium">
				<c:out value="How many questions would you like to answer?" />

				<select name="questionCount" class="tab topMargin questionChoice">
					<option value="15">15</option>
					<option value="25">25</option>
					<option value="50">50</option>
					<option value="75">75</option>
					<option value="100">100</option>
					<option value="150">150</option>
					<option value="200">200</option>
					<option value="225">225</option>
				</select>
			</div>

			<div class="topMarginMedium">
				<label for="inputDescription">(Optional) Enter a word or
					sentence that best describes yourself:</label> <input type="text"
					maxlength="280" name="selfDefinition" id="value" class="inputText" />
			</div>
			<div class="padding">
				<input class="button topMarginLarge" type="submit" value="Next Page" />
			</div>
		</form>
	</div>
</body>
<footer class="footer">
	<p>Huge shoutout and thank you to these fellow Color Pie
		enthusiasts and their wonderful resources.</p>
	<a class="padding"
		href="https://www.lesserwrong.com/posts/KbaJsfBtdpGv7EKbC/the-mtg-color-wheel">Lesser
		Wrong: Color Wheel</a> <a class="padding"
		href="https://magic.wizards.com/en/articles/archive/making-magic/pie-fights-2016-11-14">MTG
		Wizards</a> <a class="padding"
		href="http://sarpadianempiresvol-viii.tumblr.com/">Sarpadian
		Empires</a>
	<p>The answer descriptions come from the sources linked above and
		without them this quiz would not be possible.</p>

</footer>
</html>