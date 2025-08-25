public class SinhVien extends Person {
    private String maSinhVien;
    private String khoa;

    public SinhVien(int id, String name, String email, String maSinhVien, String khoa) {
        super(id, name, email);
        this.maSinhVien = maSinhVien;
        this.khoa = khoa;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
