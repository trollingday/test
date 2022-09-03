package spring.mvc.kyj.service;

import org.springframework.ui.Model;

import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.JoinFormDTO;

public interface CustomerService {
	
	public int confirmIdAction(String id);
	
	public void signInAction(JoinFormDTO data);

	public int emailChkAction(String key);

	public CustomerDTO modifyDetailAction(String strId);
	
	public int modifyCustomerAction(JoinFormDTO data);
		
	public int deleteCustomerAction(String strId);
	
	public void memberList(String pageNum, Model model);
	
	public void sendEmail(String email, String key);
	
	public CustomerDTO purchasingDetail(String strId);
	
}
