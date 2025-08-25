public class Sach {
    String maSach;
    String tenSach;
    int namXB;
    int gia;
    int soLuong;

    public Sach(String ma, String ten, int nam, int gia, int soLuong) {
        this.maSach = ma;
        this.tenSach = ten;
        this.namXB = nam;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String toString() {
        return maSach + "," + tenSach + "," + namXB + "," + gia + "," + soLuong;
    }
}
