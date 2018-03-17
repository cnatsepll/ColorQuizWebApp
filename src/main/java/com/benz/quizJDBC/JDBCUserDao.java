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
		String sqlInsertPost = "INSERT INTO users(username, post_date) VALUES (?,?)";
		newUser.setDatePosted(LocalDateTime.now());
		jdbcTemplate.update(sqlInsertPost, newUser.getUserName(), newUser.getDatePosted());
		return newUser;
	}

	public int getUserId(User newUser) {
		String sqlQueryPost = "SELECT * FROM users WHERE post_date = ? AND username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryPost, newUser.getDatePosted(), newUser.getUserName());
		int userId = results.getInt(1);
		return userId;
	}
}
