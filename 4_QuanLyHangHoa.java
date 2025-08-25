import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyHangHoa {

    public static List<HangHoa> taoDanhSachHangHoa(int m, int n) {
        List<HangHoa> danhSachHangHoa = new ArrayList<>();
        // Tao m mat hang thuc pham
        for (int i = 0; i < m; i++) {
            danhSachHangHoa.add(new HangThucPham());
        }
        // Tao n mat hang dien may
        for (int i = 0; i < n; i++) {
            danhSachHangHoa.add(new HangDienMay());
        }
        return danhSachHangHoa;
    }

    public static void hienThiDanhSach(List<HangHoa> danhSach) {
        System.out.println("Ma hang | Ten hang | So luong | Don gia | Ton kho | Ngay sx | Het han | VAT | Danh gia");
        for (HangHoa hh : danhSach) {
            String ngaySX = "N/A";
            String ngayHH = "N/A";
            
            // Xac dinh loai hang de lay thong tin ngay thang
            if (hh instanceof HangThucPham) {
                HangThucPham htp = (HangThucPham) hh;
                ngaySX = htp.getNgaySanXuat().toString();
                ngayHH = htp.getNgayHetHan().toString();
            }
            
            System.out.printf("%-8s|%-10s|%-9d|%-8.2f|%-8d|%-9s|%-8s|%-5.2f|%s%n",
                              hh.getMaHang(), hh.getTenHang(), hh.getSoLuong(), hh.getDonGia(),
                              hh.getSoLuongTonKho(), ngaySX, hh.getTrangThaiHetHan(), hh.tinhVat(), hh.danhGia());
        }
    }

    public static void ghiFile(List<HangHoa> danhSach) {
        String fileHetHan = "DThuMucBarthangHetHan.txt";
        String fileConHan = "DThuMucBarthangConHan.txt";

        try (PrintWriter writerHetHan = new PrintWriter(new FileWriter(fileHetHan));
             PrintWriter writerConHan = new PrintWriter(new FileWriter(fileConHan))) {

            for (HangHoa hh : danhSach) {
                String line = String.format("%s | %s | %d | %.2f | %d | %s | %s | %.2f | %s%n",
                                            hh.getMaHang(), hh.getTenHang(), hh.getSoLuong(), hh.getDonGia(),
                                            hh.getSoLuongTonKho(), 
                                            hh instanceof HangThucPham ? ((HangThucPham)hh).getNgaySanXuat().toString() : "N/A", 
                                            hh.getTrangThaiHetHan(), hh.tinhVat(), hh.danhGia());

                if (hh.getTrangThaiHetHan().equalsIgnoreCase("True")) {
                    writerHetHan.print(line);
                } else {
                    writerConHan.print(line);
                }
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public static void timKiemTheoTen(List<HangHoa> danhSach, String tenTimKiem) {
        List<HangHoa> ketQua = new ArrayList<>();
        for (HangHoa hh : danhSach) {
            if (hh.getTenHang().toLowerCase().contains(tenTimKiem.toLowerCase())) {
                ketQua.add(hh);
            }
        }

        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay mat hang nao co ten '" + tenTimKiem + "'.");
        } else {
            System.out.println("Ket qua tim kiem cho '" + tenTimKiem + "':");
            hienThiDanhSach(ketQua);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so mat hang thuc pham (m): ");
        int m = scanner.nextInt();
        System.out.print("Nhap so mat hang dien may (n): ");
        int n = scanner.nextInt();

        List<HangHoa> danhSachHangHoa = taoDanhSachHangHoa(m, n);
        System.out.println("\n--- Danh sach hang hoa vua tao ---");
        hienThiDanhSach(danhSachHangHoa);

        System.out.println("\n--- Ghi file ---");
        ghiFile(danhSachHangHoa);

        scanner.nextLine(); // doc bo ky tu thua
        System.out.print("\nNhap ten mat hang muon tim kiem: ");
        String tenTimKiem = scanner.nextLine();
        timKiemTheoTen(danhSachHangHoa, tenTimKiem);
        
        scanner.close();
    }
}
