package com.bansachonline.springmvc.controller;

import com.bansachonline.springmvc.model.TacGia;
import com.bansachonline.springmvc.service.ChuDeService;
import com.bansachonline.springmvc.service.NhaXuatBanService;
import com.bansachonline.springmvc.service.TacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 05/11/2018.
 */
@Controller
@RequestMapping("/nxb-tacgia-chude/")
public class NXB_TacGia_ChuDe_Controller {

    @Autowired
    NhaXuatBanService nxbService;

    @Autowired
    TacGiaService tacgiaService;

    @Autowired
    ChuDeService chudeService;
    @RequestMapping("")
    public String NXB_TacGia_ChuDe( ModelMap mm){
        try {
            mm.put("NXB",nxbService.ShowAll());
            mm.put("TacGia",tacgiaService.ShowAll());
            mm.put("ChuDe",chudeService.ShowAll());
        }
        catch (Exception e){}
        return "NXB_TacGia_ChuDe";
    }
}
