package com.example.qlnv.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hinhthuc")
public class HinhThucEntity {
	@Id
	private String MAHT;
	private String TENHT;
	
	
	public HinhThucEntity() {
	}
	public HinhThucEntity(String mAHT, String tENHT) {
		super();
		MAHT = mAHT;
		TENHT = tENHT;
	}
	public String getMAHT() {
		return MAHT;
	}
	public void setMAHT(String mAHT) {
		MAHT = mAHT;
	}
	public String getTENHT() {
		return TENHT;
	}
	public void setTENHT(String tENHT) {
		TENHT = tENHT;
	}
	
}
