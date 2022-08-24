package spring.mvc.kyj.service;

import java.util.List;
import java.util.Map;

import spring.mvc.kyj.dto.CustomerDTO;

public interface CustomerService {
	
	public int confirmIdAction(String id);
	
	public void signInAction(CustomerDTO dto);

	public int emailChkAction(String key);

	public CustomerDTO modifyDetailAction(String strId);
	
	public int modifyCustomerAction(CustomerDTO dto);
		
	public int deleteCustomerAction(String strId);
	
	public List<CustomerDTO> memberList(Map<String, Object> map);
	
	public void sendEmail(String email, String key);
	
}
