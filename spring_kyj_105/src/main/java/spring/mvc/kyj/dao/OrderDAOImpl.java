package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.kyj.dto.ChartDTO;
import spring.mvc.kyj.dto.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int InsertOrder(OrderDTO dto) {
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);	
		return dao.InsertOrder(dto);
	}

	@Override
	public List<OrderDTO> orderList(Map<String, Object> map) {
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);		
		return dao.orderList(map);		
	}

	@Override
	public int orderCnt() {
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		return dao.orderCnt();		
	}

	@Override
	public List<OrderDTO> cusOrderList(String name) {	
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);		
		return dao.cusOrderList(name);
	}

	@Override
	public OrderDTO selectOrder(int orderNo) {
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);		 
		return dao.selectOrder(orderNo);	
	}

	@Override
	public int stockUpdate(OrderDTO dto) {
		int updateCnt = sqlSession.update("spring.mvc.kyj.dao.OrderDAO.stockUpdate",dto);
		return updateCnt;
	}

	@Override
	public int orderUpdate(Map<String, Object> map) {
		int updateCnt = sqlSession.update("spring.mvc.kyj.dao.OrderDAO.orderUpdate",map);	
		return updateCnt;
	}

	@Override
	public List<OrderDTO> refundList(Map<String, Object> map) {
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);		
		return dao.refundList(map);	
	}

	@Override
	public int refundCnt() {  
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);	 
		return dao.refundCnt();	
	}

	@Override
	public int stockUpdate2(OrderDTO dto) {	
		int updateCnt = sqlSession.update("spring.mvc.kyj.dao.OrderDAO.stockUpdate2",dto);
		return updateCnt;
	}

	@Override
	public List<OrderDTO> saleHistoryList(Map<String, Object> map) {	
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);	
		return dao.saleHistoryList(map);	
	}

	@Override
	public int payPermitCnt() {  
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);		 
		return dao.payPermitCnt();	
	}
	
	@Override
	public List<ChartDTO> saleChart() {
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		return dao.saleChart();	
	}

}
