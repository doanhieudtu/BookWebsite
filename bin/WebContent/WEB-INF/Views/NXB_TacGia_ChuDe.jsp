<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Duyệt Đơn Hàng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <link href="<c:url value="/resources/cssAdmin/bootstrap.min.css"/>"  rel="stylesheet" >
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/cssAdmin/style.css"/>"  rel="stylesheet" >
    <link href="<c:url value="/resources/cssAdmin/morris.css"/>"  rel="stylesheet" >
    <!-- Graph CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/css/fontawesome-free-5.0.9/web-fonts-with-css/css/fontawesome-all.css"/>">
    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>" ></script>
    <!-- //jQuery -->
    <link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
    <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- lined-icons -->
    <script src="<c:url value="/resources/cssAdmin/icon-font.min.css"/>" ></script>
    <!-- //lined-icons -->
    <link href="<c:url value="/resources/css/Style.css"/>"  rel="stylesheet" >
</head>
<body>
<div class="page-container">
    <div class="page-container">
        <!--/content-inner-->
        <div class="left-content" style="background-color: white;">
            <div class="col-12 col-sm-8 col-md-12"  id="ThongTin">
                <div class="row">
                    <div class="col-12 col-sm-4 col-md-8"  id="DanhMuc">
                        <ul class="navbar-nav mr-auto narbar-menu" style="list-style: none">
                            <li class="nav-item dropdown" >
                                <div class="col-sm-12 top-content-select">
                                    <select class="custom-select MenuHoSo">
                                        <option class="custom-select-web-design" value="web-design">--------Chọn---------</option>
                                        <option class="custom-select-web-design" value="web-design">Nhà Xuất Bản.</option>
                                        <option class="custom-select-web-design" value="branding">Tác Giả.</option>
                                        <option class="custom-select-web-design" value="branding">Chủ Đề.</option>
                                    </select>
                                </div>
                            </li>
                        </ul>
                        <table class="table" id="DanhSachNXB">
                            <thead>
                            <th> Mã NXB</th>
                            <th> Tên NXB</th>
                            <th> Địa Chỉ</th>
                            <th> Số Điện Thoại</th>
                            <th><i class="fas fa-plus fa-2x btn  btn" id="themNXB"></i></th>
                            </thead>
                            <tbody>
                            <c:forEach var="Item" items="${NXB}">
                                <tr>
                                    <td class="maNXB">${Item.getMaNXB()}</td>
                                    <td class="tenNXB">${Item.getTenNXB()}</td>
                                    <td class="diachiNXB">${Item.getDiaChi()}</td>
                                    <td class="sdtNXB">${Item.getDienThoai()}</td>
                                    <td><i class="fas fa-pencil-alt btn editNXB"></i></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <table class="table" id="DanhSachTacGia" style="display: none">
                            <thead>
                            <th> Mã Tác Giả</th>
                            <th> Tên Tác Giả</th>
                            <th> Địa Chỉ</th>
                            <th> Số Điện Thoại</th>
                            <th><i class="fas fa-plus fa-2x btn" id="themTacGia"></i></th>
                            </thead>
                            <tbody>
                            <c:forEach var="Item" items="${TacGia}">
                                <tr>
                                    <td class="maTacGia">${Item.getMaTG()}</td>
                                    <td class="tenTacGia">${Item.getTenTG()}</td>
                                    <td class="diachiTacGia">${Item.getDiaChi()}</td>
                                    <td class="sdtTacGia">${Item.getDienThoai()}</td>
                                    <td><i class="fas fa-pencil-alt btn editTacGia"></i></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <table class="table" id="DanhSachChuDe"  style="display: none">
                            <thead>
                            <th> Mã Chủ Đề</th>
                            <th> Tên Chủ Đề</th>
                            <th><i class="fas fa-plus fa-2x btn" id="themChuDe"></i></th>
                            </thead>
                            <tbody>
                            <c:forEach var="Item" items="${ChuDe}">
                                <tr>
                                    <td class="maChuDe">${Item.getMaCD()}</td>
                                    <td class="tenChuDe">${Item.getTenCD()}</td>
                                    <td><i class="fas fa-pencil-alt btn editChuDe"></i></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-12 col-sm-2 col-md-4"  id="ThemMoi-SuaDoi" >
                        <div id="formEditNXB" style="display: none">
                            <form >
                                <h4>Sửa đổi thông tin nhà xuất bản.</h4>
                                <div class="form-group">
                                    <label >Tên Nhà Xuất Bản</label>
                                    <input type="text" class="form-control"  id="teneditNXB"/>
                                </div>
                                <div class="form-group">
                                    <label >Số điện thoại liên hệ.</label>
                                    <input type="text" class="form-control"  id="sdteditNXB"/>
                                </div>
                                <div class="form-group">
                                    <label  >Địa chỉ.</label>
                                    <input type="text" class="form-control"  id="diachieditNXB"/>
                                </div>
                                <div class="form-group">
                                    <span><i class="far fa-save fa-2x btn" id="saveNXB"></i></span>
                                </div>
                            </form>
                        </div>
                        <div  id="formEditTacGia" style="display: none">
                            <form >
                                <h4>Sửa đổi thông tin tác giả.</h4>
                                <div class="form-group">
                                    <label >Tên Tác Giả</label>
                                    <input type="text" class="form-control"  id="teneditTacGia"/>
                                </div>
                                <div class="form-group">
                                    <label >Số điện thoại liên hệ.</label>
                                    <input type="text" class="form-control"  id="sdteditTacGia"/>
                                </div>
                                <div class="form-group">
                                    <label  >Địa chỉ.</label>
                                    <input type="text" class="form-control"  id="diachieditTacGia"/>
                                </div>
                                <div class="form-group">
                                    <span><i class="far fa-save fa-2x btn" id="saveTacGia"></i></span>
                                </div>
                            </form>
                        </div>
                        <div id="formEditChuDe" style="display: none">
                            <form >
                                <h4>Sửa đổi thông tin chủ đề.</h4>
                                <div class="form-group">
                                    <label >Tên Chủ Đề</label>
                                    <input type="text" class="form-control"  id="teneditChuDe"/>
                                </div>
                                <div class="form-group">
                                    <span><i class="far fa-save fa-2x btn" id="saveChuDe"></i></span>
                                </div>
                            </form>
                        </div>
                        <div id="formThemNXB" style="display: none">
                        <form >
                            <h4>Điền thông tin nhà xuất bản.</h4>
                            <div class="form-group">
                                <label >Tên Nhà Xuất Bản</label>
                                <input type="text" class="form-control" id="tenmoiNXB"/>
                            </div>
                            <div class="form-group">
                                <label >Số điện thoại liên hệ.</label>
                                <input type="text" class="form-control"  id="sdtmoiNXB">
                            </div>
                            <div class="form-group">
                                <label  >Địa chỉ.</label>
                                <input type="text" class="form-control"  id="diachimoiNXB">
                            </div>
                            <div class="form-group">
                                <a href="#" id="themMoiNXB"><span>Thêm Mới</span></a>
                            </div>
                        </form>
                        </div>
                        <div  id="formThemTacGia" style="display: none">
                        <form >
                            <h4>Điền thông tin tác giả.</h4>
                            <div class="form-group">
                                <label >Tên Tác Giả</label>
                                <input type="text" class="form-control"  id="tenmoiTacGia"/>
                            </div>
                            <div class="form-group">
                                <label >Số điện thoại liên hệ.</label>
                                <input type="text" class="form-control"  id="sdtmoiTacGia">
                            </div>
                            <div class="form-group">
                                <label  >Địa chỉ.</label>
                                <input type="text" class="form-control"  id="diachimoiTacGia">
                            </div>
                            <div class="form-group">
                                <a href="#" id="themMoiTacGia"><span>Thêm Mới</span></a>
                            </div>
                        </form>
                        </div>
                        <div id="formThemChuDe" style="display: none">
                        <form >
                            <h4>Điền thông tin chủ đề.</h4>
                            <div class="form-group">
                                <label >Tên Chủ Đề</label>
                                <input type="text" class="form-control"  id="tenmoiChuDe"/>
                            </div>
                            <div class="form-group">
                                <a href="#" id="themMoiChuDe"><span>Thêm Mới</span></a>
                            </div>
                        </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="sidebar-menu">
        <header class="logo1">
            <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a>
        </header>
        <div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
        <div class="menu">
            <ul id="menu" >
                <li  ><a href="/san-pham/them"><i class="fas fa-book"></i><span>Sản Phẩm</span><div class="clearfix"></div></a></li>
                <li><a href="/khach-hang/tai-khoan"><i class="far fa-user-circle"></i><span>Khách Hàng</span><div class="clearfix"></div></a></li>
                <li  ><a href="/nxb-tacgia-chude/"><i class="fa fa-bar-chart"></i><span>N.X.Bản-Chủ Đề-Tác Giả</span><div class="clearfix"></div></a></li>
                <li><a href="/don-hang/"><i class="fas fa-money-bill-wave-alt"></i><span>Duyệt Đơn Hàng</span><div class="clearfix"></div></a></li>
                <li  ><a href="#"><i class="fas fa-chart-line"></i><span>Thống Kê/Báo Cáo</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul >
                        <li  ><a href="icons.html">Sách</a></li>
                        <li ><a href="typography.html">Doanh Thu</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="clearfix"></div>
    </div>
    <div class="clearfix"></div>
</div>
</div>
<script>
    var toggle = true;

    $(".sidebar-icon").click(function() {
        if (toggle)
        {
            $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
            $("#menu span").css({"position":"absolute"});
        }
        else
        {
            $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
            setTimeout(function() {
                $("#menu span").css({"position":"relative"});
            }, 400);
        }

        toggle = !toggle;
    });
</script>
<!--js -->
<script src="<c:url value="/resources/jsAdmin/scripts.js"/>" ></script>
<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>" ></script>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"/>" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"/>" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/jsAdmin/bootstrap.min.js"/>" ></script>
<!-- /Bootstrap Core JavaScript -->
<!-- morris JavaScript -->
<script src="<c:url value="/resources/js/custom.js"/>"></script>
</body>
</html>