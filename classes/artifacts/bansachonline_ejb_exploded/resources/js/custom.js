$(document).ready(function() {
				var TongTien=parseInt($(".GiaBan").text());
			    var fomart=TongTien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
			    var ketqua=$(".GiaBan").html(fomart);
			    
			    var TongTien=parseInt($(".ThanhTien").text());
			    var fomart=TongTien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
			    var ketqua=$(".ThanhTien").html(fomart);
			    
			 
});
			$("#singin").click(function(){
                $("#singin").addClass("active");
                $("#container-center-login-right").hide();
                $("#login").removeClass("active");
                $("#container-center-signin-right").show();
            });
            $("#login").click(function(){
                $("#login").addClass("active");
                $("#singin").removeClass("active");
                $("#container-center-signin-right").hide();
                $("#container-center-login-right").show();             
            });
            $(".btton-dang-nhap").click(function(){
            	var gmail= $(".email").val();
            	var pass= $(".matkhau").val();
            	$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/kiem-tra-dang-nhap",
            	    data: {email:gmail,matkhau:pass},
            	    success: function(data) {
            	    	alert(data);
            	    	$("#thong-bao-dang-nhap").text("");
            	    	if(data=="true"){
            	    		if($("#thong-bao-dang-nhap").text()==""||$("#thong-bao-dang-nhap").text()=="Đăng nhập thất bại.")
            	    			{
            	    			$("#thong-bao-dang-nhap").append("Đăng nhập thành công.");
            	    		
            	    			}
                		}
                		else
                			if(data=="false"){
                	    		if($("#thong-bao-dang-nhap").text()==""||$("#thong-bao-dang-nhap").text()=="Đăng nhập thành công.")
                	    			{
                	    			$("#thong-bao-dang-nhap").append("Đăng nhập thất bại.");
                	    			}
                    		}
					},
            	});
            	
            });
            $("#addCart").click(function() {
				var maSach=$("#MaSach").text();
				var soluong=parseInt($("#SoLuong").text());
				$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/them-vao-gio-hang",
            	    data: {MaSach:maSach},
            	    success: function(data) {
            	    	soluong= soluong+1;
            	    	$("#SoLuong").text(soluong);
					},
            	});
			});
            $(".tangsoluong").click(function() {
            	var masanpham= $("#Masanpham").text();
				var idsanpham= "#"+masanpham;
				
				$("#masanpham").text(soluong);
			});
            $(".giamsoluong").click(function() {
            	var masanpham= $("#Masanpham").text();
            	var soluong=parseInt($("#giatri").text());
            		soluong=soluong-1;
    				$("#giatri").text(soluong);
			});
            $(".soluong").change(function() {
				var soLuong=parseInt($(this).val());
				var giaban= parseInt($(this).closest("tr").find(".Giaban").text());
				var fomart=giaban.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
				var fomart_gia=$(this).closest("tr").find(".Giaban").html(fomart);
				var masach=parseInt($(this).closest("tr").find(".MaSach").text());

				$.ajax({
					type: 'POST',
            	    url:"/bansachonline/api/xu-ly-so-luong",
            	    data: {soluong:soLuong,MaSanPham:masach},
            	    success: function(data) {
            	    var TongTien=parseInt(data);
            	    var fomart=TongTien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
            	    var ketqua=$("#TongTien").html(""+fomart);
            	    }
				})
			});
            $(".btnXoa").click(function() {
            	var self=$(this);
            	var masach=parseInt($(this).closest("tr").find(".MaSach").text());
            	$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/xoa-san-pham",
            	    data: {MaSach:masach},
            	    success: function(data) {
            	    	self.closest("tr").remove();
            	    	var TongTien=parseInt(data);
                     	var fomart=TongTien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
                     	var ketqua=$("#TongTien").html(""+fomart);
            	    }
            	})
			});
            $("#DatHang").click(function() {
				var hoTen=$("#hoTen").val();
				var diaChi=$("#diaChi").val();
				var soDT=$("#soDT").val();
				var ghiChu=$("#ghiChu").val();
				$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/dat-hang",
            	    data:{TenKhachHang:hoTen,DiaChi:diaChi,SoDT:soDT,GhiChu:ghiChu},
            	    success: function(data) {
            	    		if(data==1)
            	    		$("#checkDatHang").show();
            	    		else
            	    			window.location.replace('/bansachonline/khach-hang/dang-nhap');
            	    }
            	})
			});
            $("#editHoSo").click(function() {
				$("#HoTen").removeAttr("readonly");
				$("#Email").removeAttr("readonly");
				$("#DiaChi").removeAttr("readonly");
				$("#SoDT").removeAttr("readonly");
				$("#MatKhau").removeAttr("readonly");
				$("#luuhoso").show();
			});
            $("#saveHoSo").click(function() {
            	$("#HoTen").attr("readonly",true);
				$("#Email").attr("readonly",true);
				$("#DiaChi").attr("readonly",true);
				$("#SoDT").attr("readonly",true);
				$("#MatKhau").attr("readonly",true);
				  var  hoTen=$("#HoTen").val();
				  var  soDT=$("#SoDT").val();
				  var	diaChi=$("#DiaChi").val();
				  var 	Email=$("#Email").val();
				  var	matKhau=$("#MatKhau").val();
				$.ajax({
					type: 'POST',
            	    url:"/bansachonline/api/chinh-sua-ho-so",
            	    data:{HoTen:hoTen,SoDT:soDT,DiaChi:diaChi,Email:Email,MatKhau:matKhau},
            	    success: function(data) {
            	    	alert("LUU THANH CONG")
            	    },
				});
            });
            $( "select" ).change(function() {
              $( "select option:selected" ).each(function() {
                 if($(this).text()=="Lịch Sử Đặt Hàng."){
                	 $("#ThongTinCaNhan").show();
                	 $("#HoSoCaNhan").hide();
                	 $("#DanhSachDonHang").show();
                	 $("#ChiTietDonHang").show();
                 }
                 else if($(this).text()=="Thông Tin Cá Nhân."){
                	 $("#ThongTinCaNhan").hide();
                	 $("#HoSoCaNhan").show();
                	 $("#DanhSachDonHang").hide();
                	 $("#ChiTietDonHang").hide();
                 }
                else if($(this).text()=="Đăng Xuất."){
                	window.location.replace('/bansachonline/khach-hang/dang-xuat');
              };
            });
            });
            $("body").on("click",".paging-item", function() {
				var sotrang=parseInt($(this).text());
				$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/lay-don-hang-theo-trang",
            	    data:{index:sotrang},
            	    success: function(data) {
            	    	var tsanpham=$("#ListDonHang").find("tbody");
            	    	tsanpham.empty();
            	    	tsanpham.append(data);
            	    	
            	    }
            	})
			});
            $(".ChiTiet").click(function() {
				var maHoaDon=parseInt($(this).closest("tr").find("#MaDonHang").text());
				alert(maHoaDon);
			})
			$("body").on("click",".paging-item-sach", function() {
				var sotrang=parseInt($(this).text());
				$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/lay-sach-theo-trang",
            	    data:{index:sotrang},
            	    success: function(data) {
            	    	var tsanpham=$("#DanhSachSanPham").find("tbody");
            	    	tsanpham.empty();
            	    	tsanpham.append(data);
            	    	},
				});
				});
            function readURL(input) {
    		    if (input.files && input.files[0]) {
    		        var reader = new FileReader();
    		        
    		        reader.onload = function (e) {
    		            $("#img-upload").attr('src', e.target.result);
    		        }
    		        
    		        reader.readAsDataURL(input.files[0]);
    		    }
    		}

            var files=[];
            var tenhinh;
            $("#HinhAnh").change(function(event) {
				files= event.target.files;
				tenhinh= files[0].name;
				alert(tenhinh);
            	forms= new FormData();
            	forms.append("files",files[0]);
            	$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/upload-file",
            	    data:forms,
            	    processData: false,
            	    contentType: false,
            	    enctype:"multipart/form-data",
            	    success: function(data) {
            	    }   	
				});
			});
            $("#btnThemSach").click(function(event) {
            	event.preventDefault();
            	var formdata = $("#FormSanPham" ).serializeArray();
            	json={};
            	$.each(formdata, function(i,field) {
					json[field.name]= field.value;
				});
            	$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/them-san-pham",
            	    data:{dataJson:JSON.stringify(json),HinhAnh:tenhinh},
            	    success: function(data) {
            	    }   	
				});
            	console.log(tenhinh);
			})
			  $("body").on("click",".XemChiTiet", function() {
				  var masach=parseInt($(this).closest("tr").find("#MaSach").text());
				$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/chi-tiet-san-pham",
            	    data:{MaSach:masach},
            	    success: function(data) {
            	    	var tsanpham=$("#ThongTinSach").find("tbody");
            	    	tsanpham.empty();
            	    	tsanpham.append(data);
            	    }
            	})
			});
            
            $("body").on("click",".btnXoaSach", function() {
            	var self=$(this);
            	var masach=parseInt($(this).closest("tr").find("#MaSach").text());
            	$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/xoa-san-pham-quan-tri",
            	    data: {MaSach:masach},
            	    success: function(data) {
            	    	self.closest("tr").remove();
            	    }
            	})
			});
            $("body").on("click",".ChiTietDonHang", function() {
            	var maCT=parseInt($(this).closest("tr").find("#MaDonHang").text());
            	$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/chi-tiet-don-hang",
            	    data: {MaChiTiet:maCT},
            	    success: function(data) {
            	    	var tsanpham=$("#ChiTietDonHangTable").find("tbody");
            	    	tsanpham.empty();
            	    	tsanpham.append(data);
            	    }
            	})
			});
            $("body").on("click",".btnXoaDonHang", function() {
            	var self=$(this);
            	var madonhang=parseInt($(this).closest("tr").find("#MaDonHang").text());
            	$.ajax({
            		type: 'POST',
            	    url:"/bansachonline/api/xoa-don-hang",
            	    data: {MaDonHang:madonhang},
            	    success: function(data) {
            	    	self.closest("tr").remove();
            	    }
            	})
			});
                   
           