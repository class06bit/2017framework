package com.hb.day04pm.model.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GuestDaoTest {
	private static GuestDao guestDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String path="/config-context.xml";
		ApplicationContext context
		=new ClassPathXmlApplicationContext(path);
		guestDao=(GuestDao) context.getBean("guestDao");
	}
	
	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(guestDao.selectAll());
	}

}
