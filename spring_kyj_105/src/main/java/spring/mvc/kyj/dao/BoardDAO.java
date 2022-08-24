package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.kyj.dto.BoardCommentDTO;
import spring.mvc.kyj.dto.BoardDTO;

public interface BoardDAO {
	
	public List<BoardDTO> boardList(Map<String, Object> map);

	public int boardCnt();
		
	public int boardInsert(BoardDTO dto);
	
	public void plusReadCnt(int num);
	
	public BoardDTO getBoardDetail(int num);
	
	public int commentInsert(BoardCommentDTO dto);
	
	public List<BoardCommentDTO> getCommentList(int board_num);

}
