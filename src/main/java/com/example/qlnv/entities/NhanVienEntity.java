package com.example.qlnv.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "nhanvien")
@Data
public class NhanVienEntity {
    @Id
    @GenericGenerator(name = "client_id_nv", strategy = "com.example.qlnv.generator.NhanVienIdGenerator")
    @GeneratedValue(generator = "client_id_nv")
    private String MANV;
    private String HO;
    private String TEN;
    private String DIACHI;
    private String SDT;
    private String GIOITINH;
    private String NGAYSINH;
    private String HINHANH;
    private String CHUCVU;
    private String CHINHANH;
    private String HINHTHUC;
    private String TRANGTHAI;
    
	public String getGIOITINH() {
		return GIOITINH;
	}
	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}
	public String getNGAYSINH() {
		return NGAYSINH;
	}
	public void setNGAYSINH(String nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public String getHO() {
		return HO;
	}
	public void setHO(String hO) {
		HO = hO;
	}
	public String getTEN() {
		return TEN;
	}
	public void setTEN(String tEN) {
		TEN = tEN;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getHINHANH() {
		return HINHANH;
	}
	public void setHINHANH(String hINHANH) {
		HINHANH = hINHANH;
	}
	public String getCHUCVU() {
		return CHUCVU;
	}
	public void setCHUCVU(String cHUCVU) {
		CHUCVU = cHUCVU;
	}
	public String getCHINHANH() {
		return CHINHANH;
	}
	public void setCHINHANH(String cHINHANH) {
		CHINHANH = cHINHANH;
	}
	public String getTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(String tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	public String getHINHTHUC() {
		return HINHTHUC;
	}
	public void setHINHTHUC(String hINHTHUC) {
		HINHTHUC = hINHTHUC;
	}
	
    
    

    //one to one
//    @OneToOne(mappedBy = "nhanVien", fetch = FetchType.LAZY)
//    private TaiKhoanEntity taiKhoan;

    //one to many
//    @OneToMany(mappedBy = "thuongPhat", fetch = FetchType.LAZY)
//    private Collection<ThuongPhatEntity> kpiEntities;
//    @OneToMany(mappedBy = "lichLam", fetch = FetchType.LAZY)
//    private Collection<LichLamEntity> lichLamEntities;
//    @OneToMany(mappedBy = "luong", fetch = FetchType.LAZY)
//    private Collection<LuongEntity> luongEntities;
//    @OneToMany(mappedBy = "nVQuanLy", fetch = FetchType.LAZY)
//    private Collection<QuanLyEntity> quanLyEntities;

    // many to one
//    @ManyToOne
//    @JoinColumn(name = "CHUCVU")
//    private ChucVuEntity chucVu;
//    @ManyToOne
//    @JoinColumn(name = "HINHTHUC")
//    private HinhThucEntity hinhThuc;
//    @ManyToOne
//    @JoinColumn(name = "TRANGTHAI")
//    private TrangThaiNVEntity trangThaiNV;
//    @ManyToOne
//    @JoinColumn(name = "CHINHANH")
//    private ChiNhanhEntity chiNhanh;
}
