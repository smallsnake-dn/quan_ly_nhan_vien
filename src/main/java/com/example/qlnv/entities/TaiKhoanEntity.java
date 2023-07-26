package com.example.qlnv.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class TaiKhoanEntity {
    @Id
    private String username;
    private String MANV;
//    private String MAQ;
    private String password;
    private boolean enabled;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

    
    

    //one to one
//    @OneToOne
//    @JoinColumn(name = "MANV")
//    private NhanVienEntity nhanVien;

    //many to one
//    @ManyToOne
//    @JoinColumn(name = "MAQ")
//    private QuyenEntity quyen;


}
