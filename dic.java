// File: vn/edu/library/model/Nguoi.java
package vn.edu.library.model;

public abstract class Nguoi {
    protected String id;
    protected String ten;
    protected String email;

    public Nguoi(String id, String ten, String email) {
        this.id = id;
        this.ten = ten;
        this.email = email;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public abstract String toString();
}

// File: vn/edu/library/model/SinhVien.java
package vn.edu.library.model;

import vn.edu.library.utils.XuLyChuoi;

public class SinhVien extends Nguoi {
    private String maSinhVien;
    private String khoa;
    private double diemTB;

    public SinhVien(String maSinhVien, String hoTen, String gioiTinh, String queQuan, double diemTB) {
        super(maSinhVien, hoTen, ""); // Gia su email khong co trong moi dinh dang
        this.maSinhVien = maSinhVien;
        this.diemTB = diemTB;
        this.khoa = khoa; // Thuoc tinh khong co trong chu ky ham tao nay trong phan tich, nhung duoc them vao de hoan chinh.
    }
    
    // Ham tao bo sung de phu hop voi dinh dang nguon du lieu khac
    public SinhVien(String loai, String id, String ten, String email, String maSinhVien, String khoa) {
        super(id, ten, email);
        this.maSinhVien = maSinhVien;
        this.khoa = khoa;
    }

    public SinhVien(String maSV, String hoTen, String gioiTinh, String queQuan, String diemTB) {
        super(maSV, hoTen, null); // Email khong co trong dinh dang nay
        this.maSinhVien = maSV;
        // Phan tich diemTB tu chuoi
        try {
            this.diemTB = Double.parseDouble(diemTB);
        } catch (NumberFormatException e) {
            this.diemTB = 0.0; // Gia tri mac dinh neu phan tich that bai
        }
    }


    public String getMaSinhVien() { return maSinhVien; }
    public void setMaSinhVien(String maSinhVien) { this.maSinhVien = maSinhVien; }
    public String getKhoa() { return khoa; }
    public void setKhoa(String khoa) { this.khoa = khoa; }
    public double getDiemTB() { return diemTB; }
    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }

    @Override
    public String toString() {
        return String.join(";", this.maSinhVien, this.ten, this.khoa, String.valueOf(this.diemTB));
    }
}

// File: vn/edu/library/model/GiangVien.java
package vn.edu.library.model;

public class GiangVien extends Nguoi {
    private String maGiangVien;
    private String boMon;

    public GiangVien(String loai, String id, String ten, String email, String maGiangVien, String boMon) {
        super(id, ten, email);
        this.maGiangVien = maGiangVien;
        this.boMon = boMon;
    }

    public String getMaGiangVien() { return maGiangVien; }
    public void setMaGiangVien(String maGiangVien) { this.maGiangVien = maGiangVien; }
    public String getBoMon() { return boMon; }
    public void setBoMon(String boMon) { this.boMon = boMon; }

    @Override
    public String toString() {
        return String.join(";", this.maGiangVien, this.ten, this.boMon);
    }
}

// File: vn/edu/library/model/MatHang.java
package vn.edu.library.model;

import java.util.Date;

public abstract class MatHang {
    protected String maHang;
    protected String tenHang;
    protected int soLuong;
    protected double donGia;
    protected int tonKho;

    public MatHang(String maHang, String tenHang, int soLuong, double donGia, int tonKho) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tonKho = tonKho;
    }

    public String getMaHang() { return maHang; }
    public void setMaHang(String maHang) { this.maHang = maHang; }
    public String getTenHang() { return tenHang; }
    public void setTenHang(String tenHang) { this.tenHang = tenHang; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
    public int getTonKho() { return tonKho; }
    public void setTonKho(int tonKho) { this.tonKho = tonKho; }

    public abstract double tinhVAT();
    public abstract boolean kiemTraHetHan();
    public abstract String danhGiaBanHang();

    @Override
    public abstract String toString();
}

