package com.hb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hb.model.Dao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("/my.xml");
		Dao dao=(Dao) ac.getBean("dao");
		dao.print();
		dao.print();
		dao.print();
		dao.print();
	}

}
