package com.homework.jdbctest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class DbConnection {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "w3_d1_15maggio";
	String user = "postgres";
	String pass = "root";
	Connection conn;
	Statement st;
	
	public DbConnection() throws SQLException {
		conn = DriverManager.getConnection(url+dbName, user,pass);
		st = conn.createStatement();
		System.out.println("DB Connesso!!");
	}
	
	public void insertStudent(Studenti s) throws SQLException {
		String sql = "INSERT INTO school_students " 
				+ "(name, lastname, gender, birthdate, avg, min_vote, max_vote)" 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, s.getName());
		ps.setString(2, s.getLastname());
		ps.setString(3, s.getGender().toString());
		ps.setDate(4, Date.valueOf(s.getBirthdate()));
		ps.setDouble(5, s.getAvg());
		ps.setInt(6, s.getMin_vote());
		ps.setInt(7, s.getMax_vote());
		ps.executeUpdate();
		System.out.println(s.getName() + " " + s.getLastname() + " salvato nel DB");
	}
	
	public void updateStudent(int id, HashMap<String, Object> s) {
		
	}
	
	public void deleteStudent(int id) {
		
	}
	
	public Studenti getBest() {
		
		return null;
	}
	
	public List<Studenti> getVoteRange(int min, int max) {
		
		return null;
	}
	
	
}
