public class DienThoaiTrongKho extends DienThoai {
    private DienThoai dienThoaiTrongKho;
    private int soLuongTrongKho;

    public DienThoaiTrongKho() {
    }

    public DienThoaiTrongKho(String id, String ten, String nhanHieu, int gia, int soLuongTrongKho) {
        super(id, ten, nhanHieu, gia);
        this.soLuongTrongKho = soLuongTrongKho;
    }

    public DienThoai getDienThoaiTrongKho() {
        return dienThoaiTrongKho;
    }

    public void setDienThoaiTrongKho(DienThoai dienThoaiTrongKho) {
        this.dienThoaiTrongKho = dienThoaiTrongKho;
    }

    public int getSoLuongTrongKho() {
        return soLuongTrongKho;
    }

    public void setSoLuongTrongKho(int soLuongTrongKho) {
        this.soLuongTrongKho = soLuongTrongKho;
    }

    @Override
    public String toString() {
        return "DienThoaiTrongKho{" +
                "id='" + getId() + '\'' +
                ", ten='" + getTen() + '\'' +
                ", nhanHieu='" + getNhanHieu() + '\'' +
                ", gia='" + getGia() + '\'' + ", soLuongTrongKho='" +
                getSoLuongTrongKho() + '\'' + '}';
    }

    public String toString2() {
        return String.format("%s/%s/%s/%d/%d", getId(), getTen(), getNhanHieu(), getGia(), soLuongTrongKho);
    }
}
