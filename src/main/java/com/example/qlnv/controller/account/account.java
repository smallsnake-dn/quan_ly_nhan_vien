package com.example.qlnv.controller.account;

import com.example.qlnv.entities.Authorities;
import com.example.qlnv.entities.NhanVienEntity;
import com.example.qlnv.entities.QuyenEntity;
import com.example.qlnv.entities.TaiKhoanEntity;
import com.example.qlnv.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class account {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @GetMapping(value = "/index")
    public String index(ModelMap modelMap, @RequestParam(name = "error", defaultValue = "false", required = false)String error){
        List<HashMap<String, String>> listData = taiKhoanService.getData();
        List<NhanVienEntity> listNV = taiKhoanService.getListNV();
        List<QuyenEntity> listRole = taiKhoanService.getRole();
        modelMap.addAttribute("listData", listData);
        modelMap.addAttribute("listNVD", listNV);
        modelMap.addAttribute("listRole", listRole);
        modelMap.addAttribute("error", error);
//        System.out.println(listNV);
        return "account/account";
    }

    @PostMapping("/saveTK")
    public String saveTK(@RequestParam("manv")String manv, @RequestParam("username")String username,
                         @RequestParam("quyen")String quyen, @RequestParam("enable")String enable,
                         @RequestParam("password")String password){
    	if(manv.equals("none")) {
    		return "redirect:/account/index?error=true";
    	}
        TaiKhoanEntity tk = new TaiKhoanEntity();
        tk.setUsername(username);
        tk.setMANV(manv);
        tk.setEnabled((enable == "1")?true:false);
        tk.setPassword(password);
        taiKhoanService.register(tk);
        Authorities authorities = new Authorities();
        authorities.setUsername(username);
        authorities.setAuthority(quyen);
        taiKhoanService.addRole(authorities);
        return "redirect:/account/index";
    }

    @PostMapping("/updateU")
    public String updateU(@RequestParam("username")String username, @RequestParam("quyen")String quyen,
                          @RequestParam("enable")String enable, @RequestParam("password")String password){
        taiKhoanService.updateTK(username, password, enable);
        System.out.println(password);
        if(!quyen.equals("role")){
            taiKhoanService.updateAuthor(username, quyen);
        }
        return "redirect:/account/index";
    }



//    @PostMapping(value = "test", produces = "text/plain")
//    public String post(@RequestBody String string){
//
//        return "redirect:account/account";
//    }
}
