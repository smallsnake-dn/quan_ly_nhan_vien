package com.example.qlnv.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "chamcong")
@Data
@IdClass(ChamCongPK.class)
public class ChamCongEntity {
    @Id
    private String MANV;
    @Id
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date NGAY;
    @Id
    private LocalTime GIOVAO;
    private LocalTime GIORA;
    private float TONG;
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
	public LocalTime getGIORA() {
		return GIORA;
	}
	public void setGIORA(LocalTime gIORA) {
		GIORA = gIORA;
	}
	public float getTONG() {
		return TONG;
	}
	public void setTONG(float tONG) {
		TONG = tONG;
	}
    
    
    
}
