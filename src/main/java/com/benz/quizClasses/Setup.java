package com.benz.quizClasses;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.URL;

public class Setup {

	private String whiteQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/whiteKeyed.csv";
	URL whiteURL = new URL(whiteQuestionsFilePath);
	private String blueQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/blueKeyed.csv";
	URL blueURL = new URL(blueQuestionsFilePath);
	private String blackQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/blackKeyed.csv";
	URL blackURL = new URL(blackQuestionsFilePath);
	private String redQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/redKeyed.csv";
	URL redURL = new URL(redQuestionsFilePath);
	private String greenQuestionsFilePath = "https://github.com/cnatsepll/ColorQuizQuestions/blob/master/greenKeyed.csv";
	URL greenURL = new URL(greenQuestionsFilePath);
	
	
	private	List<String> filePaths = new ArrayList<>(); // Keyed csv's live here


	public String getWhiteQuestionsFilePath() {
		return whiteQuestionsFilePath;
	}
	public void setWhiteQuestionsFilePath(String whiteQuestionsFilePath) {
		this.whiteQuestionsFilePath = whiteQuestionsFilePath;
	}
	public String getBlueQuestionsFilePath() {
		return blueQuestionsFilePath;
	}
	public void setBlueQuestionsFilePath(String blueQuestionsFilePath) {
		this.blueQuestionsFilePath = blueQuestionsFilePath;
	}
	public String getBlackQuestionsFilePath() {
		return blackQuestionsFilePath;
	}
	public void setBlackQuestionsFilePath(String blackQuestionsFilePath) {
		this.blackQuestionsFilePath = blackQuestionsFilePath;
	}
	public String getRedQuestionsFilePath() {
		return redQuestionsFilePath;
	}
	public void setRedQuestionsFilePath(String redQuestionsFilePath) {
		this.redQuestionsFilePath = redQuestionsFilePath;
	}
	public String getGreenQuestionsFilePath() {
		return greenQuestionsFilePath;
	}
	public void setGreenQuestionsFilePath(String greenQuestionsFilePath) {
		this.greenQuestionsFilePath = greenQuestionsFilePath;
	}
	public List<String> getFilePaths() {
		return filePaths;
	}
	public void setFilePaths(List<String> filePaths) {
		this.filePaths = filePaths;
	}

}
