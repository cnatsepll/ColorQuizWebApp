package com.benz.Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.benz.quizApp.ColorQuiz;
import com.benz.quizClasses.QuizDao;
import com.benz.quizClasses.User;
import com.benz.quizClasses.UserDao;



@Controller
public class QuizController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	QuizDao quizDao;
	@Autowired
	BasicDataSource dataSource;
	
	@RequestMapping(path="/quizPageLanding", method=RequestMethod.POST)
	public String displayQuizPageLanding(@RequestParam String selfDefinition, 
			@RequestParam int questionCount, @RequestParam String inputName, HttpSession session) throws IOException{
		int questionCounter = 1;
		User newUser = new User();
		newUser.setUserName(inputName);
		newUser.setSelfDefinition(selfDefinition);
		userDao.initiateUser(newUser);
		int userId = newUser.getUserId();
		ColorQuiz colorQuiz = new ColorQuiz(dataSource);
		colorQuiz.run(userId);
		session.setAttribute("name", inputName);
		session.setAttribute("userId", userId);
		session.setAttribute("questionCounter", questionCounter);
		session.setAttribute("colorQuiz", colorQuiz);
		session.setAttribute("questionCount", questionCount);
		return "redirect:/quizPageLanding";
	}
	@RequestMapping(path="/quizPageLanding", method=RequestMethod.GET)
	public String displayQuizPageLandingGET(){	
		return "quizPageLanding";
	}
	
	@RequestMapping(path="/quizPage", method=RequestMethod.POST)
	public String displayQuizPage(HttpSession session, @RequestParam int answerValue, 
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
		quizDao.storeUserAnswer((int)session.getAttribute("userId"), colorKey, question, answerValue);
		colorQuiz.removeQuestion();
		return "redirect:/quizPage";
	}
	@RequestMapping(path="/quizPage", method=RequestMethod.GET)
	public String displayQuizPageGET(HttpSession session){	
		ColorQuiz colorQuiz = (ColorQuiz) session.getAttribute("colorQuiz");
		colorQuiz.newQuestion();
		return "quizPage";
	}
}
