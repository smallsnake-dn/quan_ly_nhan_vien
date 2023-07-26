package com.example.qlnv.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lichlam")
@Data
@IdClass(LichLamPK.class)
public class LichLamEntity {
    @Id
    private String MANV;
    @Id
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date NGAY;
    @Id
    private String CA;
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
	public String getCA() {
		return CA;
	}
	public void setCA(String cA) {
		CA = cA;
	}
	public String getGHICHU() {
		return GHICHU;
	}
	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}
    
    

    //Many to one
//    @ManyToOne
//    @JoinColumn(name = "CA")
//    @MapsId
//    private CaEntity  ca;
//    @ManyToOne
//    @JoinColumn(name = "MANV")
//    @MapsId
//    private NhanVienEntity lichLam;
}
