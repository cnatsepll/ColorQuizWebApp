package com.benz.quizClasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Setup {

	public List<URL> getFilePaths() {
		List<URL>filePaths = new ArrayList<>();
		 String whiteQuestionsFilePath = "https://raw.githubusercontent.com/cnatsepll/ColorQuizQuestions/master/whiteKeyed.csv";
		 String blueQuestionsFilePath = "https://raw.githubusercontent.com/cnatsepll/ColorQuizQuestions/master/blueKeyed.csv";
		 String blackQuestionsFilePath = "https://raw.githubusercontent.com/cnatsepll/ColorQuizQuestions/master/blackKeyed.csv";
		 String redQuestionsFilePath = "https://raw.githubusercontent.com/cnatsepll/ColorQuizQuestions/master/redKeyed.csv";
		 String greenQuestionsFilePath = "https://raw.githubusercontent.com/cnatsepll/ColorQuizQuestions/master/greenKeyed.csv";
		try {
			URL whiteURL = new URL(whiteQuestionsFilePath);
			filePaths.add(whiteURL);
			URL blueURL = new URL(blueQuestionsFilePath);
			filePaths.add(blueURL);
			URL blackURL = new URL(blackQuestionsFilePath);
			filePaths.add(blackURL);
			URL redURL = new URL(redQuestionsFilePath);
			filePaths.add(redURL);
			URL greenURL = new URL(greenQuestionsFilePath);
			filePaths.add(greenURL);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	return filePaths;
	}
}
