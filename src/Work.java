import java.io.*;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Work {
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
    public void WriteToBAIDOXE(XeVao A, String fileName) {
        OpenFileToWrite(fileName);
        prWriter.println(A.toString2());
        CloseFileAfterWrite();
    }

    public void WriteToTHONGKE(XeVaoRa A, String fileName) {
//        File file = new File(fileName);
        OpenFileToWrite(fileName);
        prWriter.println(A.toString2());
        CloseFileAfterWrite();
    }

    //========================================================================================
    //Create
    public XeVao CreateXeVaoFromFile(String data) {
        String[] s = data.split("/");
        XeVao A = new XeVao(s[0], s[1], s[2], s[3], s[4], s[5]);
        return A;
    }

    public void CreateAndShowHoaDon(long soTien1H) throws FileNotFoundException, ParseException {
        String fileName = "THONGKE.DAT";
        String time = String.valueOf(java.time.LocalTime.now());//lấy h:m:s(UTC)
        String ymd = String.valueOf(java.time.LocalDate.now());//lấy y-m-d

        ArrayList<XeVao> xeVaos = ReadXeVaoFromFile("BAIDOXE.DAT");

        String bienSoRa;

        XeVao xeRa = new XeVao();
        do {
            ShowAllBAIDOXE();
            System.out.println("\nNhập biển số xe của xe muốn thanh toán");
            bienSoRa = scanner.nextLine();
            for (int i = 0; i < xeVaos.size(); i++)
                if (bienSoRa.equals(xeVaos.get(i).getBienSoXe())) {
                    xeRa = xeVaos.get(i);
                    xeVaos.remove(i);//xóa xe này khỏi bãi đỗ xe
                }
            if (xeRa.getId() == null)
                System.out.println("Không thể tìm thấy xe này\nMời nhập lại");
        }
        while (xeRa.getId() == null);

        double soHGuiXe = timeDiff(xeRa.getNgayGui(), xeRa.getThoiGianGui(), ymd, time);
        double soTienPhaiTra = soHGuiXe * soTien1H;

        //hiển thị hóa đơn lên màn hình
        System.out.println("--------------------Hóa đơn--------------------");
        System.out.println("Biển số xe: " + xeRa.getBienSoXe());
        System.out.println("Nhan hieu: " + xeRa.getNhanHieu());
        System.out.println("Màu sắc: " + xeRa.getMauSac());
        System.out.println("Gửi lúc: " + xeRa.getThoiGianGui() + "(UTC) ngày:" + xeRa.getNgayGui());
        System.out.println("Lấy lúc: " + time + "(UTC) ngày:" + ymd);
        System.out.println("Số tiền phải trả: " + (long) soTienPhaiTra);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");

        XeVaoRa A = new XeVaoRa(xeRa.getId(), xeRa.getNhanHieu(), xeRa.getMauSac(), xeRa.getBienSoXe(),
                xeRa.getThoiGianGui(), xeRa.getNgayGui(), time, ymd, (long) soTienPhaiTra);
        WriteToTHONGKE(A, fileName);
        UpdateFileBAIDOXE(xeVaos, "BAIDOXE.DAT");//GHI LẠI LIST VÀO BÃI ĐỖ XE
    }

    //===================================
    //Read
    public ArrayList<XeVao> ReadXeVaoFromFile(String fileName) {
        OpenFileToRead(fileName);
        ArrayList<XeVao> list = new ArrayList<XeVao>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            XeVao A = CreateXeVaoFromFile(data);
            list.add(A);
        }
        CloseFileAfterRead();
        return list;
    }

    //================================================
    //Show
    public void ShowAllBAIDOXE() {
        ArrayList<XeVao> arr = ReadXeVaoFromFile("BAIDOXE.DAT");
        for (XeVao i : arr)
            System.out.println(i.toString());
    }


    //===========================
    // Update
    public void UpdateFileBAIDOXE(ArrayList<XeVao> A, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for (XeVao i : A) {
            prWriter.println(i.toString2());
        }
        CloseFileAfterWrite();
    }

    ////////
    public double timeDiff(String startDate, String time1, String endDate, String time2) throws ParseException {
        //trả về số h đã gửi xe
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse(startDate);
        Date date2 = simpleDateFormat.parse(endDate);
        long x = (date2.getTime() - date1.getTime());

        double daysDiff = x * 1.0 / 60 / 60 / 1000;//trả về số h chênh lệch giữa 2 ngày

        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
        date1 = simpleTimeFormat.parse(time1);
        date2 = simpleTimeFormat.parse(time2);

        x = date2.getTime() - date1.getTime();
        double timesDiff = x * 1.0 / 1000 / 60 / 60;

        return daysDiff + timesDiff;
    }
}
