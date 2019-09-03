package com.bridgelabz.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.LoginPojo;
import com.bridgelabz.model.RegistrationDetails;

@Repository
public class Repo {

	RegistrationDetails details;
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

//setter injection dataSource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

//setter injection for jdbcTemplate
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//registration
	public int doregister(RegistrationDetails userDetails) {

		String sql = "insert into UserRegistration(firstname,lastname,gender,country,password,mobileNumber,emailId) values('"
				+ userDetails.getFirstname() + "','" + userDetails.getLastname() + "','" + userDetails.getGender()
				+ "','" + userDetails.getCountry() + "','" + userDetails.getPassword() + "','"
				+ userDetails.getMobileNumber() + "','" + userDetails.getEmailId() + "')";
		int execute = jdbcTemplate.update(sql);
		return execute;
	}

//login
	public int doLogin(LoginPojo loginDetails) {

		String sql = "select * from UserRegistration where emailId='" + loginDetails.getFirstname() + "' and password='"
				+ loginDetails.getPassword() + "'";
		List<RegistrationDetails> details = jdbcTemplate.query(sql, new GetUser());
		if (details.size() != 0) {
			return 1;
		} else
			return 0;
	}

//fetching data from database table 
	class GetUser implements RowMapper<RegistrationDetails> {
		@Override
		public RegistrationDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

			RegistrationDetails details = new RegistrationDetails();
			details.setFirstname(rs.getString("firstname"));
			details.setLastname(rs.getString("lastname"));
			details.setCountry(rs.getString("country"));
			details.setEmailId(rs.getString("emailId"));
			details.setMobileNumber(rs.getString("mobileNumber"));
			details.setPassword(rs.getString("password"));
			return details;
		}
	}

//checking whether the email is in database or not
	public int checkEmail(String email) {

		String sql = "select * from UserRegistration where emailId= '" + email + "'";
		List<RegistrationDetails> details = jdbcTemplate.query(sql, new GetUser());
		if (details.size() > 0) {
			return 1;
		}
		return 0;
	}

//setting password to database
	public void setPasswordToDataBase(String password, String email) {

		String sql = "update UserRegistration set password = ? where emailId= ?";
		int n = jdbcTemplate.update(sql, password, email);
	}
}