public class Xe {
    private String nhanHieu, mauSac, bienSoXe;

    public Xe() {
    }

    public Xe(String nhanHieu, String mauSac, String bienSoXe) {
        this.nhanHieu = nhanHieu;
        this.mauSac = mauSac;
        this.bienSoXe = bienSoXe;
    }

    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "nhanHieu='" + nhanHieu + '\'' +
                ", mauSac='" + mauSac + '\'' +
                ", bienSoXe='" + bienSoXe + '\'' +
                '}';
    }
}