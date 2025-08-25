public class SinhVien {
    private String maSV;
    private String hoTen;
    private String gioiTinh;
    private String queQuan;
    private double diemTB;

    // Constructor
    public SinhVien(String maSV, String hoTen, String gioiTinh, String queQuan, double diemTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.diemTB = diemTB;
    }

    // Getter & Setter
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public String getQueQuan() { return queQuan; }
    public void setQueQuan(String queQuan) { this.queQuan = queQuan; }

    public double getDiemTB() { return diemTB; }
    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }

    // toString
    @Override
    public String toString() {
        return maSV + ";" + hoTen + ";" + gioiTinh + ";" + queQuan + ";" + diemTB;
    }
}

