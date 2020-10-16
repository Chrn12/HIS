package com.woniuxy.his.controller;


import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.his.entity.Advice;

import com.woniuxy.his.entity.OutHospital;
import com.woniuxy.his.entity.Patient;

import com.woniuxy.his.service.AdviceService;
import com.woniuxy.his.service.OperatingRecordService;
import com.woniuxy.his.service.OutHospitalService;

import com.woniuxy.his.service.PatientService;
import com.woniuxy.his.utils.JsonResult;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Resource
    private PatientService patientService;

    @Resource
    private OperatingRecordService operatingRecordService;

    @Resource
    private AdviceService adviceService;

    @Resource
    private OutHospitalService outHospitalService;

    @RequestMapping("/byid")
    public JsonResult selectPatient(Integer id) throws Exception{
        Patient patient = patientService.getById(id);
        List <Patient> list = new ArrayList<Patient>();
        list.add(patient);
        return new JsonResult("200","success",list,null);
    }


    @GetMapping("all")
    public JsonResult selectPatient(Integer pageNow,Integer showNum) throws Exception{
        Page page = new Page(pageNow,showNum);
        QueryWrapper<Patient> queryWrapper =new QueryWrapper<Patient>();
        queryWrapper.eq("status", 2);
        Page pageInfo = patientService.pageMaps(page, queryWrapper);
        //Page pageInfo = patientService.page(page, queryWrapper);
        System.out.println("得到的分页信息"+pageInfo);
        return new JsonResult("200","success",null,pageInfo);
    }
    @PostMapping("affirm")
    public JsonResult updatePatientMoney(Patient patient) throws Exception{
        patientService.updatePatientMoney(patient);
        return new JsonResult("200","success",null,null);
    }



    @RequestMapping("/clearbills")
    public JsonResult selectPatientBills(Integer id) throws Exception{
        //根据id查询用户
        Patient patient = patientService.getById(id);

        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime outTime = instant.atZone(zoneId).toLocalDateTime();

        //查询住院时间 计算住院费
        LocalDateTime inTime = patient.getInTime();
        Duration duration = Duration.between(inTime,outTime);
        long days = duration.toDays();
        long hours = duration.toHours();
        int day = (int) (hours/24);
        double dayTatol = day;
        int leftHours = (int)(13);
        if(leftHours >= 12) {
            dayTatol = dayTatol+ 0.5;
        }
        Double stayCost = dayTatol * 200;
        //查询总费用
        QueryWrapper<Advice> queryWrapper =new QueryWrapper<Advice>();
        queryWrapper.eq("pid",patient.getId() );
        Advice advice = adviceService.getOne(queryWrapper);
        Double adviceCost = advice.getTotal();
        Double totalMoney = stayCost + adviceCost ;
        //查询出院审核状态
        QueryWrapper<OutHospital> queryWrapper1 =new QueryWrapper<OutHospital>();
        queryWrapper1.eq("pid", patient.getId());

        OutHospital outHospital = outHospitalService.getOne(queryWrapper1);


        //录入缴费信息

        Double payMoney = totalMoney - patient.getMoney();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("patient", patient);
        map.put("totalmoney", totalMoney);
        map.put("paymoney", payMoney);
        map.put("status", outHospital.getStatus());
        return new JsonResult("200","success",null,map);
    }



    @RequestMapping("/clearbillsbtn")
    public JsonResult updatePatientBills(Integer id,Double money,Double paymoney,LocalDateTime
            outTime) throws Exception{
        patientService.updatePatientBills(id, money, paymoney, outTime);
        return new JsonResult("200","success",null,null);
    }

    @GetMapping("/byin")
    public JsonResult selectPatientByIn(Integer pageNow,Integer showNum) throws Exception{

        return new JsonResult("200","success",null,patientService.selectPatientsPageByIn
                (pageNow, showNum));
    }

    @GetMapping("/byout")
    public JsonResult selectPatientByOut(Integer pageNow,Integer showNum) throws Exception {

        return new JsonResult("200", "success", null, patientService.selectPatientsPageByOut
                (pageNow, showNum));
    }


}