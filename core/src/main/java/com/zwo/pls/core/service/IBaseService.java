package com.zwo.pls.core.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author 黄记新 提供针对一个表基础的服务类
 *
 */
public interface IBaseService<T> {

	/**
	 * 逻辑删除对象
	 * 
	 * @param key
	 * @return
	 */
	public int logicalDelete(Object key);

	/**
	 * 逻辑批量删除对象
	 * 
	 * @param key
	 * @return
	 */
	public int logicalDeleteBatch(List<String> key);

	/**
	 * 逻辑删除对象
	 * 
	 * @param record
	 * @return
	 */
	public int delete(T record);

	/**
	 * 逻辑批量删除对象
	 * 
	 * @param key
	 * @return
	 */
	public int deleteBatch(List<Object> key);

	/**
	 * 根据封装好的条件进行删除
	 * 
	 * @param example
	 * @return
	 */
	public int deleteByExample(Object example);

	/**
	 * 根据主键删除对象
	 * 
	 * @param key
	 * @return
	 */
	public int deleteByPrimaryKey(Object key);

	/**
	 * 插进去对象
	 * 
	 * @param record
	 * @return
	 */
	public int insert(T record);

	/**
	 * 插进去可选的对象，仅不为null的时候对象列会被插入
	 * 
	 * @param record
	 * @return
	 */
	public int insertSelective(T record);

	/**
	 * 查询对象
	 * 
	 * @param record
	 * @return
	 */
	public List<T> select(T record);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	public List<T> selectAll();

	/**
	 * 分页封装对象查询
	 * 
	 * @param example
	 * @return
	 */
	public PageInfo<T> selectByExample(Object example, Integer page, Integer size);

	/**
	 * 封装对象查询
	 * 
	 * @param example
	 * @return
	 */
	public List<T> selectByExample(Object example);

	/**
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

	/**
	 * 根据主键进行查询
	 * 
	 * @param key
	 * @return
	 */
	public T selectByPrimaryKey(Object key);

	/**
	 * @param record
	 * @return
	 */
	public int selectCount(T record);

	/**
	 * @param example
	 * @return
	 */
	public int selectCountByExample(Object example);

	/**
	 * 查询一条
	 * 
	 * @param record
	 * @return
	 */
	public T selectOne(T record);

	/**
	 * @param example
	 * @return
	 */
	public T selectOneByExample(Object example);

	public int updateByExample(T record, Object example);

	public int updateByExampleSelective(T record, Object example);

	public int updateByPrimaryKey(T record);

	public int updateByPrimaryKeySelective(T record);
}