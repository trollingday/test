package spring.mvc.kyj.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.kyj.dto.BoardCommentDTO;
import spring.mvc.kyj.dto.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> boardList(Map<String, Object> map);
	
	public int boardInsert(MultipartHttpServletRequest req, BoardDTO dto);
		
	public BoardDTO boardDetail(int num);
		
	public void commentAdd(BoardCommentDTO dto);
		
	public List<BoardCommentDTO> commentList(int board_num);

}
