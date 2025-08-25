import java.util.Random;

public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected int soLuong;
    protected double donGia;
    protected int soLuongTonKho;

    // Các phương thức getter/setter
    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    // Constructor chung
    public HangHoa() {
        this.maHang = taoMaHangNgauNhien();
        this.soLuong = taoSoNgauNhien(10, 100);
        this.donGia = taoSoNgauNhien(100, 500);
        this.soLuongTonKho = taoSoNgauNhien(0, this.soLuong);
    }

    // Phương thức trừu tượng để tính VAT và đánh giá
    public abstract double tinhVat();

    public abstract String danhGia();

    public abstract String getTrangThaiHetHan();

    // Phương thức tạo mã hàng ngẫu nhiên (3 ký tự in hoa)
    private String taoMaHangNgauNhien() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char c = (char) (rand.nextInt(26) + 'A');
            sb.append(c);
        }
        return sb.toString();
    }

    // Phương thức tạo số ngẫu nhiên trong khoảng
    protected int taoSoNgauNhien(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
