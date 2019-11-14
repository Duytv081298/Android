package com.android.btvn_buoi8.Models;

import java.util.Random;

public class Story {
    private  int icon;
    private String ten;
    private String chuong;
    private String tacgia;
    private String ncn;

    private String theLoai;
    private String ngayup;

    private String noiDung;

    private String listTheLoai []={"Ngôn Tình","Tiên Hiệp","Kiếm Hiệp","Đô Thị", "Dị Giới", "Đam Mỹ", "Cổ Đại", "Cũng đấu" ,"Xuyên Không"};
    private String listNgayUp []={"2016-05-03 20:30:26","2015-04-03 13:22:35","2014-04-08 14:34:23","2016-09-12 15:23:34",
            "2014-03-09 04:34:45", "2015-07-12 07:24:34", "2014-03-09 07:10:35", "2015-06-09 01:10:35" ,"2015-06-05 04:11:22"};

    private Random rd = new Random();




    public Story(int icon, String ten, String chuong, String tacgia, String ncn,  String noiDung) {
        int i = rd.nextInt(9);
        this.icon = icon;
        this.ten = ten;
        this.chuong = chuong;
        this.tacgia = tacgia;
        this.ncn = ncn;

        this.noiDung = noiDung;
        this.ngayup = listNgayUp[i];
        if (i> 6){
            this.theLoai = listTheLoai[i] + " , " + listTheLoai[i-2];
        }else {
            this.theLoai = listTheLoai[i] + " , " + listTheLoai[i+2];
        }
    }

    public int getIcon() {
        return icon;
    }

    public String getTen() {
        return ten;
    }

    public String getChuong() {
        return chuong;
    }

    public String getTacgia() {
        return tacgia;
    }

    public String getNcn() {
        return ncn;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public String getNgayup() {
        return ngayup;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setChuong(String chuong) {
        this.chuong = chuong;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public void setNcn(String ncn) {
        this.ncn = ncn;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setNgayup(String ngayup) {
        this.ngayup = ngayup;
    }

    public void setListTheLoai(String[] listTheLoai) {
        this.listTheLoai = listTheLoai;
    }

    public void setListNgayUp(String[] listNgayUp) {
        this.listNgayUp = listNgayUp;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }
}
