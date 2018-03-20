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
		<h1>Walk the Planes</h1>
			
			${colorQuiz.newQuestion()}
					<!--  ask question if questions remain -->
			<c:choose> 
			<c:when test="${questionCounter < questionCount}"> 
					<!--  generate question word -->
	<div class="topMargin">
		<c:out value="${questionCounter} )" />
	<span><c:out value="${colorQuiz.returnQuestion()}"/></span>
			</div>		
					<!--  itterate questionCounter -->	
			<c:url var="formAction" value="/quizPage"/>
				<form method="POST" action="${formAction}">
					<div class="formInputGroup topMargin">
					<label for="inputName">How strongly do you associate with the above term?</label> 
						<div>
						<input type="hidden" name="quality" value="${colorQuiz.returnQuality()}">
						<input type="hidden" name="question" value="${colorQuiz.returnQuestion()}">
						<input type="hidden" name="colorKey" value="${colorQuiz.returnColorTypeKey()}">
						<label>
						<input type="radio" name="answerValue" value= 1 onclick="this.form.submit();">Not at all
						</label>
						<label>
						<input type="radio" name="answerValue" value= 3 onclick="this.form.submit();">A little bit
						</label>
						<label>
						<input type="radio" name="answerValue" value= 6 onclick="this.form.submit();">Some
						</label>
						<label>
						<input type="radio" name="answerValue" value= 10 onclick="this.form.submit();">Very Strongly
						</label>
						<label>
						<input type="radio" name="answerValue" value= 15 onclick="this.form.submit();">That's me
						</label>
						</div>
					</div>
<!-- 	<input class="formSubmitButton" type="submit" value="Next question"/>
 -->		</form>
		</c:when>
		<c:when test="${questionCounter == questionCount}">
		<c:out value="${questionCounter} )" />
	<span><c:out value=" ${colorQuiz.returnQuestion()}"/></span>
					<!--  itterate questionCounter -->	
			<c:url var="formAction" value="/resultsPage"/>
				<form method="POST" action="${formAction}">
					<div class="formInputGroup topMargin">
					<label for="inputName">How strongly do you associate with the above term?</label> 
						<div>
						<input type="hidden" name="quality" value="${colorQuiz.returnQuality()}">
						<input type="hidden" name="question" value="${colorQuiz.returnQuestion()}">
						<input type="hidden" name="colorKey" value="${colorQuiz.returnColorTypeKey()}">
						<label>
						<input type="radio" name="answerValue" value= 1 onclick="this.form.submit();">Not at all
						</label>
						<label>
						<input type="radio" name="answerValue" value= 3 onclick="this.form.submit();">A little bit
						</label>
						<label>
						<input type="radio" name="answerValue" value= 6 onclick="this.form.submit();">Some
						</label>
						<label>
						<input type="radio" name="answerValue" value= 10 onclick="this.form.submit();">Very Strongly
						</label>
						<label>
						<input type="radio" name="answerValue" value= 15 onclick="this.form.submit();">That's me
						</label>
						</div>
					</div>
<!-- 	<input class="formSubmitButton" type="submit" value="Get results!"/>
 -->		</form>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
		</c:choose>
	</body>
</html>