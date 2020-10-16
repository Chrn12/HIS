package com.woniuxy.his;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.his.entity.OperatingRecord;
import com.woniuxy.his.entity.Patient;
import com.woniuxy.his.mapper.OperatingRecordMapper;
import com.woniuxy.his.mapper.PatientMapper;
import com.woniuxy.his.service.PatientService;


@SpringBootTest(classes=HisApplication.class)
@RunWith(SpringRunner.class)
class HisApplicationTests {
	
	@Resource
	private OperatingRecordMapper operatingRecordMapper;
	
	@Resource
	private PatientService patientService;
	
	@Resource
	private PatientMapper  patientMapper;

    @Test
    void contextLoads() {
    	List<OperatingRecord> dailySettlementById = operatingRecordMapper.selectDailySettlementById(1);
    	System.out.println(dailySettlementById);
    }
    
    @Test
    void countDays() {
    	//根据id查询用户
    			Patient patient = patientService.getById(1);
    			//修改用户状态为已缴费
    			Patient patientNew = new Patient();
    			patientNew.setId(patient.getId());
    			patientNew.setStatus(3);		
    			Date date = new Date();
    			Instant instant = date.toInstant();
    	        ZoneId zoneId = ZoneId.systemDefault();
    	        LocalDateTime outTime = instant.atZone(zoneId).toLocalDateTime();        
    	        patientNew.setOutTime(outTime);                     
    			patientService.updateById(patientNew);
    			//查询住院时间
    			LocalDateTime inTime = patient.getInTime();
    			Duration duration = Duration.between(inTime,outTime);
    			long days = duration.toDays();
    			long hours = duration.toHours();
    			int day = (int) (hours/24);
    			double dayTatol = day;
    			System.out.println("住院天数"+dayTatol);
    			int leftHours = (int)(13);
    			if(leftHours >= 12) {
    				dayTatol = dayTatol+ 0.5;
    			}
    			System.out.println("计算后"+dayTatol);
    }
    @Test
    public void qwe() {
    	Page page = new Page(1,2);
    	IPage<Map<String,Object>> pageInfo = patientMapper.selectPatientsPageByOut(page, 0);
    	System.out.println(pageInfo);
    	List<Map<String,Object>> list = pageInfo.getRecords();
    	System.out.println(list);
    	
    }

}
