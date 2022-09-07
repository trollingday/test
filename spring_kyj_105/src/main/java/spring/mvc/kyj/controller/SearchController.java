package spring.mvc.kyj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.dto.BoardDTO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.OrderDTO;
import spring.mvc.kyj.dto.ProductDTO;
import spring.mvc.kyj.service.SearchServiceImpl;

@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	SearchServiceImpl service;
	
	@RequestMapping("boardKeyword.sc")	
	public ModelAndView searchKeyword1(String selectBox, String keyword, String pageNum){	
		
		logger.info("[url => boardKeyword.sc]");

		Map<String, Object> searchMap=new HashMap<String, Object>();
		searchMap.put("type", selectBox);
		searchMap.put("keyword", keyword);
		searchMap.put("pageNum", pageNum);
		
		//페이징처리 계산
		Pagination paging = new Pagination(pageNum);
		int total=service.searchBoardNewNum(searchMap);
		paging.setTotalCount(total);
		
		searchMap.put("start", paging.getStartRow());
		searchMap.put("end", paging.getEndRow());	
		
		List<BoardDTO> boardlist = service.searchBoardList(searchMap);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manager/board/qna/boardList");
		mav.addObject("boardBox", boardlist);
		mav.addObject("paging2",paging);
		mav.addObject("searchMap",searchMap);

		return mav;								
	} 

	@RequestMapping("memberKeyword.sc")	
	public ModelAndView searchKeyword2(String selectBox, String keyword, String pageNum){	
		
		logger.info("[url => memberKeyword.sc]");

		Map<String, Object> searchMap=new HashMap<String, Object>();
		searchMap.put("type", selectBox);
		searchMap.put("keyword", keyword);
		searchMap.put("pageNum", pageNum);
		
		//페이징처리 계산
		Pagination paging = new Pagination(pageNum);
		int total=service.searchMemberNewNum(searchMap);
		paging.setTotalCount(total);
		
		searchMap.put("start", paging.getStartRow());
		searchMap.put("end", paging.getEndRow());	
		
		List<CustomerDTO> memberlist = service.searchMemberList(searchMap);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manager/member/memberList");
		mav.addObject("memberBox", memberlist);
		mav.addObject("paging2",paging);
		mav.addObject("searchMap",searchMap);

		return mav;								
	} 
	
	@RequestMapping("orderKeyword.sc")	
	public ModelAndView searchKeyword3(String selectBox, String keyword, String pageNum){	
		
		logger.info("[url => orderKeyword.sc]");

		Map<String, Object> searchMap=new HashMap<String, Object>();
		searchMap.put("type", selectBox);
		searchMap.put("keyword", keyword);
		searchMap.put("pageNum", pageNum);
		
		//페이징처리 계산
		Pagination paging = new Pagination(pageNum);
		int total=service.searchOrderNewNum(searchMap);
		paging.setTotalCount(total);
		
		searchMap.put("start", paging.getStartRow());
		searchMap.put("end", paging.getEndRow());	
		
		List<OrderDTO> orderlist = service.searchOrderList(searchMap);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manager/order/orderList");
		mav.addObject("OrderBox", orderlist);
		mav.addObject("paging2",paging);
		mav.addObject("searchMap",searchMap);

		return mav;								
	} 

	@RequestMapping("refundKeyword.sc")	
	public ModelAndView searchKeyword4(String selectBox, String keyword, String pageNum){	
		
		logger.info("[url => refundKeyword.sc]");

		Map<String, Object> searchMap=new HashMap<String, Object>();
		searchMap.put("type", selectBox);
		searchMap.put("keyword", keyword);
		searchMap.put("pageNum", pageNum);
		
		//페이징처리 계산
		Pagination paging = new Pagination(pageNum);
		int total=service.searchRefundNewNum(searchMap);
		paging.setTotalCount(total);
		
		searchMap.put("start", paging.getStartRow());
		searchMap.put("end", paging.getEndRow());	
		
		List<OrderDTO> refundlist = service.searchRefundList(searchMap);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manager/order/refundList");
		mav.addObject("refundBox", refundlist);
		mav.addObject("paging2",paging);
		mav.addObject("searchMap",searchMap);

		return mav;								
	}
	
	@RequestMapping("productKeyword.sc")	
	public ModelAndView searchKeyword5(String selectBox, String keyword, String pageNum){	
		
		logger.info("[url => productKeyword.sc]");

		Map<String, Object> searchMap=new HashMap<String, Object>();
		searchMap.put("type", selectBox);
		searchMap.put("keyword", keyword);
		searchMap.put("pageNum", pageNum);
		
		//페이징처리 계산
		Pagination paging = new Pagination(pageNum);
		int total=service.searchProductNewNum(searchMap);
		paging.setTotalCount(total);
		
		searchMap.put("start", paging.getStartRow());
		searchMap.put("end", paging.getEndRow());	
		
		List<ProductDTO> productlist = service.searchProductList(searchMap);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manager/stock/productList");
		mav.addObject("productBox", productlist);
		mav.addObject("paging2",paging);
		mav.addObject("searchMap",searchMap);

		return mav;								
	}
	
}
