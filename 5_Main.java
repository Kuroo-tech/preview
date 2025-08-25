import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===MENU Quan Li Sinh Vien===");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Tim kiem sinh vien theo ten");
            System.out.println("4. Hien thi danh sach sinh vien");
            System.out.println("5. Loc sinh vien theo ket qua hoc tap");
            System.out.println("6. Thong ke so luong sinh vien Dat / Khong dat");
            System.out.println("7. Luu sinh vien ra file");
            System.out.println("8. Doc sinh vien tu file");
            System.out.println("9. Thoat chuong trinh");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma sinh vien: ");
                    String maSV = sc.nextLine();
                    System.out.print("Ho ten sinh vien: ");
                    String hoTen = sc.nextLine();
                    System.out.print("Gioi tinh(Nam/Nu): ");
                    String gioiTinh = sc.nextLine();
                    System.out.print("Que quan: ");
                    String queQuan = sc.nextLine();
                    System.out.print("Diem trung binh: ");
                    double diemTB = Double.parseDouble(sc.nextLine());

                    SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, queQuan, diemTB);
                    dssv.themSinhVien(sv);
                    break;

                case 2:
                    System.out.print("Nhap ma sinh vien can xoa: ");
                    String maXoa = sc.nextLine();
                    if (dssv.xoaSinhVienTheoMa(maXoa)) {
                        System.out.println("Xoa thanh cong!");
                    } else {
                        System.out.println("Khong tim thay ma sinh vien can xoa!");
                    }
                    break;

                case 3:
                    System.out.print("Nhap ten sinh vien can tim: ");
                    String tenTim = sc.nextLine();
                    ArrayList<SinhVien> ketQua = dssv.timKiemTheoTen(tenTim);
                    if (ketQua.isEmpty()) {
                        System.out.println("Khong tim thay sinh vien!");
                    } else {
                        System.out.println("Ket qua tim kiem:");
                        for (SinhVien svFound : ketQua) {
                            System.out.println(svFound);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Danh sach sinh vien:");
                    dssv.hienThiDanhSach();
                    break;

                case 5:
                    System.out.println("\nSinh viem khong dat (diem >= 5.0):");
                    ArrayList<SinhVien> svDat = dssv.locSinhVienDat();
                    if (svDat.isEmpty()) System.out.println("Khong co sinh vien nao dat!");
                    else for (SinhVien sv1 : svDat) System.out.println(sv1);

                    System.out.println("\nSinh vien dat (diem < 5.0):");
                    ArrayList<SinhVien> svKhongDat = dssv.locSinhVienKhongDat();
                    if (svKhongDat.isEmpty()) System.out.println("Khong co sinh vien nao khong dat!");
                    else for (SinhVien sv2 : svKhongDat) System.out.println(sv2);
                    break;

                case 6:
                    dssv.thongKe();
                    break;

                case 7:
                    dssv.luuVaoFile();
                    break;

                case 8:
                    dssv.docTuFile();
                    break;

                case 9:
                    System.out.println("Thoat chuong trinh thanh cong.\nHen gap lai!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Xin vui long thu lai");
            }
        } while (choice != 9);

        sc.close();
    }
}
