package spring.mvc.kyj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.kyj.common.FileService;
import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.dao.ProductDAO;
import spring.mvc.kyj.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO dao;
	
	@Override
	public void productList(String pageNum, Model model) {
		
		Pagination paging = new Pagination(pageNum);
		int total=dao.productCnt();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		Map<String, Object> map=new HashMap<String, Object>();	
		map.put("start", start);
		map.put("end", end);
		
		List<ProductDTO> productBox = dao.productList(map);
		
		model.addAttribute("productBox", productBox);
		model.addAttribute("paging",paging);	

	}	

    @Override
    public void productAddAction(MultipartHttpServletRequest req, ProductDTO dto, Model model) {
    	
		//파일업로드
		FileService fs=new FileService();		
		MultipartFile file = fs.uploadFile(req);
		  
		// 1   비스포크   /jsp_pj_105/resources/upload/비스포크냉장고.jpg   주방가전   삼성   비스포크 디자인, 성능 최신형   890000   5   판매중   22/02/28
		// upload폴더를 새로고침하면 등록한 이미지가 들어온다.
		String p_img1 = "/kyj/resources/upload/" + file.getOriginalFilename();
		dto.setPdImg(p_img1);
		    
		int insertCnt = dao.productInsert(dto);
		
		model.addAttribute("insertCnt",insertCnt);
    	
    }
    
	@Override
	public void productDetail(Model model, int pdNo, int pageNum) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pdNo", pdNo);
		map.put("pageNum", pageNum);
		
		ProductDTO dto = dao.getProductDetail(map);
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);	
		
	}	   

	@Override
	public void productUpdateAction(MultipartHttpServletRequest req, Model model, ProductDTO dto, String pageNum) {
		
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
		  
		int updateCnt = dao.productUpdate(dto);
		  	
		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("pageNum", pageNum);		
		
	}

	@Override
	public void productDeleteAction(int pdNo, int pageNum, Model model) {
		
		int deleteCnt = dao.productDelete(pdNo);
		
		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("pageNum", pageNum);
		
	}

	@Override
	public void productAll(Model model) {
		
		List<ProductDTO> productBox = dao.productAll();
		
		model.addAttribute("productBox", productBox);
	}

}