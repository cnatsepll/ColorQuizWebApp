package com.benz.quizJDBC;

import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.benz.quizClasses.User;
import com.benz.quizClasses.UserDao;

@Component
public class JDBCUserDao implements UserDao{
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCUserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public User initiateUser(User newUser) {
		String sqlInsertPost = "INSERT INTO users(username, self_definition) VALUES (?,?)"
				+ " RETURNING user_id";
		int userId = jdbcTemplate.queryForObject(sqlInsertPost, int.class, newUser.getUserName(), newUser.getSelfDefinition());
		newUser.setUserId(userId);
		return newUser;
	}

	public int getUserIdFromDatabase() {
		String sqlQueryPost = "SELECT user_id from users ORDER BY user_id DESC LIMIT 1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryPost);
		int maxId = results.getInt("user_id");
		return (maxId+1);
	}
	
	public String returnUsernameFromDatabase(User newUser) {
		String sqlQueryPost = "SELECT * FROM users WHERE post_date = ? AND username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryPost, newUser.getDatePosted(), newUser.getUserName());
		return results.getString("username");
	}
	
//	private User mapRowToUser(SqlRowSet results) {
//		User newUser;
//		newUser = new User();
//		newUser.setDatePosted((LocalDateTime)(results.getLocalDateTime("post_date"));
//		newUser.setSelfDefinition(selfDefinition);
//		newUser.setUserId(userId);
//		newUser.setUserName(userName);
//
//		return newUser;
//	}
//	
}
