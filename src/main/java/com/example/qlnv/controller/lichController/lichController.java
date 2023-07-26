package com.example.qlnv.controller.lichController;

import com.example.qlnv.dao.LichLamRepository;
import com.example.qlnv.entities.CaEntity;
import com.example.qlnv.entities.LichLamEntity;
import com.example.qlnv.entities.NhanVienEntity;
import com.example.qlnv.services.LichLamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/lich")
public class lichController {
    @Autowired
    LichLamService lichLamService;
    @GetMapping("/index")
    public String index(ModelMap modelMap, @RequestParam(name = "error", defaultValue = "false", required = false)String error) {
        List<LichLamEntity> lichL = lichLamService.getAll();
        List<NhanVienEntity> listNV = lichLamService.getNV();
        List<CaEntity> listC = lichLamService.getCa();
        modelMap.addAttribute("listL", lichL);
        modelMap.addAttribute("ListNV", listNV);
        modelMap.addAttribute("ListC", listC);
        modelMap.addAttribute("error", error);
        return "/lich/lich";
    }

    @PostMapping(value = "/them")
    public String add(@RequestParam("manv")String manv, @RequestParam("ca")String maca,
                      @RequestParam("date")String ngay, @RequestParam("ghichu")String ghichu){
        try {
        	lichLamService.addLich(manv, ngay, maca, ghichu);
		} catch (Exception e) {
			return "redirect:/lich/index?error=true";
		}
        return "redirect:/lich/index";
    }
}
