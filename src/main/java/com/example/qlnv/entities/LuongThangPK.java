package com.example.qlnv.entities;

import java.io.Serializable;
import java.util.Date;

public class LuongThangPK implements Serializable{
	private String MANV;
	private Date NGAY;
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
	

}
