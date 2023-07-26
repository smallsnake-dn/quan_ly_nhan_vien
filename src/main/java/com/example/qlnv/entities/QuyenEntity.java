package com.example.qlnv.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "quyen")
@Data
public class QuyenEntity {
    @Id
    @GenericGenerator(name = "client_id_q", strategy = "com.example.qlnv.generator.QuyenIdGenerator")
    @GeneratedValue(generator = "client_id_q")
    private String MAQ;
    private String TENQ;
	public String getMAQ() {
		return MAQ;
	}
	public void setMAQ(String mAQ) {
		MAQ = mAQ;
	}
	public String getTENQ() {
		return TENQ;
	}
	public void setTENQ(String tENQ) {
		TENQ = tENQ;
	}

    
    
    //One to many
//    @OneToMany(mappedBy = "quyen", fetch = FetchType.LAZY)
//    private Collection<TaiKhoanEntity> taiKhoanEntities;
}
