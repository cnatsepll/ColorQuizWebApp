package com.benz.quizJDBC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.benz.quizClasses.Setup;
import com.benz.quizClasses.SetupDao;

@Component
public class JDBCSetupDao implements SetupDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSetupDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<URL> createFilePathsList() {
		Setup runSetup = new Setup();
		List<URL> filePaths = runSetup.getFilePaths();
		return filePaths;
	}
	
	@Override
	public void resetQuestionTables() {
		String removeFromWhite = "DELETE FROM white_questions";
		jdbcTemplate.update(removeFromWhite);
		String removeFromBlue = "DELETE FROM blue_questions";
		jdbcTemplate.update(removeFromBlue);
		String removeFromBlack = "DELETE FROM black_questions";
		jdbcTemplate.update(removeFromBlack);
		String removeFromRed = "DELETE FROM red_questions";
		jdbcTemplate.update(removeFromRed);
		String removeFromGreen = "DELETE FROM green_questions";
		jdbcTemplate.update(removeFromGreen);
	}
	

	@Override
	public Map<Integer, List> fillQuestionsTablesReturnQuestionQuiz(List<URL> filePaths) throws IOException {
		Map<Integer, List> colorQuiz = new HashMap<>();

		for (int i = 0; i < filePaths.size(); i++) {
			URL csvKey = filePaths.get(i);
			List<String> qualities = new ArrayList<>();

			try (Scanner lineReader = new Scanner(csvKey.openStream())) {
				while (lineReader.hasNextLine()) {
					String line = lineReader.nextLine();
					System.out.println(line);
					String lineArray[] = line.split(",");
					String readLine = lineArray[0];
					if (i == 0) {
						String sqlInsertPost = "INSERT INTO white_questions(question_word) VALUES (?)";
						jdbcTemplate.update(sqlInsertPost, readLine);
						qualities.add(readLine);
						colorQuiz.put(i, qualities);
					} else if (i == 1) {
						String sqlInsertPost = "INSERT INTO blue_questions(question_word) VALUES (?)";
						jdbcTemplate.update(sqlInsertPost, readLine);
						qualities.add(readLine);
						colorQuiz.put(i, qualities);
					}else if (i == 2) {
						String sqlInsertPost = "INSERT INTO black_questions(question_word) VALUES (?)";
						jdbcTemplate.update(sqlInsertPost, readLine);
						qualities.add(readLine);
						colorQuiz.put(i, qualities);
					}else if (i == 3) {
						String sqlInsertPost = "INSERT INTO red_questions(question_word) VALUES (?)";
						jdbcTemplate.update(sqlInsertPost, readLine);
						qualities.add(readLine);
						colorQuiz.put(i, qualities);
					}else if (i == 4) {
						String sqlInsertPost = "INSERT INTO green_questions(question_word) VALUES (?)";
						jdbcTemplate.update(sqlInsertPost, readLine);
						qualities.add(readLine);
						colorQuiz.put(i, qualities);
					}
				}
			}
		}
		return colorQuiz;
	}
}
