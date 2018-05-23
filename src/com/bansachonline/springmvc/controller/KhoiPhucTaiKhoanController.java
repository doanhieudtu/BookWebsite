package com.bansachonline.springmvc.controller;

import com.bansachonline.springmvc.model.KhachHang;
import com.bansachonline.springmvc.model.UserToken;
import com.bansachonline.springmvc.service.KhacHangService;
import com.bansachonline.springmvc.service.MailService;
import com.bansachonline.springmvc.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by DELL on 05/22/2018.
 */
@Controller
@RequestMapping("/khoi-phuc-tai-khoan/")
public class KhoiPhucTaiKhoanController {

    @Autowired
    MailService mailService;

    @Autowired
    KhacHangService khachHangService;

    @Autowired
    UserTokenService userTokenService;
    private String Email ;


    @RequestMapping("")
    public String YeuCauKhoiPhuc()
    {
        return "yeu-cau-khoi-phuc";
    }

    @PostMapping
    @RequestMapping("cap-ma-khoi-phuc")
    @ResponseBody
    public String CapMaKhoiPhuc (@RequestParam String Email, HttpServletRequest request)
    {

        ArrayList<KhachHang> lsKhacHang= new ArrayList<>();
        try {
            lsKhacHang=(ArrayList<KhachHang>) khachHangService.FindbyProperty("Email",Email,"Email","DESC")[0];
        }catch (Exception e){}

        if(lsKhacHang.size()!=0)
        {

            UserToken userToken= new UserToken();
            Date toDate= new Date();
            userToken.setTimeChange(toDate.getTime());
            userToken.setUserToken(lsKhacHang.get(0));


//            gui mail
            String subject="";
            String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getLocalPort();
            subject+="De reset tai khoan, ban can click vai link duoi day:\n" +"Lien ket nay chi ton tai trong vong  2h.\n Chuc ban thanh cong.\n"+appUrl
                    +"/khoi-phuc-tai-khoan/kiem-tra-ton-tai-ma?token="+(userToken.getTimeChange()+"")+"&Email="+Email;
            mailService.sendMail("nhasachcdio397@gmail.com",lsKhacHang.get(0).getEmail(),"Khoi phuc tai khoan",subject);
            userTokenService.Add(userToken);
            return "1";
        }
        else
        return "0";
    }

    @GetMapping
    @RequestMapping("kiem-tra-ton-tai-ma")
    public String KiemTraTonTaiMa(@RequestParam String token,@RequestParam String Email)
    {
        this.Email=Email;
        Date toDate= new Date();
        if((((toDate.getTime()-Long.parseLong(token))/1000)/3600)<=2)
        {
            return "khoi-phuc-tai-khoan";
//            ArrayList<KhachHang> lsKhacHang= new ArrayList<>();
//            lsKhacHang=(ArrayList<KhachHang>) khachHangService.FindbyProperty("Email",Email,"Email","DESC")[0];
//
//            lsKhacHang.get(0).setMatKhau();
        }
        return "0";
    }
    @PostMapping
    @RequestMapping("khoi-phuc")
    @ResponseBody
    public String KhoiPhuc(@RequestParam String MatKhauMot,@RequestParam String MatKhauHai)
    {
        if(MatKhauMot.equals(MatKhauHai))
          try {
              ArrayList<KhachHang> lsKhacHang= new ArrayList<>();
              lsKhacHang=(ArrayList<KhachHang>) khachHangService.FindbyProperty("Email",this.Email,"Email","DESC")[0];

              lsKhacHang.get(0).setMatKhau(MatKhauMot);

              khachHangService.UpdateInfor(lsKhacHang.get(0));
              return "1";
          }catch (Exception ae) {}
        return "0";
    }
}
