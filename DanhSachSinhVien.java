import java.io.*;
import java.util.ArrayList;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> list;

    public DanhSachSinhVien() {
        list = new ArrayList<>();
    }

    // 1. Thêm sinh viên
    public void themSinhVien(SinhVien sv) {
        list.add(sv);
    }

    // 2. Xóa sinh viên theo mã số
    public boolean xoaSinhVienTheoMa(String maSV) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSV().equalsIgnoreCase(maSV)) {
                list.remove(i);
                return true; // xóa thành công
            }
        }
        return false; // không tìm thấy mã sinh viên
    }

    // 3. Tìm kiếm sinh viên theo tên (in ra tất cả kết quả phù hợp)
    public ArrayList<SinhVien> timKiemTheoTen(String ten) {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        for (SinhVien sv : list) {
            if (sv.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(sv);
            }
        }
        return ketQua;
    }

    // 4. Hiển thị toàn bộ danh sách
    public void hienThiDanhSach() {
        if (list.isEmpty()) {
            System.out.println("Danh sách sinh viên đang rỗng!");
            return;
        }
        for (SinhVien sv : list) {
            System.out.println(sv);
        }
    }

    // 5. Lọc sinh viên: Đạt (diemTB >= 5.0)
    public ArrayList<SinhVien> locSinhVienDat() {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        for (SinhVien sv : list) {
            if (sv.getDiemTB() >= 5.0) {
                ketQua.add(sv);
            }
        }
        return ketQua;
    }

    // Lọc sinh viên: Không đạt (diemTB < 5.0)
    public ArrayList<SinhVien> locSinhVienKhongDat() {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        for (SinhVien sv : list) {
            if (sv.getDiemTB() < 5.0) {
                ketQua.add(sv);
            }
        }
        return ketQua;
    }

    // 6. Thống kê số lượng sinh viên Đạt và Không đạt
    public void thongKe() {
        int demDat = 0, demKhongDat = 0;
        for (SinhVien sv : list) {
            if (sv.getDiemTB() >= 5.0) demDat++;
            else demKhongDat++;
        }
        System.out.println("Số lượng sinh viên Đạt: " + demDat);
        System.out.println("Số lượng sinh viên Không đạt: " + demKhongDat);
    }

    // 7. Lưu danh sách vào file DSSV.txt
    public void luuVaoFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("DSSV.txt"))) {
            for (SinhVien sv : list) {
                bw.write(sv.toString());
                bw.newLine();
            }
            System.out.println("Đã lưu danh sách vào file DSSV.txt!");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    // 8. Đọc danh sách từ file DSSV.txt và hiển thị
    public void docTuFile() {
        list.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("DSSV.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String maSV = parts[0];
                    String hoTen = parts[1];
                    String gioiTinh = parts[2];
                    String queQuan = parts[3];
                    double diemTB = Double.parseDouble(parts[4]);
                    SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, queQuan, diemTB);
                    list.add(sv);
                }
            }
            System.out.println("Đọc file DSSV.txt thành công! Dưới đây là danh sách sinh viên:");
            hienThiDanhSach();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file DSSV.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Dữ liệu điểm không hợp lệ trong file DSSV.txt!");
        }
    }

}
