public class DienThoaiMua extends DienThoai {
    private DienThoai dienThoaiMua;
    private int soLuongMua;
    private int thanhTien;

    public DienThoaiMua() {
    }

    public DienThoaiMua(DienThoai dienThoaiMua, int soLuongMua, int thanhTien) {
        this.dienThoaiMua = dienThoaiMua;
        this.soLuongMua = soLuongMua;
        this.thanhTien = thanhTien;
    }

    public DienThoaiMua(String id, String ten, String nhanHieu, int gia, int soLuongMua) {
        super(id, ten, nhanHieu, gia);
        this.soLuongMua = soLuongMua;
    }

    public DienThoaiMua(String id, String ten, String nhanHieu, int gia, int soLuongMua, int thanhTien) {
        super(id, ten, nhanHieu, gia);
        this.soLuongMua = soLuongMua;
        this.thanhTien = thanhTien;
    }

    public DienThoai getDienThoaiMua() {
        return dienThoaiMua;
    }

    public void setDienThoaiMua(DienThoai dienThoaiMua) {
        this.dienThoaiMua = dienThoaiMua;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "DienThoaiMua{" +
                "id='" + getId() + '\'' +
                ", ten='" + getTen() + '\'' +
                ", nhanHieu='" + getNhanHieu() + '\'' +
                ", gia=" + getGia() + ", soLuongTrongGio=" + soLuongMua +
                ", thanhTien=" + thanhTien +
                '}';
    }

    public String toString2() {
        return String.format("%s/%s/%s/%d/%d/%d", getId(), getTen(), getNhanHieu(), getGia(), getSoLuongMua(), getThanhTien());
    }
}
