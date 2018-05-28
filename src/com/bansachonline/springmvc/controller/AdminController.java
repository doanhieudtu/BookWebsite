package com.bansachonline.springmvc.controller;

import com.bansachonline.springmvc.model.ChiTietDonHang;
import com.bansachonline.springmvc.model.DonHang;
import com.bansachonline.springmvc.service.DonHangService;
import com.bansachonline.springmvc.service.GopYService;
import com.bansachonline.springmvc.service.KhacHangService;
import com.bansachonline.springmvc.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DELL on 05/24/2018.
 */
@Controller
@RequestMapping("/Admin/")
public class AdminController {
    @Autowired
    KhacHangService khacHangService;

    @Autowired
    DonHangService donHangService;


    @Autowired
    SachService sachService;

    @RequestMapping("Login")
    public String Admin()
    {
        return "admin-login";
    }
    @PostMapping
    @RequestMapping("Kiem-Tra")
    @ResponseBody
    public String Login(@RequestParam String Ten, @RequestParam String Password, ModelMap mm){
        System.out.print(Ten);
        if(Ten.equals("doanhieudtu@gmail.com")&&Password.equals("admin"))
        {
            return "1";
        }
        else
        return "0";
    }
    @RequestMapping("thong-ke")
    public String ThongKe(ModelMap mm){

        int tongSoSach=0;
        double tongDoanhThu=0;
        int tongKhachHang=0;
        int tongDonHang=0;
        tongSoSach+= sachService.ShowAll().size();
        for(DonHang donHang: donHangService.ShowAll())
        {
            if(donHang.getDaThanhToan()!=0)
            {
                for(ChiTietDonHang ctDonHang: donHang.getcHitIetdOnhAng())
                {
                    tongDoanhThu+= ctDonHang.getDonGia()*ctDonHang.getSoLuong();
                }
            }
        }
        tongKhachHang+= khacHangService.ShowAll().size();
        tongDonHang+= donHangService.ShowAll().size();

        mm.put("TongSoSach",tongSoSach);
        mm.put("TongDoanhThu", tongDoanhThu);
        mm.put("TongKhachHang",tongKhachHang);
        mm.put("TongDonHang",tongDonHang);
        return "thong-ke";
    }
}
