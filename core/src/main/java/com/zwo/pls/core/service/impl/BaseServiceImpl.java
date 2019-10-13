/**
 * 
 */
package com.zwo.pls.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwo.pls.core.service.IBaseService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.RowBounds;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.validation.ValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
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

	@Override
	public int insertForExcelSheet(String fileName, InputStream is, String creator){
//		int result = 0;
//		Workbook workbook = null;
//		try {
//			log.info("-Excel导入交班信息，START。。。。");
//			// 文件类型
//			if (ExcelUtil.isExcel2007(fileName)) {
//				workbook = new XSSFWorkbook(is);
//			} else {
//				workbook = new HSSFWorkbook(is);
//			}
//			//获取表单sheet的数量
//			int numberOfSheets = workbook.getNumberOfSheets();
//			log.info("存在的数量sheet：" + numberOfSheets);
//			Sheet sheet = workbook.getSheetAt(0);
//			result = this.insertSingleSheet(sheet, creator);
//			log.info("-Excel导入交班信息，end。。。。结果为：" + result);
//		} catch (Exception e) {
//			throw new ValidationException(e.getMessage());
//		} finally {
//			if (workbook != null) {
//				try {
//					workbook.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (is != null) {
//				try {
//					is.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		return 0;
	}

	// 可供参考的数据提取方法。
	/*private int insertSingleSheet(Sheet sheet, String creator) {
		String sheetName = sheet.getSheetName();
		int result = 0;
		//行数
		int lastRowNum = sheet.getLastRowNum();
		if (lastRowNum < 2) {
//            return 0;
			throw new ValidationException("导入表单数据为空！");
		}
		Cell cell = sheet.getRow(0).getCell(0);
		//获取标题
		String title = cell.getStringCellValue();
		if (!title.trim().equals("织厂交班信息详情表")) {
			throw new ValidationException("导入的不是织厂交班信息数据！请核查！");
		}
		//从第三行开始循环
		boolean flag = true;
		int startRow = 2;
		while (flag) {
			Row row = sheet.getRow(startRow);
			if (row == null || "".equals(row)) {
				flag = false;
				break;
			}
			if (row.getCell(1) == null || "".equals(row.getCell(1))) {
				flag = false;
				break;
			}
			startRow++;
			ShiftExchange shiftExchange = new ShiftExchange();
			//员工编号
			String empVal;
			if (row.getCell(1) == null || row.getCell(1).equals("")) {
				throw new ValidationException("第" + startRow + "行员工编号不能为空！");
			}
			row.getCell(1).setCellType(CellType.STRING);
			empVal = row.getCell(1).getStringCellValue();
			shiftExchange.setEmployeeId(empVal);
			//校验员工 并填充员工部门 部门id 入职日期
			this.replenishEmpInfo(shiftExchange);
			//交班日期
			String shifExcheangeDate;
			if (row.getCell(2).equals("") || row.getCell(2) == null) {
				throw new ValidationException("第" + startRow + "行交班日期不能为空！");
			}
			//  shifExcheangeDate = row.getCell(2).getStringCellValue();
			//  shiftExchange.setExshiftDate(LocalDateTime.parse(shifExcheangeDate + "T00:00:00"));
			shiftExchange.setExshiftDate(ExcelUtil.parseLocalDateOfCell(row.getCell(2)).atStartOfDay());

			//班制
			String shiftName;
			if (row.getCell(3) == null || row.getCell(3).equals("")) {
				throw new ValidationException("第" + startRow + "行班制不能为空！");
			}
			row.getCell(3).setCellType(CellType.STRING);
			shiftName = row.getCell(3).getStringCellValue();
			shiftExchange.setShift(shiftName);

			//帮工
			String helper = null;
			if (row.getCell(4) != null) {
				row.getCell(4).setCellType(CellType.STRING);
				helper = row.getCell(4).getStringCellValue();
			}
			shiftExchange.setHelper(helper);

			//分区
			String area = null;
			if (row.getCell(5) != null) {
				row.getCell(5).setCellType(CellType.STRING);
				area = row.getCell(5).getStringCellValue();
			}
			shiftExchange.setArea(area);
			//分组
			String empGroup = null;
			if (row.getCell(6) != null) {
				row.getCell(6).setCellType(CellType.STRING);
				empGroup = row.getCell(6).getStringCellValue();
			}
			shiftExchange.setEmpGroup(empGroup);

			//机台编号
			String machineNo;
			if (row.getCell(7) == null || row.getCell(7).equals("")) {
				throw new ValidationException("第" + startRow + "行机台编号不能为空！");
			}
			row.getCell(7).setCellType(CellType.STRING);
			machineNo = row.getCell(7).getStringCellValue();
			shiftExchange.setMachineNo(machineNo);
			//值机数
			String machineCount;
			if (row.getCell(8) == null || row.getCell(8).getStringCellValue().equals("")) {
				throw new ValidationException("第" + startRow + "行值机数不能为空！");
			}
			row.getCell(8).setCellType(CellType.STRING);
			machineCount = row.getCell(8).getStringCellValue();
			shiftExchange.setMachineCount(Integer.parseInt(machineCount));
			//工作内容
			String task;
			if (row.getCell(9) == null || row.getCell(9).getStringCellValue().equals("")) {
				throw new ValidationException("第" + startRow + "行工作内容不能为空！");
			}
			row.getCell(9).setCellType(CellType.STRING);
			task = row.getCell(9).getStringCellValue();
			shiftExchange.setTask(task);
			//是否外借
			boolean isBorrow = false;
			if (row.getCell(10) != null || !row.getCell(10).getStringCellValue().equals("")) {
				row.getCell(10).setCellType(CellType.STRING);
				if (row.getCell(10).getStringCellValue().equals("1")) {
					isBorrow = true;
				}
			}
			shiftExchange.setBorrowFlag(isBorrow);
			//借入车间
			String borrowWorkShop = null;
			if (row.getCell(11) == null || row.getCell(11).equals("")) {
				//如果
				if (isBorrow) {
					throw new ValidationException("第" + startRow + "行借入车间不能为空！");
				}
			} else {
				row.getCell(11).setCellType(CellType.STRING);
				borrowWorkShop = row.getCell(11).getStringCellValue();
			}
			shiftExchange.setBorrowingWorkshop(borrowWorkShop);
			//调用先员校验方法
			this.replenishEmpInfo(shiftExchange);
			//根据日期 员工id查询是否存在同样记录
			ShiftExchangeExample example = new ShiftExchangeExample();
			example.createCriteria().andExshiftDateEqualTo(shiftExchange.getExshiftDate()).andEmployeeIdEqualTo(shiftExchange.getEmployeeId());
			List<ShiftExchange> shiftExchanges = shiftExchangeMapper.selectByExample(example);
			LocalDateTime now = LocalDateTime.now();
			if (CollectionUtils.isNotEmpty(shiftExchanges)) {
				shiftExchange.setId(shiftExchanges.get(0).getId());
				shiftExchange.setUpdateBy(creator);
				shiftExchange.setUpdateTime(now);
				//存在记录则进行修改
				int res = this.updateByPrimaryKeySelective(shiftExchange);
				result += res;
			} else {
				shiftExchange.setCreateTime(now);
				shiftExchange.setCreateBy(creator);
				//调用插入方法
				int res = this.insertSelective(shiftExchange);
				result += res;
			}
		}
		return result;
	}*/
}
