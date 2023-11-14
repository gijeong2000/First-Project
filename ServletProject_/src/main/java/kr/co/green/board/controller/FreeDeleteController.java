package kr.co.green.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.service.BoardServiceImpl;

@WebServlet("/boardDelete.do")
public class FreeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FreeDeleteController() {
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
		
		
		//값받기
		int idx =Integer.valueOf(request.getParameter("idx"));
		
		
		BoardServiceImpl freeDeleteService = new BoardServiceImpl();
		int result = freeDeleteService.boardDelete(idx);
		
		if(result==0) {
			System.out.println("삭제모다쥬");
			response.sendRedirect("/views/common/error.jsp");	
			
		}else {
			System.out.println("삭제해라 애송이");
			response.sendRedirect("/freeList.do?cpage=1");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
