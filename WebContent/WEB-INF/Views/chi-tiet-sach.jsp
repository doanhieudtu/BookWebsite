<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chi Tiết Sản Phẩm </title>
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
								  <c:forEach var="Item" items="${ChuDe}">
									  <a class="dropdown-item" href="/san-pham/chu-de?MaCD=${Item.getMaCD()}">${Item.getTenCD()}</a>
								  </c:forEach>
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
                           			 	<a class="dropdown-item" href="/khach-hang/ho-so">Hồ Sơ Cá Nhân</a>
                            			<a class="dropdown-item" href="/khach-hang/dang-xuat">Đăng Xuất</a>
                          			</div>
                          		</c:when>
                          		<c:when test="${user=='chuadangnhap'}">
                          			<div  id="DangNhap"><a class="nav-link" href="/khach-hang/dang-nhap">Đăng Nhập</a></div>
                          		</c:when>
                          	</c:choose>
                      		</div>
                        </li>
                      </ul>
                       <c:set var="sizeGioHang" scope="session" value="${GioHang.getTongSoLuong()}"/>
                       <c:choose>
                       		<c:when test="${sizeGioHang==0}">
                       			<span style="color: silver">( 0 sản phẩm)</span>
                       		</c:when>
                       		<c:when  test="${sizeGioHang>0}">
                       			 <span style="color: silver">(
                       		 	<span id="SoLuong" style="color: silver">${GioHang.getTongSoLuong()}</span> sản phẩm)
                       </span>
                       		</c:when>
                       </c:choose>
                      	<a  href="/GioHang/"><i class="fas fa-cart-arrow-down fa-2x gioHang"></i></a>
                    </div>
                  </nav>
    </div>
    <div id="noi-dung-chi-tiet">
    	<div class="row">
    		<div class="col-12 col-sm-3 col-md-3">
    			<h3>Danh Mục Chủ Đề</h3>
    			<ul>
    				<c:forEach var="chuDe" items="${ChuDe}">
    					<li><a href="/san-pham/chu-de?MaCD=${chuDe.getMaCD()}">${chuDe.getTenCD()}</a></li>
    				</c:forEach>
    			</ul>
    		</div>
    		<div id="Sach" class="col-12 col-sm-6 col-md-9">
    			<div class="row">
    				<div class="col-12 col-sm-4 col-md-4">
    					<img src="/resources/image/${Sach.getAnhBia()}" alt="anh-ve-sach"><br/>
    				</div>
    				<div class="col-12 col-sm-8 col-md-8">
    					<h2>Tên Sách: ${Sach.getTenSach()}</h2>
    					<div id="MaSach" style="display: none">${Sach.getMaSach()}</div>
    					<table class="table " id="infor-sach">
  							<tbody>
    							<tr>
      								<th scope="row" >Tác Giả:</th>
									<td>
      									<c:forEach var="tacGia" items="${TacGiaChiTiet}">
      										<span>${tacGia.getTenTG()}</span>
      									</c:forEach>
      								</td>
    							</tr>
    							<tr>
      								<th scope="row">Giá Bán:</th>
      								<td><span  class="GiaBan">${Sach.getGiaBan()}</span><span> VNĐ</span></td>
    							</tr>
   								<tr>
      								<th scope="row" >Số Lượng</th>
      								<c:set var="soluong" scope="session" value="${Sach.getSoLuongTon()}"/>
      								<c:choose>
      									<c:when test="${soluong>0}">
      										<td>${Sach.getSoLuongTon()}</td>
      									</c:when >
      									<c:when test="${soluong==0}">
      										<td><span>hết hàng.</span></td>
      									</c:when>
      								</c:choose>
      								
    							</tr>
    							<tr>
      								<th scope="row">Nhà Xuất Bản:</th>
      								<td>${NhaXuatBan}</td>
    							</tr>
    							
    							<tr>
      								<th scope="row">Mô Tả:</th>
      								<td><span>${Sach.getMoTa()}.</span></td>
    							</tr>
    							<tr>
      								<th scope="row">Thêm Vào Giỏ Hàng</th>
      								<td>
      								 <i class=" btn fas fa-cart-arrow-down fa-3x" id="addCart"></i></td>
									<th  scope="row"><span id="themGioHang" style="display: none">Đã thêm vào giỏ hàng</span></th>
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