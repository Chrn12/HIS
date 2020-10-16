package com.woniuxy.his.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-13
 */
public class OperatingRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer patientId;

    private String details;

    private Double money;

    private LocalDateTime time;

    /**
     * 1存入 2结算
     */
    private Integer status;

    private String invoice;

    private Double totalPaymoney;

    private String remark;

    private String patientName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Double getTotalPaymoney() {
        return totalPaymoney;
    }

    public void setTotalPaymoney(Double totalPaymoney) {
        this.totalPaymoney = totalPaymoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "OperatingRecord{" +
        "id=" + id +
        ", patientId=" + patientId +
        ", details=" + details +
        ", money=" + money +
        ", time=" + time +
        ", status=" + status +
        ", invoice=" + invoice +
        ", totalPaymoney=" + totalPaymoney +
        ", remark=" + remark +
        ", patientName=" + patientName +
        "}";
    }
}
