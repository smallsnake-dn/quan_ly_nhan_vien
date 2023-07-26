package com.example.qlnv.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "luong")
@Data
@IdClass(LuongPK.class)
public class LuongEntity {
    @Id
    private String MANV;
    @Id
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date NGAY;
    private String MAVBQD;
    private float LUONG;
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
	public String getMAVBQD() {
		return MAVBQD;
	}
	public void setMAVBQD(String mAVBQD) {
		MAVBQD = mAVBQD;
	}
	public float getLUONG() {
		return LUONG;
	}
	public void setLUONG(float lUONG) {
		LUONG = lUONG;
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
//    private NhanVienEntity luong;
}
