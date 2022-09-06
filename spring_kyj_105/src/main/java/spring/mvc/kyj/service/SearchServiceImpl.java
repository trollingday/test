package spring.mvc.kyj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.kyj.dao.SearchDAO;
import spring.mvc.kyj.dto.BoardDTO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.OrderDTO;
import spring.mvc.kyj.dto.ProductDTO;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	SearchDAO dao;

	@Override
	public List<BoardDTO> searchBoardList(Map<String, Object> searchMap) {
		return dao.searchBoardList(searchMap);
	}

	@Override
	public int searchBoardNewNum(Map<String, Object> searchMap) {
		return dao.searchBoardNewNum(searchMap);
	}

	@Override
	public List<CustomerDTO> searchMemberList(Map<String, Object> searchMap) {
		return dao.searchMemberList(searchMap);
	}

	@Override
	public int searchMemberNewNum(Map<String, Object> searchMap) {
		return dao.searchMemberNewNum(searchMap);
	}

	@Override
	public List<OrderDTO> searchOrderList(Map<String, Object> searchMap) {
		return dao.searchOrderList(searchMap);
	}

	@Override
	public int searchOrderNewNum(Map<String, Object> searchMap) {
		return dao.searchOrderNewNum(searchMap);
	}

	@Override
	public List<OrderDTO> searchRefundList(Map<String, Object> searchMap) {
		return dao.searchRefundList(searchMap);
	}

	@Override
	public int searchRefundNewNum(Map<String, Object> searchMap) {
		return dao.searchRefundNewNum(searchMap);
	}

	@Override
	public List<ProductDTO> searchProductList(Map<String, Object> searchMap) {
		return dao.searchProductList(searchMap);
	}

	@Override
	public int searchProductNewNum(Map<String, Object> searchMap) {
		return dao.searchProductNewNum(searchMap);
	}
	
}
