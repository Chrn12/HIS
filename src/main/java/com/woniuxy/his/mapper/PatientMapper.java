package com.woniuxy.his.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.his.entity.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-16
 */
public interface PatientMapper extends BaseMapper<Patient> {
    public List<Patient> selectPatientsByOut () ;
    public List<Patient> selectPatientsByIn () ;


    Page<Map<String, Object>> selectPatientsPageByIn(Page page, @Param("status") Integer status);
    Page<Map<String, Object>> selectPatientsPageByOut(Page page,@Param("status") Integer status);

}
