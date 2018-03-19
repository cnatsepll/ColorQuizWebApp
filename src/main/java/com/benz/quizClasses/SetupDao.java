package com.benz.quizClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;


public interface SetupDao {
		
	public List<URL> createFilePathsList();
	
	public void resetQuestionTables();
	
	public Map<Integer, List> fillQuestionsTablesReturnQuestionQuiz(List<URL> filePaths) throws FileNotFoundException, IOException;
	
	

}
