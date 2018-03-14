package com.benz.Controllers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.benz.quizApp.ColorQuiz;
import com.benz.quizClasses.User;
import com.benz.quizJDBC.JDBCUserDao;



@Controller
public class QuizController {
	
	@Autowired
	JDBCUserDao userDao;

	
	@RequestMapping(path="/quizPage", method=RequestMethod.GET)
	public String displayQuizPage(@RequestParam String inputName) throws FileNotFoundException {
		User newUser = new User();
		newUser.setUserName(inputName);
		userDao.initiateUser(newUser);
		ColorQuiz colorQuiz = new ColorQuiz();
		colorQuiz.run(newUser.getUserId());
		return "quizPage";
	}
	
}
