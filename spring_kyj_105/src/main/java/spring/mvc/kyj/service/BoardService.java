package spring.mvc.kyj.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.kyj.dto.BoardCommentDTO;
import spring.mvc.kyj.dto.BoardDTO;

public interface BoardService {
	
	public ModelAndView boardList(String pageNum);
	
	public ModelAndView boardInsert(MultipartHttpServletRequest req, BoardDTO dto);
		
	public ModelAndView boardDetail(int num);
		
	public void commentAdd(BoardCommentDTO dto);
		
	public List<BoardCommentDTO> commentList(int board_num);

}
