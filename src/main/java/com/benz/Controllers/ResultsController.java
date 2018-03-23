package com.benz.Controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.benz.quizApp.ColorQuiz;
import com.benz.quizClasses.QuizDao;

@Controller
public class ResultsController {
	
	@Autowired
	QuizDao quizDao;
	
	@RequestMapping(path="/resultsPage", method=RequestMethod.POST)
	public String displayResultsPage(HttpSession session, @RequestParam int answerValue, 
			@RequestParam String quality, @RequestParam String question, @RequestParam String colorKey){
		ColorQuiz colorQuiz = (ColorQuiz) session.getAttribute("colorQuiz");
		int questionCounter = (int) session.getAttribute("questionCounter");
		questionCounter++;
		colorQuiz.storeColorResult(quality, answerValue);
		session.setAttribute("quality", quality);
		session.setAttribute("question", question);
		session.setAttribute("answerValue", answerValue);
		session.setAttribute("colorKey", colorKey);
		session.setAttribute("colorResult", colorQuiz.getColorResult());
		session.setAttribute("questionCounter", questionCounter);
		colorQuiz.removeQuestion();
		Map<String, Integer> colorResult = (Map<String, Integer>) session.getAttribute("colorResult");
		colorQuiz.fillColorCounters();
		List<String> results = colorQuiz.generateMageResult(colorResult, questionCounter);
		String scores = colorQuiz.returnScores(questionCounter);
		session.setAttribute("scores", scores);
		session.setAttribute("results", results);
		quizDao.storeUserAnswer((int)session.getAttribute("userId"), colorKey, question, answerValue);
		quizDao.storeUserFinalResults((int)session.getAttribute("userId"), colorResult, colorQuiz, questionCounter);
		return "redirect:/resultsPage";
	}
	@RequestMapping(path="/resultsPage", method=RequestMethod.GET)
	public String displayResultsPageGET(){	
		return "resultsPage";
	}

}
