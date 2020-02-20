# BTL_Java_Hit_2019
Chương trình đơn giản việc bán điện thoại

Tổ chức chương trình:
- Lớp DienThoai:
	+Thuộc tính: mã, tên, nhãn hiệu, giá
- Lớp DienThoaiTrongKho kế thừa DienThoai:
	+ Thuộc tính:
	    Thêm: số lượng trong kho
	+ Phương thức: Constructor, Getter&Setter , toString , toString2
- Lớp DienThoaiMua kế thừa DienThoai:
	+ Thuộc tính:
	    Thêm: số lượng mua, thành tiền
	+ Phương thức: Constructor, Getter&Setter , toString , toString2
- Lớp KhachHang:
	+ Thuộc tính: Tên, SĐT , Địa chỉ
	+ Phương thức: Constructor, Getter&Setter

Cơ sở dữ liệu: KHO.dat
- Main:
    ----------------Menu-----------------
    + Thêm điên thoại vào kho
        + Tạo 1 DienThoaiTrongKho rồi ghi vào file KHO.dat
    + Hiển thị tất cả điện thoại trong kho
    + Sửa điện thoại trong kho
    + Nhặt điên thoại vào giỏ
        + Tạo 1 DienThoaiMua rồi ghi vào file GIO.dat
    + Hiển thị toàn bộ giỏ hàng
    + Tạo thông tin khách hàng
        + Tạo 1 DienThoaiTrongKho rồi ghi vào file KHO.dat
    + Sửa thông tin khách hàng
    + Hiển thị thông tin khách hàng
    + Tạo rồi xuất hóa đơn hóa đơn
        + Hiển thị hóa đơn: Ngày, giờ, thông tin khách hàng, giỏ hàng, tổng số tiền phải thanh toán
        + Tạo ra 1 file với tên [dmyhms].dat
        + Xóa file GIOHANG.dat và KHACH.DAT ////////// chưa viết
        + Giảm số lượng của DienThoaiTrongKho ////////chưa viết
    + Exit
        + Say good bye
        + Xóa file KHACH.DAT VÀ GIO.dat //chưa được

- Hạn chế:
    + Chưa sửa được Giỏ hàng mà mình đã chọn
    + Chỉ có thể thêm điện thoại vào giỏ bằng Id
        + Sẽ update ở các version sau !
    + Chưa có method hay function nào kiểm soát(đọc lại, đếm, ...) số hóa đơn đã tạo ra
    + Các function, các method viết chưa được trừu tượng hóa
- Tài liệu tham khảo:
    + Github: Bùi Tất Trung(tattrung15)
    + Youtube: 2 bài đọc ghi file trên kênh của Thân Triệu
    + Bên cạnh có còn có tài liệu tràn lan trên Google, Stack Overflow, ...

- Nhóm thực hiện:
    + PNam(NamKeKe)
    + PNam(tieulac305)