package spring.mvc.kyj.service;

import java.util.List;
import java.util.Map;

import spring.mvc.kyj.dto.BoardDTO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.OrderDTO;
import spring.mvc.kyj.dto.ProductDTO;

public interface SearchService {
	
	public List<BoardDTO> searchBoardList(Map<String, Object> searchMap);
	
	public int searchBoardNewNum(Map<String, Object> searchMap);
	
	public List<CustomerDTO> searchMemberList(Map<String, Object> searchMap);
	
	public int searchMemberNewNum(Map<String, Object> searchMap);

	public List<OrderDTO> searchOrderList(Map<String, Object> searchMap);
	
	public int searchOrderNewNum(Map<String, Object> searchMap);

	public List<OrderDTO> searchRefundList(Map<String, Object> searchMap);
	
	public int searchRefundNewNum(Map<String, Object> searchMap);
	
	public List<ProductDTO> searchProductList(Map<String, Object> searchMap);
	
	public int searchProductNewNum(Map<String, Object> searchMap);
	
}
