package com.example.qlnv.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "trangthainv")
@Data
public class TrangThaiNVEntity {
    @Id
    @GenericGenerator(name = "client_id_tt", strategy = "com.example.qlnv.generator.TrangThaiNVIdGenerator")
    @GeneratedValue(generator = "client_id_tt")
    private String MATT;
    private String TENTT;
	public String getMATT() {
		return MATT;
	}
	public void setMATT(String mATT) {
		MATT = mATT;
	}
	public String getTENTT() {
		return TENTT;
	}
	public void setTENTT(String tENTT) {
		TENTT = tENTT;
	}
    
    

    //One to many
//    @OneToMany(mappedBy = "trangThaiNV", fetch = FetchType.LAZY)
//    private Collection<NhanVienEntity> nhanVienEntities;
}
