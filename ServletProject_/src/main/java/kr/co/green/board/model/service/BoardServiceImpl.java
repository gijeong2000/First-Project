package kr.co.green.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.board.model.dao.FreeDAO;
import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;

public class BoardServiceImpl implements BoardService {
	private Connection con;
	private DatabaseConnection dc;
	private FreeDAO freeDAO;
	
	public BoardServiceImpl() {
		freeDAO = new FreeDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	// 게시글 목록 조회
	public ArrayList<BoardDTO> boardList(PageInfo pi,String searchText) {
		return freeDAO.boardList(con, pi ,searchText);
	}
	
	
	// 전체 게시글 수
	public int boardListCount(String searchText) {
		return freeDAO.boardListCount(con,searchText);
	}
	
	// 글 등록
	public int boardEnroll(String title, String content, String name) {
		return freeDAO.boardEnroll(con, title, content, name);
	}
	
	// 조회수 +1
	public int boardView(int idx) {
		return freeDAO.boardView(con, idx);
	}

	
	@Override
	public void boardSelect(BoardDTO board) {
	freeDAO.boardSelect(con,board);
		
	}

	@Override
	public int boardUpdate(BoardDTO nufree) {
		
		return freeDAO.boardUpdate(con,nufree);
	}

	@Override
	public int boardDelete(int idx) {
		
		return freeDAO.boardDelete(con,idx);
	}
	
	
}











