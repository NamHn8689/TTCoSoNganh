# TTCoNganh
Tổ chức chương trình:
- Lớp Xe:
	+ Thuộc tính: nhãn hiệu, màu săc, biển số xe;
- Lớp XeVao kế thừa từ lớp Xe:
	+ Thuộc tính:
	    Thêm: id, thời gian gửi, ngày gửi.
	+ Phương thức: Constructor, Getter&Setter , toString , toString2
- Lớp XeVaoRa kế thừa XeVao:
	+ Thuộc tính:
	    Thêm: thời gian lấy,ngày lấy, số tiền phải trả
	+ Phương thức: Constructor, Getter&Setter , toString , toString2
- Main:
    ----------------Menu-----------------
    + Thêm xe vào BAIDOXE
        + Tạo 1 Xe rồi ghi vào file BAIDOXE.DAT
    + Hiển thị tất cả Xe trong BAIDOXE
    + Hiển thị hóa đơn:Thông tin về xe ra
        + Biển số, màu sắc, nhãn hiệu
        + Ngày giờ gửi xe
        + Ngày giờ lấy xe 
        + Số tiền phải thanh toán(được tính theo số giờ đã gửi)
    + Làm việc với file THONGKE
        + Hiển thị tất cả file THONGKE.DAT
        + Hiển thị tổng số tiền đã thu từ trước đế nay
        + Hiển thị số xe đã gửi và thanh toán xong từ trước đế nay
        + Hiển thị tất cả thông tin về xe ra vào trong ngày yyyy-MM-dd
        + Hiển thị số xe đã gửi và thanh toán trong ngày yyyy-MM-dd
        + Tổng số tiền đã thu trong ngày yyyy-mm-dd
        + Trở lại 
    + Thoát
- Hạn chế:
    + Còn nhiều Exception chưa fix