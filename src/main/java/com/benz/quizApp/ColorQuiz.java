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
	Randomizer random = new Randomizer();
	boolean timeToGo = false;
	int questionCounter = 0;
	private int userId;
	private String question;
//	public static void main(String[] args) throws FileNotFoundException {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/color_quiz_database");
//		dataSource.setUsername("postgres");
//		ColorQuiz application = new ColorQuiz();
//		application.run(getUserDao());
//	}
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
		Map<Integer, List> colorQuiz = setupDao.fillQuestionsTablesReturnQuestionQuiz(filePaths);
		setupQuiz(colorQuiz);
	}
	public List<String> askUserQuestion(Map<Integer, List> colorQuiz, Randomizer random, Quiz quiz) {
		int key = random.keyRandomizer(colorQuiz);
		List<String> questionList = new ArrayList<>();
		if (key == 5) {
			String noValidQuestions = "true";
			questionList.add(noValidQuestions);
			return questionList;
		}else {
		int i = random.newLine(colorQuiz, key);
		List<String> lineArray = quiz.getColorQualities(colorQuiz, key, i);
		String colorTypeKey = lineArray.get(i).substring(0, 1);
		String question = quiz.getQuestion(colorQuiz, lineArray, i, key);
		questionList.add(question);
		questionList.add(colorTypeKey);
		setQuestion(questionList);
		return questionList;
		}
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(List<String> questionList) {
		question = questionList.get(0);
	}
	public void setupQuiz(Map<Integer, List> colorQuiz) {
		Map<String, Integer> colorResult = new HashMap<>();
		boolean validAnswer = false;
		int answer = -1;
		Scanner answerReader = new Scanner(System.in);
		while (!timeToGo) {
			List<String> questionList = askUserQuestion(colorQuiz, random, quiz);
			String question = questionList.get(0);
			String colorTypeKey = questionList.get(1);
				if (question.equals("true")){
				setTimeToGo(true);
				break;
				}
//			while (!validAnswer) {
//				System.out.println("");
//				if (questionCounter >= 10) {
//					System.out.println("Press '0' at anytime to quit");
//					System.out.println("");
//				}
				System.out.println(question);
//				System.out.print("On a scale of 1(lowest) - 5(highest), how strongly do you associate with this term? ");
				answer = quiz.getAnswer(answerReader, colorQuiz, colorTypeKey);
				if (answer < 6 && answer > 0) {
//					System.out.println(userId);
					quizDao.storeUserAnswer(userId,colorTypeKey,question, answer);
					validAnswer = true;
					break;
				} else if (answer == 0) {
					boolean isConfirmed = false;
					while (!isConfirmed) {
//						System.out.println("");
//						System.out.println("Are you sure you'd like to quit?");
//						System.out.println("Enter 'Y' for Yes, or 'N' for No.");
//						System.out.println("The more questions you answer the more accurate your result will be.");
						String confirmation = answerReader.nextLine();
						if (confirmation.toLowerCase().equals("y")) {
							timeToGo = true;
							validAnswer = true;
							isConfirmed = true;
							break;
						} else if (confirmation.toLowerCase().equals("n")) {
							validAnswer = false;
							isConfirmed = true;
							continue;
						}
					}
				} else {
//					System.out.println("");
//					System.out.println("");
//					System.out.println("");
//					System.out.println("Please enter a number between 1(lowest) and 5(highest) to continue");
					validAnswer = false;
				}
//			}
			colorResult.put(colorTypeKey, quiz.storeResult(colorResult, colorTypeKey, answer));
			questionCounter++;
		}
		quiz.fillCounters(colorResult);
		quizDao.storeUserFinalResults(userId,colorResult);
		String results = quiz.printScores(colorResult, questionCounter, timeToGo);
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
		System.out.println(results);
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
	public ColorQuiz() {
	}

}
