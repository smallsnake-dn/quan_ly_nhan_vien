package com.example.qlnv.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "chinhanh")
@Data
public class ChiNhanhEntity {
    @Id
    @GenericGenerator(name = "client_id_cn", strategy = "com.example.qlnv.generator.ChiNhanhIdGenerator")
    @GeneratedValue(generator = "client_id_cn")
    private String MACN;
    private String TENCN;
    private String DIACHI;
	public String getMACN() {
		return MACN;
	}
	public void setMACN(String mACN) {
		MACN = mACN;
	}
	public String getTENCN() {
		return TENCN;
	}
	public void setTENCN(String tENCN) {
		TENCN = tENCN;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}

    
    
    //One to many
//    @OneToMany(mappedBy = "chiNhanh", fetch = FetchType.LAZY)
//    private Collection<NhanVienEntity> nhanVienEntities;
//    @OneToMany(mappedBy = "quanLyCN", fetch = FetchType.LAZY)
//    private Collection<QuanLyEntity> quanLyEntities;


}
