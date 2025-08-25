public class GiangVien extends Person {
    private String maGiangVien;
    private String boMon;

    public GiangVien(int id, String name, String email, String maGiangVien, String boMon) {
        super(id, name, email);
        this.maGiangVien = maGiangVien;
        this.boMon = boMon;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getBoMon() {
        return boMon;
    }

    public void setBoMon(String boMon) {
        this.boMon = boMon;
    }
}
