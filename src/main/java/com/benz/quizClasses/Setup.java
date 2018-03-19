package com.benz.quizClasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Setup {

	public List<URL> getFilePaths() {
		List<URL>filePaths = new ArrayList<>();
		 String whiteQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/whiteKeyed.csv";
		 String blueQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/blueKeyed.csv";
		 String blackQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/blackKeyed.csv";
		 String redQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/redKeyed.csv";
		 String greenQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/greenKeyed.csv";
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
	return filePaths;
	}
	
//	private	List<String> filePaths = new ArrayList<>(); // Keyed csv's live here


//	public String getWhiteQuestionsFilePath() {
//		return whiteQuestionsFilePath;
//	}
//	public void setWhiteQuestionsFilePath(String whiteQuestionsFilePath) {
//		this.whiteQuestionsFilePath = whiteQuestionsFilePath;
//	}
//	public String getBlueQuestionsFilePath() {
//		return blueQuestionsFilePath;
//	}
//	public void setBlueQuestionsFilePath(String blueQuestionsFilePath) {
//		this.blueQuestionsFilePath = blueQuestionsFilePath;
//	}
//	public String getBlackQuestionsFilePath() {
//		return blackQuestionsFilePath;
//	}
//	public void setBlackQuestionsFilePath(String blackQuestionsFilePath) {
//		this.blackQuestionsFilePath = blackQuestionsFilePath;
//	}
//	public String getRedQuestionsFilePath() {
//		return redQuestionsFilePath;
//	}
//	public void setRedQuestionsFilePath(String redQuestionsFilePath) {
//		this.redQuestionsFilePath = redQuestionsFilePath;
//	}
//	public String getGreenQuestionsFilePath() {
//		return greenQuestionsFilePath;
//	}
//	public void setGreenQuestionsFilePath(String greenQuestionsFilePath) {
//		this.greenQuestionsFilePath = greenQuestionsFilePath;
//	}
//
//	public void setFilePaths(List<String> filePaths) {
//		this.filePaths = filePaths;
//	}

}
