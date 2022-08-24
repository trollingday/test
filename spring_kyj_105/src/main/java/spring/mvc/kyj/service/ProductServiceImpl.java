package spring.mvc.kyj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.kyj.dao.ProductDAO;
import spring.mvc.kyj.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO dao;
	
	@Override
	public List<ProductDTO> productList(Map<String, Object> map) {
		return dao.productList(map);
	}	

    @Override
    public int productAddAction(ProductDTO dto) {
	    return dao.productInsert(dto);
    }
    
	@Override
	public ProductDTO productDetail(Map<String, Object> map) {
		return dao.getProductDetail(map);
	}	   

	@Override
	public int productUpdateAction(ProductDTO dto) {
		return dao.productUpdate(dto);
	}

	@Override
	public int productDeleteAction(int pdNo) {
		return dao.productDelete(pdNo);
	}

	@Override
	public List<ProductDTO> productAll() {
		return dao.productAll();
	}

}