/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacedevotees.common;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

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
	 * 
	 * @param database
	 * @param user
	 * @param password
	 */
	public static void initialize(String database, String user, String password) {
		String dbUrl = String.format("jdbc:mysql://localhost:3306/%s?useUnicode=true&characterEncoding=UTF-8",
				database);

		AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext();
		context = context1;
		context1.register(AppInitializer.class);

		ConfigurableEnvironment environment = new StandardEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();
		Map<String, Object> myMap = new HashMap<>();
		myMap.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		myMap.put("db.driver", "com.mysql.jdbc.Driver");
		myMap.put("db.url", dbUrl);
		myMap.put("db.user", user);
		myMap.put("db.password", password);
		propertySources.addFirst(new MapPropertySource("MY_MAP", myMap));
		context1.setEnvironment(environment);
		context1.refresh();

	}

	public static DevoteeDao devoteeDao() {
		return context.getBean(DevoteeDao.class);
	}

	public static boolean areCredentialsValid(String database, String user, String password)
			throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			java.sql.Connection connect = DriverManager.getConnection(
					String.format("jdbc:mysql://localhost/%s?user=%s&password=%s", database, user, password));
			return connect.isValid(5);
		} catch (SQLException ex) {
			return false;
		}
	}

	public static void main(String[] args) {
		DBControls.initialize("dude", "root", "root");
		DevoteeDao dao = DBControls.devoteeDao();
		Devotee devotee = new Devotee();
		devotee.setName("Haribol");
		dao.save(devotee);
	}

}
