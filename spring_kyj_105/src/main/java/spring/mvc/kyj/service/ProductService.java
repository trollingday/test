package spring.mvc.kyj.service;

import java.util.List;
import java.util.Map;

import spring.mvc.kyj.dto.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> productList(Map<String, Object> map);
	
	public int productAddAction(ProductDTO dto);

	public ProductDTO productDetail(Map<String, Object> map);

	public int productUpdateAction(ProductDTO dto);
	
	public int productDeleteAction(int pdNo);

	public  List<ProductDTO> productAll();
	
}
