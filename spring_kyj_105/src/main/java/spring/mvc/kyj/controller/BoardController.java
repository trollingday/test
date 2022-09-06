package spring.mvc.kyj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.dao.BoardDAO;
import spring.mvc.kyj.dto.BoardCommentDTO;
import spring.mvc.kyj.dto.BoardDTO;
import spring.mvc.kyj.service.BoardServiceImpl;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardServiceImpl service;
	
	@Autowired
	BoardDAO dao;
		
	//--------------- [Q&A게시판] -----------------------
	
	//게시글 목록을 보여준다.
	@RequestMapping("qboardList.ad")
	public ModelAndView qboardList(String pageNum) {
		logger.info("[url => qboardList.ad]");
		
		//페이징처리 계산
		Pagination paging = new Pagination(pageNum);
		int total=dao.boardCnt();
		paging.setTotalCount(total);
		
		//페이징처리된 게시물 데이터 받아오기
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());	
				
		List<BoardDTO> boardBox = service.boardList(map);
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("board/qna/boardList");
		mav.addObject("boardBox", boardBox);
		mav.addObject("paging",paging);
		
		return mav;
	}
	
	@RequestMapping("qboard_insert.ad")
	public String qboard_insert() {
		logger.info("[url => qboard_insert.ad]");
		
		return "board/qna/boardInsert";
	}
	
	//게시글정보를 입력한다.
	@RequestMapping("qboard_insertAction.ad")
	public ModelAndView qboard_insertAction(MultipartHttpServletRequest req, BoardDTO dto) {
		logger.info("[url => qboard_insertAction.ad]");
		
		int insertCnt = service.boardInsert(req, dto);
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("board/qna/boardList");
		mav.addObject("insertCnt", insertCnt);
		
		return mav;
	}
	
	//게시글 상세페이지
	@RequestMapping("qboard_detailAction.ad")
	public ModelAndView qboard_detailAction(int num) {
		logger.info("[url => qboard_detailAction.ad]");
			
		//특정게시글 상세데이터를 가져온다.
		BoardDTO dto = service.boardDetail(num);
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("board/qna/boardDetail");
		mav.addObject("dto", dto);
		
		return mav;
	}
	
	//--------------- [관리자 게시판 관리] ----------------------
	
	//게시글 목록을 보여준다.
	@RequestMapping("qboardList_admin.ad")
	public ModelAndView qboardList_admin(String pageNum) {
		logger.info("[url => qboardList_admin.ad]");
				
		//페이징처리 계산
		Pagination paging = new Pagination(pageNum);
		int total=dao.boardCnt();
		paging.setTotalCount(total);
		
		//페이징처리된 게시물 데이터 받아오기
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", paging.getStartRow());
		map.put("end", paging.getEndRow());	
				
		List<BoardDTO> boardBox = service.boardList(map);
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("manager/board/qna/boardList");
		mav.addObject("boardBox", boardBox);
		mav.addObject("paging",paging);
		
		return mav;
	}
	
	//게시글 상세페이지
	@RequestMapping("qboard_detailAction_admin.ad")
	public ModelAndView qboard_detailAction_admin(int num) {
		logger.info("[url => qboard_detailAction_admin.ad]");
				
		//특정게시글 상세데이터를 가져온다.
		BoardDTO dto = service.boardDetail(num);
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("manager/qna/boardDetail");
		mav.addObject("dto", dto);
		
		return mav;
	}
	
	//--------------- [관리자 답변] ----------------------
	
	//댓글정보를 등록한다.
	@RequestMapping("commentAdd.ad")
	public void commentAdd(BoardCommentDTO dto) {
		logger.info("[url => commentAdd.ad]");
		
		service.commentAdd(dto);
	}
	
	//댓글 목록
	@ResponseBody
	@RequestMapping("commentList.ad")
	public Map<String, Object> commentList(int num) {
		logger.info("[url => commentList.ad]");

		List<BoardCommentDTO> commentBox = service.commentList(num);
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentBox", commentBox);
		
		return map;
	}
}
