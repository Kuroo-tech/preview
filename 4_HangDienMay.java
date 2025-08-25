import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh; // Thang

    private static final String[] TEN_HANG_DIEN_MAY = {"May tinh", "May giat", "Dieu hoa", "Quat dien"};

    public HangDienMay() {
        super();
        this.tenHang = TEN_HANG_DIEN_MAY[new Random().nextInt(TEN_HANG_DIEN_MAY.length)];
        this.thoiGianBaoHanh = taoSoNgauNhien(24, 72);
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }
    
    @Override
    public double tinhVat() {
        return soLuong * donGia * 0.10;
    }

    @Override
    public String getTrangThaiHetHan() {
        // Tương đương hết hạn nếu thời gian từ ngày sản xuất > 2 lần thời gian bảo hành
        // Vì đề không có ngày sản xuất riêng, nên ta dùng ngày tạo ngẫu nhiên
        LocalDate ngayTao = LocalDate.now(); 
        long soThangDaQua = ChronoUnit.MONTHS.between(ngayTao.minusMonths(thoiGianBaoHanh * 2), ngayTao);
        return soThangDaQua >= thoiGianBaoHanh * 2 ? "True" : "False";
    }

    @Override
    public String danhGia() {
        double tyLeTonKho = (double) soLuongTonKho / soLuong;
        if (tyLeTonKho < 0.1) {
            return "Ban nhanh";
        } else if (tyLeTonKho >= 0.1 && tyLeTonKho < 0.3) {
            return "Ban cham";
        } else {
            return "Kho ban";
        }
    }
}
