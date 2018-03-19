<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Welcome To The Color Quiz!</title>
</head>
<body>
	<h1>Welcome To The Color Quiz!</h1>

	<c:url var="formAction" value="/quizPageLanding"/>
	<form method="POST" action="${formAction}">
		<div class="formInputGroup">
			<label for="inputName">Please enter your name:</label>
				 <input required="required" type="text" name="inputName" id="value" />
			<div class="howManyQuestions" style="font-size: 14px;">
				<c:out value="How many questions would you like to answer?:" />

				<select name="questionCount" class="tab">
					<option value="10">10</option>
					<option value="25">25</option>
					<option value="50">50</option>
					<option value="75">75</option>
					<option value="100">100</option>
				</select>
				<div>
					<c:out value="The more questions answered, the more accurate your result will be." />
				</div>
						<div class="formInputGroup">
			<label for="inputName">(Optional)Please enter a word or sentence that best describes yourself:</label>
				 <input type="text" name="selfDefinition" id="value" />
			</div>
			</div>
		</div>
		<input class="formSubmitButton" type="submit" value="Next Page" />
	</form>
</body>
</html>