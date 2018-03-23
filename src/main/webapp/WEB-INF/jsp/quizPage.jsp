<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/png"
	href="https://lh3.ggpht.com/uBFmbIA5X7gkUCZLmpyxSKtkJ-zeOBq448O8VCs6pK0LVX1xrzZe_LtqjRDgLNcxrA=w300" />
<meta charset="UTF-8">
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<title>Color Quiz</title>
</head>
<body>

	<%-- 			${colorQuiz.newQuestion()}
 --%>
	<!--  ask question if questions remain -->
	<c:choose>
		<c:when test="${questionCounter < questionCount}">
			<!--  generate question word -->
			<div class="topPadding topMarginLarge">
				<c:out value="${questionCounter} )" />
				<span class="big"><c:out
						value="${colorQuiz.returnQuestion()}" /></span>
			</div>
			<!--  itterate questionCounter -->
			<c:url var="formAction" value="/quizPage" />
			<form method="POST" action="${formAction}">
				<div class="formInputGroup topMarginMedium">
					<label for="inputName">How strongly do you associate with
						the above term?</label>
					<div class="topMarginMedium">
						<input type="hidden" name="quality"
							value="${colorQuiz.returnQuality()}"> <input
							type="hidden" name="question"
							value="${colorQuiz.returnQuestion()}"> <input
							type="hidden" name="colorKey"
							value="${colorQuiz.returnColorTypeKey()}"> <label
							class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=1 onclick="this.form.submit();">
							Not at all
						</label> <label class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=3 onclick="this.form.submit();">
							A little bit
						</label> <label class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=5 onclick="this.form.submit();">
							Some
						</label> <label class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=12 onclick="this.form.submit();">
							Very Strongly
						</label> <label class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=30 onclick="this.form.submit();">
							That's me
						</label>
					</div>
				</div>
				<!-- 	<input class="formSubmitButton" type="submit" value="Next question"/>
 -->
			</form>
		</c:when>
		<c:when test="${questionCounter == questionCount}">
			<div class="topPadding topMarginLarge">
				<c:out value="${questionCounter} )" />
				<span class="big"><c:out
						value="${colorQuiz.returnQuestion()}" /></span>
			</div>
			<!--  itterate questionCounter -->
			<c:url var="formAction" value="/resultsPage" />
			<form method="POST" action="${formAction}">
				<div class="formInputGroup topMarginMedium">
					<label for="inputName">How strongly do you associate with
						the above term?</label>
					<div class="topMarginMedium">
						<input type="hidden" name="quality"
							value="${colorQuiz.returnQuality()}"> <input
							type="hidden" name="question"
							value="${colorQuiz.returnQuestion()}"> <input
							type="hidden" name="colorKey"
							value="${colorQuiz.returnColorTypeKey()}"> <label
							class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=1 onclick="this.form.submit();">
							Not at all
						</label> <label class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=3 onclick="this.form.submit();">
							A little bit
						</label> <label class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=5 onclick="this.form.submit();">
							Some
						</label> <label class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=12 onclick="this.form.submit();">
							Very Strongly
						</label> <label class="quizChoiceButton"> <input type="radio"
							name="answerValue" value=30 onclick="this.form.submit();">
							That's me
						</label>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>
</body>
</html>