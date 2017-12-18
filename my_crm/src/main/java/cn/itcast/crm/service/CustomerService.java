package cn.itcast.crm.service;

import java.util.List;

import javax.jws.WebService;

import cn.itcast.crm.domain.Customer;

@WebService
public interface CustomerService {
	//1、查询未关联定区客户
	public List<Customer> findByFixedAreaIdIsNull();
	//2、查询关联定区客户
	public List<Customer> findByFixedAreaId(String fixedAreaId);
	//3、客户关联定区
	public void assigncustomerstodecidedzone(String fixedAreaId,String customerIds);
	//4、保存或更新用户
	public void save(Customer customer);
	//5、根据手机号查询用户
	public Customer findByTelephone(String telephone);
	//6、激活邮箱
	public void activeMail(String telephone);
	//7、根据邮箱查询用户
	public Customer findByEmail(String email);
	//8、根据地址查询定区id
	public String findByAddress(String address);
}
