package com.example.qlnv.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "luongthang")
@IdClass(LuongThangPK.class)
@Data
public class LuongThangEntity {
	@Id
	private String MANV;
	@Id
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date NGAY;
	private String CHINHANH;
	private int THANG;
	private float TONG;
	private float THUONG;
	private float PHAT;
	
	
	public LuongThangEntity() {
	}
	
	

	public LuongThangEntity(String mANV, Date nGAY, String cHINHANH, int tHANG, float tONG, float tHUONG, float pHAT) {
		MANV = mANV;
		NGAY = nGAY;
		CHINHANH = cHINHANH;
		THANG = tHANG;
		TONG = tONG;
		THUONG = tHUONG;
		PHAT = pHAT;
	}



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



	public String getCHINHANH() {
		return CHINHANH;
	}



	public void setCHINHANH(String cHINHANH) {
		CHINHANH = cHINHANH;
	}



	public int getTHANG() {
		return THANG;
	}



	public void setTHANG(int tHANG) {
		THANG = tHANG;
	}



	public float getTONG() {
		return TONG;
	}



	public void setTONG(float tONG) {
		TONG = tONG;
	}



	public float getTHUONG() {
		return THUONG;
	}



	public void setTHUONG(float tHUONG) {
		THUONG = tHUONG;
	}



	public float getPHAT() {
		return PHAT;
	}



	public void setPHAT(float pHAT) {
		PHAT = pHAT;
	}
	
	
}
