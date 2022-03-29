package com.javalec.project.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.project.command.CategorylistCommand;
import com.javalec.project.command.PCommand;

/**
 * Servlet implementation class homecontroller
 */
@WebServlet("*.do")
public class homecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8"); //한글처리를 줘야되기때문에 써줘야됨
		
		String viewPage = null; // viewPage는 사용자가 보는 화면을 뜻함. switch를 통해 이줄밑에는 viewPage의 종류를 정의해주면됨
		PCommand command =null;
		
		String uri = request.getRequestURI(); // uri는 프로젝트 이름/~.do
		String conPath = request.getContextPath(); // conPath는 프로젝트 이름
		String com = uri.substring(conPath.length()); // com은 ~.do
		
//		System.out.println(uri); 
//		System.out.println(conPath);
//		System.out.println(com);
		
		switch(com) {
		case("/categorylist.do"): // /list.do -> 전체 내용 보여주기
			
			command = new CategorylistCommand();
			command.execute(request, response);
			viewPage = "categorylist.jsp";
			break;
			
		
//		
//		case("/content_view.do"):
//			command = new BContentCommand();
//			command.execute(request, response);
//			viewPage = "content_view.jsp";
//			break;
//			
//		case("/modify.do"):
//			command = new BModifyCommand();
//			command.execute(request, response);
//			viewPage = "list.do";
//		break;
		
		
		} // switch(com)
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}//actiondo
}
