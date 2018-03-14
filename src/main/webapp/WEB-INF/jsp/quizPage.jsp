<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Color Quiz</title>
	</head>
	<body>
		<h1>Walk the Planes</h1>
		<!-- while loop until confirmation of quiz end is given -->
		<!--  generate question word -->
			<!--  while loop until valid answer is given -->
				<form method="GET" action="${formAction}">
					<div class="formInputGroup">
					<label for="inputName">1-5 How strongly do you associate with the above term?</label> <input type="integer"
					name="answerValue" id="value" />
					</div>
				<input class="formSubmitButton" type="submit" value="Submit Answer"/>
				</form>

	</body>
</html>