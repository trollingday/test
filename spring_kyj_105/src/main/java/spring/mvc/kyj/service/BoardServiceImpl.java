package spring.mvc.kyj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.kyj.common.FileService;
import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.dao.BoardDAO;
import spring.mvc.kyj.dto.BoardCommentDTO;
import spring.mvc.kyj.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public ModelAndView boardList(String pageNum) {	
		
		//페이징처리 계산
		Pagination paging = new Pagination(pageNum);
		int total=dao.boardCnt();
		paging.setTotalCount(total);
		
		//페이징처리된 게시물 데이터 받아오기
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());	
		
		List<BoardDTO> boardBox = dao.boardList(map);
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("board/qna/boardList");
		mav.addObject("boardBox", boardBox);
		mav.addObject("paging",paging);
		
		return mav;
	}

	@Override
	public ModelAndView boardInsert(MultipartHttpServletRequest req, BoardDTO dto) {
		
		//파일업로드
		FileService fs=new FileService();		
		MultipartFile file = fs.uploadFile(req);
		
		dto.setPdImg("/kyj/resources/upload2/" + file.getOriginalFilename());
		dto.setNum(dao.boardCnt());
		
		int insertCnt = dao.boardInsert(dto);
				
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("board/qna/boardList");
		mav.addObject("insertCnt", insertCnt);
		
		return mav;
	}

	@Override
	public ModelAndView boardDetail(int num) {	
				
		//조회수 증가
		dao.plusReadCnt(num);
		
		BoardDTO dto = dao.getBoardDetail(num);
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("board/qna/boardDetail");
		mav.addObject("dto", dto);
		
		return mav;	
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
