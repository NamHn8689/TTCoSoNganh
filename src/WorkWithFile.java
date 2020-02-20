import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkWithFile {
    private FileWriter fwriter;
    private BufferedWriter buffer;
    private PrintWriter prWriter;
    private Scanner scanner;

    //Open file
    public void OpenFileToWrite(String fileName) {
        try {
            fwriter = new FileWriter(fileName, true);//mở file với tên & ghi đè ko mất dữ liệu
            buffer = new BufferedWriter(fwriter);
            prWriter = new PrintWriter(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists())
                file.createNewFile();
            scanner = new Scanner(Paths.get(fileName), "UTF-8");
            //Paths.get(fileName) = đường dẫn file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //=============================
    //Close
    public void CloseFileAfterWrite() {//đóng từ ngoài vào trong
        try {
            prWriter.close();
            buffer.close();
            fwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead() {
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //===============================
    //Write
    public void WriteToBAIDOXE(XeVao A, String filename) {
        OpenFileToWrite(filename);
        prWriter.println(A.toString2());
        CloseFileAfterWrite();
    }

    //    public void WriteToGIO(DienThoaiMua A){
//        OpenFileToWrite("GIOHANG.dat");
//        prWriter.println(A.toString2());
//    }
    public void WriteToKHACH(KhachHang A, String filename) {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
        OpenFileToWrite(filename);
        prWriter.println(A.toString2());
        CloseFileAfterWrite();
    }


    /////////
    //========================================================================================
    //Create
    public DienThoaiMua CreateDTMFromFile(String data) {
        String[] s = data.split("/");
        DienThoaiMua A = new DienThoaiMua(s[0], s[1], s[2], Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]));
        return A;
    }

    public XeVao CreateXeVaoFromFile(String data) {
        String[] s = data.split("/");
        XeVao A = new XeVao(s[0], s[1], s[2], s[3], s[4], s[5]);
        return A;
    }

    public void CreateThenShowHoaDon(int soTien1H) throws FileNotFoundException {
//        String time = String.valueOf(java.time.LocalDate.now());//lấy y-m-d
//        String[] arrText = time.split("-");
//        String fileName = arrText[2] + arrText[1] + arrText[0];
//        time = String.valueOf(java.time.LocalTime.now());//lấy h:m:s(UTC)
//        arrText = time.split(":");
////        fileName += (arrText[0] + arrText[1] + arrText[2] + ".DAT");
////        File file = new File(fileName);//create file
////        OpenFileToWrite(fileName);

        String time = String.valueOf(java.time.LocalTime.now());//lấy h:m:s(UTC)
        String ymd = String.valueOf(java.time.LocalDate.now());//lấy y-m-d
        ArrayList<XeVao> xeVaos = ReadXeVaoFromFile("BAIDOXE.DAT");
        String bienSoRa;

        XeVao xeRa = new XeVao();
        do {
            System.out.println("Nhập biển số xe của xe muốn thanh toán");
            bienSoRa = scanner.nextLine();
            for (int i = 0; i < xeVaos.size(); i++)
                if (bienSoRa.equals(xeVaos.get(i).getBienSoXe()))
                    xeRa = xeVaos.get(i);
            if (xeRa.getId() == null)
                System.out.println("Không thể tìm thấy xe này\nMời nhập lại");
        }
        while (xeRa.getId() == null);


        ArrayList<DienThoaiMua> GIO;
        GIO = ReadDTMFromFile("GIOHANG.dat");

        //Ghi file Khach
        prWriter.println("--------------------Hóa đơn-------------------");
        prWriter.println("Biển số xe: " + xeRa.getBienSoXe());
        prWriter.println("Nhan hieu: " + xeRa.getNhanHieu());
        prWriter.println("Màu sắc: " + xeRa.getMauSac());
        prWriter.println("Gửi lúc: " + xeRa.getThoiGianGui() + " ngày:" + xeRa.getNgayGui());
        prWriter.println("Lấy lúc: " + time + " ngày:" + ymd);
        prWriter.println("---------------------------------------------------------------------------------------");
        prWriter.println("---------------------------------------------------------------------------------------");


        int tongTien = 0;
        for (int i = 0; i < GIO.size(); i++) {
            DienThoaiMua A = GIO.get(i);
            prWriter.println(A.toString2());
            tongTien += A.getThanhTien();
        }
        prWriter.println("                               Tổng tiền: " + tongTien);
        ////////////////////////////////////////////////////
        OpenFileToRead(fileName);
        while (scanner.hasNext())
            System.out.println(scanner.nextLine());
        CloseFileAfterWrite();
    }

    //===================================
    //Read
    public ArrayList<DienThoaiMua> ReadDTMFromFile(String filename) {
        OpenFileToRead(filename);
        ArrayList<DienThoaiMua> list = new ArrayList<DienThoaiMua>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            DienThoaiMua A = CreateDTMFromFile(data);
            list.add(A);
        }
        CloseFileAfterRead();
        return list;
    }

    public ArrayList<XeVao> ReadXeVaoFromFile(String filename) {
        OpenFileToRead(filename);
        ArrayList<XeVao> list = new ArrayList<XeVao>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            XeVao A = CreateXeVaoFromFile(data);
            list.add(A);
        }
        CloseFileAfterRead();
        return list;
    }

    public KhachHang ReadFileKHACH() {
        String fileName = "KHACH.DAT";
        OpenFileToRead(fileName);
        KhachHang A = new KhachHang();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] s = data.split("/");
            A.setTenKhachHang(s[0]);
            A.setSdt(s[1]);
            A.setDiaChi(s[2]);
        }
        return A;
    }

    //================================================
    //Show
    public void ShowAllBAIDOXE() {
        ArrayList<XeVao> arr = ReadXeVaoFromFile("BAIDOXE.DAT");
        for (XeVao i : arr)
            System.out.println(i.toString());
    }

    public void ShowAllDTM() {
        ArrayList<DienThoaiMua> arr = ReadDTMFromFile("GIOHANG.dat");
        for (DienThoaiMua i : arr)
            System.out.println(i.toString());
    }

    //===========================
    // Update
    public void UpdateFileKHO(ArrayList<DienThoaiTrongKho> A, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {//kiểm tra xem đã có hay chưa
            file.delete();
        }
        OpenFileToWrite(fileName);
        for (DienThoaiTrongKho dt : A) {
            prWriter.println(dt.toString2());
        }
        CloseFileAfterWrite();
    }

    public void UpdateFileGIOHANG(ArrayList<DienThoaiMua> A, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for (DienThoaiMua dt : A) {
            prWriter.println(dt.toString2());
        }
        CloseFileAfterWrite();
    }

    //delete file
    public void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists())
            file.delete();
    }
}
