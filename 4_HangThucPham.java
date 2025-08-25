import java.time.LocalDate;
import java.util.Random;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    
    private static final String[] TEN_HANG_THUC_PHAM = {"My tom", "Trai cay", "Banh keo", "Nuoc ngot"};

    public HangThucPham() {
        super();
        this.tenHang = TEN_HANG_THUC_PHAM[new Random().nextInt(TEN_HANG_THUC_PHAM.length)];
        this.ngaySanXuat = taoNgayNgauNhien(2022, 1, 1, 2022, 12, 31);
        this.ngayHetHan = taoNgayNgauNhien(2023, 1, 1, 2023, 12, 31);
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    @Override
    public double tinhVat() {
        return soLuong * donGia * 0.05;
    }

    @Override
    public String getTrangThaiHetHan() {
        return LocalDate.now().isAfter(ngayHetHan) ? "True" : "False";
    }

    @Override
    public String danhGia() {
        double tyLeTonKho = (double) soLuongTonKho / soLuong;
        if (tyLeTonKho < 0.2) {
            return "Ban nhanh";
        } else if (tyLeTonKho >= 0.2 && tyLeTonKho < 0.5) {
            return "Ban duoc";
        } else if (tyLeTonKho >= 0.5 && tyLeTonKho < 0.7) {
            return "Ban cham";
        } else {
            return "Kho ban";
        }
    }

    // Phương thức tạo ngày ngẫu nhiên
    private LocalDate taoNgayNgauNhien(int startY, int startM, int startD, int endY, int endM, int endD) {
        LocalDate start = LocalDate.of(startY, startM, startD);
        LocalDate end = LocalDate.of(endY, endM, endD);
        long startDay = start.toEpochDay();
        long endDay = end.toEpochDay();
        long randomDay = startDay + new Random().nextInt((int) (endDay - startDay + 1));
        return LocalDate.ofEpochDay(randomDay);
    }
}
