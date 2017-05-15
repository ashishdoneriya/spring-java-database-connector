/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacedevotees.common;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bacedevotees.dao.DevoteeDao;
import bacedevotees.pojo.Devotee;

/**
 *
 * @author ashish
 */
public class DBControls {
	
	private static ApplicationContext context;
	/**
	 * Initialize Database and set Application Context
	 * @param database
	 * @param user
	 * @param password 
	 */
	public static void initialize(String database, String user, String password) {
		System.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		System.setProperty("db.driver", "com.mysql.jdbc.Driver");
		String dbUrl = String.format("jdbc:mysql://localhost:3306/%s?useUnicode=true&characterEncoding=UTF-8", database);
		System.setProperty("db.url", dbUrl);
		System.setProperty("db.user", user);
		System.setProperty("db.password", password);
		context = new AnnotationConfigApplicationContext(AppInitializer.class);
	}
	
	public static DevoteeDao devoteeDao(){
		return context.getBean(DevoteeDao.class);
	}
	
	public static boolean areCredentialsValid(String database, String user, String password) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			java.sql.Connection connect = DriverManager.getConnection(
			String.format("jdbc:mysql://localhost/%s?user=%s&password=%s",
					database, user, password));
			return connect.isValid(5);
		} catch (SQLException ex) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		DBControls.initialize("dude", "root", "root");
		DevoteeDao dao = DBControls.devoteeDao();
		Devotee devotee = new Devotee();
		devotee.setName("Hari");
		dao.save(devotee);
	}
	
}
