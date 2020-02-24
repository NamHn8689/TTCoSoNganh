import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String baiDoXe = "BAIDOXE.DAT";
        long soTien1H = 5000;
        Work f = new Work();
        Scanner scanner = new Scanner(System.in);
        int op;
        String Edit;
        do {
            System.out.println("----------------------------------------MENU----------------------------------------");
            System.out.println("1. Nhập thông tin xe vào");
            System.out.println("2. Hiển thị tất cả xe trong bãi đỗ xe");
            System.out.println("3. Tạo hóa đơn khi có xe ra");
            System.out.println("4. Làm việc với file THONGKE");
//            System.out.println("3. Sửa điện thoại trong kho");
//            System.out.println("5. Hiển thị toàn bộ giỏ hàng");
//            System.out.println("6. Tạo thông tin khách hàng");
//            System.out.println("7. Sửa thông tin khách hàng");
//            System.out.println("8. Hiển thị thông tin khách hàng");
            //xuất hóa đơn gồm id, các thông tin liên quan đến xe,
            // ngày giờ lấy xe số tiền phải trả
            // xóa khỏi thong tin về xe ra trong bãi đỗi xe
            // đồng thời ghi dữ liệu về xe ra vào file THONGKE.DAT để truy suất(đếm số xe đã
            //gửi trong ngày hôm nay, số tiền đã thu được trong ngày hôm nay
            System.out.println("0. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            op = scanner.nextInt();

            switch (op) {
                case 0:
                    System.out.println("Hẹn gặp lại!");
                    break;
                case 1:
                    String nhanHieu, mauSac, bienSoXe;
                    scanner.nextLine();
                    System.out.print("Nhập nhãn hiệu xe: ");
                    nhanHieu = scanner.nextLine();
                    System.out.print("Nhập màu sắc xe: ");
                    mauSac = scanner.nextLine();
                    System.out.print("Nhập biển số xe: ");
                    bienSoXe = scanner.nextLine();
                    String time = String.valueOf(java.time.LocalTime.now());//lấy h:m:s(UTC)
                    String ymd = String.valueOf(java.time.LocalDate.now());//lấy y-m-d
                    //tạo id (ymdhms+bienSoXe)
                    String[] arrText = ymd.split("-");
                    String id = arrText[2] + arrText[1] + arrText[0];
                    arrText = time.split(":");
                    id += arrText[0] + arrText[1] + arrText[2];

                    XeVao A = new XeVao(id, nhanHieu, mauSac, bienSoXe, time, ymd);
                    //ghi xe A vào file BAIDOXE.DAT
                    f.GhiVaoBAIDOXE(A, baiDoXe);
                    break;
                case 2:
                    System.out.println("\nBãi đỗ xe:\n");
                    f.XuatTatCaBAIDOXE();
                    System.out.println("                                                                                   Xuất thành công\n");
                    break;
                case 3:
                    f.CreateAndShowHoaDon(soTien1H);
                    break;
                case 4:
                    int op4;
                    do {
                        do {
                            System.out.println("0. Trở lại");
                            System.out.println("1. Hiển thị tất cả file THONGKE");
                            System.out.println("2. Hiển thị tổng số tiền đã thu từ trước đế nay");
                            System.out.println("3. Hiển thị số xe đã gửi và thanh toán xong từ trước đế nay");
                            System.out.println("4. Hiển thị tất cả thông tin về xe ra vào trong ngày yyyy-MM-dd");
                            System.out.println("5. Hiển thị số xe đã gửi và thanh toán trong ngày yyyy-MM-dd");
                            System.out.println("6. Tổng số tiền đã thu trong ngày yyyy-mm-dd");
                            //case 6 tong so tien da thu tu ngày x đến nay
                            System.out.print("\nLựa chọn của ban: ");
                            op4 = Integer.parseInt(scanner.nextLine());
                        } while (op4 < 0 || op4 > 4);
                        switch (op4) {
                            case 1:
                                f.XuatTatCaTHONGKE();
                                System.out.println("XUẤT FILE THONGKE.DAT THÀNH CÔNG");
                                break;
                            case 2:
                                f.XuatToanBoTienTuTHONGKE();
                                break;
                            case 3:
                                f.XuatDemTHONGKE();
                                break;
                            case 4:
                                scanner.nextLine();
                                String dd, mm, yyyy;
                                do {
                                    System.out.println("Vui lòng nhập ngày tháng năm");
                                    System.out.print("Ngày(dd): ");
                                    dd = scanner.nextLine();
                                    System.out.print("Tháng(mm): ");
                                    mm = scanner.nextLine();
                                    System.out.print("Năm(yyyy): ");
                                    yyyy = scanner.nextLine();
                                } while (dd.length() > 2 || dd.length() == 0 || mm.length() > 2
                                        || mm.length() == 0 || yyyy.length() > 4 || yyyy.length() == 0);
                                
                                break;
                            case 5:
                                System.out.print("Số lượng sẽ sửa thành: ");
                                Edit = scanner.nextLine();
                                KHO.get(indexOfPhoneEdit).setSoLuongTrongKho(Integer.parseInt(Edit));
                                break;
                            default:
                                break;
                        }
                        while (op4 != 0) ;
                    }
                default:
                    System.out.println("\nBạn đã chọn sai");
                    System.out.println("Vui lòng chọn lại.\n");
            }
        }
        while (op != 0);
    }
}

