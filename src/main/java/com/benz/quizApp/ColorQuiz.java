package com.benz.quizApp;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.benz.quizClasses.Quiz;
import com.benz.quizClasses.Randomizer;
import com.benz.quizClasses.Setup;
import com.benz.quizJDBC.JDBCSetupDao;

public class ColorQuiz {
	private JDBCSetupDao setupDao;

	public ColorQuiz(DataSource datasource) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/color_quiz_database");
		dataSource.setUsername("postgres");
		setupDao = new JDBCSetupDao(dataSource);
	}

	public void run() throws FileNotFoundException {
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

	public void setupQuiz(Map<Integer, List> colorQuiz) {
		Map<String, Integer> colorResult = new HashMap<>();

		Randomizer random = new Randomizer();
		Quiz quiz = new Quiz();
		Setup setup = new Setup();

		boolean timeToGo = false;
		int questionCounter = 0;
/*
 * Quiz is now set up, below code begins to run the quiz itself
 */
		while (!timeToGo) {
			
			System.out.println(colorQuiz.get(1).size());

			int key = random.keyRandomizer(colorQuiz);
			if (key == 5) {
				timeToGo = true;
				break;
			}
			int i = random.newLine(colorQuiz, key);

			List<String> lineArray = quiz.getColorQualities(colorQuiz, key, i);
			String colorTypeKey = lineArray.get(i).substring(0, 1);

			String question = quiz.getQuestion(colorQuiz, lineArray, i, key);

			boolean validAnswer = false;
			int answer = -1;
			Scanner answerReader = new Scanner(System.in);
			while (!validAnswer) {
				System.out.println("");
				if (questionCounter >= 10) {
					System.out.println("Press '0' at anytime to quit");
					System.out.println("");
				}
				// System.out.println(colorTypeKey);
				System.out.println(question);
				System.out
						.print("On a scale of 1(lowest) - 5(highest), how strongly do you associate with this term? ");
				answer = quiz.getAnswer(answerReader, colorQuiz, colorTypeKey);
				if (answer < 6 && answer > 0) {
					validAnswer = true;
					break;
				} else if (answer == 0) {
					boolean isConfirmed = false;
					while (!isConfirmed) {
						System.out.println("");
						System.out.println("Are you sure you'd like to quit?");
						System.out.println("Enter 'Y' for Yes, or 'N' for No.");
						System.out.println("The more questions you answer the more accurate your result will be.");
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
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("Please enter a number between 1(lowest) and 5(highest) to continue");
					validAnswer = false;
				}

			}

			colorResult.put(colorTypeKey, quiz.storeResult(colorResult, colorTypeKey, answer));
			questionCounter++;
		}
		// String mage = quiz.printMageResult(colorResult, questionCounter);
		String results = quiz.printScores(colorResult, questionCounter, timeToGo);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(results);

	}

	public static void main(String[] args) throws FileNotFoundException {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/color_quiz_database");
		dataSource.setUsername("postgres");

		ColorQuiz application = new ColorQuiz(dataSource);
		application.run();

	}
}
