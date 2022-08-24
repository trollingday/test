package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.kyj.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ProductDTO> productList(Map<String, Object> map) {
		ProductDAO dao = sqlSession.getMapper(ProductDAO.class);		
		return dao.productList(map);
	}	

	@Override
	public int productCnt() {
		ProductDAO dao = sqlSession.getMapper(ProductDAO.class);
		return dao.productCnt();	
	}	
		
	@Override
	public int productInsert(ProductDTO dto) {
		ProductDAO dao = sqlSession.getMapper(ProductDAO.class);
	    return dao.productInsert(dto);
	}
		
	@Override
	public ProductDTO getProductDetail(Map<String, Object> map) {
		ProductDAO dao = sqlSession.getMapper(ProductDAO.class);
		return dao.getProductDetail(map);				
	}

	@Override
	public int productUpdate(ProductDTO dto) {
		return sqlSession.update("spring.mvc.kyj.dao.ProductDAO.productUpdate",dto);		
	}

	@Override
	public int productDelete(int pdNo) {
		return sqlSession.delete("spring.mvc.kyj.dao.ProductDAO.productDelete",pdNo);		
	}

	@Override
	public List<ProductDTO> productAll() {
		ProductDAO dao = sqlSession.getMapper(ProductDAO.class);
		return dao.productAll();
	}
		
}
