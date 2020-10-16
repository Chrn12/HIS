package com.woniuxy.his.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liushaoqi
 * @since 2020-10-13
 */
public class MedicalAdvice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医嘱表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer doctorId;

    private Integer nid;

    private String remark;

    /**
     * 处方id
     */
    private Integer preId;

    private Integer patientId;

    private Double mdPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Double getMdPrice() {
        return mdPrice;
    }

    public void setMdPrice(Double mdPrice) {
        this.mdPrice = mdPrice;
    }

    @Override
    public String toString() {
        return "MedicalAdvice{" +
        "id=" + id +
        ", doctorId=" + doctorId +
        ", nid=" + nid +
        ", remark=" + remark +
        ", preId=" + preId +
        ", patientId=" + patientId +
        ", mdPrice=" + mdPrice +
        "}";
    }
}
