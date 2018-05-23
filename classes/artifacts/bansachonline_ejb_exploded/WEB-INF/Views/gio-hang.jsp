<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Giỏ Hàng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link href="<c:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css"/>"  rel="stylesheet" >
     <link href="<c:url value="/resources/css/animate.css"/>"  rel="stylesheet" >
     <link href="<c:url value="/resources/css/Style.css"/>"  rel="stylesheet" >
  	<link rel="stylesheet" href="<c:url value="/resources/css/fontawesome-free-5.0.9/web-fonts-with-css/css/fontawesome-all.css"/>"> 
</head>
<body>
    <div id="header-menu" class="container-fluid "  >
            <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-all">
                    <a class="navbar-brand wow pulse"  data-wow-duration="5s" href="/bansachonline/cdio/trangchu">  <img src="/bansachonline/resources/image/logo.jpg"/></a>
                    <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                  
                    <div class="collapse navbar-collapse navbar-home-lik-vv" id="navbarSupportedContent">
                      <ul class="navbar-nav mr-auto narbar-menu">
                        <li class="nav-item active">
                          <a class="nav-link " href="/bansachonline/cdio/trangchu">Trang Chủ<span class="sr-only">(current)</span></a>
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
                      		<c:set var="user" scope="session" value="${User.getEmail()}"/>
                      		<c:choose>
                      			<c:when  test="${user!='chuadangnhap'}">
                      				<div id="HoSoKhachHang" >
                      				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           				 ${User.getEmail()}
                          			</a>
                          			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
                           			 	<a class="dropdown-item" href="#">Hồ Sơ Cá Nhân</a>
                            			<a class="dropdown-item" href="#">Lịch Sử Đặt Hàng</a>
                            			<a class="dropdown-item" href="/bansachonline/khach-hang/dang-xuat">Đăng Xuất</a>
                          			</div>
                          		</c:when>
                          		<c:when test="${user=='chuadangnhap'}">
                          			<div  id="DangNhap"><a class="nav-link" href="/bansachonline/khach-hang/dang-nhap">Đăng Nhập</a></div>
                          		</c:when>
                          	</c:choose>
                      		</div>
                        </li>
                      </ul>
                   
                    </div>
                  </nav>
    </div>
    <div id="noi-dung-chi-tiet">
    	<div class="row">
    		<div id="Sach" class="col-12 col-sm-6 col-md-12">
    			<div class="row">
    				<div class="col-12 col-sm-8 col-md-8">
    				
    					<h4>Chi Tiết Giỏ Hàng: </h4>
    					<table class="table " id="infor-sach">
  							 <thead>
    							<tr>
    								<th scope="col"></th>
      								<th scope="col">Tên Sách</th>
      								<th scope="col">Giá Bán</th>
      								<th scope="col">Số Lượng</th>
      								<th scope="col"> </th>
    							</tr>
  							</thead>
  							
  							<tbody>
  								<c:forEach var="Item" items="${GioHang.getDanhSachSP()}">
  								<tr>
  									<td  class="product-giohang"><a href="/bansachonline/Chi-Tiet-San-Pham/Sach?MaSach=${Item.getMaSanPham()}"><img src="/bansachonline/resources/image/${Item.getAnhBia()}" alt="anh-ve-sach"></a></td>
      								<td ><span class="tensach">${Item.getTenSanPham()}</span></td>
      								<td class="Giaban">${Item.getGiaBan()}</td>
      								<td><input  class="soluong" type="number" min="1" max="${Item.getMaxsize()}" DefaultValue="${Item.getSoLuong()}" value="${Item.getSoLuong()}"/></td>
      								<td class="MaSach" style="display: none"><span>${Item.getMaSanPham()}</span></td>
      								<td><i class="fas fa-trash-alt fa-2x btnXoa"></i></td>
    							</tr>
  								</c:forEach>
  								<tr>
  									<td></td>
    								<td>Tổng Tiền: </td>
    								<td ><span id="TongTien" >${GioHang.getTongTien()}</span> VNĐ</td>
    								<td><a href="#"></a></td>
    								<td></td>
    							</tr>	
  							</tbody>	
    					</table>
    				</div>
    				<div class="col-12 col-sm-4 col-md-4">
    						<h4 id="checkDatHang" style="display: none;color:cadetblue;">Đặt hàng thành công !!!</h4>
    					<h4>Thông Tin Đặt Hàng.</h4>
    					<form>
  							<div class="form-group">
   								 <label for="exampleFormControlInput1">Họ tên khách hàng.</label>
    							<input type="text" class="form-control"  id="hoTen"/>
 							 </div>
 							 <div class="form-group">
    						<label for="exampleFormControlTextarea1">Số điện thoại liên hệ.</label>
    						<input type="text" class="form-control"  id="soDT">
  							</div>
  							<div class="form-group">
    						<label for="exampleFormControlTextarea1 " >Địa chỉ giao hàng.</label>
    						<input type="text" class="form-control" id="diaChi">
  							</div>
  							<div class="form-group">
    						<label for="exampleFormControlTextarea1" >Ghi Chú.</label>
    						<textarea class="form-control" id="ghiChu"></textarea>
 							</div>
 							<div class="btn" id="DatHang"><span>Đặt Hàng</span></div>
						</form>
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