package com.benz.Controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benz.quizApp.ColorQuiz;
import com.benz.quizClasses.QuizDao;

@Controller
public class ResultsController {
	
	@Autowired
	QuizDao quizDao;
	
	@RequestMapping(path="/resultsPage", method=RequestMethod.POST)
	public String displayResultsPage(HttpSession session) {
		int questionCounter = (int) session.getAttribute("questionCounter");
		ColorQuiz colorQuiz = (ColorQuiz) session.getAttribute("colorQuiz");
		Map<String, Integer> colorResult = (Map<String, Integer>) session.getAttribute("colorResult");
		colorQuiz.fillColorCounters();
		List<String> results = colorQuiz.generateMageResult(colorResult, questionCounter);
		String scores = colorQuiz.returnScores(questionCounter);
		session.setAttribute("scores", scores);
		session.setAttribute("results", results);
		return "redirect:/resultsPage";
	}
	@RequestMapping(path="/resultsPage", method=RequestMethod.GET)
	public String displayResultsPageGET(){	
		return "resultsPage";
	}

}
