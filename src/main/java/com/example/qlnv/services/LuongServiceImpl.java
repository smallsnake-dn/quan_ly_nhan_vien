package com.example.qlnv.services;

import com.example.qlnv.dao.*;
import com.example.qlnv.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class LuongServiceImpl implements LuongService {
	@Autowired
	private LuongRepository luongRepository;
	@Autowired
	private NhanVienRepository nhanVienRepository;
	@Autowired
	private ChiNhanhRepository chiNhanhRepository;
	@Autowired
	private ChamCongRepository chamCongRepository;
	@Autowired
	private ThuongPhatRepository thuongPhatRepository;

	@Autowired
	private LoaiTPRepository loaiTPRepository;
	
	@Autowired
	private LuongThangRepository luongThangRepository;
	
	@Autowired
	private LichLamRepository lichLamRepository;
	
	@Autowired
	private CaRepository caRepository;

	@Override
	public List<LuongEntity> getListLuong() {
		List<LuongEntity> luong = luongRepository.findAll();
		if (luong.isEmpty()) {
			return luong;
		}
		Collections.sort(luong, new Comparator<LuongEntity>() {
			@Override
			public int compare(LuongEntity lhs, LuongEntity rhs) {
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				return lhs.getNGAY().getTime() > rhs.getNGAY().getTime() ? -1
						: (lhs.getNGAY().getTime() < rhs.getNGAY().getTime()) ? 1 : 0;
			}
		});
		return luong;
	}

	@Override
	public HashMap<String, String> getLuong() {
		return null;
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
	public List<ChamCongEntity> getListChamCong() {
		List<ChamCongEntity> chamCong = chamCongRepository.findAll();
		Collections.sort(chamCong, new Comparator<ChamCongEntity>() {
			@Override
			public int compare(ChamCongEntity lhs, ChamCongEntity rhs) {
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				return lhs.getNGAY().getTime() > rhs.getNGAY().getTime() ? -1
						: (lhs.getNGAY().getTime() < rhs.getNGAY().getTime()) ? 1 : 0;
			}
		});
		return chamCong;
	}

	@Override
	public List<ThuongPhatEntity> getListThuongPhat() {
		List<ThuongPhatEntity> thuongPhat = thuongPhatRepository.findAll();
		Collections.sort(thuongPhat, new Comparator<ThuongPhatEntity>() {
			@Override
			public int compare(ThuongPhatEntity lhs, ThuongPhatEntity rhs) {
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				return lhs.getNGAY().getTime() > rhs.getNGAY().getTime() ? -1
						: (lhs.getNGAY().getTime() < rhs.getNGAY().getTime()) ? 1 : 0;
			}
		});
		return thuongPhat;
	}

	private HashMap<String, ChamCongEntity> getMapCC() {
		List<ChamCongEntity> listCC = getListChamCong();
		HashMap<String, ChamCongEntity> map = new HashMap<>();
		for (ChamCongEntity cc : listCC) {
			map.put(cc.getMANV() + "-" + cc.getNGAY(), cc);
		}
		return map;
	}

	private HashMap<String, ThuongPhatEntity> getMapTP() {
		List<ThuongPhatEntity> listTP = getListThuongPhat();
		HashMap<String, ThuongPhatEntity> map = new HashMap<>();
		for (ThuongPhatEntity tmp : listTP) {
			map.put(tmp.getMANV() + "-" + tmp.getNGAY(), tmp);
		}
		return map;
	}

	private HashMap<String, LuongEntity> getMapLCB() {
		List<LuongEntity> listL = getListLuong();
		HashMap<String, LuongEntity> map = new HashMap<>();
		for (LuongEntity tmp : listL) {
			map.put(tmp.getMANV() + "-" + tmp.getNGAY(), tmp);
		}
		return map;
	}

	private float countCC(List<ChamCongEntity> l) {
		float tmp = 0;
		if (l == null)
			return 0;
		for (ChamCongEntity tm : l) {
			tmp += tm.getTONG();
		}
		return tmp;
	}

	private float countThuong(List<ThuongPhatEntity> l) {
		float tmp = 0;
		if (l == null)
			return 0;
		for (ThuongPhatEntity tm : l) {
			tmp += tm.getSOTIEN();
		}
		return tmp;
	}

	private float countPhat(List<ThuongPhatEntity> l) {
		float tmp = 0;
		if (l == null)
			return 0;
		for (ThuongPhatEntity tm : l) {
			tmp += tm.getSOTIEN();
		}
		return tmp;
	}

//	@Override
//	public List<HashMap<String, String>> getLuongNew() {
//		LocalDate now = LocalDate.now(); // 2015-11-24
//		LocalDate pr1m = now.minusMonths(1); // 2015-10-24
//		LocalDate pr2m = now.minusMonths(2);
//		List<LuongEntity> listL = new ArrayList<>();
////        listL.addAll(luongRepository.selectC();)
//		///////////////////////////////////////////////
//		HashMap<String, ChamCongEntity> mapCC = getMapCC();
//		HashMap<String, ThuongPhatEntity> mapTP = getMapTP();
//		List<LuongEntity> listLuong = getListLuong();
//		List<NhanVienEntity> listNV = nhanVienRepository.findAll();
//		Calendar cal = Calendar.getInstance();
////        cal.setTime(date);
////        int month = cal.get(Calendar.MONTH);
//		Date date = new Date();
//		List<HashMap<String, String>> hash = new ArrayList<>();
//		listNV.forEach((nhanVienEntity -> {
//			HashMap<String, String> rs = new HashMap<>();
//			int thang = now.getMonth().getValue();
//			boolean flag = true;
//			String manv = nhanVienEntity.getMANV();
//			List<ChamCongEntity> c = chamCongRepository.selectCC(nhanVienEntity.getMANV(), thang);
//			List<ThuongPhatEntity> t = thuongPhatRepository.selectT(nhanVienEntity.getMANV(), thang);
//			List<LuongEntity> l = luongRepository.selectC();
//			List<ThuongPhatEntity> p = thuongPhatRepository.selectP(nhanVienEntity.getMANV(), thang);
//				rs.put("manv", manv);
//				rs.put("hoten", nhanVienEntity.getHO() + " " + nhanVienEntity.getTEN());
//				rs.put("chinhanh", nhanVienEntity.getCHINHANH());
//				rs.put("thang", Integer.toString(thang));
//				float thuong = countThuong(t);
//				float phat = countPhat(p);
//				float cc = countCC(c);
//				rs.put("thuong", Float.toString(thuong));
//				rs.put("phat", Float.toString(phat));
//				rs.put("cc", Float.toString(cc));
//				for (LuongEntity lg : l) {
//					if (lg.getMANV().equals(manv)) {
//						System.out.println("Thuong phat: " + Float.toString(lg.getLUONG() * cc + thuong - phat));
//						rs.put("luong", Float.toString(lg.getLUONG() * cc + thuong - phat));
//						flag = false;
//					}
//				}
//				if(flag) {
//					rs.put("luong", "0");
//				}
//				rs.put("sdt", nhanVienEntity.getSDT());
//				hash.add(rs);
//			
//
//		}));
//		listNV.forEach((nhanVienEntity -> {
//			HashMap<String, String> rs = new HashMap<>();
//			int thang = pr1m.getMonth().getValue();
//			boolean flag = true;
//			String manv = nhanVienEntity.getMANV();
//			List<LuongEntity> l = luongRepository.selectC();
//			List<ThuongPhatEntity> t = thuongPhatRepository.selectT(nhanVienEntity.getMANV(), thang);
//			List<ChamCongEntity> c = chamCongRepository.selectCC(nhanVienEntity.getMANV(), thang);
//			List<ThuongPhatEntity> p = thuongPhatRepository.selectP(nhanVienEntity.getMANV(), thang);
//				float thuong = countThuong(t);
//				float phat = countPhat(p);
//				float cc = countCC(c);
//				rs.put("manv", manv);
//				rs.put("hoten", nhanVienEntity.getHO() + " " + nhanVienEntity.getTEN());
//				rs.put("chinhanh", nhanVienEntity.getCHINHANH());
//				rs.put("thang", Integer.toString(thang));
//				rs.put("thuong", Float.toString(thuong));
//				rs.put("phat", Float.toString(phat));
//				rs.put("cc", Float.toString(cc));
//				for (LuongEntity lg : l) {
//					if (lg.getMANV().equals(manv)) {
//						rs.put("luong", Float.toString(lg.getLUONG() * cc + thuong - phat));
//						flag = false;
//					}
//				}
//				if(flag) {
//					rs.put("luong", "0");
//				}
//				rs.put("sdt", nhanVienEntity.getSDT());
//				hash.add(rs);
//			
//
//		}));
//		listNV.forEach((nhanVienEntity -> {
//			HashMap<String, String> rs = new HashMap<>();
//			int thang = pr2m.getMonth().getValue();
//			boolean flag = true;
//			String manv = nhanVienEntity.getMANV();
//			List<ChamCongEntity> c = chamCongRepository.selectCC(nhanVienEntity.getMANV(), thang);
//			List<ThuongPhatEntity> t = thuongPhatRepository.selectT(nhanVienEntity.getMANV(), thang);
//			List<ThuongPhatEntity> p = thuongPhatRepository.selectP(nhanVienEntity.getMANV(), thang);
//			List<LuongEntity> l = luongRepository.selectC();
//			rs.put("manv", manv);
//			rs.put("hoten", nhanVienEntity.getHO() + " " + nhanVienEntity.getTEN());
//			rs.put("chinhanh", nhanVienEntity.getCHINHANH());
//			rs.put("thang", Integer.toString(thang));
//			float thuong = countThuong(t);
//			float phat = countPhat(p);
//			float cc = countCC(c);
//			rs.put("thuong", Float.toString(thuong));
//			rs.put("phat", Float.toString(phat));
//			rs.put("cc", Float.toString(cc));
//			for (LuongEntity lg : l) {
//				if (lg.getMANV().equals(manv)) {
//					rs.put("luong", Float.toString(lg.getLUONG() * cc + thuong - phat));
//					flag = false;
//				}
//			}
//			if(flag) {
//				rs.put("luong", "0");
//			}
//			rs.put("sdt", nhanVienEntity.getSDT());
//			hash.add(rs);
//
//		}));
//
//		return hash;
//	}
	@Override
	public List<LuongThangEntity> getLuongNew() {
		LocalDate now = LocalDate.now(); // 2015-11-24
		LocalDate pr1m = now.minusMonths(1); // 2015-10-24
		List<LuongEntity> listL = new ArrayList<>();
//        listL.addAll(luongRepository.selectC();)
		///////////////////////////////////////////////
		List<NhanVienEntity> listNV = nhanVienRepository.findAll();
//		Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        int month = cal.get(Calendar.MONTH);
		Date date = new Date();
		int lastM = pr1m.getMonthValue();
		listNV.forEach((nhanVienEntity -> {
			String manv = nhanVienEntity.getMANV();
			List<LuongThangEntity> luongThangEntities = luongThangRepository.listLTbyM(lastM, manv);
			if(luongThangEntities.isEmpty()) {
				float tongL = 0;
				float congPT = 0;
				float congFT = 0;
				List<LichLamEntity> lichLamEntities = lichLamRepository.getLbyM(manv, lastM);
				Iterator<LichLamEntity> lichL = lichLamEntities.iterator();
				List<ThuongPhatEntity> t = thuongPhatRepository.selectT(nhanVienEntity.getMANV(), lastM);
				List<ThuongPhatEntity> p = thuongPhatRepository.selectP(nhanVienEntity.getMANV(), lastM);
				float thuong = countThuong(t);
				float phat = countPhat(p);
				LuongEntity luongEntity = luongRepository.selectML(manv, lastM);
				if(nhanVienEntity.getHINHTHUC().equals("PT")) {
					while(lichL.hasNext()) {
					      LichLamEntity i = lichL.next();
					      boolean flag = true;
					      List<ChamCongEntity> listCC = chamCongRepository.selectCCbyNV(manv, i.getNGAY());
					      CaEntity ca = caRepository.getById(i.getCA());
					      for(ChamCongEntity cc : listCC) {
					    	  if(cc.getGIOVAO().compareTo(ca.getTGBD()) == 1 && cc.getGIOVAO().compareTo(ca.getTGKT()) == -1) {
					    		  flag = false;
					    	  }
					      }
					      if(flag) {
					        lichL.remove();
					      } else {
					    	  congPT += ca.getTONGGIO();
					      }
					    }
					tongL += congPT*(luongEntity != null?luongEntity.getLUONG():0) + thuong - phat;
				}else {
					while(lichL.hasNext()) {
					      LichLamEntity i = lichL.next();
					      List<ChamCongEntity> listCC = chamCongRepository.selectCCbyNV(manv, i.getNGAY());
					      LocalTime end = LocalTime.parse("17:00:00");
					      CaEntity ca = caRepository.getById(i.getCA());
					      for(ChamCongEntity cc : listCC) {
					    	  if(cc.getGIOVAO().compareTo(end) >= 0) {
					    		  congFT += cc.getTONG();
					    	  }else if(cc.getGIOVAO().compareTo(end) == -1) {
					    		  congFT += (cc.getGIORA().getHour()-end.getHour()) + (cc.getGIORA().getMinute())/60;
					    	  }
					      }
					    }
					tongL +=(luongEntity != null?luongEntity.getLUONG():0) + congFT*(luongEntity != null?luongEntity.getLUONG():0)*0.006 + thuong - phat;
				}
				
				System.out.print(now.getDayOfMonth());
				luongThangRepository.addLT(manv,now.getYear()+"-"+now.getMonthValue()+ "-" + String.valueOf(now.getDayOfMonth()), nhanVienEntity.getCHINHANH(), lastM, tongL, thuong, phat);

			}
		}));
	
		return luongThangRepository.findAll();
	}

	@Override
	public List<LoaiTPEntity> getListLoai() {
		return loaiTPRepository.findAll();
	}

	@Override
	public void saveL(String manv, String ngay, String mavb, String luong, String ghichu) {
		luongRepository.addL(manv, ngay, mavb, luong, ghichu);
	}

	@Override
	public void saveTP(String manv, String ngay, String loai, String mavb, String sotien, String ghichu) {
		thuongPhatRepository.addTP(manv, ngay, loai, mavb, sotien, ghichu);
	}
}
