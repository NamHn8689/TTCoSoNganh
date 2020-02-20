public class KhachHang {
    private String tenKhachHang, sdt, diaChi;

    public KhachHang() {
    }

    public KhachHang(String tenKhachHang, String sdt, String diaChi) {
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "tenKhachHang='" + tenKhachHang + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    public String toString2() {
        return String.format("%s/%s/%s", getTenKhachHang(), getSdt(), getDiaChi());
    }
}