// File: vn/edu/library/model/MatHangThucPham.java
package vn.edu.library.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MatHangThucPham extends MatHang {
    private Date ngaySanXuat;
    private Date ngayHetHan;

    public MatHangThucPham(String maHang, String tenHang, int soLuong, double donGia, int tonKho, Date ngaySanXuat, Date ngayHetHan) {
        super(maHang, tenHang, soLuong, donGia, tonKho);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    public Date getNgaySanXuat() { return ngaySanXuat; }
    public void setNgaySanXuat(Date ngaySanXuat) { this.ngaySanXuat = ngaySanXuat; }
    public Date getNgayHetHan() { return ngayHetHan; }
    public void setNgayHetHan(Date ngayHetHan) { this.ngayHetHan = ngayHetHan; }

    @Override
    public double tinhVAT() {
        return 0.05 * this.soLuong * this.donGia;
    }

    @Override
    public boolean kiemTraHetHan() {
        return new Date().after(this.ngayHetHan);
    }

    @Override
    public String danhGiaBanHang() {
        double tyLeTonKho = (double) this.tonKho / this.soLuong;
        if (tyLeTonKho < 0.2) return "Ban nhanh";
        if (tyLeTonKho < 0.5) return "Ban duoc";
        if (tyLeTonKho < 0.7) return "Ban cham";
        return "Kho ban";
    }

    @Override
    public String toString() {
        return String.join("|",
                maHang,
                tenHang,
                String.valueOf(soLuong),
                String.valueOf(donGia),
                String.valueOf(tonKho),
                ngaySanXuat.toString(),
                ngayHetHan.toString(),
                String.valueOf(tinhVAT()),
                danhGiaBanHang());
    }
}

// File: vn/edu/library/model/MatHangDienMay.java
package vn.edu.library.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MatHangDienMay extends MatHang {
    private int thoiGianBaoHanh;

    public MatHangDienMay(String maHang, String tenHang, int soLuong, double donGia, int tonKho, int thoiGianBaoHanh) {
        super(maHang, tenHang, soLuong, donGia, tonKho);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public int getThoiGianBaoHanh() { return thoiGianBaoHanh; }
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) { this.thoiGianBaoHanh = thoiGianBaoHanh; }

    @Override
    public double tinhVAT() {
        return 0.10 * this.soLuong * this.donGia;
    }

    @Override
    public boolean kiemTraHetHan() {
        long chenhLech = new Date().getTime() - new Date().getTime(); // Gia su khong co ngay san xuat, nen day la mot cho dat truoc.
        long soThangDaQua = TimeUnit.DAYS.convert(chenhLech, TimeUnit.MILLISECONDS) / 30;
        return soThangDaQua > 2 * this.thoiGianBaoHanh;
    }

    @Override
    public String danhGiaBanHang() {
        double tyLeTonKho = (double) this.tonKho / this.soLuong;
        if (tyLeTonKho < 0.1) return "Ban nhanh";
        if (tyLeTonKho < 0.3) return "Ban cham";
        return "Kho ban";
    }

    @Override
    public String toString() {
        return String.join("|",
                maHang,
                tenHang,
                String.valueOf(soLuong),
                String.valueOf(donGia),
                String.valueOf(tonKho),
                "N/A",
                "N/A",
                String.valueOf(tinhVAT()),
                danhGiaBanHang());
    }
}

// File: vn/edu/library/model/Sach.java
package vn.edu.library.model;

public class Sach {
    private String maSach;
    private String tenSach;
    private int namXuatBan;
    private double gia;
    private int soLuong;

    public Sach(String maSach, String tenSach, int namXuatBan, double gia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.namXuatBan = namXuatBan;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    // Getters
    public String getMaSach() { return maSach; }
    public String getTenSach() { return tenSach; }
    public int getNamXuatBan() { return namXuatBan; }
    public double getGia() { return gia; }
    public int getSoLuong() { return soLuong; }

    // Setters
    public void setMaSach(String maSach) { this.maSach = maSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }
    public void setNamXuatBan(int namXuatBan) { this.namXuatBan = namXuatBan; }
    public void setGia(double gia) { this.gia = gia; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    @Override
    public String toString() {
        return String.join(",", maSach, tenSach, String.valueOf(namXuatBan), String.valueOf(gia), String.valueOf(soLuong));
    }
}

// File: vn/edu/library/model/NhanVien.java
package vn.edu.library.model;

public class NhanVien {
    private String maNhanVien;
    private String hoVaTen;
    private String loaiHopDong;
    private double heSoLuong;
    
    public NhanVien(String maNhanVien, String hoVaTen, String loaiHopDong, double heSoLuong) {
        this.maNhanVien = maNhanVien;
        this.hoVaTen = hoVaTen;
        this.loaiHopDong = loaiHopDong;
        this.heSoLuong = heSoLuong;
    }

    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }
    public String getHoVaTen() { return hoVaTen; }
    public void setHoVaTen(String hoVaTen) { this.hoVaTen = hoVaTen; }
    public String getLoaiHopDong() { return loaiHopDong; }
    public void setLoaiHopDong(String loaiHopDong) { this.loaiHopDong = loaiHopDong; }
    public double getHeSoLuong() { return heSoLuong; }
    public void setHeSoLuong(double heSoLuong) { this.heSoLuong = heSoLuong; }
}

// File: vn/edu/library/model/GiangVien.java
package vn.edu.library.model;

public class GiangVien {
    private String maGiangVien;
    private String hoVaTen;
    private String loaiHopDong;
    private double heSoLuong;
    private double phuCap;

    public GiangVien(String maGiangVien, String hoVaTen, String loaiHopDong, double heSoLuong, double phuCap) {
        this.maGiangVien = maGiangVien;
        this.hoVaTen = hoVaTen;
        this.loaiHopDong = loaiHopDong;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }

    public String getMaGiangVien() { return maGiangVien; }
    public void setMaGiangVien(String maGiangVien) { this.maGiangVien = maGiangVien; }
    public String getHoVaTen() { return hoVaTen; }
    public void setHoVaTen(String hoVaTen) { this.hoVaTen = hoVaTen; }
    public String getLoaiHopDong() { return loaiHopDong; }
    public void setLoaiHopDong(String loaiHopDong) { this.loaiHopDong = loaiHopDong; }
    public double getHeSoLuong() { return heSoLuong; }
    public void setHeSoLuong(double heSoLuong) { this.heSoLuong = heSoLuong; }
    public double getPhuCap() { return phuCap; }
    public void setPhuCap(double phuCap) { this.phuCap = phuCap; }
}

// File: vn/edu/library/utils/XuLyChuoi.java
package vn.edu.library.utils;

public class XuLyChuoi {
    // Phuong thuc chuyen mot chuoi thanh chu hoa dau tu
    public static String chuyenThanhChuHoaDauTu(String chuoi) {
        if (chuoi == null || chuoi.isEmpty()) {
            return "";
        }
        StringBuilder chuoiKetQua = new StringBuilder();
        boolean kyTuTiepTheoLaChuHoa = true;

        for (char c : chuoi.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                kyTuTiepTheoLaChuHoa = true;
            } else if (kyTuTiepTheoLaChuHoa) {
                c = Character.toTitleCase(c);
                kyTuTiepTheoLaChuHoa = false;
            }
            chuoiKetQua.append(c);
        }
        return chuoiKetQua.toString();
    }
}

// File: vn/edu/library/io/QuanLyTepTin.java
package vn.edu.library.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class QuanLyTepTin {

    // Phuong thuc doc mot danh sach doi tuong tu tep voi dau phan cach chi dinh
    public static <T> List<T> docTuTep(String duongDan, String dauPhanCach) {
        List<T> danhSachDuLieu = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(duongDan))) {
            String dong;
            while ((dong = br.readLine()) != null) {
                // Phan tich chuoi va tao doi tuong o day.
                // Viec nay cu the cho tung lop va can duoc trien khai ben ngoai.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return danhSachDuLieu;
    }
    
    // Phuong thuc luu mot danh sach doi tuong vao mot tep
    public static <T> void luuVaoTep(String duongDan, List<T> duLieu) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(duongDan))) {
            for (T phanTu : duLieu) {
                pw.println(phanTu.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phuong thuc loc va luu mot danh sach doi tuong vao mot tep
    public static <T> void locVaLuuVaoTep(String duongDan, List<T> duLieu, Predicate<T> boLoc) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(duongDan))) {
            for (T phanTu : duLieu) {
                if (boLoc.test(phanTu)) {
                    pw.println(phanTu.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// File: vn/edu/library/manager/TroGiupQuanLy.java
package vn.edu.library.manager;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TroGiupQuanLy {

    // Phuong thuc chung de sap xep mot danh sach su dung mot bo so sanh
    public static <T> void sapXepDanhSach(List<T> danhSach, Comparator<? super T> boSoSanh) {
        danhSach.sort(boSoSanh);
    }
    
    // Tim kiem cac phan tu co chua tu khoa trong ten cua chung
    public static <T> List<T> timKiemTheoTen(List<T> danhSach, String tuKhoa, Function<T, String> hamTrichXuatTen) {
        String tuKhoaThuong = tuKhoa.toLowerCase();
        return danhSach.stream()
                  .filter(phanTu -> hamTrichXuatTen.apply(phanTu).toLowerCase().contains(tuKhoaThuong))
                  .collect(Collectors.toList());
    }

    // Phuong thuc chung de loc mot danh sach
    public static <T> List<T> locDanhSach(List<T> danhSach, Predicate<T> boLoc) {
        return danhSach.stream()
                  .filter(boLoc)
                  .collect(Collectors.toList());
    }

    // Phuong thuc chung de dem cac phan tu dua tren mot ham phan loai
    public static <T> Map<String, Long> demTheoDieuKien(List<T> danhSach, Function<T, String> hamPhanLoai) {
        return danhSach.stream()
                  .collect(Collectors.groupingBy(hamPhanLoai, Collectors.counting()));
    }
}
