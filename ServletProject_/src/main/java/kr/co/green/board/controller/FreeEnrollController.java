package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.board.model.service.BoardServiceImpl;

@WebServlet("/freeEnroll.do")
public class FreeEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FreeEnrollController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 1. 내용, 제목 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 2. 세션에 있는 name 꺼내기
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		// 3. 서비스 호출
		BoardServiceImpl boardService = new BoardServiceImpl();
		int result = boardService.boardEnroll(title, content, name);

		// 4. 성공 유무에 따라 처리
		if (result > 0) {
			response.sendRedirect("/freeList.do?cpage=1");
		} else {

		}

	}

}
