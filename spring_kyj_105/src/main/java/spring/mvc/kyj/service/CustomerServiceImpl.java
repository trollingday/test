package spring.mvc.kyj.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.kyj.common.EmailChkHandler;
import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.common.SettingValues;
import spring.mvc.kyj.dao.CustomerDAO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.JoinFormDTO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO dao;
	
    @Autowired
    BCryptPasswordEncoder passwordEncoder;   // 비밀번호 암호화 클래스
				
	@Override
	public int confirmIdAction(String id) {		
		return dao.idCheck(id);
	}

	@Override
	public void signInAction(JoinFormDTO data) {
		
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
		
		int insertCnt=dao.insertCustomer(dto);
		
        // 시큐리티 - 가입성공시 이메일인증을 위해 이메일 전송
        if(insertCnt == 1) {
           sendEmail(dto.getEmail(), dto.getKey());   // email은 반드시 가입한 구글계정 이메일       
        }
	}
	
	@Override
	public int emailChkAction(String key) {	
		int selectCnt = dao.selectKey(key);
			  
		if(selectCnt == 1) {
			return dao.updateGrade(key);
		} 	
			  
		return 0;
	}

	@Override
	public CustomerDTO modifyDetailAction(String strId) {		
		return dao.getCustomerDetail(strId);
	}

	@Override
	public int modifyCustomerAction(JoinFormDTO data) {	
		
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
		
		return dao.updateCustomer(dto); 
	}	
	
	@Override
	public int deleteCustomerAction(String strId) {
		return dao.deleteCustomer(strId);		
	}

	@Override
	public void memberList(String pageNum, Model model) {	
		
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
		
		List<CustomerDTO> memberBox = dao.memberList(map);
		
		model.addAttribute("memberBox", memberBox);
		model.addAttribute("paging",paging);
		
	}
	
	@Override
	public void sendEmail(String email, String key) {
		
		final String username = SettingValues.ADMIN;      // 본인 이메일
		final String password = SettingValues.PW;      // 본인 비밀번호
		final String host = "smtp.gmail.com";
		  
		// SMTP(메일 서버) 설정
		  
		// 아래 import는 pom.xml에 mail API를 설정해야 가능
		// import java.util.Properties;
		Properties props = new Properties();         
		props.put("mail.smtp.user", username);         // SMTP에서 사용할 메일 주소
		props.put("mail.smtp.password", password);      // 비밀번호
		props.put("mail.smtp.host", host);            // host 서버 : gmail로 설정
		props.put("mail.smtp.port", "25");            // 25번 포트 사용
		props.put("mail.debug", "true");            // 디버그 설정
		props.put("mail.smtp.auth", "true");         // 인증 : true
		props.put("mail.smtp.starttls.enable", "true");   // tls 사용 허용
		props.put("mail.smtp.ssl.enable", "true");      // ssl 허용
		props.put("mail.smtp.ssl.trust", host);         // ssl 신뢰 가능으로 설정(보안레벨)
		  
		// propert값 설정
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		  
		// import javax.mail.Session;
		// import javax.mail.Authenticator
		// import javax.mail.PasswordAuthentication
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		  
		// import javax.mail.Message
		// import javax.mail.internet.MimeMessage;
		// import javax.mail.internet.InternetAddress;
		// import javax.mail.Transport
		  
		// emailChk.do를 컨트롤러에 작성
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("admin@CosmoJspPJ.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			     
			// localhost => 본인 IP => 원격 발표시 IP 수정
			// 링크를 클릭해서 "이메일 인증 성공" => enabled를 1로 update함
			String content ="회원가입을 축하드립니다. 링크를 눌러 회원가입을 완료하세요."
			+ "<a href='http://localhost/kyj/emailChk.do?key=" + key + "'>링크</a>";
			message.setSubject("회원가입 인증 메일");
			message.setContent(content, "text/html; charset=utf-8");
			     
			Transport.send(message);
			System.out.println("<<<< Email SEND >>>>");
		} catch(Exception e) {
			e.printStackTrace();
		}   
		
	}

	@Override
	public CustomerDTO purchasingDetail(String strId) {
		return dao.getCustomerDetail(strId);		
	}
	
}

	