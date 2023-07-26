package com.example.qlnv.entities;

import lombok.Data;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "thuongphat")
@IdClass(ThuongPhatPK.class)
public class ThuongPhatEntity {
    @Id
    private String MANV;
    @Id
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date NGAY;
    private String LOAI;
    private String MAVB;
    private float SOTIEN;
    private String GHICHU;
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public Date getNGAY() {
		return NGAY;
	}
	public void setNGAY(Date nGAY) {
		NGAY = nGAY;
	}
	public String getLOAI() {
		return LOAI;
	}
	public void setLOAI(String lOAI) {
		LOAI = lOAI;
	}
	public String getMAVB() {
		return MAVB;
	}
	public void setMAVB(String mAVB) {
		MAVB = mAVB;
	}
	public float getSOTIEN() {
		return SOTIEN;
	}
	public void setSOTIEN(float sOTIEN) {
		SOTIEN = sOTIEN;
	}
	public String getGHICHU() {
		return GHICHU;
	}
	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}
    
    

    //many to one
//    @ManyToOne
//    @JoinColumn(name = "MANV")
//    @MapsId
//    private NhanVienEntity thuongPhat;
//    @ManyToOne
//    @JoinColumn(name = "LOAI")
//    private LoaiTPEntity loaiTP;
}
