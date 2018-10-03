<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Hồ Sơ Cá Nhân</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link href="<c:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css"/>"  rel="stylesheet" >
     <link href="<c:url value="/resources/css/animate.css"/>"  rel="stylesheet" >
     <link href="<c:url value="/resources/css/Style.css"/>"  rel="stylesheet" >
  	<link rel="stylesheet" href="<c:url value="/resources/css/fontawesome-free-5.0.9/web-fonts-with-css/css/fontawesome-all.css"/>"> 
</head>
<body>
    <div id="header-menu" class="container-fluid "  >
            <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-all">
                    <a class="navbar-brand wow pulse"  data-wow-duration="5s" href="/bookstore/trangchu">  <img src="/resources/image/logo.jpg"/></a>
                    <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                  
                    <div class="collapse navbar-collapse navbar-home-lik-vv" id="navbarSupportedContent">
                      <ul class="navbar-nav mr-auto narbar-menu">
                        <li class="nav-item active">
                          <a class="nav-link " href="/bookstore/trangchu">Trang Chủ<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Dịch Vụ</a>
                        </li>
                        <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Danh Mục Sách
                          </a>
                          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                          </div>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link disabled nav-item" href="#">Liên Hệ</a>
                        </li>
                         
                      </ul>
                      <ul class="navbar-nav mr-auto narbar-menu">
                      	<li class="nav-item dropdown" >
                      		<div class="col-sm-12 top-content-select">
                        	<select class="custom-select MenuHoSo">
                        		<option class="custom-select-web-design" value="web-design">Thông Tin Cá Nhân.</option>
                       			<option class="custom-select-web-design" value="branding" >Lịch Sử Đặt Hàng.</option>
                       			<option class="custom-select-web-design" value="branding">Đăng Xuất.</option>
                       		</select>
                      		</div>
                        </li>
                      </ul>
                   
                    </div>
                  </nav>
    </div>
    <div id="noi-dung-chi-tiet">
    		<div id="Sach" class="col-12 col-sm-6 col-md-12"  >
    			<div class="row" >
    				<div class="col-12 col-sm-2 col-md-3" >
    					<div id="ThongTinCaNhan" style="display: none">
    					<h4>Thông Tin Cá Nhân</h4>
    					<form>
  							<div class="form-group">
   								 <label>Họ tên.</label>
    							<input type="text" class="form-control" value="${User.getHoTen()}"  readonly/>
 							 </div>
 							 <div class="form-group">
    						<label >Số điện thoại liên hệ.</label>
    						<input type="text" class="form-control" value="${User.getDienThoai()}" readonly>
  							</div>
  							<div class="form-group">
    						<label >Địa chỉ.</label>
    						<input type="text" class="form-control" value="${User.getDiaChi()}"  readonly>
  							</div>
  							<div class="form-group">
    						<label>Email.</label>
    						<input type="text" class="form-control"  value="${User.getEmail()}"  readonly>
 							</div>
						</form>
						</div>
    				</div>
    				<div class="col-12 col-sm-4 col-md-5">
    					<div class="row" id="HoSoCaNhan" >
    						<div class="col-12 col-sm- col-md-10">
    							<h4>Thông Tin Cá Nhân</h4>
    							<form>
  									<div class="form-group">
   								 		<label >Họ tên.</label>
    									<input type="text" class="form-control" value="${User.getHoTen()}"  readonly id="HoTen"/>
 							 		</div>
 							 		<div class="form-group">
    									<label >Số điện thoại liên hệ.</label>
    									<input type="text" class="form-control" value="${User.getDienThoai()}" readonly id="SoDT">
  									</div>
  									<div class="form-group">
    									<label  >Địa chỉ.</label>
    									<input type="text" class="form-control" value="${User.getDiaChi()}"  readonly id="DiaChi">
  									</div>
  									<div class="form-group">
    									<label >Email.</label>
    									<input type="text" class="form-control"  value="${User.getEmail()}"  readonly id="Email">
 									</div>
 									<div class="form-group">
    									<label>Mật Khẩu.</label>
    									<input type="password" class="form-control"  value="${User.getMatKhau()}"  readonly id="MatKhau">
 									</div>
 									<div class="form-group" style="display: none" id="luuhoso"><span>****Lưu thông tin..............................<i class="far fa-save fa-2x btn" id="saveHoSo"></i></span></div>
								</form>
							</div>
							<div class="col-12 col-sm-3 col-md-2" class="form-group" id="editHoSo">
    						<i class="fas fa-edit fa-2x btn"></i>
    						</div>
						</div>
						<div class="row">
    						<div class="col-12 col-sm-6 col-md-12"  id="DanhSachDonHang" style="display: none">
    							<h4>Danh Sách Đơn Hàng.</h4>
    							<table class="table" id="ListDonHang">
    								<thead>
    									<th scope="col">Mã Đ.Hàng</th>
    										<th scope="col"> Ngày Đặt</th>
    										<th scope="col"></th>
    										<th scope="col"></th>
    								</thead>
    								<tbody>
    									<c:forEach var="DonHang" items="${ListDonHang}">
    									<tr>
    										<td id="MaDonHang">${DonHang.getMaDH()}</td>
    										<td>${DonHang.getNgayDat()}</td>
    										<c:set  var="check" scope="session" value="${DonHang.getTinhTrangGiaoHang()}"/>
    										<td><a href="#" class="btnXoaDonHang"><i class="fas fa-trash-alt fa-2x btn"></i></a></td>
    										<td><a href="#" class="ChiTietDonHang">Chi Tiết</a></td>
    									</tr>
    									</c:forEach>
    								</tbody>
    							</table>
    							
    							<div  class="row">
								<div  class="col-12 col-sm-2 col-md-4"></div>
								<ul class="pagination col-12 col-sm-2 col-md-4">
									<c:forEach var="index" begin="1" end="${TongPage}">
									 <li style="margin-left: 10px; width: 10px;" class="paging-item"><a href="#">${index}</a></li>
									</c:forEach>
								</ul>
								<div  class="col-12 col-sm-2 col-md-4"></div>
								</div>
							</div>
							</div>
							
						</div>
    				<div class="col-12 col-sm-4 col-md-4" >
    					<div id="ChiTietDonHang" style="display: none">
    						<h4>Chi Tiết Đơn Hàng.</h4>
    							<table class="table" id="ChiTietDonHangTable">
    								<thead>
    										<th scope="col">Tên Sách</th>
    										<th scope="col">Số Lượng</th>
    										<th scope="col">Gía Bán</th>
    								</thead>
    								<tbody>
    									<c:forEach var="DonHang" items="${DonHangChiTiet}">
    									<tr>
    										<td>${DonHang.getsAchdOnhAng().getTenSach()}</td>
    										<td >${DonHang.getSoLuong()}</td>
    										<td>${DonHang.getDonGia()}</td>
    									</tr>
    									</c:forEach>
    									<tr>
    										<td ><span>Tổng Tiền</span></td>
    										<td ><span  class="ThanhTien">${ThanhTien}</span></td>
    										<td ><span>.VNĐ</span></td>
    									</tr>
    								</tbody>
    							</table>
						</div>
    				</div>
    		</div>
    </div>
	</div>
    <div id="footer" class="container-fluid">
      <div class="row">
          <div class="col-12 col-sm-4 col-md-4">
              <p><span class="title-footer">THÔNG TIN SHOP</span></p>
              <p>Book Store là một cửa hàng startup của những bạn.....</p>
          </div>
          <div class="col-12 col-sm-4 col-md-4">
              <p><span  class="title-footer">LIÊN HỆ</span></p>
              <p>Email: bookstoredanang@gmail.com</p>
              <p>Số Điện Thoại: 0947414027.</p>
          </div>
          <div class="col-12 col-sm-4 col-md-4">
              <p><span  class="title-footer">GÓP Ý</span></p>
              <input id="txtEmail"type="text" placeholder="Email."/>
              <textarea id="content" placeholder="Nội dung góp ý"></textarea>
              <input id="send-mail"type="button" style="width: 100%; background-color: cadetblue; border: none" value="Gửi">
          </div>
      </div>
    </div>
 	<script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>" ></script>
	<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"/>" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"/>" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/js/custom.js"/>"></script>
</body>
</html>