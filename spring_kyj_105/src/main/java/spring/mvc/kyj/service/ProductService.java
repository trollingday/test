package spring.mvc.kyj.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.kyj.dto.ProductDTO;

public interface ProductService {
	
	public void productList(String pageNum, Model model);
	
	public void productAddAction(MultipartHttpServletRequest req, ProductDTO dto, Model model);

	public void productDetail(Model model, int pdNo, int pageNum);

	public void productUpdateAction(MultipartHttpServletRequest req, Model model, ProductDTO dto, String pageNum);
	
	public void productDeleteAction(int pdNo, int pageNum, Model model);

	public void productAll(Model model);
	
}
