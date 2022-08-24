package spring.mvc.kyj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.kyj.common.FileService;
import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.dao.ProductDAO;
import spring.mvc.kyj.dto.ProductDTO;
import spring.mvc.kyj.service.ProductServiceImpl;

@Controller
public class StockController {
	
	private static final Logger logger = LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	ProductServiceImpl service;
	
	@Autowired
	ProductDAO dao;	
	
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

		Pagination paging = new Pagination(pageNum);
		int total=dao.productCnt();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		Map<String, Object> map=new HashMap<String, Object>();	
		map.put("start", start);
		map.put("end", end);
		List<ProductDTO> productBox = service.productList(map);
		
		model.addAttribute("productBox", productBox);
		model.addAttribute("paging",paging);	
		
		logger.info(paging.toString());
				
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
		
		//파일업로드
		FileService fs=new FileService();		
		MultipartFile file = fs.uploadFile(req);
		  
		// 1   비스포크   /jsp_pj_105/resources/upload/비스포크냉장고.jpg   주방가전   삼성   비스포크 디자인, 성능 최신형   890000   5   판매중   22/02/28
		// upload폴더를 새로고침하면 등록한 이미지가 들어온다.
		String p_img1 = "/kyj/resources/upload/" + file.getOriginalFilename();
		dto.setPdImg(p_img1);
		    
		int insertCnt = service.productAddAction(dto);
		model.addAttribute("insertCnt",insertCnt);
		
		return "manager/stock/productAddAction";
	}

	//재고정보 수정 페이지로 이동
	@RequestMapping("productUpdate.st")
	public String productUpdate(Model model, int pdNo, int pageNum) {
		logger.info("[url => productUpdate.st]");
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pdNo", pdNo);
		map.put("pageNum", pageNum);
		
		ProductDTO dto = service.productDetail(map);	
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);	
		
		return "manager/stock/productUpdate";
	}

	//재고정보 수정
	@RequestMapping("productUpdateAction.st")
	public String productUpdateAction(MultipartHttpServletRequest req, Model model, ProductDTO dto, String pageNum) {
		logger.info("[url => productUpdateAction.st]");
	   
		//파일업로드
		FileService fs=new FileService();		
		MultipartFile file = fs.uploadFile2(req);
		
		if(!file.isEmpty()) {	  
		    String p_img1 = "/kyj/resources/upload/" + file.getOriginalFilename(); 
		    System.out.println("p_img1 : "+p_img1);
			dto.setPdImg(p_img1);	
		} else {
			dto.setPdImg(req.getParameter("pdImg02"));
		}
		  
		int updateCnt = service.productUpdateAction(dto);
		  	
		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("pageNum", pageNum);		
			
		return "manager/stock/productUpdateAction";
	}
	
	//재고정보 삭제 페이지로 이동
	@RequestMapping("productDelete.st")
	public String productDelete(Model model, int pdNo, int pageNum) {
		logger.info("[url => productDelete.st]");
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pdNo", pdNo);
		map.put("pageNum", pageNum);
		
		ProductDTO dto = service.productDetail(map);	
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);	
		
		return "manager/stock/productDelete";
	}

	//재고정보를 삭제
	@RequestMapping("productDeleteAction.st")
	public String productDeleteAction(int pdNo, int pageNum, Model model) {
		logger.info("[url => productDeleteAction.st]");
	
		int deleteCnt = service.productDeleteAction(pdNo);
		
		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
		
		return "manager/stock/productDeleteAction";
	}
	
	//--------------- [product] -------------------------
	
	//고객에게 모든 상품정보를 보여준다.
	@RequestMapping("productAll.st")
	public String productAll(Model model) {
		logger.info("[url => productAll.st]");
		
		List<ProductDTO> productBox = service.productAll();
		
		model.addAttribute("productBox", productBox);
		
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
