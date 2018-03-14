package com.benz.quizClasses;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface QuizDao {

	public void storeUserAnswer(int userId, String colorTypeKey, String question, int answer);
	
	public void storeUserFinalResults(int userId, Map<String, Integer> colorResult);
}
