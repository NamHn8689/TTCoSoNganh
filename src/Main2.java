//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        WorkWithFile f = new WorkWithFile();
//        Scanner scanner = new Scanner(System.in);
//        int op;
//        String Edit;
//        do {
//            System.out.println("----------------------------------------MENU----------------------------------------");
//            System.out.println("1. Thêm điên thoại vào kho");
//            System.out.println("2. Hiển thị tất cả điện thoại trong kho");
//            System.out.println("3. Sửa điện thoại trong kho");
//            System.out.println("4. Nhặt điên thoại vào giỏ");
//            System.out.println("5. Hiển thị toàn bộ giỏ hàng");
//            System.out.println("6. Tạo thông tin khách hàng");
//            System.out.println("7. Sửa thông tin khách hàng");
//            System.out.println("8. Hiển thị thông tin khách hàng");
//            System.out.println("9. Tạo hóa đơn hóa đơn");//xuất hóa đơn + ghi hóa đơn vào folder
//            System.out.println("0. Thoát");
//
//            System.out.print("Lựa chọn của bạn: ");
//            op = scanner.nextInt();
//
//            switch (op) {
//                case 0:
//                    System.out.println("Hẹn gặp lại!");
//                    break;
//                case 1:
//                    String id, ten, nhanHieu;
//                    int gia, soLuong;
//                    scanner.nextLine();
//                    System.out.print("Nhập mã điên thoại: ");
//                    id = scanner.nextLine();
//                    System.out.print("Nhập tên điện thoại: ");
//                    ten = scanner.nextLine();
//                    String[] brand = {"Apple", "SAMSUNG", "HUAWEI", "NOKIA", "XIAOMI", "OPPO", "VSMART", "BPHONE", "VIVO", "LG", "ZTE", "Lựa chọn khác ..."};
//                    int op1;//bắt lựa chọn nhãn hiệu
//                    System.out.println("Chọn nhãn hiệu: ");
//                    do {
//                        System.out.println("1. Apple");
//                        System.out.println("2. SAMSUNG");
//                        System.out.println("3. HUAWEI");
//                        System.out.println("4. NOKIA");
//                        System.out.println("5. XIAOMI");
//                        System.out.println("6. OPPO");
//                        System.out.println("7. VSMART");
//                        System.out.println("8. BPHONE");
//                        System.out.println("9. VIVO");
//                        System.out.println("10. LG");
//                        System.out.println("11. ZTE");
//                        System.out.println("12. Lựa chọn khác ...");
//
//                        System.out.print("\nLựa chọn của ban: ");
//                        op1 = Integer.parseInt(scanner.nextLine());
//                    } while (op1 <= 0 || op1 > 12);
//                    if (op1 == 12) {
//                        System.out.print("Nhập nhãn hiệu: ");
//                        nhanHieu = scanner.nextLine();
//                    } else
//                        nhanHieu = brand[op1 - 1];
//
//                    System.out.print("Nhập giá: ");
//                    gia = scanner.nextInt();
//                    System.out.print("Nhập số lượng: ");
//                    soLuong = scanner.nextInt();
//                    DienThoaiTrongKho A = new DienThoaiTrongKho(id, ten, nhanHieu, gia, soLuong);
//
//                    //ghi điện thoại A vào file KHO
//                    f.WriteToKHO(A);
//                    break;
//                case 2:
//                    System.out.println("\nKho:\n");
//                    f.ShowAllDTTK();
//                    System.out.println("                                                                                   Xuất thành công\n");
//                    break;
//                case 3:
//                    scanner.nextLine();
//                    ArrayList<DienThoaiTrongKho> KHO = f.ReadDTTKFromFile("KHO.dat");
//
//                    int indexOfPhoneEdit = -1;
//                    do {
//                        System.out.println("Kho:");
//                        f.ShowAllDTTK();
//                        System.out.print("Id điện thoại cần sửa: ");
//                        Edit = scanner.nextLine();
//                        for (int i = 0; i < KHO.size(); i++)
//                            if (KHO.get(i).getId().equals(Edit)) {
//                                indexOfPhoneEdit = i;
//                                break;
//                            }//có time sẽ viết lại thành binary search
//
//                        if (indexOfPhoneEdit == -1) {
//                            System.out.println("Không tìm thấy id này");
//                            System.out.println("Hãy nhập lại!");
//                        }
//                    } while (indexOfPhoneEdit == -1);
//
//                    int op3;
//                    do {
//                        System.out.println("0. Trở lại");
//                        System.out.println("1. Sửa id");
//                        System.out.println("2. Sửa tên");
//                        System.out.println("3. Sửa nhãn hiệu");
//                        System.out.println("4. Sửa giá");
//                        System.out.println("5. Sửa số lương");
//
//                        System.out.print("\nLựa chọn của ban: ");
//                        op3 = Integer.parseInt(scanner.nextLine());
//                    } while (op3 < 0 || op3 > 5);
//                    switch (op3) {
//                        case 1:
//                            System.out.print("Id sẽ sửa thành: ");
//                            Edit = scanner.nextLine();
//                            KHO.get(indexOfPhoneEdit).setId(Edit);
//                            break;
//                        case 2:
//                            System.out.print("Tên sẽ sửa thành: ");
//                            Edit = scanner.nextLine();
//                            KHO.get(indexOfPhoneEdit).setTen(Edit);
//                            break;
//                        case 3:
//                            System.out.print("Nhãn hiệu sẽ sửa thành: ");
//                            Edit = scanner.nextLine();
//                            KHO.get(indexOfPhoneEdit).setNhanHieu(Edit);
//                            break;
//                        case 4:
//                            System.out.print("Giá sẽ sửa thành: ");
//                            Edit = scanner.nextLine();
//                            KHO.get(indexOfPhoneEdit).setGia(Integer.parseInt(Edit));
//                            break;
//                        case 5:
//                            System.out.print("Số lượng sẽ sửa thành: ");
//                            Edit = scanner.nextLine();
//                            KHO.get(indexOfPhoneEdit).setSoLuongTrongKho(Integer.parseInt(Edit));
//                            break;
//                        default:
//                            break;
//                    }
////                    for(int i=0;i<KHO.size()-1;i++){
////                        for (int j=i+1;j<KHO.size();j++){
////                            if(KHO.get(i).getNhanHieu().equals(KHO.get(j).getNhanHieu())) {
////                                DienThoaiTrongKho a = KHO.get(i);
////                                KHO. = KHO.get(j);
////                                KHO.get(j) = a;
////                            }
////                        }
////                    }
//                    f.UpdateFileKHO(KHO, "KHO.dat");
//                    break;
//                case 4:
//                    //Sửa file GIOHANG.dat
//                    scanner.nextLine();
//                    System.out.println("Kho:");
//                    f.ShowAllDTTK();
//
//                    KHO = f.ReadDTTKFromFile("KHO.dat");
//                    ArrayList<DienThoaiMua> GIO = f.ReadDTMFromFile("GIOHANG.dat");
//                    System.out.print("Nhập id điện thoại cần thêm: ");
//                    String idAdd = scanner.nextLine();
//                    int indexOfIdAdd = -1;
//                    for (int i = 0; i < KHO.size(); i++)
//                        if (KHO.get(i).getId().equals(idAdd)) {
//                            indexOfIdAdd = i;
//                            break;
//                        }
//                    if (indexOfIdAdd == -1) {
//                        System.out.println("Not found");
//                        break;
//                    }
//                    System.out.print("Nhập số lượng: ");
//                    Edit = scanner.nextLine();
//                    int thanhTien = KHO.get(indexOfIdAdd).getGia() * Integer.parseInt(Edit);
//                    DienThoaiMua AA = new DienThoaiMua(KHO.get(indexOfIdAdd).getId(), KHO.get(indexOfIdAdd).getTen(),
//                            KHO.get(indexOfIdAdd).getNhanHieu(), KHO.get(indexOfIdAdd).getGia(), Integer.parseInt(Edit), thanhTien);
//                    GIO.add(AA);
//                    f.UpdateFileGIOHANG(GIO, "GIOHANG.dat");//ghi 1 list vào file
//                    break;
//                case 5:
//                    f.ShowAllDTM();
//                    break;
//                case 6:
//                    String tenKh, sdt, diaChi;
//                    scanner.nextLine();
//                    System.out.print("\nNhap ten: ");
//                    tenKh = scanner.nextLine();
//                    System.out.print("Nhap SDT: ");
//                    sdt = scanner.nextLine();
//                    System.out.print("Nhap dia chi: ");
//                    diaChi = scanner.nextLine();
//                    KhachHang khachHang = new KhachHang(tenKh, sdt, diaChi);
//                    f.WriteToKHACH(khachHang, "KHACH.DAT");
//                    break;
//                case 7:
//                    khachHang = f.ReadFileKHACH();
//                    if (khachHang.getTenKhachHang() == "") {
//                        System.out.println("Chưa nhập khách hàng");
//                        break;
//                    }
//                    int op7;
//                    do {
//                        System.out.println("0. Trở lại");
//                        System.out.println("1. Sửa tên");
//                        System.out.println("2. Sửa số điện thoại");
//                        System.out.println("3. Sửa địa chỉ");
//                        System.out.print("\nLựa chọn của bạn: ");
//                        op7 = Integer.parseInt(scanner.nextLine());
//                    } while (op7 < 0 || op7 > 3);
//                    switch (op7) {
//                        case 1:
//                            System.out.print("Tên sẽ sửa thành: ");
//                            Edit = scanner.nextLine();
//                            khachHang.setTenKhachHang(Edit);
//                            break;
//                        case 2:
//                            System.out.print("Số điện thoại sẽ sửa thành: ");
//                            Edit = scanner.nextLine();
//                            khachHang.setSdt(Edit);
//                            break;
//                        case 3:
//                            System.out.print("Địa chỉ sẽ sửa thành: ");
//                            Edit = scanner.nextLine();
//                            khachHang.setDiaChi(Edit);
//                            break;
//                    }
//                    f.WriteToKHACH(khachHang, "KHACH.DAT");
//                    break;
//                case 8:
//                    khachHang = f.ReadFileKHACH();
//                    System.out.println(khachHang.toString());
//                    break;
//                case 9:
//                    f.CreateThenShowHoaDon();
//                    break;
//                default:
//                    System.out.println("\nBạn đã chọn sai");
//                    System.out.println("Vui lòng chọn lại.\n");
//            }
//        }
//        while (op != 0);
//    }
//}
//
