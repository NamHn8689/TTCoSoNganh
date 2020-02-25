public class XeVaoRa extends XeVao {
    private String thoiGianLay;
    private String ngayLay;
    private int soTienPhaiTra;

    public XeVaoRa() {
    }

    public XeVaoRa(String thoiGianLay, String ngayLay, int soTienPhaiTra) {
        this.thoiGianLay = thoiGianLay;
        this.ngayLay = ngayLay;
        this.soTienPhaiTra = soTienPhaiTra;
    }

    public XeVaoRa(String id, String nhanHieu, String mauSac, String bienSoXe, String thoiGianGui, String ngayGui, String thoiGianLay, String ngayLay, int soTienPhaiTra) {
        super(id, nhanHieu, mauSac, bienSoXe, thoiGianGui, ngayGui);
        this.thoiGianLay = thoiGianLay;
        this.ngayLay = ngayLay;
        this.soTienPhaiTra = soTienPhaiTra;
    }

    public String getThoiGianLay() {
        return thoiGianLay;
    }

    public String getNgayLay() {
        return ngayLay;
    }

    public int getSoTienPhaiTra() {
        return soTienPhaiTra;
    }

    @Override
    public String toString() {
        return "XeVaoRa{" +
                "thoiGianLay='" + thoiGianLay + '\'' +
                ", ngayLay='" + ngayLay + '\'' +
                '}';
    }

    public String toString2() {
        return getId() + '/' + getNhanHieu() + '/' + getMauSac() + '/' + getBienSoXe() + '/' + getThoiGianGui()
                + '/' + getNgayGui() + '/' + getThoiGianLay() + '/' + getNgayLay() + '/' + getSoTienPhaiTra();
    }
}
