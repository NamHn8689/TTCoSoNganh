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

    public String getMauSac() {
        return mauSac;
    }

    public String getBienSoXe() {
        return bienSoXe;
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