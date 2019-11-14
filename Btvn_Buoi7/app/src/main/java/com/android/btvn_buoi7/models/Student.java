package com.android.btvn_buoi7.models;

public class Student {
    private  int icon;
    private String tv_name;
    private String tv_fname;
    private String tv_subjects;
    private String tv_point;

    public Student(int icon, String tv_name,  String tv_subjects, String tv_point) {
        this.icon = icon;
        this.tv_name = tv_name;
        String tv_fname = tv_name.charAt(0) +"";
        this.tv_fname = tv_fname.toUpperCase();
        this.tv_subjects = tv_subjects;
        this.tv_point = tv_point;
    }

    public int getIcon() {
        return icon;
    }

    public String getTv_name() {
        return tv_name;
    }

    public String getTv_fname() {
        return tv_fname;
    }

    public String getTv_subjects() {
        return tv_subjects;
    }

    public String getTv_point() {
        return tv_point;
    }
}
