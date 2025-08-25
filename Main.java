import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MENU QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Lọc sinh viên theo kết quả học tập");
            System.out.println("6. Thống kê số lượng sinh viên Đạt / Không đạt");
            System.out.println("7. Lưu danh sách ra file");
            System.out.println("8. Đọc danh sách từ file");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã sinh viên: ");
                    String maSV = sc.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String hoTen = sc.nextLine();
                    System.out.print("Nhập giới tính (Nam/Nữ): ");
                    String gioiTinh = sc.nextLine();
                    System.out.print("Nhập quê quán: ");
                    String queQuan = sc.nextLine();
                    System.out.print("Nhập điểm trung bình: ");
                    double diemTB = Double.parseDouble(sc.nextLine());

                    SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, queQuan, diemTB);
                    dssv.themSinhVien(sv);
                    System.out.println("Đã thêm sinh viên!");
                    break;

                case 2:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    String maXoa = sc.nextLine();
                    if (dssv.xoaSinhVienTheoMa(maXoa)) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy mã sinh viên để xóa!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String tenTim = sc.nextLine();
                    ArrayList<SinhVien> ketQua = dssv.timKiemTheoTen(tenTim);
                    if (ketQua.isEmpty()) {
                        System.out.println("Không tìm thấy sinh viên nào phù hợp!");
                    } else {
                        System.out.println("Kết quả tìm kiếm:");
                        for (SinhVien svFound : ketQua) {
                            System.out.println(svFound);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Danh sách sinh viên:");
                    dssv.hienThiDanhSach();
                    break;

                case 5:
                    System.out.println("Lọc sinh viên Đạt (điểm >= 5.0):");
                    ArrayList<SinhVien> svDat = dssv.locSinhVienDat();
                    if (svDat.isEmpty()) System.out.println("Không có sinh viên nào Đạt.");
                    else for (SinhVien sv1 : svDat) System.out.println(sv1);

                    System.out.println("\nLọc sinh viên Không đạt (điểm < 5.0):");
                    ArrayList<SinhVien> svKhongDat = dssv.locSinhVienKhongDat();
                    if (svKhongDat.isEmpty()) System.out.println("Không có sinh viên nào Không đạt.");
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
                    System.out.println("Thoát chương trình thành công.\nHẹn gặp lại!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, mời chọn lại.");
            }
        } while (choice != 9);

        sc.close();
    }
}
