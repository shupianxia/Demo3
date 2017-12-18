package cn.itcast.crm.mapper;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;

/**
 * 字典表管理mapper
 * @author 刘亮
 *
 */
public interface BaseDictMapper {
	List<BaseDict> getBaseDictListByDictTypeCode(String dictTypeCode);
}