package com.example.qlnv.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Data
public class ChamCongPK implements Serializable {
    private String MANV;
    private Date NGAY;
    private LocalTime GIOVAO;
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
	public LocalTime getGIOVAO() {
		return GIOVAO;
	}
	public void setGIOVAO(LocalTime gIOVAO) {
		GIOVAO = gIOVAO;
	}
    
    
}
