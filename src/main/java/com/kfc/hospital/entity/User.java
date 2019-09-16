package com.kfc.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class User {
    @TableField(exist = false)
    private Integer mingci;
    private Integer id;
    private String wxName;
    private String openId;
    private Integer point;
    private String headImage;

    public Integer getMingci() {
        return mingci;
    }

    public void setMingci(Integer mingci) {
        this.mingci = mingci;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}
