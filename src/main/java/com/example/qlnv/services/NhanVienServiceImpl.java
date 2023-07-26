package com.example.qlnv.services;

import com.example.qlnv.dao.*;
import com.example.qlnv.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService{
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private ChiNhanhRepository chiNhanhRepository;
    @Autowired
    private TrangThaiRepository trangThaiRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;
    
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    
    @Autowired
    private ChamCongRepository chamCongRepository;
    
    @Autowired
    private LichLamRepository lichLamRepository;
    
    @Autowired
    private LuongRepository luongRepository;
    
    @Autowired
    private HinhThucRepository hinhThucRepository;

    @Autowired
    public NhanVienServiceImpl(NhanVienRepository nhanVienRepository){
        this.nhanVienRepository = nhanVienRepository;
    }

    @Override
    public String addNV(NhanVienEntity nhanVien) {
//        nhanVienRepository.addNV(nhanVien.getMANV(),nhanVien.getHO(), nhanVien.getTEN(), nhanVien.getDIACHI(),
//                nhanVien.getCHUCVU(), nhanVien.getCHINHANH(), nhanVien.getHINHTHUC(), nhanVien.getTRANGTHAI());
        nhanVienRepository.save(nhanVien);
        return "OKKKKK";
    }

    @Override
    public String updateNV(NhanVienEntity nhanVien) {
        nhanVienRepository.editNV(nhanVien.getMANV(), nhanVien.getHO(), nhanVien.getTEN(), nhanVien.getDIACHI(),
                nhanVien.getCHUCVU(), nhanVien.getCHINHANH(), nhanVien.getSDT(), nhanVien.getTRANGTHAI(),
                nhanVien.getHINHANH(), nhanVien.getGIOITINH(), nhanVien.getNGAYSINH(), nhanVien.getHINHTHUC());
        return "OKKKKK";
    }

    @Override
    public String deleteNV(String id) {
    	System.out.println(taiKhoanRepository.getTK(id));
    	System.out.println(taiKhoanRepository.getTK(id).isEmpty());
    	if(!taiKhoanRepository.getTK(id).isEmpty() || !lichLamRepository.getTK(id).isEmpty() ||
    			!chamCongRepository.getTK(id).isEmpty() || !luongRepository.getTK(id).isEmpty()) {
    		return "false";
    	}
    	
        nhanVienRepository.deleteById(id);
        return "true";
    }

    @Override
    public List<NhanVienEntity> getListNhanVien() {
        return nhanVienRepository.findAll();
    }

    @Override
    public List<ChiNhanhEntity> getListChiNhanh() {
        return chiNhanhRepository.findAll();
    }

    @Override
    public List<TrangThaiNVEntity> getListTrangThaiNvEntities() {
        return trangThaiRepository.findAll();
    }

    @Override
    public List<ChucVuEntity> getListChucVu() {
        return chucVuRepository.findAll();
    }

	@Override
	public List<HinhThucEntity> getListHinhThuc() {
		
		return hinhThucRepository.findAll();
	}
    
    


}
