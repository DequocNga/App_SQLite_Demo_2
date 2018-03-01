package com.russia.app_sqlite_demo_2.model;

/**
 * Created by VLADIMIR PUTIN on 3/1/2018.
 */

public class Student {
    Integer maSV;
    String tenSV;

    public Student(Integer maSV, String tenSV) {
        this.maSV = maSV;
        this.tenSV = tenSV;
    }

    public Student() {
    }

    public Integer getMaSV() {
        return maSV;
    }

    public void setMaSV(Integer maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }
}
