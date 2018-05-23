<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html ">
<html>
<head>
<link href="<c:url value="/resources/css/Style.css"/>"  rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm Mới Sách</title>
</head>
<body>
	<div id="trangchu">
		<form:form action="bansachonline/Sach/them"  method="get" modelAttribute="Sach">
		
		<div>Tên Sách</div>
		<form:input type="text" path="TenSach"/>
		<div>Gia Bán</div>
		<form:input type="text" path="GiaBan"/>
		<div>Mô Tả </div>
		<form:input type="text" path="MoTa"/>
		<div>Anh Bìa</div>
		<form:input type="text" path="AnhBia"/>
		<div>Số Lượng Tồn</div>
		<form:input type="text" path="SoLuongTon"/>
		<div>Ngày Cập Nhật: </div>
		<form:input type="Date" path="NgayCapNhat"/>
		<div>Chủ Đề</div>
		<form:select path="MaChuDe">
		<form:option value="true" label="-----Chon Chủ Đề--------"/>
		<form:options items="${ChuDe}"/>
		</form:select>
		<div>Nhà Xuất Bản</div>
		<form:select path="MaNXB">
		<form:option value="true" label="-----Chọn Nhà Xuất Bản -----" />
		<form:options items="${NhaXuatBan}" />
		</form:select>
		<button>Them</button>
		</form:form>
	</div>
</body>
</html>