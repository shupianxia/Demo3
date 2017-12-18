package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crm.mapper.CustomerMapper;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.CustomerInfo;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Page<Customer> getCustomerList(CustomerInfo customerInfo, Integer currentPage) {
		//计算起始页码
		int startIndex = (currentPage - 1) * customerInfo.getPageSize();
		customerInfo.setStartIndex(startIndex);
		//条件+分页查询客户信息
		List<Customer> customerList = customerMapper.getCustomerList(customerInfo);
		//查询总记录数
		int total = customerMapper.getTotalForPage(customerInfo);
		//封装结果
		Page<Customer> page = new Page<Customer>();
		page.setCurrentPage(currentPage);
		page.setPageSize(customerInfo.getPageSize());
		page.setTotal(total);
		page.setDatas(customerList);
		return page;
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerMapper.getCustomerById(id);
	}

	@Override
	public void customerUpdate(Customer customer) {
		customerMapper.customerUpdate(customer);
	}

	@Override
	public void customerDelete(long id) {
		customerMapper.customerDelete(id);
	}
}
