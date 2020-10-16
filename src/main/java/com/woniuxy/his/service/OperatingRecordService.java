package com.woniuxy.his.service;

import com.woniuxy.his.entity.OperatingRecord;
import com.woniuxy.his.utils.JsonResult;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-13
 */
public interface OperatingRecordService extends IService<OperatingRecord> {
	public List<OperatingRecord> selectDailySettlementById(Integer id) throws Exception;
	public List<OperatingRecord> selectOperatingRecordByStatus(OperatingRecord operatingRecord) throws Exception;
	public List<OperatingRecord> selectDetilsById(Integer id) throws Exception;
}
