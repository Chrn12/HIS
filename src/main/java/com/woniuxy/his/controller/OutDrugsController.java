package com.woniuxy.his.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.his.service.OutDrugsService;
import com.woniuxy.his.service.OutHospitalService;
import com.woniuxy.his.utils.JsonResult;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-15
 */
@Controller
@RequestMapping("/outDrugs")
public class OutDrugsController {
	
	@Resource
	private OutDrugsService outDrugsService;
	
	public JsonResult selectOutDrugsById() throws Exception{
		
		return new JsonResult("200","success",null,null);	
	}

}

