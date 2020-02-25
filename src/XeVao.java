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

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    @Override
    public String toString() {
        return "XeVao{" +
                "id='" + id + '\'' + ", nhanHieu='" + getNhanHieu() + '\'' + ", mauSac='" + getMauSac() + '\'' + ", bienSoXE='" + getBienSoXe() + '\'' +
                ", thoiGianGui='" + thoiGianGui + '\'' +
                ", ngayGui='" + ngayGui + '\'' +
                '}';
    }

    public String toString2() {
        return String.format("%s/%s/%s/%s/%s/%s", getId(), getNhanHieu(), getMauSac(), getBienSoXe(), getThoiGianGui(), getNgayGui());
    }
}