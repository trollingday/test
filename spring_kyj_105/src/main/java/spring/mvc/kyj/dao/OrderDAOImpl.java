package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.kyj.dto.ChartDTO;
import spring.mvc.kyj.dto.CustomerDTO;
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

	//DB에서 모든 주문정보 검색
	@Override
	public List<OrderDTO> orderList(Map<String, Object> map) {

		System.out.println("DAO - orderList");
		
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		
		return dao.orderList(map);		
	}

	//DB에서 모든 주문정보 갯수 검색
	@Override
	public int orderCnt() {

		System.out.println("DAO - orderCnt");
		  
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		 
		return dao.orderCnt();		
	}

	//DB에서 특정회원의 주문정보 검색
	@Override
	public List<OrderDTO> cusOrderList(String name) {
		
		System.out.println("DAO - cusOrderList");
		
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		
		return dao.cusOrderList(name);
		
	}

	//DB에서 특정 주문정보 검색
	@Override
	public OrderDTO selectOrder(int orderNo) {
		
		System.out.println("DAO - selectOrder");
		  
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		 
		return dao.selectOrder(orderNo);	
	}

	//DB에 재고정보 업데이트(결제승인)
	@Override
	public int stockUpdate(OrderDTO dto) {
		
		System.out.println("DAO - stockUpdate");
		
		int updateCnt = sqlSession.update("spring.mvc.kyj.dao.OrderDAO.stockUpdate",dto);
		
		return updateCnt;
	}

	//DB에 주문정보 업데이트
	@Override
	public int orderUpdate(Map<String, Object> map) {
		
		System.out.println("DAO - orderUpdate");
		
		int updateCnt = sqlSession.update("spring.mvc.kyj.dao.OrderDAO.orderUpdate",map);
		
		return updateCnt;
	}

	//DB에서 모든 환불요청 정보 검색
	@Override
	public List<OrderDTO> refundList(Map<String, Object> map) {
		
		System.out.println("DAO - refundList");
		
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		
		return dao.refundList(map);	
	}

	//DB에서 환불요청 갯수 구하기
	@Override
	public int refundCnt() {
		
		System.out.println("DAO - refundCnt");
		  
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		 
		return dao.refundCnt();	
	}
	
	//DB에서 재고정보 업데이트(환불승인)
	@Override
	public int stockUpdate2(OrderDTO dto) {
		
		System.out.println("DAO - stockUpdate2");
		
		int updateCnt = sqlSession.update("spring.mvc.kyj.dao.OrderDAO.stockUpdate2",dto);
		
		return updateCnt;
	}

	//DB에서 결제승인 주문정보 검색(결산내역)
	@Override
	public List<OrderDTO> saleHistoryList(Map<String, Object> map) {
		
		System.out.println("DAO - saleHistoryList");
		
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		
		return dao.saleHistoryList(map);
		
	}

	//DB에서 결제승인 갯수 구하기(결산용)
	@Override
	public int payPermitCnt() {
		
		System.out.println("DAO - payPermitCnt");
		  
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		 
		return dao.payPermitCnt();	
	}

	//DB에서 월별 매출 검색(결산차트)
	@Override
	public List<ChartDTO> saleChart() {
		
		System.out.println("DAO - saleChart");
		
		OrderDAO dao = sqlSession.getMapper(OrderDAO.class);
		
		return dao.saleChart();	
	}

}
