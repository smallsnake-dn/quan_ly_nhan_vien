package com.example.qlnv.services;

import com.example.qlnv.dao.NhanVienRepository;
import com.example.qlnv.dao.QuyenRepository;
import com.example.qlnv.dao.TaiKhoanRepository;
import com.example.qlnv.dao.AuthoritiesRepository;
import com.example.qlnv.entities.NhanVienEntity;
import com.example.qlnv.entities.QuyenEntity;
import com.example.qlnv.entities.TaiKhoanEntity;
import com.example.qlnv.entities.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private void setTaiKhoanRepository(TaiKhoanRepository taiKhoanRepository){
        this.taiKhoanRepository = taiKhoanRepository;
    }
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private QuyenRepository quyenRepository;



//    @Autowired
//    private PasswordEncoder encode;




    @Override
    public List<TaiKhoanEntity> getAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public String register(TaiKhoanEntity taiKhoan) {
//        if (emailExist(accountDto.getEmail())) {
//            throw new EmailExistsException(
//                    "There is an account with that email adress:" + accountDto.getEmail());
//        }
        TaiKhoanEntity user = new TaiKhoanEntity();
        user.setUsername(taiKhoan.getUsername());
        user.setMANV(taiKhoan.getMANV());
        user.setPassword((new BCryptPasswordEncoder()).encode(taiKhoan.getPassword()));
//        user.setLastName(accountDto.getLastName());
//
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//
//        user.setEmail(accountDto.getEmail());
//        user.setRole(new Role(Integer.valueOf(1), user));
        taiKhoanRepository.saveTK(user.getUsername(), user.getMANV(), user.getPassword(), user.isEnabled()?"True":"False");
        return "OK";
    }

    private String getTenNV(String manv){
        NhanVienEntity nv = nhanVienRepository.getById(manv);
        return nv.getHO() + " " + nv.getTEN();
    }

    @Override
    public List<HashMap<String, String>> getData() {
        List<HashMap<String, String>> hash = new ArrayList<HashMap<String, String>>();
        List<TaiKhoanEntity> taiKhoanEntities = taiKhoanRepository.findAll();
        List<Authorities> author = authoritiesRepository.findAll();

        for(TaiKhoanEntity tk : taiKhoanEntities){
            HashMap<String, String> map = new HashMap<String, String>();
            String role = "";
            String manv = tk.getMANV().trim();
            String username = tk.getUsername().trim();
            map.put("manv", manv);
            map.put("username", username);
            String ten = getTenNV(manv);
            map.put("name", ten);
            for(Authorities a : author){
                if(a.getUsername().trim().equals(username)) {
                    role += a.getAuthority() + " ";
                }
            }
            role = role.trim();
            map.put("roles", role);
            map.put("enable", tk.isEnabled()?"true":"false");
            hash.add(map);
        }
        return hash;
    }

    @Override
    public List<NhanVienEntity> getListNV() {
        return nhanVienRepository.findAll();
    }

    @Override
    public List<QuyenEntity> getRole() {
        return quyenRepository.findAll();
    }

    @Override
    public void addRole(Authorities authorities) {
        authoritiesRepository.saveTK(authorities.getUsername(), authorities.getAuthority());
    }

    @Override
    public void updateTK(String username, String password, String enable) {
        if(!password.equals("")){
        taiKhoanRepository.editTK(username, (new BCryptPasswordEncoder()).encode(password), enable);
        }
        else {
            taiKhoanRepository.editTKNoP(username, enable);
        }
    }

    @Override
    public void updateAuthor(String username, String authority) {
        authoritiesRepository.editAuthor(username, authority);
    }
}
