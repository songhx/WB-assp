package com.assp.common.service;

/**
 * 如底层没有继承通用Mapper,那么在服务层请勿集成该接口
 */

import java.util.List;

public interface BasicBatchService<T> {
	/**
	 * 批量插入
	 * @param recordList
	 * @return
	 */
	int addList(List<T> recordList);
	
	/**
	 * 批量删除,暂不支持
	 */
	@Deprecated
	int deleteList(List<T> recordList);
}
