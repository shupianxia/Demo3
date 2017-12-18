package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;
public interface BaseDictService {
	List<BaseDict> getBaseDictListByDictTypeCode(String dictTypeCode);
}
