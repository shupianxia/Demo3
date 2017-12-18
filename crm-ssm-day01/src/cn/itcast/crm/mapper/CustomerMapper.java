package cn.itcast.crm.mapper;

import java.util.List;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.CustomerInfo;

/**
 * 字典表管理mapper
 * @author 刘亮
 *
 */
public interface CustomerMapper {
	List<Customer> getCustomerList(CustomerInfo customerInfo);
	int getTotalForPage(CustomerInfo customerInfo);
	Customer getCustomerById(long id);
	void customerUpdate(Customer customer);
	void customerDelete(long id);
}