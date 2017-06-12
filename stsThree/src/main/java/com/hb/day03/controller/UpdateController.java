package com.hb.day03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.day03.model.dao.GuestDao;
import com.hb.day03.model.dto.GuestVo;

@Controller
public class UpdateController {
	@Autowired
	private GuestDao guestDao;

	@RequestMapping(value="/guest",method=RequestMethod.GET)
	public String addForm(){
		return "form";
	}
	@RequestMapping(value="/guest",method=RequestMethod.POST)
	public String insertOne(@ModelAttribute GuestVo bean){
		try {
			guestDao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	/* 
	 * PUT 메서드 활용
	 * 1. web.xml -> HiddenHttpMethodFilter클래스 filter등록
	 * 2. form tag에 아래 추가
	 * 		<input type="hidden" name="_method" value="put" />
	 * 단, form tag의 method=post
	 * 
	 * */
	@RequestMapping(value="/guest/{idx}",method=RequestMethod.PUT)
	public String updateOne(@PathVariable int idx, @ModelAttribute GuestVo bean){
		try {
			guestDao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/guest/"+idx;
	}
	
	@RequestMapping(value="/guest/{idx}",method=RequestMethod.DELETE)
	public String deleteOne(@PathVariable int idx){
		try {
			guestDao.deleteOne(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "home";
	}
}








