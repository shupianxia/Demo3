package cn.itcast.crm.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.CustomerInfo;
import cn.itcast.crm.service.BaseDictService;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Value("${customer.typecode.source}")
	private String typecodeSource;
	@Value("${customer.typecode.industry}")
	private String typecodeIndustry;
	@Value("${customer.typecode.level}")
	private String typecodeLevel;
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("customerList")
	public String showCustomerList(Model model,CustomerInfo customerInfo,@RequestParam(defaultValue="1") Integer currentPage) throws Exception{
		//get请求乱码处理
		if (StringUtils.isNotBlank(customerInfo.getCustName())) {
			String custName = new String(customerInfo.getCustName().getBytes("iso8859-1"),"utf-8");
			customerInfo.setCustName(custName);
		}
		//查询字典表反显下拉选数据，需要dictTypeCode，在配置文件中配置
		List<BaseDict> sourceList = baseDictService.getBaseDictListByDictTypeCode(typecodeSource);
		List<BaseDict> industryList = baseDictService.getBaseDictListByDictTypeCode(typecodeIndustry);
		List<BaseDict> levelList = baseDictService.getBaseDictListByDictTypeCode(typecodeLevel);
		//数据传递给jsp
		model.addAttribute("fromType",sourceList);
		model.addAttribute("industryType",industryList);
		model.addAttribute("levelType",levelList);
		//多条件+分页查询客户信息
		Page<Customer> page = customerService.getCustomerList(customerInfo, currentPage);
		model.addAttribute("page", page);
		//反显查询条件
		model.addAttribute("custName",customerInfo.getCustName());
		model.addAttribute("custSource",customerInfo.getCustSource());
		model.addAttribute("custIndustry",customerInfo.getCustIndustry());
		model.addAttribute("custLevel",customerInfo.getCustLevel());
		//返回逻辑视图
		return "customer";
	}
	
	@RequestMapping("getCustomerById")
	@ResponseBody
	public Customer getCustomerById(long id){
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	@RequestMapping("customerUpdate")
	@ResponseBody
	public String customerUpdate(Customer customer){
		customerService.customerUpdate(customer);
		return "success";
	}
	
	@RequestMapping("customerDelete")
	@ResponseBody
	public String customerDelete(long id){
		customerService.customerDelete(id);
		return "success";
	}
}




















