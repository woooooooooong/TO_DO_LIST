package com.javalec.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.project.dao.Categorylist_dao;

public class CategorylistCommand implements PCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Categorylist_dao dao = new Categorylist_dao();
		ArrayList<BDto> dtos = dao.list();
		
		request.setAttribute("list", dtos);
	}
}
