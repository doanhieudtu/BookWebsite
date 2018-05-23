package com.bansachonline.springmvc.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bansachonline.springmvc.model.ChiTietDonHang;
import com.bansachonline.springmvc.model.KhachHang;
import com.bansachonline.springmvc.service.KhacHangService;

@Controller
@SessionAttributes("User")
@RequestMapping("/khach-hang/")
public class KhacHangController {
	private static Pattern pattern;
	private static Matcher matcher;

	@Autowired
	KhacHangService khachHangService;
	
	@RequestMapping("dang-nhap")
	public String DangNhap()
	{
		return "KhachHang_DangNhap";
	}
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static boolean ValidateEmai(String email)
	{
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	@PostMapping
	@RequestMapping("dang-ki")
	public String Dangki(@RequestParam String email, @RequestParam String matkhaua,  @RequestParam String matkhaub, ModelMap mm) {
		boolean kTraMail= ValidateEmai(email);
		if(kTraMail)
		{
			ArrayList<KhachHang> list=null;
			try {
				list= (ArrayList<KhachHang>) khachHangService.FindbyProperty("Email",email,"Email","DESC")[0];
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(list.size()!=0)
			{
					mm.addAttribute("Email","Email đã được đăng kí cho tài khoản khác");
			}
			else{
				if(matkhaua.length()>8)
				{
					mm.addAttribute("matkhau","Lỗi mật khẩu, mật khẩu tối đa chỉ 8 kí tự.");
				}
				else
				{
					if(matkhaua.equals(matkhaub)) {
						KhachHang khach= new KhachHang();
						khach.setEmail(email);
						khach.setMatKhau(matkhaua);
						khach.setGioiTinh((byte) 1);
						khach.setHoTen(email);
						Date ngay = new Date(2018, 01, 01);
						khach.setNgaySinh(ngay);
						khach.setTenTK(email);
						int key=khachHangService.ThemKhachHang(khach);
						if(key==1)
						{
							System.out.println("Đăng kí thành công");
							mm.addAttribute("Success","Đăng kí thành công.Vui lòng đăng nhập và chỉnh sửa thông tin cá nhân.");
						}
						else
						{
							System.out.println("Đăng kí thất bại.");
							mm.addAttribute("Success","Đăng kí thất bại do lỗi hệ thống.");
						}
					}
					else
					{
						mm.addAttribute("matkhau","Lỗi mật khẩu, mật khẩu nhập lại của bạn không đúng.");
					}
				}
			}
		}
		else
		{
			mm.addAttribute("Email","Định dạng email không hợp lệ.");
		}
		return "KhachHang_DangNhap";
	}
	@PostMapping
	@RequestMapping("dang-xuat")
	public String DangXuat(HttpSession ss,ModelMap mm)
	{
		ss.removeAttribute("User");
		KhachHang khachHang1= new KhachHang();
		khachHang1.setEmail("chuadangnhap");
		mm.addAttribute("User",khachHang1);
		return "redirect:/khach-hang/dang-nhap";
	}
	
	
	
	@PostMapping
	@RequestMapping("ho-so")
	public String HoSoKhachHang(HttpSession ss, ModelMap mm)
	{
		KhachHang a= new KhachHang();
		a=(KhachHang)ss.getAttribute("User");
		double tongPage= Math.ceil((double)(a.getdOnhAng().size())/5);
		
		float Tongtien=0;
		try {
			for(ChiTietDonHang b: a.getdOnhAng().get(0).getcHitIetdOnhAng())
			{
				Tongtien+=b.getDonGia()*b.getSoLuong();
			}
			System.out.println(tongPage);
			mm.put("ListDonHang",khachHangService.getDonHangLazy(a,0,5));
			System.out.println(khachHangService.getDonHangLazy(a,0,5).size());
			mm.put("TongPage",tongPage);
			mm.put("DonHangChiTiet",a.getdOnhAng().get(0).getcHitIetdOnhAng());
			mm.put("ThanhTien", Tongtien);
		}
		catch (Exception e){}

		return "ho-so-khach-hang";
	}
	@RequestMapping("tai-khoan")
	public String QuanLyTaiKhoan(ModelMap mm)
	{
		List<KhachHang> lsKhachHang= new ArrayList<>() ;
		lsKhachHang= khachHangService.ShowAll();
		mm.put("DanhSachKhachHang",lsKhachHang);
		return "khach-hang";
	}
}
