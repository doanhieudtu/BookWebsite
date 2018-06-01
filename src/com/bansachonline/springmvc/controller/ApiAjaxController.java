package com.bansachonline.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.bansachonline.springmvc.model.*;
import com.bansachonline.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/")
@SessionAttributes({"User","GioHang"})
public class ApiAjaxController {
	@Autowired
	KhacHangService khachHangService;
	
	@Autowired
	SachService sachService;

	@Autowired
	GopYService gopYService;
	
	@Autowired
	DonHangService donHangService;
	
	@Autowired
	ChiTietDonHangService chiTietService;
	@Autowired
	XuLyGioHangSerVice xuLyGioHang;
	
	@PostMapping()
	@RequestMapping("kiem-tra-dang-nhap")
	@ResponseBody
	public String XuLyDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap mm)
	{
		KhachHang khacHang= khachHangService.DangNhap(email, matkhau);
		if(khacHang==null)
		{
			System.out.println("dang nhap that bai");
			return "false";
		}
		else
		{
			System.out.println("dang nhap thanh cong");
			mm.addAttribute("User", khacHang);
			return "true";	
		}
	}
	@PostMapping
	@RequestMapping("them-vao-gio-hang")
	@ResponseBody
	public void ThemSanPham(@RequestParam String MaSach,HttpSession ss, ModelMap mm)
	{
		GioHang gioHang= new GioHang();
		 gioHang= (GioHang) ss.getAttribute("GioHang");
		 ArrayList<Sach> sach= (ArrayList<Sach>) sachService.FinbyProperty("MaSach",Integer.parseInt(MaSach),"MaSach", "DESC")[0];
		 ArrayList<ItemGioHang> lsItema= new ArrayList<>();
		if(gioHang==null)
		{
			System.out.println("Chua co san pham nao");
			ItemGioHang iTem= new ItemGioHang();
			iTem.setAnhBia(sach.get(0).getAnhBia());
			iTem.setMaxsize(sach.get(0).getSoLuongTon());
			iTem.setMaSanPham(Integer.parseInt(MaSach));
			iTem.setTenSanPham(sach.get(0).getTenSach());
			iTem.setGiaBan(sach.get(0).getGiaBan());
			iTem.setSoLuong(1);
			lsItema.add(iTem);
			GioHang gioHangMoi= new GioHang();
			gioHangMoi.setDanhSachSP(lsItema);
			gioHangMoi.setTongTien(xuLyGioHang.TongTien(gioHangMoi));
			mm.addAttribute("GioHang", gioHangMoi);
			System.out.println("Da them.");
		}
		else
		{
			if(xuLyGioHang.KiemTraGioHang(Integer.parseInt(MaSach), gioHang))
			{
				System.out.println("Trung ma san pham");
				for(ItemGioHang a: gioHang.getDanhSachSP())
				{
					if(a.getMaSanPham()==sach.get(0).getMaSach())
					{
						xuLyGioHang.ThemSoLuong(Integer.parseInt(MaSach), a,1);
						gioHang.setTongTien(xuLyGioHang.TongTien(gioHang));
						break;
					}
				}
				ss.setAttribute("GioHang", gioHang);
				System.out.println("Da them");
			}
			else
			{
					System.out.println("San pham moi");
					ItemGioHang iTem= new ItemGioHang();
					iTem.setAnhBia(sach.get(0).getAnhBia());
					iTem.setMaxsize(sach.get(0).getSoLuongTon());
					iTem.setMaSanPham(Integer.parseInt(MaSach));
					iTem.setTenSanPham(sach.get(0).getTenSach());
					iTem.setGiaBan(sach.get(0).getGiaBan());
					iTem.setSoLuong(1);
					xuLyGioHang.ThemItem(iTem, gioHang);
					gioHang.setTongTien(xuLyGioHang.TongTien(gioHang));
					xuLyGioHang.TongTien(gioHang);
					ss.setAttribute("GioHang", gioHang);
					System.out.println("Da them");
			}
			
		}
		
	}
	@PostMapping
	@RequestMapping("xu-ly-so-luong")
	@ResponseBody
	public String ChinhSuaSoLuong( @RequestParam int MaSanPham,@RequestParam int soluong, HttpSession ss, ModelMap mm)
	{
		GioHang gioHang= new GioHang();
		gioHang=(GioHang)ss.getAttribute("GioHang");
		for(ItemGioHang a: gioHang.getDanhSachSP()) {
			if(a.getMaSanPham()==MaSanPham) 
				{
					int hienTai=a.getSoLuong();
					soluong=soluong-hienTai;
					if(soluong>0)
					{
							xuLyGioHang.ThemSoLuong(MaSanPham, a,soluong);
							xuLyGioHang.TongTien(gioHang);
							ss.setAttribute("GioHang", gioHang);
							
							return String.valueOf(gioHang.getTongTien());
					}
						
					else
					{	
							xuLyGioHang.ThemSoLuong(MaSanPham, a,soluong);
							xuLyGioHang.TongTien(gioHang);
							ss.setAttribute("GioHang", gioHang);
							return String.valueOf(gioHang.getTongTien());
					}
				}
		}
		return String.valueOf(gioHang.getTongTien());
	}
	@PostMapping
	@RequestMapping("xoa-san-pham")
	@ResponseBody
	public String XoaSanPham(@RequestParam int MaSach, HttpSession ss)
	{
		GioHang gioHang= new GioHang();
		gioHang=(GioHang)ss.getAttribute("GioHang");
		for(ItemGioHang a: gioHang.getDanhSachSP())
		{
			if(a.getMaSanPham()==MaSach)
			{
				gioHang.getDanhSachSP().remove(a);
				xuLyGioHang.TongTien(gioHang);
				ss.setAttribute("GioHang",gioHang);
				return String.valueOf(gioHang.getTongTien());
			}
		}
		return "0";
	}
	@PostMapping
	@RequestMapping("dat-hang")
	@ResponseBody
	public String DatHang(@RequestParam String TenKhachHang,@RequestParam String DiaChi,@RequestParam String SoDT,@RequestParam String GhiChu, HttpSession ss)
	{
		if(((KhachHang) ss.getAttribute("User")).getEmail()!="chuadangnhap")
		{
			if(ss.getAttribute("GioHang")!=null)
			{
				GioHang gioHang= new GioHang();
				gioHang= (GioHang)ss.getAttribute("GioHang");
				KhachHang khacHang= new KhachHang();
				khacHang=(KhachHang) ss.getAttribute("User");
				DonHang donHang= new DonHang();
				 khacHang.setDiaChi(DiaChi);
				 khacHang.setDienThoai(SoDT);
				 khacHang.setHoTen(TenKhachHang);
				 khachHangService.UpdateInfor(khacHang);
				 ss.setAttribute("User",khacHang);
				 donHang.setkHachhAng((KhachHang)ss.getAttribute("User"));
				 donHang.setNgayDat(new Date());
				 donHang.setNgayGiao(new Date());
				 donHang.setDaThanhToan(0);
				 donHang.setTinhTrangGiaoHang((byte)0);
				 ArrayList<ChiTietDonHang> listChiTietDH= new ArrayList<>();
				 donHang.setcHitIetdOnhAng(listChiTietDH);
				 donHang.setGhiChu(GhiChu);
				 donHangService.AddDonHang(donHang);
				 khacHang.getdOnhAng().add(donHang);
				 ss.setAttribute("User",khacHang);
				 for(ItemGioHang a: gioHang.getDanhSachSP())
				 {	
					 ChiTietDonHang  chiTietHoaDon= new ChiTietDonHang();
					 ArrayList<Sach> sach= (ArrayList<Sach>) sachService.FinbyProperty("MaSach",a.getMaSanPham(),"MaSach", "DESC")[0];
					 chiTietHoaDon.setdOnhAng(donHang);
					 chiTietHoaDon.setsAchdOnhAng(sach.get(0));
					 sach.get(0).setSoLuongTon(sach.get(0).getSoLuongTon()-a.getSoLuong());
					 sachService.UpdateInfor(sach.get(0));
					 chiTietHoaDon.setDonGia(a.getGiaBan());
					 chiTietHoaDon.setSoLuong(a.getSoLuong());
					 chiTietService.addCTDonHang(chiTietHoaDon);
					 listChiTietDH.add(chiTietHoaDon);
				 }
				 
				 ArrayList<DonHang> DonHang= (ArrayList<com.bansachonline.springmvc.model.DonHang>) donHangService.FindbyProperty("MaDH",donHang.getMaDH(),"MaDH","DESC")[0];
				 DonHang.get(0).setcHitIetdOnhAng(listChiTietDH);
				 donHangService.UpdateInfor( DonHang.get(0));
				 return "1";
			}
		}
		return "0";
	}
	@PostMapping
	@RequestMapping(path="lay-don-hang-theo-trang",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String LayHoaDon(@ RequestParam int index, HttpSession ss)
	{
		KhachHang a= new KhachHang();
		a=(KhachHang)ss.getAttribute("User");
		int tongPage= (a.getdOnhAng().size()+1)/5;
		List<DonHang> listDonHang=null;
			if(index==1)
			{
				listDonHang= khachHangService.getDonHangLazy(a,0,5);
			}
			else
			{
				listDonHang= khachHangService.getDonHangLazy(a,(index-1)*5, 5);
			}
		String html="";
		for(DonHang donHang: listDonHang){
			String check="";
			if(donHang.getTinhTrangGiaoHang()==1) {
				check+="Đã Nhận.";
			}
			else
				check="Chưa Nhận.";
			html+="<tr>";
				html+="<td id='MaDonHang'>"+donHang.getMaDH()+"</td>";
				html+="<td>"+donHang.getNgayDat()+"</td>";
				html+="<td><a href='#'class='btnXoaDonHang'><i class='fas fa-trash-alt fa-2x btn'></i></a></td>";
				html+="<td><a href='#'class='ChiTietDonHang'>Chi Tiết</a></td>";
			html+="</tr>";
		}
		return html;
	}
	@PostMapping
	@RequestMapping("chinh-sua-ho-so")
	@ResponseBody
	public String ChinhSuaHoSo(@RequestParam String HoTen,@RequestParam String Email,@RequestParam String DiaChi,@RequestParam String SoDT,@RequestParam String MatKhau, HttpSession ss)
	{
		KhachHang khacHang= new KhachHang();
		khacHang= (KhachHang) ss.getAttribute("User");
		khacHang.setHoTen(HoTen);
		khacHang.setDiaChi(DiaChi);
		khacHang.setEmail(Email);
		khacHang.setDienThoai(SoDT);
		khacHang.setMatKhau(MatKhau);
		khachHangService.UpdateInfor(khacHang);
		ss.setAttribute("User",khacHang);
		return "1";
	}
	@PostMapping
	@RequestMapping(path="lay-sach-theo-trang",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String LaySach(@RequestParam int index, HttpSession ss)
	{
		List<Sach> listSach=null;
			if(index==1)
			{
				listSach= sachService.ShowBookLimit(5,0);
			}
			else
			{
				listSach= sachService.ShowBookLimit(5,(index-1)*5);
			}
		String html="";
		for(Sach sach: listSach){
			html+="<tr>";
				html+="<td><i class='fas fa-trash-alt fa-2x btnXoaSach btn'></i></td>";
				html+="<td  id='MaSach'>"+sach.getMaSach()+"</td>";
				html+="<td>"+sach.getTenSach()+"</td>";
				html+="<td><span class='XemChiTiet btn'>Chi Tiết</span></td>";

			html+="</tr>";
		}
		return html;
	}
	
	@Autowired
	ServletContext servletContext;
	
	@PostMapping
	@RequestMapping("upload-file")
	@ResponseBody
	public String UploadFile(MultipartHttpServletRequest request)
	{
		String path_save= servletContext.getRealPath("/resources/image/");
		Iterator<String> listName= request.getFileNames();
		
		MultipartFile mpf= request.getFile(listName.next());
		mpf.getOriginalFilename();
		File fileSave= new File(path_save+mpf.getOriginalFilename());
		try {
			mpf.transferTo(fileSave);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path_save);
		return "";
	}
	
	@Autowired
	NhaXuatBanService nxbService;
	
	@Autowired
	SachVaTacGiaService sachVsTacGia;
	
	@Autowired
	ChuDeService chuDeServce;
	
	@Autowired
	TacGiaService tacGiaService;
	
	@PostMapping
	@RequestMapping("them-san-pham")
	@ResponseBody
	public String ThemSanPham(@RequestParam String dataJson,@RequestParam String HinhAnh)
	{
		ObjectMapper ojbect= new ObjectMapper();
		try {
			Sach_No_Peroperty_Object sachJson= ojbect.readValue(dataJson,Sach_No_Peroperty_Object.class);
			
			ArrayList<NhaXuatBan> lsNXB= new ArrayList<>();
			ArrayList<ChuDe> lsChuDe= new ArrayList<>();
			ArrayList<TacGia> lsTacGia= new ArrayList<>();
			Sach sach= new Sach();
			
			lsChuDe= (ArrayList<ChuDe>)chuDeServce.FindbyProperty("TenCD",sachJson.getMaChuDe(),"MaCD","DESC")[0];
			
			lsNXB= (ArrayList<NhaXuatBan>)nxbService.FindbyProperty("TenNXB",sachJson.getMaNXB(),"MaNXB","DESC")[0];
			
			lsTacGia= (ArrayList<TacGia>) tacGiaService.FindbyProperty("TenTG",sachJson.getTacGia(),"MaTG","DESC")[0];
			
			sach.setTenSach(sachJson.getTenSach());
			sach.setAnhBia(HinhAnh);
			sach.setcHudE(lsChuDe.get(0));
			sach.setGiaBan(sachJson.getGiaBan());
			sach.setMoTa(sachJson.getMoTa());
			sach.setNgayCapNhat(sachJson.getNgayCapNhat());
			sach.setSoLuongTon(sachJson.getSoLuongTon());
			sach.setnHaxUatbAn(lsNXB.get(0));
			ArrayList<SachVaTacGia> ls= new ArrayList<>();
			sach.setsAchtAcgIa(ls);
			sachService.Add(sach);
			
			SachVaTacGia sacTacGia= new SachVaTacGia();
			
			ArrayList<Sach> lsSach= (ArrayList<Sach>)sachService.FindbyProperty("TenSach",sachJson.getTenSach(),"MaSach","DESC")[0];
			sacTacGia.setsAchtAcgIa(lsSach.get(0));
			sacTacGia.setVaiTro("Chủ Bút");
			lsTacGia= (ArrayList<TacGia>) tacGiaService.FindbyProperty("TenTG",sachJson.getTacGia(),"MaTG","DESC")[0];
			sacTacGia.settAgIa(lsTacGia.get(0));
			sachVsTacGia.Add(sacTacGia);
			
			ArrayList<SachVaTacGia> lsSachTG= (ArrayList<SachVaTacGia>)sachVsTacGia.FindbyProperty("MaSach",lsSach.get(0).getMaSach(),"MaSach","DESC")[0];
			
			
			lsSach= (ArrayList<Sach>)sachService.FindbyProperty("TenSach",sachJson.getTenSach(),"MaSach","DESC")[0];
			
			lsSach.get(0).setsAchtAcgIa(lsSachTG);
			
			sachService.Update(lsSach.get(0));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dataJson+"dasdsa"+HinhAnh);
		return "";
	}
	@PostMapping
	@RequestMapping(path="chi-tiet-san-pham",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String ChiTietSP(@RequestParam int MaSach)
	{
		ArrayList<Sach> sach= new ArrayList<Sach>();
		sach= (ArrayList<Sach>)sachService.FinbyProperty("MaSach", MaSach,"MaSach", "DESC")[0];
		
		ArrayList<SachVaTacGia> lsTacGiaVaSach= new ArrayList<>();
		ArrayList<TacGia> lsTacGia= new ArrayList<>();
		String tacGia="";
		lsTacGiaVaSach= (ArrayList<SachVaTacGia>) sachVsTacGia.FindbyProperty("MaSach",MaSach,"MaSach","DESC")[0];
		for(SachVaTacGia a: lsTacGiaVaSach) tacGia+=a.gettAgIa().getTenTG()+" ";
		
		
		String html="<tr>";
			html+="<th scope='row' >Thông Tin Chi Tiết:</th>";
			html+="<td><i class='fas fa-pencil-alt btn editSach'></i></td>";
			html+="</tr>";
			html+="<tr>";
			html+="<th scope='row' >Mã Sách:</th>";
			html+="<td><span id='maEditSach'>"+sach.get(0).getMaSach()+"</td>";
			html+="</tr>";
			html+="<tr>";
			html+="<th scope='row' >Tên Sách:</th>";
			html+="<td><span id='tenEditSach'>"+sach.get(0).getTenSach()+"</td>";
			html+="</tr>";
			html+="<tr>";
			html+="<th scope='row' >Hình Ảnh:</th>";
			html+="<td ><img id='hinhAnhEdit' src='/resources/image/"+sach.get(0).getAnhBia()+"' ><br/></td>";
			html+="</tr>";
			html+="<th scope='row' >Tác Giả:</th>";
			html+="<td><span id='tacGiaEdit'>"+tacGia+"</span></td>";
			html+="</tr>";
			html+="<tr>";
			html+="<th scope='row'>Giá Bán:</th>";
			html+="<td><span id='giaBanEdit' class='GiaBan'>"+sach.get(0).getGiaBan()+"</span><span> VNĐ</span></td>";
			html+="</tr>";
			html+="<tr>";
			html+="<th scope='row' >Số Lượng</th>";
			html+="<td><span id='soLuongEdit' class='SoLuong'>"+sach.get(0).getSoLuongTon()+"</td>";
			html+="</tr>";
			html+="<tr>";
			html+="<th scope='row' >Nhà Xuất Bản</th>";
			html+="<td><span id='nxbEdit' class='NhaXB'>"+sach.get(0).getnHaxUatbAn().getTenNXB()+"</td>";
			html+="</tr>";
			html+="<tr>";
			html+="<th scope='row'>Mô Tả:</th>";
			html+="<td><span id='moTaEdit' >"+sach.get(0).getMoTa()+".</span></td>";
			html+="</tr>";
		return html;
	}
	
	@PostMapping
	@RequestMapping("xoa-san-pham-quan-tri")
	@ResponseBody
	public String XoaSanPhamQuanTri(@RequestParam int MaSach)
	{
		ArrayList<Sach> ls=(ArrayList<Sach>) sachService.FinbyProperty("MaSach",MaSach,"MaSach","DESC")[0];
		ArrayList<SachVaTacGia>lsTacGiaVaSach= (ArrayList<SachVaTacGia>) sachVsTacGia.FindbyProperty("MaSach",MaSach,"MaSach","DESC")[0];
		ArrayList<ChiTietDonHang> lsChiTietDH=(ArrayList<ChiTietDonHang>) chiTietService.FindbyProperty("MaSach",MaSach,"MaSach","DESC")[0];
		for(SachVaTacGia a: lsTacGiaVaSach) sachVsTacGia.DeleteSachVSTacGia(a);
		for(ChiTietDonHang a: lsChiTietDH) chiTietService.DeleteChiTietDonHang(a);
		sachService.DeleteT(ls.get(0));
 		return "1";
	}
	@PostMapping
	@RequestMapping(path="chi-tiet-don-hang",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String ChiTietDonHang(@RequestParam int MaChiTiet)
	{
		ArrayList<DonHang> a= (ArrayList<DonHang>) donHangService.FindbyProperty("MaDH", MaChiTiet,"MaDH","DESC")[0];
		String html="";
		float Tongtien=0;
		for(ChiTietDonHang b: a.get(0).getcHitIetdOnhAng() )
		{
			html+="<tr>";
			html+="<td >"+b.getsAchdOnhAng().getTenSach()+"</td>";
			html+="<td>"+b.getSoLuong()+"</td>";
			html+="<td>"+b.getDonGia()+"</td>";
			html+="</tr>";
			Tongtien+=b.getDonGia()*b.getSoLuong();
		}
		html+="<tr>";
		html+="<td ><span>Tổng Tiền</span></td>";
		html+="<td ><span  class='ThanhTien'>"+Tongtien+"</span></td>";
		html+="<td ><span>.VNĐ</span></td>";
		html+="</tr>";
 		return html;
	}

	@PostMapping
	@RequestMapping("xoa-don-hang")
	@ResponseBody
	public String XoaDonHang(@RequestParam int MaDonHang)
	{
		ArrayList<DonHang> a= (ArrayList<DonHang>) donHangService.FindbyProperty("MaDH", MaDonHang,"MaDH","DESC")[0];
		for(ChiTietDonHang b: a.get(0).getcHitIetdOnhAng())
		{
			chiTietService.DeleteChiTietDonHang(b);
		}
		donHangService.DeleteDonHang(a.get(0));
 		return "1";
	}

	@PostMapping
	@RequestMapping("them-nxb")
	@ResponseBody
	public  String ThemNXB(@RequestParam String TenNXB,@RequestParam String DiaChi,@RequestParam String SDT){
		try{
			NhaXuatBan nxb= new NhaXuatBan();
			nxb.setTenNXB(TenNXB);
			nxb.setDiaChi(DiaChi);
			nxb.setDienThoai(SDT);
			nxbService.add(nxb);
		}catch (Exception e){}
		return "1";
	}

	@PostMapping
	@RequestMapping("save-nxb")
	@ResponseBody
	public  String ChinhSuaNXB(@RequestParam String MaNXB,@RequestParam String TenNXB,@RequestParam String DiaChi,@RequestParam String SDT){
		try{
			ArrayList<NhaXuatBan> lsNXB= (ArrayList<NhaXuatBan>) nxbService.FindbyProperty("MaNXB",Integer.parseInt(MaNXB),"MaNXB","DESC")[0];
			NhaXuatBan nxb= lsNXB.get(0);
			nxb.setTenNXB(TenNXB);
			nxb.setDiaChi(DiaChi);
			nxb.setDienThoai(SDT);
			nxbService.UpdateInfor(nxb);
		}catch (Exception e){}
		return "1";
	}

	@PostMapping
	@RequestMapping("them-tacgia")
	@ResponseBody
	public  String ThemTacGia(@RequestParam String TenTacGia,@RequestParam String DiaChi,@RequestParam String SDT){
		try{
			TacGia tacGia= new TacGia();
			tacGia.setTenTG(TenTacGia);
			tacGia.setDiaChi(DiaChi);
			tacGia.setDienThoai(SDT);
			tacGiaService.add(tacGia);
		}catch (Exception e){}
		return "1";
	}

	@PostMapping
	@RequestMapping("save-tacgia")
	@ResponseBody
	public  String ChinhSuaTacGia(@RequestParam String MaTacGia,@RequestParam String TenTacGia,@RequestParam String DiaChi,@RequestParam String SDT){
		try{
			ArrayList<TacGia> lsTacGia= (ArrayList<TacGia>) tacGiaService.FindbyProperty("MaTG",Integer.parseInt(MaTacGia),"MaTG","DESC")[0];
			TacGia tacGia= lsTacGia.get(0);
			tacGia.setTenTG(TenTacGia);
			tacGia.setDiaChi(DiaChi);
			tacGia.setDienThoai(SDT);
			tacGiaService.UpdateInfor(tacGia);
		}catch (Exception e){}
		return "1";
	}

	@PostMapping
	@RequestMapping("them-chude")
	@ResponseBody
	public String ThemChuDe(@RequestParam String TenCD)
	{
		try {
			ChuDe chuDe= new ChuDe();
			chuDe.setTenCD(TenCD);
			chuDeServce.add(chuDe);
		}catch (Exception e){}
		return "1";
	}

	@PostMapping
	@RequestMapping("save-chude")
	@ResponseBody
	public String ChinhSuaChuDe(@RequestParam String MaCD,@RequestParam String TenCD)
	{
		ArrayList<ChuDe> lsChuDe=(ArrayList<ChuDe>) chuDeServce.FindbyProperty("MaCD",Integer.parseInt(MaCD),"MaCD","DESC")[0];
		try {
			ChuDe chuDe= lsChuDe.get(0);
			chuDe.setTenCD(TenCD);
			chuDeServce.UpdateInfor(chuDe);
		}catch (Exception e){}
		return "1";
	}
	@PostMapping
	@RequestMapping("save-san-pham")
	@ResponseBody
	public String EidtSanPham(@RequestParam String dataJson,@RequestParam String HinhAnh,@RequestParam String MaSach ) {
		ArrayList<Sach> sach= (ArrayList<Sach>) sachService.FindbyProperty("MaSach",Integer.parseInt(MaSach),"MaSach","DESC")[0];
		try {
			ObjectMapper ojbect= new ObjectMapper();
			Sach_No_Peroperty_Object sachJson= ojbect.readValue(dataJson,Sach_No_Peroperty_Object.class);
			System.out.println(MaSach);
			ArrayList<NhaXuatBan> lsNXB= new ArrayList<>();
			ArrayList<ChuDe> lsChuDe= new ArrayList<>();
			ArrayList<TacGia> lsTacGia= new ArrayList<>();
			try {
				System.out.println(sachJson.getMaChuDe());
				lsChuDe= (ArrayList<ChuDe>)chuDeServce.FindbyProperty("TenCD",sachJson.getMaChuDe(),"MaCD","DESC")[0];
				System.out.println(lsChuDe.size());
			}catch (Exception e){}
			try {
				lsNXB= (ArrayList<NhaXuatBan>)nxbService.FindbyProperty("TenNXB",sachJson.getMaNXB(),"MaNXB","DESC")[0];
			}catch (Exception e){}
			try {
				lsTacGia= (ArrayList<TacGia>) tacGiaService.FindbyProperty("TenTG",sachJson.getTacGia(),"MaTG","DESC")[0];
			}catch (Exception e){}
			if(!sachJson.getTenSach().equals(sach.get(0).getTenSach()))sach.get(0).setTenSach(sachJson.getTenSach());
			if(!HinhAnh.equals(sach.get(0).getAnhBia())||HinhAnh.equals(""))sach.get(0).setAnhBia(HinhAnh);
			if(sachJson.getNgayCapNhat()!=sach.get(0).getNgayCapNhat()) sach.get(0).setNgayCapNhat(sachJson.getNgayCapNhat());
			System.out.print(HinhAnh);
			if(lsChuDe.size()>0){sach.get(0).setcHudE(lsChuDe.get(0));}
			if(lsNXB.size()>0){sach.get(0).setnHaxUatbAn(lsNXB.get(0));}
			if(lsTacGia.size()>0){
				SachVaTacGia sachVaTacGia= new SachVaTacGia();
				sachVaTacGia.setsAchtAcgIa(sach.get(0));
				sachVaTacGia.settAgIa(lsTacGia.get(0));
				sachVaTacGia.setVaiTro("Chủ bút");
				ArrayList<SachVaTacGia> lsSachVaTacGia= new ArrayList<>();
				lsSachVaTacGia.add(sachVaTacGia);
				sach.get(0).setsAchtAcgIa(lsSachVaTacGia);
			}
			if(sachJson.getGiaBan()!=sach.get(0).getGiaBan())sach.get(0).setGiaBan(sachJson.getGiaBan());
			if(!sachJson.getMoTa().equals(sach.get(0).getMoTa()))sach.get(0).setMoTa(sachJson.getMoTa());
			if(sachJson.getSoLuongTon()!=sach.get(0).getSoLuongTon())sach.get(0).setSoLuongTon(sachJson.getSoLuongTon());
			sachService.Update(sach.get(0));
			return "yes";
		}catch (Exception e){}
		return "no";
	}
	@PostMapping
	@RequestMapping("duyet-giao-hang")
	@ResponseBody
	public String DuyetGiaoHang(@RequestParam String MaDH){
		try {
			ArrayList<DonHang> donHang= new ArrayList<>();
			donHang=(ArrayList<DonHang>) donHangService.FindbyProperty("MaDH",Integer.parseInt(MaDH),"MaDH","DESC")[0];
			donHang.get(0).setTinhTrangGiaoHang((byte)1);
			donHangService.UpdateInfor(donHang.get(0));
			return "1";
		}catch (Exception e){}
		return"0";
	}
	@PostMapping
	@RequestMapping("duyet-thanh-toan")
	@ResponseBody
	public String DuyetThanhToan(@RequestParam String MaDH){
		try {
			ArrayList<DonHang> donHang= new ArrayList<>();
			donHang=(ArrayList<DonHang>) donHangService.FindbyProperty("MaDH",Integer.parseInt(MaDH),"MaDH","DESC")[0];
			donHang.get(0).setDaThanhToan((byte)1);
			donHangService.UpdateInfor(donHang.get(0));
			return "1";
		}catch (Exception e){}
		return"0";
	}
	@PostMapping
	@RequestMapping("xoa-tai-khoan")
	@ResponseBody
	public String XoaTaiKhoan(@RequestParam String MaKH)
	{
		try {
			List<KhachHang> lsKhacHang= new ArrayList<KhachHang>();
			lsKhacHang= (ArrayList<KhachHang>) khachHangService.FindbyProperty("MaKH",Integer.parseInt(MaKH),"MaKH","DESC")[0];
			khachHangService.DeleteKhacHang(lsKhacHang.get(0));
			return "1";
		}catch (Exception e){}
		return "0";
	}
	@PostMapping
	@RequestMapping("gop-y")
	@ResponseBody
	public String GopY(@RequestParam String Email,@RequestParam String NoiDung)
	{
		try {
			GopY gopY= new GopY();
			gopY.setEmail(Email);
			gopY.setNoiDung(NoiDung);
			gopYService.add(gopY);
			return "1";
		}catch (Exception e){}
		return "0";
	}
}
