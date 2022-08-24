package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.kyj.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	SqlSession sqlSession;

	@Override
	public int idCheck(String strId) {
		
		//sqlSession.selectOne("패키지명.id",매개변수);
		//selectOne : 1건, selectList : 여러건
		return sqlSession.selectOne("spring.mvc.kyj.dao.CustomerDAO.idCheck",strId);
	}

	@Override
	public int insertCustomer(CustomerDTO dto) {
		return sqlSession.insert("spring.mvc.kyj.dao.CustomerDAO.insertCustomer",dto);
	}

	@Override
	public int selectKey(String key) {
	      return sqlSession.selectOne("spring.mvc.kyj.dao.CustomerDAO.selectKey", key);   
	}

	@Override
	public int updateGrade(String key) {
	      return sqlSession.update("spring.mvc.kyj.dao.CustomerDAO.updateGrade", key);   
	}
	
	@Override
	public CustomerDTO getCustomerDetail(String strId) {		
		return sqlSession.selectOne("spring.mvc.kyj.dao.CustomerDAO.getCustomerDetail",strId);
	}	
		
	@Override
	public int updateCustomer(CustomerDTO dto) {		
		return sqlSession.update("spring.mvc.kyj.dao.CustomerDAO.updateCustomer",dto);
	}

	@Override
	public int deleteCustomer(String strId) {		
		return sqlSession.delete("spring.mvc.kyj.dao.CustomerDAO.deleteCustomer",strId);
	}

	@Override
	public List<CustomerDTO> memberList(Map<String, Object> map) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);	
		return dao.memberList(map);		
	}

	@Override
	public int memberCnt() {
		 CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);	 
	     return dao.memberCnt();
	}
	
}	