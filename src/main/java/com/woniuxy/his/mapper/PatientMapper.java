package com.woniuxy.his.mapper;

import com.woniuxy.his.entity.Patient;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
public interface PatientMapper extends BaseMapper<Patient> {
	public List<Patient> selectPatientsByOut () ;
	public List<Patient> selectPatientsByIn () ;
	
	
	Page<Map<String, Object>> selectPatientsPageByIn(Page page,@Param("status") Integer status);
	Page<Map<String, Object>> selectPatientsPageByOut(Page page,@Param("status") Integer status);
}
