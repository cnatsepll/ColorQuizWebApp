package com.benz.quizClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Setup {

	private String whiteQuestionsFilePath = "/Users/nlckbenz/colorQuizFiles/whiteKeyed.csv";
	private String blueQuestionsFilePath = "/Users/nlckbenz/colorQuizFiles/blueKeyed.csv";
	private String blackQuestionsFilePath = "/Users/nlckbenz/colorQuizFiles/blackKeyed.csv";
	private String redQuestionsFilePath = "/Users/nlckbenz/colorQuizFiles/redKeyed.csv";
	private String greenQuestionsFilePath = "/Users/nlckbenz/colorQuizFiles/greenKeyed.csv";
	
	
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
