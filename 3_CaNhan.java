public class CaNhan {
    String ma, hoTen, loaiHD;
    int luong;

    public CaNhan(String ma, String hoTen, String loaiHD, int luong) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.loaiHD = loaiHD;
        this.luong = luong;
    }

    public String toString() {
        return ma + "," + hoTen + "," + loaiHD + "," + luong;
    }
}
