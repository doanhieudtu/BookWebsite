<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html ">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Đăng Nhập</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/Style.css"/>"  rel="stylesheet" >
<link rel="stylesheet" href="<c:url value="/resources/css/fontawesome-free-5.0.9/web-fonts-with-css/css/fontawesome-all.css"/>">
</head>
<body id="body-login">
<div id="body-flex-login">
<div id="container-login">
<div id="container-login-left">
<div class="header-login">
<span id="text-logo">Wellcome</span><br/>
<span id="text-hueristed">Mỗi cuốn sách là một bức tranh kì diệu về cuộc sống.</span>
</div>
<div  class="footer-login">
<p><i class="far fa-hand-point-right" style="color: lightcoral"></i><span>Luôn cập nhật sách mới.</span></p>
<p><i class="far fa-hand-point-right" style="color: lightcoral"></i><span>Giảm hơn 30% tất cả các sản phẩm cho các đọc giả vip.</span></p>
</div>
</div>
<div id="container-login-right">
<div id="header-top-right" class="header-right">
<span class="active" id="login">Đăng Nhập ADMIN</span>
</div>
<div id="container-center-login-right">
<form>
<div class="background-icon-email">
<i class="far fa-envelope fa-2x"></i>
</div>
<input  type="text" class="email" name="email" placeholder="Email."><br/>
<div class="background-icon-lock" >
<i class="fas fa-lock fa-2x"></i>
</div>
<input  type="password" class="matkhau" name="matkhau" placeholder="Password."/><br/>
</form>
<div id="btton-dang-nhap-admin" >Đăng Nhập</div></br>
<span  id="thong-bao-dang-nhap-admin"></span><br/>

<div id="icon-social-login">
<i class="fab fa-facebook-square fa-5x" ></i>
</div>
</div>
</div>
</div>
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>" ></script>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"/>" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"/>" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/custom.js"/>"></script>
</body>
</html>