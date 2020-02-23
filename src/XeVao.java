public class XeVao extends Xe {
    private String id;
    private String thoiGianGui;
    private String ngayGui;


    public XeVao() {
    }

    public XeVao(String id, String nhanHieu, String mauSac, String bienSoXe, String thoiGianGui, String ngayGui) {
        super(nhanHieu, mauSac, bienSoXe);
        this.id = id;
        this.thoiGianGui = thoiGianGui;
        this.ngayGui = ngayGui;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(String thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    @Override
    public String toString() {
        return "XeVao{" +
                "id='" + id + '\'' +
                ", thoiGianGui='" + thoiGianGui + '\'' +
                ", ngayGui='" + ngayGui + '\'' +
                '}';
    }

    public String toString2() {
        return String.format("%s/%s/%s/%s/%s/%s", getId(), getNhanHieu(), getMauSac(), getBienSoXe(), getThoiGianGui(), getNgayGui());
    }
}