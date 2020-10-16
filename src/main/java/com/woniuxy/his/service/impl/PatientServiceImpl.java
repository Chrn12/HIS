package com.woniuxy.his.service.impl;

import com.woniuxy.his.entity.OperatingRecord;
import com.woniuxy.his.entity.OutHospital;
import com.woniuxy.his.entity.Patient;
import com.woniuxy.his.entity.PatientInfo;
import com.woniuxy.his.entity.User;
import com.woniuxy.his.mapper.OutHospitalMapper;
import com.woniuxy.his.mapper.PatientMapper;
import com.woniuxy.his.service.OperatingRecordService;
import com.woniuxy.his.service.PatientInfoService;
import com.woniuxy.his.service.PatientService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService
{

    @Resource
    private PatientMapper patientMapper;

    @Resource
    private OutHospitalMapper outHospitalMapper;




    @Resource
    private OperatingRecordService operatingRecordService;

    @Resource
    private PatientInfoService patientInfoService;

    public List<Patient> selectPatient() throws Exception{
        QueryWrapper<Patient> queryWrapper =new QueryWrapper<Patient>();
        queryWrapper.eq("status", 2);
        List<Patient> list = patientMapper.selectList(queryWrapper);
        return list;
    }

    public void updatePatientMoney(Patient patient) throws Exception{
        //查询患者
        QueryWrapper<Patient> queryWrapper =new QueryWrapper<Patient>();
        queryWrapper.eq("id", patient.getId());
        Patient selectOne = patientMapper.selectOne(queryWrapper);
        //更新余额
        Patient patientNew = new Patient();
        patientNew.setId(patient.getId());
        patientNew.setMoney(patient.getMoney()+selectOne.getMoney());
        patientMapper.updateById(patientNew);
        //更新记录
        OperatingRecord operatingRecord = new OperatingRecord();
        operatingRecord.setPatientName(selectOne.getName());
        operatingRecord.setPatientId(patientNew.getId());
        operatingRecord.setDetails("预交交款");
        operatingRecord.setMoney(patient.getMoney());
        operatingRecord.setStatus(1);
        operatingRecordService.save(operatingRecord);
    }

    @Override
    public Page<Map<String,Object>> selectPatientsPageByIn(Integer pageNow,Integer showNum)
            throws Exception {
        //return patientMapper.selectPatientsByIn();
        Page page = new Page(pageNow,showNum);
        Page<Map<String,Object>> page2 = patientMapper.selectPatientsPageByIn(page, 0);
        System.out.println(page);
        return page2;
    }

    @Override
    public Page<Map<String,Object>> selectPatientsPageByOut(Integer pageNow,Integer showNum)
            throws Exception {
        //return patientMapper.selectPatientsByOut();
        Page page = new Page(pageNow,showNum);
        Page<Map<String,Object>> page2 = patientMapper.selectPatientsPageByOut(page, 0);
        return page2;
    }



    @Override
    public void updatePatientBills(Integer id, Double money, Double paymoney, LocalDateTime
            outTime) throws Exception {
        Patient patient = patientMapper.selectById(id);

        //修改病人状态为已缴费
        Patient patientNew = new Patient();
        patientNew.setId(patient.getId());
        patientNew.setStatus(3);
        patientNew.setOutTime(outTime);
        patientNew.setMoney(0.0);
        patientMapper.updateById(patientNew);
        //更新病人info表
        QueryWrapper<PatientInfo>queryWrapper = new QueryWrapper<PatientInfo>();
        queryWrapper.eq("patient_id", patient.getId());
        PatientInfo patientInfo = patientInfoService.getOne(queryWrapper);

        PatientInfo patientInfoNew = new PatientInfo();
        patientInfoNew.setId(patientInfo.getId());
        patientInfoNew.setPatientId(patientInfo.getPatientId());
        patientInfoNew.setStatus(2);
        patientInfoService.updateById(patientInfoNew);
        //更新出院申请表状态为已出院
        QueryWrapper<OutHospital> queryWrapper1  = new QueryWrapper<OutHospital>();
        queryWrapper1.eq("pid",patientInfo.getId());
        OutHospital selectOne = outHospitalMapper.selectOne(queryWrapper1);

        OutHospital outHospital = new OutHospital();
        outHospital.setPid(patientInfo.getId());
        outHospital.setStatus(3);
        outHospital.setId(selectOne.getId());
        outHospitalMapper.updateById(outHospital);
        //更新结算表
        OperatingRecord operatingRecord = new OperatingRecord();
        operatingRecord.setPatientId(id);
        operatingRecord.setPatientName(patient.getName());
        operatingRecord.setDetails("出院结算");
        operatingRecord.setStatus(2);
        operatingRecord.setMoney(paymoney);
        operatingRecord.setTotalPaymoney(money+paymoney);
        operatingRecord.setInvoice("发票已开");
        operatingRecord.setRemark("余额支出"+money+";"+"现金支出"+paymoney);
        operatingRecordService.save(operatingRecord);

    }
}