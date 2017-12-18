package cn.itcast.crm.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	@Override
	public List<Customer> findByFixedAreaIdIsNull() {
		return customerDao.findByFixedAreaIdIsNull();
	}
	@Override
	public List<Customer> findByFixedAreaId(String fixedAreaId) {
		return customerDao.findByFixedAreaId(fixedAreaId);
	}
	@Override
	public void assigncustomerstodecidedzone(String fixedAreaId, String customerIds) {
		//清除原来关联此定区的客户关系
		customerDao.updateCustomerFixedAreaIdsNull(fixedAreaId);
		if (StringUtils.isNoneBlank(customerIds)) {
			String[] cIds = customerIds.split(",");
			for (String id : cIds) {
				customerDao.updateCustomerFixedAreaId(fixedAreaId,Integer.parseInt(id));
			}
		}
	}
	@Override
	public void save(Customer customer) {
		System.out.println("save执行");
		customerDao.save(customer);
	}
	@Override
	public Customer findByTelephone(String telephone) {
		return customerDao.findByTelephone(telephone);
	}
	@Override
	public void activeMail(String telephone) {
		customerDao.activeMail(telephone);
	}
	@Override
	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}
	@Override
	public String findByAddress(String address) {
		//可能有多个重复地址
		List<Customer> list = (List<Customer>) customerDao.findByAddress(address);
		if (list!=null&&list.size()>0) {
			//结果都一样，返回第一个即可
			return list.get(0).getFixedAreaId();
		}
		return null;
	}
}
