package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.kyj.dto.BoardDTO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.OrderDTO;
import spring.mvc.kyj.dto.ProductDTO;

@Repository
public class SearchDAOImpl implements SearchDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardDTO> searchBoardList(Map<String, Object> searchMap) {	
		return sqlSession.selectList("searchBoardList", searchMap);
	}

	@Override
	public int searchBoardNewNum(Map<String, Object> searchMap){
		return sqlSession.selectOne("searchBoardNewNum", searchMap);
	}

	@Override
	public List<CustomerDTO> searchMemberList(Map<String, Object> searchMap) {
		return sqlSession.selectList("searchMemberList", searchMap);
	}

	@Override
	public int searchMemberNewNum(Map<String, Object> searchMap) {
		return sqlSession.selectOne("searchMemberNewNum", searchMap);
	}

	@Override
	public List<OrderDTO> searchOrderList(Map<String, Object> searchMap) {
		return sqlSession.selectList("searchOrderList", searchMap);
	}

	@Override
	public int searchOrderNewNum(Map<String, Object> searchMap) {
		return sqlSession.selectOne("searchOrderNewNum", searchMap);
	}

	@Override
	public List<OrderDTO> searchRefundList(Map<String, Object> searchMap) {
		return sqlSession.selectList("searchRefundList", searchMap);
	}

	@Override
	public int searchRefundNewNum(Map<String, Object> searchMap) {
		return sqlSession.selectOne("searchRefundNewNum", searchMap);
	}

	@Override
	public List<ProductDTO> searchProductList(Map<String, Object> searchMap) {
		return sqlSession.selectList("searchProductList", searchMap);
	}

	@Override
	public int searchProductNewNum(Map<String, Object> searchMap) {
		return sqlSession.selectOne("searchProductNewNum", searchMap);
	}

}
