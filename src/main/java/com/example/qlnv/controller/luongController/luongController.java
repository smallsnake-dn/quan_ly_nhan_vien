package com.example.qlnv.controller.luongController;

import com.example.qlnv.entities.*;
import com.example.qlnv.services.LuongService;
import com.example.qlnv.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/luong")
public class luongController {
    @Autowired
    private LuongService luongService;
    @GetMapping(value = "/index")
    public String index(ModelMap modelMap, @RequestParam(name = "error", defaultValue = "false", required = false)String error){
        LocalDate now = LocalDate.now(); // 2015-11-24
        LocalDate pr1m = now.minusMonths(1); // 2015-10-24
        LocalDate pr2m = now.minusMonths(2);
        List<NhanVienEntity> nhanVienEntities = luongService.getListNhanVien();
        List<ChiNhanhEntity> chiNhanhEntities = luongService.getListChiNhanh();
        List<ChamCongEntity> chamCongEntities = luongService.getListChamCong();
        List<ThuongPhatEntity> thuongPhatEntities = luongService.getListThuongPhat();
        List<LoaiTPEntity> listLTP = luongService.getListLoai();
        modelMap.addAttribute("listNV", nhanVienEntities);
        modelMap.addAttribute("listCN", chiNhanhEntities);
        List<Integer> thang = new ArrayList<>();
        thang.add(now.getMonth().getValue());
        thang.add(pr1m.getMonth().getValue());
        thang.add(pr2m.getMonth().getValue());
        modelMap.addAttribute("listCC", chamCongEntities);
        modelMap.addAttribute("listTP", thuongPhatEntities);
        List<LuongThangEntity> hash = luongService.getLuongNew();
        List<LuongEntity> listLuong = luongService.getListLuong();
        modelMap.addAttribute("thang", thang);
        modelMap.addAttribute("listL", hash);
        modelMap.addAttribute("listLTP", listLTP);
        modelMap.addAttribute("listLuong", listLuong);
        modelMap.addAttribute("error", error);
        System.out.println(hash.get(0).getCHINHANH());
        return "/luong/luong";
    }

    @PostMapping(value = "/saveL")
    public String saveL(@RequestParam("manv") String manv, @RequestParam("mavb")String mavb,
                        @RequestParam("luong")String luong, @RequestParam("date")String ngay,
                        @RequestParam("ghichu")String ghichu){
    	try {
    		luongService.saveL(manv, ngay, mavb, luong, ghichu);
		} catch (Exception e) {
			return "redirect:/luong/index?error=true";
		}
        return "redirect:/luong/index";
    }

    @PostMapping(value = "/saveTP")
    public String saveTP(@RequestParam("manv") String manv, @RequestParam("mavb")String mavb,
                        @RequestParam("sotien")String sotien, @RequestParam("date1")String ngay,
                        @RequestParam("ghichu")String ghichu, @RequestParam("mal") String loai){
        try {
        	luongService.saveTP(manv, ngay, loai, mavb, sotien, ghichu);
		} catch (Exception e) {
			return "redirect:/luong/index?error=true";
		}
        return "redirect:/luong/index";
    }

}
