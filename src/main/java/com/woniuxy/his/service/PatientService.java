package com.woniuxy.his.service;

import com.woniuxy.his.entity.Patient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
public interface PatientService extends IService<Patient> {
	public List<Patient> selectPatient() throws Exception;
	public void updatePatientMoney(Patient patient) throws Exception;
//	public List<Patient> selectPatientsByIn () throws Exception;
//	public List<Patient> selectPatientsByOut () throws Exception;
	
	public void updatePatientBills(Integer id,Double money,Double paymoney,LocalDateTime outTime) throws Exception;

	public IPage<Map<String,Object>> selectPatientsPageByIn (Integer pageNow,Integer showNum) throws Exception;
	public IPage<Map<String,Object>> selectPatientsPageByOut (Integer pageNow,Integer showNum) throws Exception;


}
