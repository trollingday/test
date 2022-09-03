package spring.mvc.kyj.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.kyj.common.EmailChkHandler;
import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.dao.CustomerDAO;
import spring.mvc.kyj.dto.CartDTO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.JoinFormDTO;
import spring.mvc.kyj.service.CustomerServiceImpl;

@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerServiceImpl service;
	
    @Autowired
    BCryptPasswordEncoder passwordEncoder;   // 비밀번호 암호화 클래스
    
	@Autowired
	CustomerDAO dao;
	
	@RequestMapping("/")
	public String index() {
		logger.info("[url => index]");
		return "common/main";
	}
	
	//--------------- [main] -----------------------
	
	//메인페이지 이동
	@RequestMapping("main.do")
	public String main() {
		logger.info("[url => main.do]");
		return "common/main";
	}
	
	//--------------- [회원가입] -----------------------
	
	//회원가입페이지 이동
	@RequestMapping("join.do")
	public String join() {
		logger.info("[url => join.do]");
		
		return "customer/join/join";
	}
	
	//ID중복확인
	@RequestMapping("confirmIdAction.do")
	public String confirmIdAction(HttpServletRequest req, String id, Model model) {
		logger.info("[url => confirmIdAction.do]");
					
		int selectCnt = service.confirmIdAction(id);
		
		model.addAttribute("id", id);
		model.addAttribute("selectCnt", selectCnt);
		
		return "customer/join/confirmIdAction";
	}

	//회원가입
	@RequestMapping("joinAction.do")
	public String joinAction(JoinFormDTO data) {
		logger.info("[url => joinAction.do]");
			
		CustomerDTO dto = new CustomerDTO();
		
		dto.setId(data.getId());
				
		dto.setName(data.getName());
		
		Date date=Date.valueOf(data.getBirthday());
		dto.setBirthday(date);
		
		dto.setAddress(data.getAddress());
		
		String hp="";
		String strHp1=data.getHp1();
		String strHp2=data.getHp2();
		String strHp3=data.getHp3();
		
		if(!strHp1.equals("")&&!strHp2.equals("")&&!strHp3.equals("")) {
			hp=strHp1+"-"+strHp2+"-"+strHp3;	
		}
		
		dto.setHp(hp);
		
		String email="";
		String strEmail1=data.getEmail1();
		String strEmail2=data.getEmail2();
		email=strEmail1+"@"+strEmail2;
		dto.setEmail(email);
			
		// 시큐리티 작업 - 비밀번호 암호화, 키 생성
		String password = data.getPassword();
		String encryptPassword = passwordEncoder.encode(password);		
		dto.setPassword(encryptPassword);
		
	    String key = EmailChkHandler.getKey();
	    dto.setKey(key);   
	    dto.setAuthority("ROLE_USER");
	    dto.setEnabled("0");
	    
	    //데이터를 가공한다음에 dto에 담아서 보낸다.
		service.signInAction(dto);
		
		return "common/main";
	}
		
   // 시큐리티 - 가입성공시 이메일인증을 위해 이메일 인증 후 enabled 권한을 1로 update
   @RequestMapping("emailChk.do")
   public String emailChk(String key,  Model model) {
      logger.info("[url ==> emailChk.do]");
      	
      int insertCnt = service.emailChkAction(key);     
      model.addAttribute("insertCnt", insertCnt);
      
      return "customer/join/emailChkAction";
   } 
	
	//--------------- [로그인] -----------------------
	
   	//로그인페이지 이동
	@RequestMapping("login.do")
	public String login(Model model) {
		logger.info("[url => login.do]");
		
		return "customer/login/login";
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String logOut(HttpServletRequest req, Model model) {
		logger.info("[url => logout.do]");
		
		req.getSession().invalidate();
		return "common/main";
	}
	
	//--------------- [회원정보 상세페이지 및 수정] ---------------

	//자기정보 페이지 이동
	@RequestMapping("mypage.do")
	public String mypage() {
		logger.info("[url => mypage.do]");
		
		return "customer/mypage/customerInfo/customerInfoPage";
	}

	//회원정보 상세페이지를 보여준다.
	@RequestMapping("modifyDetailAction.do")
	public String modifyDetailAction(HttpServletRequest req, Model model) {
		logger.info("[url => modifyDetailAction.do]");
				
		String strId=(String)req.getSession().getAttribute("customerID");
		CustomerDTO dto = service.modifyDetailAction(strId);	
		model.addAttribute("customerDetail", dto);
		
		return "customer/mypage/customerInfo/modifyDetailAction";
	}
	
	//회원정보 수정처리를 한다.
	@RequestMapping("modifyCustomerAction.do")
	public String modifyCustomerAction(JoinFormDTO data, Model model) {
		logger.info("[url => modifyCustomerAction.do]");
		
		CustomerDTO dto = new CustomerDTO();
		
		dto.setId(data.getId());
				
		dto.setName(data.getName());
		
		Date date=Date.valueOf(data.getBirthday());
		dto.setBirthday(date);
		
		dto.setAddress(data.getAddress());
		
		String hp="";
		String strHp1=data.getHp1();
		String strHp2=data.getHp2();
		String strHp3=data.getHp3();
		
		if(!strHp1.equals("")&&!strHp2.equals("")&&!strHp3.equals("")) {
			hp=strHp1+"-"+strHp2+"-"+strHp3;	
		}
		
		dto.setHp(hp);
		
		String email="";
		String strEmail1=data.getEmail1();
		String strEmail2=data.getEmail2();
		email=strEmail1+"@"+strEmail2;
		dto.setEmail(email);
		
		// 시큐리티 작업 - 비밀번호 암호화
		String password = data.getPassword();
		String encryptPassword = passwordEncoder.encode(password);		
		dto.setPassword(encryptPassword);
		
		int updateCnt = service.modifyCustomerAction(dto);
		model.addAttribute("updateCnt", updateCnt);
		
		return "customer/mypage/customerInfo/modifyCustomerAction";
	}
	
	//--------------- [회원 탈퇴] -----------------------
		
	//회원정보 탈퇴처리
	@RequestMapping("deleteCustomerAction.do")
	public String deleteCustomerAction(HttpServletRequest req, Model model) {
		logger.info("[url => deleteCustomerAction.do]");
		
		String strId=(String)req.getSession().getAttribute("customerID");			
		int deleteCnt = service.deleteCustomerAction(strId);
		model.addAttribute("deleteCnt", deleteCnt);
		
		return "customer/mypage/customerInfo/deleteCustomerAction";
	}

	//--------------- [회원 목록] -----------------------
	
	//관리자를 제외한 회원목록을 보여준다.
	@RequestMapping("memberList.do")
	public String memberList(HttpServletRequest req, Model model, String pageNum) {
		logger.info("[url => memberList.do]");
				
		//페이징 계산
		Pagination paging = new Pagination(pageNum);
		int total=dao.memberCnt();
		paging.setTotalCount(total);	
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		//페이징된 데이터 가져오기
		Map<String, Object> map=new HashMap<String, Object>();		
		map.put("start", start);
		map.put("end", end);
		List<CustomerDTO> memberBox = service.memberList(map);
			
		model.addAttribute("memberBox", memberBox);
		model.addAttribute("paging",paging);
		
		return "manager/member/memberList";
	}
	
	//즉시구매 상세페이지를 보여준다.
	@RequestMapping("purchasing.od")
	public String purchasing(HttpServletRequest req, CartDTO dto1, Model model) {
		logger.info("[url => purchasing.od]");
		
		int charge;
		
		if(dto1.getPrice()<30000) charge=3000;
		else charge=0;
		
		String strId=(String)req.getSession().getAttribute("customerID");
		
		CustomerDTO dto2 = service.purchasingDetail(strId); 
		
		model.addAttribute("dto01",dto1);
		model.addAttribute("dto02",dto2);
		model.addAttribute("charge",charge);
		
		return "product/purchasing";
	}
	
}
