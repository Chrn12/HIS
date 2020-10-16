package com.woniuxy.his.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.his.entity.OperatingRecord;
import com.woniuxy.his.entity.Patient;
import com.woniuxy.his.service.OperatingRecordService;
import com.woniuxy.his.service.PatientService;
import com.woniuxy.his.utils.JsonResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/operatingRecord")
public class OperatingRecordController {
	
	
	@Resource
	private OperatingRecordService operatingRecordService;
	
	@RequestMapping("/byday")
	//根据ID查询日结
	public JsonResult selectOperatingRecord(Integer id) throws Exception {		
		List<OperatingRecord> list = operatingRecordService.selectDailySettlementById(id);
		return new JsonResult("200","success",list,null);	
	}
	@RequestMapping("/bystatus")
	public JsonResult selectOperatingRecordByStatus(OperatingRecord operatingRecord) throws Exception {	
		List<OperatingRecord> list = operatingRecordService.selectOperatingRecordByStatus(operatingRecord);
		return new JsonResult("200","success",list,null);	
	}
	
	@RequestMapping("/bysomething")
	public JsonResult selectDetilsById(Integer id) throws Exception {			
		return new JsonResult("200","success",operatingRecordService.selectDetilsById(id),null);	
	}
	
	
	

}

