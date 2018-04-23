package com.zzq.beauty.model;

import java.util.Date;

public class Person {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private String address;

    private String phone;

    private Integer userid;

    private Integer type;

    private String skin;

    private String symptom;

    private Date createdate;

    private Date updatedate;

    private Date lastCareDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin == null ? null : skin.trim();
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getLastCareDate() {
        return lastCareDate;
    }

    public void setLastCareDate(Date lastCareDate) {
        this.lastCareDate = lastCareDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", userid=" + userid +
                ", type=" + type +
                ", skin='" + skin + '\'' +
                ", symptom='" + symptom + '\'' +
                ", createdate=" + createdate +
                ", updatedate=" + updatedate +
                '}';
    }


}