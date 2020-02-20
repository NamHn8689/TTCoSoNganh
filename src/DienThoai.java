public class DienThoai {
    private String id, ten, nhanHieu;
    private int gia;

    public DienThoai() {
    }

    public DienThoai(String id, String ten, String nhanHieu, int gia) {
        this.id = id;
        this.ten = ten;
        this.nhanHieu = nhanHieu;
        this.gia = gia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    @Override
    public String toString() {
        return "DienThoai{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", nhanHieu='" + nhanHieu + '\'' +
                ", gia=" + gia +
                '}';
    }
}
