package com.example.qlnv.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "chucvu")
@Data
public class ChucVuEntity {
    @Id
    @GenericGenerator(name = "client_id_cv", strategy = "com.example.qlnv.generator.ChucVuIdGenerator")
    @GeneratedValue(generator = "client_id_cv")
    private String MACV;
    private String TENCV;
	public String getMACV() {
		return MACV;
	}
	public void setMACV(String mACV) {
		MACV = mACV;
	}
	public String getTENCV() {
		return TENCV;
	}
	public void setTENCV(String tENCV) {
		TENCV = tENCV;
	}
    
    
//    @OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
//    private Collection<NhanVienEntity> nhanVienEntities;
}
