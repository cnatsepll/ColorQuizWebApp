package com.benz.quizClasses;

public interface UserDao {
	public User initiateUser(User newUser);
	
	public int getUserIdFromDatabase();
	
	public String returnUsernameFromDatabase(User newUser);
}
