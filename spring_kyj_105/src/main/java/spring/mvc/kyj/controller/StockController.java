package spring.mvc.kyj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.kyj.dto.ProductDTO;
import spring.mvc.kyj.service.ProductServiceImpl;

@Controller
public class StockController {
	
	private static final Logger logger = LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	ProductServiceImpl service;
	
	//관리자 메인페이지 이동
	@RequestMapping("adminMain.st")
	public String adminMain() {
		logger.info("[url => adminMain.st]");
		
		return "manager/common/adminMain";
	}
	
	//--------------- [stock] -------------------------
		
	//재고목록을 보여준다.
	@RequestMapping("productList.st")
	public String productList(String pageNum, Model model) {
		logger.info("[url => productList.st]");

		service.productList(pageNum, model);
		
		return "manager/stock/productList";
	}
	
	//재고정보 입력페이지로 이동
	@RequestMapping("productAdd.st")
	public String productAdd() {
		logger.info("[url => productAdd.st]");
				 
		return "manager/stock/productAdd";
	}
	
	//재고정보 입력한다.
	@RequestMapping("productAddAction.st")
	public String productAddAction(MultipartHttpServletRequest req, ProductDTO dto, Model model) {
		logger.info("[url => productAddAction.st]");
		
		service.productAddAction(req, dto, model);
		
		return "manager/stock/productAddAction";
	}

	//재고정보 수정 페이지로 이동
	@RequestMapping("productUpdate.st")
	public String productUpdate(Model model, int pdNo, int pageNum) {
		logger.info("[url => productUpdate.st]");
		
		service.productDetail(model, pdNo, pageNum);
		
		return "manager/stock/productUpdate";
	}

	//재고정보 수정
	@RequestMapping("productUpdateAction.st")
	public String productUpdateAction(MultipartHttpServletRequest req, Model model, ProductDTO dto, String pageNum) {
		logger.info("[url => productUpdateAction.st]");
	   
		service.productUpdateAction(req, model, dto, pageNum);
			
		return "manager/stock/productUpdateAction";
	}
	
	//재고정보 삭제 페이지로 이동
	@RequestMapping("productDelete.st")
	public String productDelete(Model model, int pdNo, int pageNum) {
		logger.info("[url => productDelete.st]");
		
		service.productDetail(model, pdNo, pageNum);
		
		return "manager/stock/productDelete";
	}

	//재고정보를 삭제
	@RequestMapping("productDeleteAction.st")
	public String productDeleteAction(int pdNo, int pageNum, Model model) {
		logger.info("[url => productDeleteAction.st]");
	
		service.productDeleteAction(pdNo, pageNum, model);
		
		return "manager/stock/productDeleteAction";
	}
	
	//--------------- [product] -------------------------
	
	//고객에게 모든 상품정보를 보여준다.
	@RequestMapping("productAll.st")
	public String productAll(Model model) {
		logger.info("[url => productAll.st]");
		
		service.productAll(model);
		
		return "product/productAll";
	}
	
	//고객에게 클릭한 상품 상세정보를 보여준다.
	@RequestMapping("productDetail2.st")
	public String productDetail2(ProductDTO dto, Model model) {
		logger.info("[url => productDetail2.st]");
		
		model.addAttribute("dto", dto);
		
		return "product/productDetail";
	}
	
}
