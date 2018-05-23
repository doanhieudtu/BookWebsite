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
<title>Quản Lý Sản Phẩm</title>
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
				
								<div class="col-12 col-sm-4 col-md-6"  id="ThemMoiSach">
								<h4>Thông Tin Sách</h4>
								<form id="FormSanPham">
  									<div class="form-group">
   								 		<label for="exampleFormControlInput1">Tên Sách.</label>
    									<input type="text" class="form-control" id="tenSach"name="tenSach"/>
 							 		</div>
 							 		<div class="form-group">
 							 		 <label >Nhà Xuất Bản</label>
      									<select class="form-control" name="maNXB">
        								<option selected>Chọn nhà xuất bản</option>
        								<c:forEach var="Item" items="${NhaXuatBan}">
        									<option>${Item.getTenNXB()}</option>
        								</c:forEach>
      									</select><br/>
      								</div>
 							 		<div class="form-group">
    									<label >Giá Bán.</label>
    									<input type="number" class="form-control" id="giaBan" name="giaBan">
  									</div>
  									<div class="form-group">
    									<label >Số Lượng</label>
    									<input type="number" class="form-control" id="soLuongTon"  name="soLuongTon">
  									</div>
  									
  									 <div class="form-group">
    									<label >Hình Ảnh Cho Sản Phẩm</label>
    									<input type="file" class="form-control-file"  onchange="readURL(this);" id="HinhAnh"  name="HinhAnh">
  									 </div>
  									 <div class="form-group">
  									 <img name="HinhAnh" id="img-upload"/>
  									 </div>
  									  <label >Chủ Đề</label>
      									<select  class="form-control" name="maChuDe">
        								<option selected>Chọn chủ đề.</option>
        								<c:forEach var="Item" items="${ChuDe}">
        									<option>${Item.getTenCD()}</option>
        								</c:forEach>
        								
      									</select><br/>
      									<label>Tác Giả</label>
      									<select class="form-control" name="tacGia">
        								<option selected>Chọn tác giả.</option>
        								<c:forEach var="Item" items="${TacGia}">
        									<option>${Item.getTenTG()}</option>
        								</c:forEach>
      									</select><br/>
      								<div class="form-group">
    									<label  >Ngày Cập Nhật.</label>
    									<input type="date"  class="form-control"  name="ngayCapNhat">
 									</div>
  									<div class="form-group">
    									<label  >Mô Tả.</label>
    									 <textarea class="form-control" rows="5" id="moTa" name="moTa"></textarea>
  									</div>
  									<div class="form-group">
    									<span class="btn" id="btnThemSach">Thêm Mới Sách</span>
  									</div>
									<div class="form-group">
										<span class="btn" style="display: none" id="btnHuyChinhSua">Hủy Chỉnh Sửa </span>
									</div>
									<div class="form-group">
										<span class="btn" style="display: none" id="btnLuuSach">Lưu Thông Tin Chỉnh Sửa </span>
									</div>
							 	</form>
								</div>
	    						<div class="col-12 col-sm-2 col-md-6 " >
	    							<div class="row">
										<div class="col-12 col-sm-2 col-md-4 btn"></div>
										<div class="col-12 col-sm-2 col-md-4 btn" ></div>
										<div class="col-12 col-sm- col-md-4 btn" ></div>
									</div>
								<div class="row">
								<div class="col-12 col-sm-6 col-md-12" >
									<div class="col-12 col-sm-2 col-md-3 btn"></div>
										<div class="col-12 col-sm-2 col-md-6 " ></div>
										<div class="col-12 col-sm- col-md-3 " ></div>
								</div>
								</div>
    							<table class="table"  id="DanhSachSanPham">
    								<thead>
    										<th scope="col"></th>
    										<th scope="col">Mã Sách</th>
    										<th scope="col"> Tên Sách</th>
    										<th scope="col"></th>
											<th scope="col"></th>
    								</thead>
    								<tbody>
    									<c:forEach var="Sach" items="${ListSach}">
    									<tr>
    										<td><i class="fas fa-trash-alt fa-2x btnXoaSach btn"></i></td>
    										<td id="MaSach">${Sach.getMaSach()}</td>
    										<td>${Sach.getTenSach()}</td>
    										<td><span class="XemChiTiet btn">Chi Tiết</span></td>

    									</tr>
    									</c:forEach>
    								</tbody>
    							</table>
    							<div  class="row">
								<div class=" col-12 col-sm-4 col-md-2"></div>
								<ul class="pagination col-12 col-sm-4 col-md-10 ">
									<c:forEach var="index" begin="1" end="${TongPageSach}">
									 <li style="margin-left: 10px; width: 10px;" class="paging-item-sach"><a href="#">${index}</a></li>
									</c:forEach>
								</ul>
								</div>
								<div  class="row">
									<table class="tablecol-12 col-sm-5 col-md-12" id="ThongTinSach">
  										<tbody>
  											<tr>
  												<th scope="row" ><h4>Thông Tin Chi Tiết:</h4></th>
  												<td><td><i class="fas fa-pencil-alt btn editSach"></i></td></td>
  											</tr>
											<tr>
												<th scope="row" >Mã Sách:</th>
												<td><span id="maEditSach">${Sach.getMaSach()}</span></td>
											</tr>
  											<tr>
  												<th scope="row" >Tên Sách:</th>
  												<td><span id="tenEditSach">${Sach.getTenSach()}</span></td>
  											</tr>
  											<tr>
  												<th scope="row" >Hình Ảnh:</th>
  												<td ><img id="hinhAnhEdit" src="/resources/image/${Sach.getAnhBia()}" alt="anh-ve-sach"><br/></td>
  											</tr>
    										<tr>
      											<th scope="row" >Tác Giả:</th>
      											<td>
      											<c:forEach var="tacGia" items="${tacGia}">
      												<span id="tacGiaEdit">${tacGia.getTenTG()}  </span>
      											</c:forEach>
      											</td>
    										</tr>
    										<tr>
      											<th scope="row">Giá Bán:</th>
      											<td><span  id="giaBanEdit">${Sach.getGiaBan()}</span><span> VNĐ</span></td>
    										</tr>
   											<tr>
      											<th scope="row" >Số Lượng</th>
												<td><span id="soLuongEdit">${Sach.getSoLuongTon()}</span></td>
    										</tr>
    										<tr>
      												<th scope="row">Nhà Xuất Bản:</th>
												<td><span id="nxbEdit">${NhaXB}</span></td>
    										</tr>
    							
    										<tr>
      												<th scope="row">Mô Tả:</th>
      												<td><span id="moTaEdit">${Sach.getMoTa()}.</span></td>
    										</tr>
  									</tbody>	
    							</table>
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
										 <li  ><a href="/san-pham/them/"><i class="fas fa-book"></i><span>Sản Phẩm</span><div class="clearfix"></div></a></li>
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