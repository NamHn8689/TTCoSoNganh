import javafx.util.Pair;

import java.util.ArrayList;

public class KhoDienThoai {
    public ArrayList<Pair<DienThoai, Integer>> Kho;

    //add phone
    public void ThemDTVaoKho(DienThoai A, int soluong) {
//        Kho.add(new Pair<DienThoai, Integer>(A, soluong));
        if (Kho.size() != 0) {
            boolean check = false;
            for (int i = 0; i < Kho.size(); i++) {
                //nếu id của a = id của id của key của 1 phần rử thuộc kho
                if (A.getId().equals(Kho.get(i).getKey().getId())) {
                    int a = Kho.get(i).getValue();
                    Kho.remove(i);
                    Kho.add(new Pair<DienThoai, Integer>(A, a + soluong));
                    check = true;
                    break;
                }
            }
            if (!check)
                Kho.add(new Pair<DienThoai, Integer>(A, soluong));
        } else
            Kho.add(new Pair<DienThoai, Integer>(A, soluong));
    }
    //xóa điện thoại
    public void DeletePhone(DienThoai A) {
        Kho.remove(A);
    }

    //tim gia theo ten
    public int TimGiaTheoTen(String ten) {
        for (int i = 0; i < Kho.size(); i++) {
            if (Kho.get(i).getKey().getTen().equals(ten) == true)
                return Kho.get(i).getKey().getGia();
        }
        return -1;
    }

    //In gia theo ten
    public void InGiaTheoTen(String ten) {
        int a = TimGiaTheoTen(ten);
        if (a != -1)
            System.out.println(a);
        else
            System.out.println("not found");
    }

    //TimSoLuongTheoTen
    public int TimSoLuongTheoTen(String ten) {
        for (int i = 0; i < Kho.size(); i++) {
            if (Kho.get(i).getKey().getTen().equals(ten) == true)
                return Kho.get(i).getValue();
        }
        return -1;
    }

    //InSoLuongTheoTen
    public void InSoLuongTheoTen(String ten) {
        int a = TimSoLuongTheoTen(ten);
        if (a != -1)
            System.out.println(a);
        else
            System.out.println("Not found");
    }


    //    //add phone
//    public void AddPhoneById(DienThoai A, int soluong) {
//        boolean check = false;
//        for (int i = 0; i < khoDt.size(); i++) {
//            if (A.getId() == khoDt.get(i).getId()) {
//                int a = khoDt.get(i).getSoLuong();
//                khoDt.get(i).setSoLuong(a + soluong);
//                check = true;
//                break;
//            }
//        }
//        if (!check) khoDt.add(A);
//    }


//    public DienThoai SearchById(String id){
//        for (int i = 0; i < khoDt.size(); i++) {
//            if (khoDt.get(i).getId().trim().equals(id.trim()) == true) {
//                return khoDt.get(i);
//            }
//        }
//        return new DienThoai(null,null,0,0);
//    }

//    //giamsoluong khi khach mua
//    public void GiamSoLuong(DienThoai A){
//        if (SearchById(A.getId()).getId()!=null){
//
//        }
//    }


//    //SearchByNameThenShow
//    //SearchByPriceThenShow
//    //...

}
