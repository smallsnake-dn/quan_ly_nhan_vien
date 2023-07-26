package com.example.qlnv.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "loaitp")
@Data
public class LoaiTPEntity {
    @Id
    @GenericGenerator(name = "client_id_l", strategy = "com.example.qlnv.generator.LoaiTPIdGenerator")
    @GeneratedValue(generator = "client_id_l")
    private String MALOAI;
    private String TENLOAI;
	public String getMALOAI() {
		return MALOAI;
	}
	public void setMALOAI(String mALOAI) {
		MALOAI = mALOAI;
	}
	public String getTENLOAI() {
		return TENLOAI;
	}
	public void setTENLOAI(String tENLOAI) {
		TENLOAI = tENLOAI;
	}
    
    
    

    //one to many
//    @OneToMany(mappedBy = "loaiTP", fetch = FetchType.LAZY)
//    private Collection<ThuongPhatEntity> thuongPhatEntities;
}
