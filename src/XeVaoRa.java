public class XeVaoRa extends XeVao {
    private String thoiGianLay;
    private String ngayLay;
    private long soTienPhaiTra;

    public XeVaoRa() {
    }

    public XeVaoRa(String thoiGianLay, String ngayLay, long soTienPhaiTra) {
        this.thoiGianLay = thoiGianLay;
        this.ngayLay = ngayLay;
        this.soTienPhaiTra = soTienPhaiTra;
    }

    public XeVaoRa(String id, String nhanHieu, String mauSac, String bienSoXe, String thoiGianGui, String ngayGui, String thoiGianLay, String ngayLay, long soTienPhaiTra) {
        super(id, nhanHieu, mauSac, bienSoXe, thoiGianGui, ngayGui);
        this.thoiGianLay = thoiGianLay;
        this.ngayLay = ngayLay;
        this.soTienPhaiTra = soTienPhaiTra;
    }

    public String getThoiGianLay() {
        return thoiGianLay;
    }

    public void setThoiGianLay(String thoiGianLay) {
        this.thoiGianLay = thoiGianLay;
    }

    public String getNgayLay() {
        return ngayLay;
    }

    public void setNgayLay(String ngayLay) {
        this.ngayLay = ngayLay;
    }

    public long getSoTienPhaiTra() {
        return soTienPhaiTra;
    }

    public void setSoTienPhaiTra(long soTienPhaiTra) {
        this.soTienPhaiTra = soTienPhaiTra;
    }

    @Override
    public String toString() {
        return "XeVaoRa{" +
                "thoiGianLay='" + thoiGianLay + '\'' +
                ", ngayLay='" + ngayLay + '\'' +
                '}';
    }

    public String toString2() {
        return String.format("%s/%s/%s/%s/%s/%s/%s/%s/%d", getId(), getNhanHieu(), getMauSac(), getBienSoXe(), getThoiGianGui(),
                getNgayGui(), getThoiGianLay(), getNgayLay(), getSoTienPhaiTra());
    }
}
