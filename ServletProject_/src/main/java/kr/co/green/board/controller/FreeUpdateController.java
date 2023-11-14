package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.board.model.service.BoardServiceImpl;


@WebServlet("/boardUpdate.do")
public class FreeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FreeUpdateController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//1값받기
		int idx =Integer.valueOf(request.getParameter("idx"));
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		
		
		//2서비스호출
		BoardDTO nufree = new BoardDTO();
		
		nufree.setIdx(idx);
		nufree.setTitle(title);
		nufree.setContent(content);
		
		BoardServiceImpl nufreeService = new BoardServiceImpl();
		int result = nufreeService.boardUpdate(nufree);
		//3성공유무에따라
		
		if(result==0) {
			System.out.println("실패했씁니다");
			response.sendRedirect("/views/common/error.jsp");	
		}else {
			System.out.println("성공");
			response.sendRedirect("/freeList.do?cpage=1");
			
		}
		
		
	}

}
