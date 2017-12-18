package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crm.mapper.BaseDictMapper;
import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.service.BaseDictService;

/**
 * 字典表管理service
 * @author 刘亮
 *
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictMapper baseDictMapper;
	
	public List<BaseDict> getBaseDictListByDictTypeCode(String dictTypeCode){
		return baseDictMapper.getBaseDictListByDictTypeCode(dictTypeCode);
	}
}
