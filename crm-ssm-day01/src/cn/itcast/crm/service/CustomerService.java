package cn.itcast.crm.service;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.CustomerInfo;
import cn.itcast.crm.utils.Page;

public interface CustomerService {
	Page<Customer> getCustomerList(CustomerInfo customerInfo,Integer currentPage);
	Customer getCustomerById(long id);
	void customerUpdate(Customer customer);
	void customerDelete(long id);
}
