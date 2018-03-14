package com.benz.quizJDBC;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.benz.quizClasses.Quiz;
import com.benz.quizClasses.QuizDao;
import com.benz.quizClasses.Randomizer;
@Component
public class JDBCQuizDao implements QuizDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCQuizDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void storeUserAnswer(int userId, String colorTypeKey, String question, int answer) {
		String sqlInsertPost = "INSERT INTO answer(user_id,color_type_key,question_word,answer_value) "
				+ "VALUES(?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, userId,colorTypeKey,question,answer);
		
	}
	@Override
	public void storeUserFinalResults(int userId, Map<String, Integer> colorResult) {
		 int whiteCounter = 0;
		 int blueCounter = 0;
		 int blackCounter = 0;
		 int redCounter = 0;
		 int greenCounter = 0;
		String sqlInsertPost = "INSERT INTO result(user_id, white_counter, blue_counter, black_counter, red_counter, green_counter)"
				+ " VALUES (?,?,?,?,?,?)";
		if (colorResult.get("w") != null) {
			whiteCounter = colorResult.get("w");
		}
		if (colorResult.get("u") != null) {
			blueCounter = colorResult.get("u");
		}
		if (colorResult.get("b") != null) {
			blackCounter = colorResult.get("b");
		}
		if (colorResult.get("r") != null) {
			redCounter = colorResult.get("r");
		}
		if (colorResult.get("g") != null) {
			greenCounter = colorResult.get("g");
		}
		jdbcTemplate.update(sqlInsertPost, userId,whiteCounter,blueCounter,blackCounter,redCounter,greenCounter);
	}

	
}
