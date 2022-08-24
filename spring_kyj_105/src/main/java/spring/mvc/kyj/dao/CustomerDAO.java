package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.kyj.dto.CustomerDTO;

public interface CustomerDAO {
	
	public int idCheck(String strId);
	
	public int insertCustomer(CustomerDTO dto);
	
    public int selectKey(String key);
   
    public int updateGrade(String key);
	
	public CustomerDTO getCustomerDetail(String strId);
	
	public int updateCustomer(CustomerDTO dto);
	
	public int deleteCustomer(String strId);
	
	public List<CustomerDTO> memberList(Map<String, Object> map);
	
	public int memberCnt();

}
