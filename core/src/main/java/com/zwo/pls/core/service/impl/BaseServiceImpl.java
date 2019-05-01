/**
 * 
 */
package com.zwo.pls.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwo.pls.core.service.IBaseService;
import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 黄记新 基础服务类增删改查抽象实现
 *
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
	// 注入mybaties基础接口层,由子类提供
	protected abstract Mapper<T> getBaseMapper();

	// 由子类提供基础消息。
	protected abstract String getBaseMessage();

	// 消息日志打印输出，由子类提供真正的日志实现。
	protected abstract Logger getLogger();

	@Override
	public int logicalDelete(Object key) {
		int result = 0;
		return result;
	}

	@Override
	public int logicalDeleteBatch(List<String> key) {
		int result = 0;
		return result;
	}

	@Override
	public int deleteBatch(List<Object> key) {
		int result = 0;
		return result;
	}

	@Override
	public int delete(T record) {
		int result = 0;
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "删除对象开始，传入的参数是：" + record.toString());
		}
		result = getBaseMapper().delete(record);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "删除对象结束，结果是：" + (result == 1 ? "成功" : "失败"));
		}
		return result;
	}

	@Override
	public int deleteByExample(Object example) {
		int result = 0;
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "根据传入的封装条件删除对象开始");
		}
		result = getBaseMapper().deleteByExample(example);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "删除对象结束，结果是：" + (result == 1 ? "成功" : "失败"));
		}
		return result;
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		int result = 0;
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "删除对象开始，传入的参数是：" + key.toString());
		}
		result = getBaseMapper().deleteByPrimaryKey(key);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "删除对象结束，结果是：" + (result == 1 ? "成功" : "失败"));
		}
		return result;
	}

	@Override
	public int insert(T record) {
		int result = 0;
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "插入对象开始，传入的参数是：" + record.toString());
		}
		result = getBaseMapper().insert(record);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "插入对象结束，结果是：" + (result == 1 ? "成功" : "失败"));
		}
		return result;
	}

	@Override
	public int insertSelective(T record) {
		int result = 0;
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "插入对象开始，传入的参数是：" + record.toString());
		}
		result = getBaseMapper().insertSelective(record);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "插入对象结束，结果是：" + (result == 1 ? "成功" : "失败"));
		}
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> select(T record) {
		List<T> list = getBaseMapper().select(record);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> selectAll() {
		List<T> list = getBaseMapper().selectAll();
		return list;
	}
	
	@Transactional(readOnly = true)
	@Override
	public PageInfo<T> selectByExample(Object example, Integer page, Integer size) {
		PageHelper.startPage(page,size);    //只生效一次。做两次sql查询，总数查询一次，分页查询一次
		List<T> list =  getBaseMapper().selectByExample(example);
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return pageInfo;
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> selectByExample(Object example) {
		List<T> list = getBaseMapper().selectByExample(example);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		List<T> list = getBaseMapper().selectByExampleAndRowBounds(example, rowBounds);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public T selectByPrimaryKey(Object key) {
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "查询对象开始，传入的参数是：" + key.toString());
		}
		T record = getBaseMapper().selectByPrimaryKey(key);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "查询对象结束，结果是：" + (record == null ? "没有数据" : record.toString()));
		}

		return record;
	}

	@Transactional(readOnly = true)
	@Override
	public int selectCount(T record) {
		int result = getBaseMapper().selectCount(record);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public int selectCountByExample(Object example) {
		int result = getBaseMapper().selectCountByExample(example);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public T selectOne(T record) {
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "查询对象开始，传入的参数是：" + record.toString());
		}
		T reco = getBaseMapper().selectOne(record);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "查询对象结束，结果是：" + (reco == null ? "null" :  reco.toString()));
		}
		return reco;
	}

	@Transactional(readOnly = true)
	@Override
	public T selectOneByExample(Object example) {
		T reco = getBaseMapper().selectOneByExample(example);
		return reco;
	}

	@Override
	public int updateByExample(T record, Object example) {
		int result = getBaseMapper().updateByExample(record, example);
		return result;
	}

	@Override
	public int updateByExampleSelective(T record, Object example) {
		int result = getBaseMapper().updateByExampleSelective(record, example);
		return result;
	}

	@Override
	public int updateByPrimaryKey(T record) {
		int result = 0;
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "更新对象开始，传入的参数是：" + record.toString());
		}
		result = getBaseMapper().updateByPrimaryKey(record);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "更新对象结束，结果是：" + (result == 1 ? "成功" : "失败"));
		}
		return result;
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		int result = 0;
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "更新对象开始，传入的参数是：" + record.toString());
		}
		result = getBaseMapper().updateByPrimaryKeySelective(record);
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(getBaseMessage() + "更新对象结束，结果是：" + (result == 1 ? "成功" : "失败"));
		}
		return result;
	}
}
