package com.benz.quizApp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.DataSource;

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

	public void run(int userId) throws FileNotFoundException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/color_quiz_database");
		dataSource.setUsername("postgres");
		setupDao = new JDBCSetupDao(dataSource);
		setUserId(userId);
		setupDatabaseFiles();
	}
	public void setupDatabaseFiles() throws FileNotFoundException {
		setupDao.resetQuestionTables();
		List<String> filePaths = setupDao.createFilePathsList();
		setupQuestions(filePaths);
	}
	public void setupQuestions(List<String> filePaths) throws FileNotFoundException {
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
//	<c:set var="resultsMap" value="${ }"

//	boolean validAnswer = false;
//	int answer = -1;
//		Scanner answerReader = new Scanner(System.in);
//		while (!timeToGo) {
//			generateQuestionList(colorQuiz, random, quiz);
//			List<String> questionList = getQuestionList();
//			String question = questionList.get(0);
//			String colorTypeKey = questionList.get(1);
//				if (question.equals("true")){
//				setTimeToGo(true);
//				break;
//				}
//			while (!validAnswer) {
//				System.out.println("");
//				if (questionCounter >= 10) {
//					System.out.println("Press '0' at anytime to quit");
//					System.out.println("");
//				}
//				System.out.println(question);
//				System.out.print("On a scale of 1(lowest) - 5(highest), how strongly do you associate with this term? ");
//				answer = quiz.getAnswer(answerReader, colorQuiz, colorTypeKey);
//				if (answer < 6 && answer > 0) {
//					System.out.println(userId);
//					quizDao.storeUserAnswer(userId,colorTypeKey,question, answer);
//					validAnswer = true;
//					
//					break;
//				} 
//				else if (answer == 0) {
//					boolean isConfirmed = false;
//					while (!isConfirmed) {
//						System.out.println("");
//						System.out.println("Are you sure you'd like to quit?");
//						System.out.println("Enter 'Y' for Yes, or 'N' for No.");
//						System.out.println("The more questions you answer the more accurate your result will be.");
//						String confirmation = answerReader.nextLine();
//						if (confirmation.toLowerCase().equals("y")) {
//							timeToGo = true;
//							validAnswer = true;
//							isConfirmed = true;
//							break;
//						} else if (confirmation.toLowerCase().equals("n")) {
//							validAnswer = false;
//							isConfirmed = true;
//							continue;
//						}
//					}
//				} else {
//					System.out.println("");
//					System.out.println("");
//					System.out.println("");
//					System.out.println("Please enter a number between 1(lowest) and 5(highest) to continue");
//					validAnswer = false;
//				}
//			}
//			colorResult.put(colorTypeKey, quiz.storeResult(colorResult, colorTypeKey, answer));
//		}
//		quiz.fillCounters(colorResult);
//		quizDao.storeUserFinalResults(userId,colorResult);
//		String results = quiz.printScores(colorResult, questionCounter, timeToGo);
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println(results);
//	}


//	public List<String> getQuestionList(){
//		return questionList;
//	}
//	public void setQuestionList(List<String> questionList) {
//		questionList.remove(0);
//		questionList = this.questionList;
//	}
	
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
	public ColorQuiz() {
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
