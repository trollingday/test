package spring.mvc.kyj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.kyj.dao.BoardDAO;
import spring.mvc.kyj.dto.BoardCommentDTO;
import spring.mvc.kyj.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public List<BoardDTO> boardList(Map<String, Object> map) {		
		return dao.boardList(map);
	}

	@Override
	public int boardInsert(BoardDTO dto) {
		return dao.boardInsert(dto);
	}

	@Override
	public BoardDTO boardDetail(int num) {				
		return dao.getBoardDetail(num);	
	}
	
	@Override
	public void commentAdd(BoardCommentDTO dto) {	
		dao.commentInsert(dto);
	}

	@Override
	public List<BoardCommentDTO> commentList(int board_num) {
		return dao.getCommentList(board_num);		
	}

}
