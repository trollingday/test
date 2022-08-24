package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.kyj.dto.ProductDTO;

public interface ProductDAO {

	public List<ProductDTO> productList(Map<String, Object> map);
	
	public int productCnt();
	
	public int productInsert(ProductDTO dto);
	
	public ProductDTO getProductDetail(Map<String, Object> map);

	public int productUpdate(ProductDTO dto);
	
	public int productDelete(int pdNo);	
	
	public List<ProductDTO> productAll();

}
