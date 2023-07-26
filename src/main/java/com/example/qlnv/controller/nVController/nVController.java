package com.example.qlnv.controller.nVController;

import com.example.qlnv.entities.*;
import com.example.qlnv.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/nhanvien")
public class nVController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    ServletContext servletContext;

    static String IMG_DIR = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img";


    @GetMapping(value = "/index")
    public String showPage(ModelMap modelMap, @RequestParam(value = "Delete", required = false, defaultValue = "")String del ) {
        List<NhanVienEntity> nhanVienEntityList = nhanVienService.getListNhanVien();
        List<ChiNhanhEntity> chiNhanhEntityList = nhanVienService.getListChiNhanh();
        List<ChucVuEntity> chucVuEntities = nhanVienService.getListChucVu();
        List<TrangThaiNVEntity> trangThaiNVEntityList = nhanVienService.getListTrangThaiNvEntities();
        List<HinhThucEntity> hinhThucEntities = nhanVienService.getListHinhThuc();
        if(nhanVienEntityList.isEmpty()) {
        	nhanVienEntityList = new ArrayList<NhanVienEntity>();
        }
        if(chiNhanhEntityList.isEmpty()) {
        	chiNhanhEntityList = new ArrayList<ChiNhanhEntity>();
        }
        if(chucVuEntities.isEmpty()) {
        	chucVuEntities = new ArrayList<ChucVuEntity>();
        }
        if(trangThaiNVEntityList.isEmpty()) {
        	trangThaiNVEntityList = new ArrayList<TrangThaiNVEntity>();
        }
        if(hinhThucEntities.isEmpty()) {
        	hinhThucEntities = new ArrayList<HinhThucEntity>();
        }
        modelMap.addAttribute("listNV", nhanVienEntityList);
        modelMap.addAttribute("listCN", chiNhanhEntityList);
        modelMap.addAttribute("listTT", trangThaiNVEntityList);
        modelMap.addAttribute("listCV", chucVuEntities);
        modelMap.addAttribute("listHT", hinhThucEntities);
        modelMap.addAttribute("del", del);
        return "nhanVien/nVpage";
    }


    @PostMapping(value = "/crud", params = "Edit")
    public String editNV(@RequestParam("manv") String manv, @RequestParam("hoten") String hoten,
                         @RequestParam("ten") String ten, @RequestParam("diachi") String diachi, @RequestParam("chucvu") String chucvu,
                         @RequestParam("chinhanh") String chinhanh, @RequestParam("sdt") String sdt,
                         @RequestParam("trangthai") String trangthai, @RequestParam("anh_nv") MultipartFile multipartFile, 
                         @RequestParam("date")String date, @RequestParam("gioitinh")String gioitinh, 
                         @RequestParam("hinhthuc")String hinhthuc) {
        String photoPath = IMG_DIR + "\\" + multipartFile.getOriginalFilename();
        String resourcePath = "\\img\\" + multipartFile.getOriginalFilename();
        if(!multipartFile.getOriginalFilename().equals("")) {
        	try {
                System.out.println(photoPath);
                multipartFile.transferTo(new File(photoPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        NhanVienEntity nv = new NhanVienEntity();
        nv.setMANV(manv);
        nv.setHO(hoten);
        nv.setTEN(ten);
        nv.setDIACHI(diachi);
        nv.setHINHANH(resourcePath);
        nv.setCHUCVU(chucvu);
        nv.setCHINHANH(chinhanh);
        nv.setSDT(sdt);
        nv.setTRANGTHAI(trangthai);
        nv.setGIOITINH(gioitinh);
        nv.setNGAYSINH(date);
        nv.setHINHTHUC(hinhthuc);
        nhanVienService.updateNV(nv);
        return "redirect:/nhanvien/index";
    }

    @PostMapping(value = "/crud", params = "Add")
    public String addNV(@RequestParam("hoten") String hoten,
                        @RequestParam("ten") String ten, @RequestParam("diachi") String diachi, @RequestParam("chucvu") String chucvu,
                        @RequestParam("chinhanh") String chinhanh, @RequestParam("sdt") String sdt,
                        @RequestParam("trangthai") String trangthai, @RequestParam("anh_nv") MultipartFile multipartFile, 
                        @RequestParam("date")String date, @RequestParam("gioitinh")String gioitinh,
                        @RequestParam("hinhthuc")String hinhthuc) {
    	String photoPath = IMG_DIR + "\\" + multipartFile.getOriginalFilename();
        String resourcePath = "\\img\\" + multipartFile.getOriginalFilename();
    	if(!multipartFile.getOriginalFilename().equals("")) {
            try {
                System.out.println("--------------------------------------------------------");
                System.out.println(photoPath);
                multipartFile.transferTo(new File(photoPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        NhanVienEntity nv = new NhanVienEntity();
        nv.setHO(hoten);
        nv.setTEN(ten);
        nv.setDIACHI(diachi);
        nv.setHINHANH(resourcePath);
        nv.setCHUCVU(chucvu);
        nv.setCHINHANH(chinhanh);
        nv.setSDT(sdt);
        nv.setTRANGTHAI(trangthai);
        nv.setGIOITINH(gioitinh);
        nv.setNGAYSINH(date);
        nv.setHINHTHUC(hinhthuc);
        System.out.println(nv);
        System.out.println("--------------------------------------------------------");
        nhanVienService.addNV(nv);
        return "redirect:/nhanvien/index";
    }
    @PostMapping(value = "/crud", params = "Delete")
    public String deleteNV(@RequestParam("manv") String manv) {
        String del = nhanVienService.deleteNV(manv);
        return String.format("redirect:/nhanvien/index?Delete=%s", del);
    }

    @GetMapping(value = "/upload")
    public String upload(){
        return "hello";
    }

    @PostMapping(value = "/saveFile")
    public String saveFile(@RequestParam("fileUpload") MultipartFile multipartFile){
        System.out.println(IMG_DIR + "\\" + multipartFile.getOriginalFilename());
        String photoPath = IMG_DIR + "\\" + multipartFile.getOriginalFilename();
        try {
            System.out.println(photoPath);
            multipartFile.transferTo(new File(photoPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/nhanvien/index";
    }
}
