package spring.mvc.kyj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.kyj.common.FileService;
import spring.mvc.kyj.dao.BoardDAO;
import spring.mvc.kyj.dto.BoardCommentDTO;
import spring.mvc.kyj.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public List<BoardDTO> boardList(Map<String, Object> map) {	
				
		List<BoardDTO> boardBox = dao.boardList(map);
		
		return boardBox;
	}

	@Override
	public int boardInsert(MultipartHttpServletRequest req, BoardDTO dto) {
		
		//파일업로드
		FileService fs=new FileService();		
		MultipartFile file = fs.uploadFile(req);
		
		dto.setPdImg("/kyj/resources/upload2/" + file.getOriginalFilename());
		dto.setNum(dao.boardCnt());
		
		int insertCnt = dao.boardInsert(dto);
						
		return insertCnt;
	}

	@Override
	public BoardDTO boardDetail(int num) {	
				
		//조회수 증가
		dao.plusReadCnt(num);
		
		BoardDTO dto = dao.getBoardDetail(num);
				
		return dto;	
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
