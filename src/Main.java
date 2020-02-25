import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String baiDoXe = "BAIDOXE.DAT";
        int soTien1H = 5000;
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
                    String time3 = String.valueOf(java.time.LocalTime.now());//lấy h:m:s(UTC)
                    String ymd3 = String.valueOf(java.time.LocalDate.now());//lấy y-m-d

                    scanner = new Scanner(System.in);
                    f.XuatTatCaBAIDOXE();


                    ArrayList<XeVao> xeVaos = f.DocXeVaoTuFile("BAIDOXE.DAT");
                    XeVao xeRa = new XeVao();

                    if (xeVaos.size() == 0) {
                        System.out.println("Không có xe nào trong bãi đỗ");

                    } else {
                        System.out.print("\nNhập biển số ra: ");
                        String bienSoRa = scanner.nextLine();
                        for (int i = 0; i < xeVaos.size(); i++)
                            if (bienSoRa.equals(xeVaos.get(i).getBienSoXe())) {
                                xeRa = xeVaos.get(i);
                                xeVaos.remove(i);//xóa xe này khỏi list
                                break;
                            }
                        if (xeRa.getId() == null)
                            System.out.println("Không thể tìm thấy xe này");
                    }
                    if (xeRa.getId() != null) {
                        double soHGuiXe = f.timeDiff(xeRa.getNgayGui(), xeRa.getThoiGianGui(), ymd3, time3);
                        double soTienPhaiTra = soHGuiXe * soTien1H;

                        //hiển thị hóa đơn lên màn hình
                        System.out.println("--------------------Hóa đơn--------------------");
                        System.out.println("Mã phiếu: " + xeRa.getId());
                        System.out.println("Biển số xe: " + xeRa.getBienSoXe());
                        System.out.println("Nhãn hiệu: " + xeRa.getNhanHieu());
                        System.out.println("Màu sắc: " + xeRa.getMauSac());
                        System.out.println("Gửi lúc: " + xeRa.getThoiGianGui() + "(UTC) ngày:" + xeRa.getNgayGui());
                        System.out.println("Lấy lúc: " + time3 + "(UTC) ngày:" + ymd3);
                        System.out.println("Số tiền phải trả: " + (int) soTienPhaiTra);
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("------------------------------------------------------------------------------------");
                        XeVaoRa A3 = new XeVaoRa(xeRa.getId(), xeRa.getNhanHieu(), xeRa.getMauSac(), xeRa.getBienSoXe(),
                                xeRa.getThoiGianGui(), xeRa.getNgayGui(), time3, ymd3, (int) soTienPhaiTra);
                        f.GhiVaoTHONGKE(A3, "THONGKE.DAT");
                        if (xeVaos.size() == 0) {
                            f.DeleteFile("BAIDOXE.DAT");
                            break;
                        } else
                            f.CapNhatFileBAIDOXE(xeVaos, "BAIDOXE.DAT");//GHI LẠI LIST XE VÀO BÃI ĐỖ
                    }
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
                            //case 7 tong so tien da thu tu ngày x đến nay
                            System.out.print("\nLựa chọn của ban: ");
                            op4 = scanner.nextInt();
                        } while (op4 < 0 || op4 > 6);
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
                                scanner = new Scanner(System.in);
                                String d4, m4, y4;
                                do {
                                    System.out.println("Vui lòng nhập ngày tháng năm");
                                    System.out.print("Ngày(dd): ");
                                    d4 = scanner.nextLine();
                                    System.out.print("Tháng(mm): ");
                                    m4 = scanner.nextLine();
                                    System.out.print("Năm(yyyy): ");
                                    y4 = scanner.nextLine();
                                } while (d4.length() != 2 || m4.length() != 2 || y4.length() != 4);
                                String t4 = y4 + '-' + m4 + '-' + d4;

                                f.XuatToanBoXeTheoNgay(t4);
                                break;
                            case 5:
                                scanner = new Scanner(System.in);
                                String d5, m5, y5;
                                do {
                                    System.out.println("Vui lòng nhập ngày tháng năm");
                                    System.out.print("Ngày(dd): ");
                                    d5 = scanner.nextLine();
                                    System.out.print("Tháng(mm): ");
                                    m5 = scanner.nextLine();
                                    System.out.print("Năm(yyyy): ");
                                    y5 = scanner.nextLine();
                                } while (d5.length() != 2 || m5.length() != 2 || y5.length() != 4);
                                String t5 = y5 + '-' + m5 + '-' + d5;
                                f.XuatSoXeDaVaoRaNgayX(t5);
                                break;
                            case 6:
                                scanner = new Scanner(System.in);
                                String d6, m6, y6;
                                do {
                                    System.out.println("Vui lòng nhập ngày tháng năm");
                                    System.out.print("Ngày(dd): ");
                                    d6 = scanner.nextLine();
                                    System.out.print("Tháng(mm): ");
                                    m6 = scanner.nextLine();
                                    System.out.print("Năm(yyyy): ");
                                    y6 = scanner.nextLine();
                                } while (d6.length() != 2 || m6.length() != 2 || y6.length() != 4);
                                String t6 = y6 + '-' + m6 + '-' + d6;
                                f.XuatSoTienNgayX(t6);
                        }
                    } while (op4 != 0);
                default:
                    System.out.println("\nBạn đã chọn sai");
                    System.out.println("Vui lòng chọn lại.\n");
            }
        }
        while (op != 0);
    }
}

