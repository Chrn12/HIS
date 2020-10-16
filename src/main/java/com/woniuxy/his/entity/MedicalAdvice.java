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
 * @since 2020-10-16
 */
public class MedicalAdvice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医嘱表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer fid;

    private Integer aid;

    private String remark;

    /**
     * 处方id
     */
    private Integer type;

    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MedicalAdvice{" +
        "id=" + id +
        ", fid=" + fid +
        ", aid=" + aid +
        ", remark=" + remark +
        ", type=" + type +
        ", status=" + status +
        "}";
    }
}
