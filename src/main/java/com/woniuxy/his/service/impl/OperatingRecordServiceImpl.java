package com.woniuxy.his.service.impl;

import com.woniuxy.his.entity.OperatingRecord;
import com.woniuxy.his.entity.Patient;
import com.woniuxy.his.mapper.OperatingRecordMapper;
import com.woniuxy.his.service.OperatingRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-13
 */
@Service
public class OperatingRecordServiceImpl extends ServiceImpl<OperatingRecordMapper, OperatingRecord> implements OperatingRecordService {
	@Resource
	private OperatingRecordMapper operatingRecordMapper;
	
	@Override
	public List<OperatingRecord> selectDailySettlementById(Integer id) throws Exception {
		List<OperatingRecord> list = operatingRecordMapper.selectDailySettlementById(id);
		return list;
	}

	@Override
	public List<OperatingRecord> selectOperatingRecordByStatus(OperatingRecord operatingRecord) throws Exception {
		List<OperatingRecord> list = operatingRecordMapper.selectOperatingRecordByStatus(operatingRecord.getStatus(), operatingRecord.getPatientId());
		return list;
	}

	@Override
	public List<OperatingRecord> selectDetilsById(Integer id) throws Exception {
		QueryWrapper<OperatingRecord> queryWrapper =new QueryWrapper<OperatingRecord>();
		queryWrapper.eq("patient_id", id);
		
		return operatingRecordMapper.selectList(queryWrapper);
	}

	

}
