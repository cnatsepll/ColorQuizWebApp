package com.benz.quizClasses;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


public interface SetupDao {
		
	public List<String> createFilePathsList();
	
	public void resetQuestionTables();
	
	public Map<Integer, List> fillQuestionsTablesReturnQuestionQuiz(List<String> filePaths) throws FileNotFoundException;
	
	

}
