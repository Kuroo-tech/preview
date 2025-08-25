import java.io.*;
import java.util.ArrayList;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> list;

    public DanhSachSinhVien() {
        list = new ArrayList<>();
    }

    // 1. them sinh vien
    public void themSinhVien(SinhVien sv) {
        list.add(sv);
    }

    // 2. xoa sinh vien theo ma so
    public boolean xoaSinhVienTheoMa(String maSV) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSV().equalsIgnoreCase(maSV)) {
                list.remove(i);
                return true; // xoa thanh cong
            }
        }
        return false; // khong tim thay ma sinh vien
    }

    // 3. tim kiem sinh vien theo ten
    public ArrayList<SinhVien> timKiemTheoTen(String ten) {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        for (SinhVien sv : list) {
            if (sv.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(sv);
            }
        }
        return ketQua;
    }

    // 4. hien thi toan bo danh sach
    public void hienThiDanhSach() {
        if (list.isEmpty()) {
            System.out.println("Danh sach sinh vien dang rong!");
            return;
        }
        for (SinhVien sv : list) {
            System.out.println(sv);
        }
    }

    // 5. Loc sinh vien dat
    public ArrayList<SinhVien> locSinhVienDat() {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        for (SinhVien sv : list) {
            if (sv.getDiemTB() >= 5.0) {
                ketQua.add(sv);
            }
        }
        return ketQua;
    }

    // Loc sinh vien khong dat
    public ArrayList<SinhVien> locSinhVienKhongDat() {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        for (SinhVien sv : list) {
            if (sv.getDiemTB() < 5.0) {
                ketQua.add(sv);
            }
        }
        return ketQua;
    }

    // 6. thong ke so luong sinh vien dat va khong dat
    public void thongKe() {
        int demDat = 0, demKhongDat = 0;
        for (SinhVien sv : list) {
            if (sv.getDiemTB() >= 5.0) demDat++;
            else demKhongDat++;
        }
        System.out.println("So luong sinh vien dat: " + demDat);
        System.out.println("So luong sinh vien khong dat: " + demKhongDat);
    }

    // 7. Lưu danh sách vào file dssv.txt
    public void luuVaoFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("dssv.txt"))) {
            for (SinhVien sv : list) {
                bw.write(sv.toString());
                bw.newLine();
            }
            System.out.println("Da luu file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi luu file! Chi tiet: " + e.getMessage());
        }
    }

    // 8. Doc file va hien thi
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
            System.out.println("Danh sach sinh vien:");
            hienThiDanhSach();
        } catch (IOException e) {
            System.out.println("Loi khi doc file! Chi tiet: " + e.getMessage());
        }
    }
}
