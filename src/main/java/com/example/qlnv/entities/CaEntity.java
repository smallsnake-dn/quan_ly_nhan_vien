package com.example.qlnv.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Collection;

@Entity
@Table(name = "ca")
@Data
public class CaEntity {
    @Id
    @GenericGenerator(name = "client_id_ca", strategy = "com.example.qlnv.generator.CaIdGenerator")
    @GeneratedValue(generator = "client_id_ca")
    private String MACA;
    private String TENCA;
    private LocalTime TGBD;
    private LocalTime TGKT;
    private float TONGGIO;
	public String getMACA() {
		return MACA;
	}
	public void setMACA(String mACA) {
		MACA = mACA;
	}
	public String getTENCA() {
		return TENCA;
	}
	public void setTENCA(String tENCA) {
		TENCA = tENCA;
	}
	public LocalTime getTGBD() {
		return TGBD;
	}
	public void setTGBD(LocalTime tGBD) {
		TGBD = tGBD;
	}
	public LocalTime getTGKT() {
		return TGKT;
	}
	public void setTGKT(LocalTime tGKT) {
		TGKT = tGKT;
	}
	public float getTONGGIO() {
		return TONGGIO;
	}
	public void setTONGGIO(float tONGGIO) {
		TONGGIO = tONGGIO;
	}
    
    

    //One to many
//    @OneToMany(mappedBy = "ca", fetch = FetchType.LAZY)
//    private Collection<LichLamEntity> lichLamEntities;
}
