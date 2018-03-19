package com.benz.quizApp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.benz.quizClasses.Quiz;
import com.benz.quizClasses.Randomizer;
import com.benz.quizJDBC.JDBCQuizDao;
import com.benz.quizJDBC.JDBCSetupDao;
import com.benz.quizJDBC.JDBCUserDao;

public class ColorQuiz {
	private JDBCSetupDao setupDao;
	private JDBCQuizDao quizDao;
	private JDBCUserDao userDao;
	private Quiz quiz = new Quiz();
	private Randomizer random = new Randomizer();
	boolean timeToGo = false;
	int questionCounter = 0;
	private int questionCount;
	private int userId;
	private String quality;
	private String question;
	private String colorTypeKey;
	private int answerValue;
	private Map<String, Integer> colorResult = new HashMap<>();
	private Map<Integer, List> colorQuiz = new HashMap();
	
	public ColorQuiz(BasicDataSource dataSource) {
		setupDao = new JDBCSetupDao(dataSource);
	}

	public void run(int userId) throws IOException {
		setUserId(userId);
		setupDatabaseFiles();
	}
	public void setupDatabaseFiles() throws IOException {
		setupDao.resetQuestionTables();
		List<URL> filePaths = setupDao.createFilePathsList();
		setupQuestions(filePaths);
	}
	public void setupQuestions(List<URL> filePaths) throws IOException {
		setColorQuiz(setupDao.fillQuestionsTablesReturnQuestionQuiz(filePaths));	
		}
	public void generateQuestionList(Map<Integer, List> colorQuiz) {
		int key = random.keyRandomizer(colorQuiz);
		List<String> questionList = new ArrayList<>();
		if (key == 5) {
			String noValidQuestions = "true";
			questionList.add(noValidQuestions);
			setQuestion(questionList);
		}else {
		int i = random.newLine(colorQuiz, key);
		List<String> lineArray = quiz.getColorQualities(colorQuiz, key, i);
		String quality = lineArray.get(i);
		String colorTypeKey = lineArray.get(i).substring(0, 1);
		String question = quiz.getQuestion(colorQuiz, lineArray, i, key);
		questionList.add(question);
		questionList.add(colorTypeKey);
		setQuality(quality);
		setColorTypeKey(colorTypeKey);
		setQuestion(questionList);
		}
	}
	public void setQuestion(List<String> questionList) {
		question = questionList.get(0);
	}
	public void newQuestion() {
		generateQuestionList(getColorQuiz());
	}
	
	public String returnQuestion() {
		return question;
	}
	public String returnColorTypeKey() {
		return colorTypeKey;
	}
	public void storeColorResult(String questionWord, int answerValue) {
		colorResult.put(colorTypeKey, quiz.storeResult(colorResult, colorTypeKey, answerValue));
	}
	public void fillColorCounters() {
		quiz.fillCounters(colorResult);
	}
	
	public String generateMageResult(Map<String, Integer>colorResult, int questionCounter){
		return quiz.printScores(colorResult, questionCounter);
	}
	public Randomizer getRandom() {
		return random;
	}
	public void setRandom(Randomizer random) {
		this.random = random;
	}
	public boolean isTimeToGo() {
		return timeToGo;
	}
	public void setTimeToGo(boolean timeToGo) {
		this.timeToGo = timeToGo;
	}
	public int getQuestionCounter() {
		return questionCounter;
	}
	public void setQuestionCounter(int questionCounter) {
		this.questionCounter = questionCounter;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		userId = this.userId;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public String getColorTypeKey() {
		return colorTypeKey;
	}
	public void setColorTypeKey(String colorTypeKey) {
		this.colorTypeKey = colorTypeKey;
	}
	public Map<String, Integer> getColorResult() {
		return colorResult;
	}
	public void setColorResult(Map<String, Integer> colorResult) {
		this.colorResult = colorResult;
	}
	public int getAnswerValue() {
		return answerValue;
	}
	public void setAnswerValue(int answerValue) {
		this.answerValue = answerValue;
	}
	public Map<Integer, List> getColorQuiz() {
		return colorQuiz;
	}
	public void setColorQuiz(Map<Integer, List> colorQuiz) {
		this.colorQuiz = colorQuiz;
	}
	public String returnQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}

}
