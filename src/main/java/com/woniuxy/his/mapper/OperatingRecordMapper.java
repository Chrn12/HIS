package com.woniuxy.his.mapper;

import com.woniuxy.his.entity.OperatingRecord;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-13
 */
public interface OperatingRecordMapper extends BaseMapper<OperatingRecord> {
	public List<OperatingRecord> selectDailySettlementById(Integer id);
	public List<OperatingRecord> selectOperatingRecordByStatus(@Param("status") Integer status, @Param("patientId") Integer patientId) ; 
	
}
