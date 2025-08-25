import java.io.*;
import java.util.*;

public class Chinh {
    public static void main(String[] args) throws Exception {
        List<Sach> ds = docFile("DanhMucSach.txt");
        System.out.println("Cau 1: Noi dung file DanhMucSach.txt");
        ds.forEach(System.out::println);

        System.out.println("\nCau 2: Tao file sach xuat ban tu 2020");
        List<Sach> moi = new ArrayList<>();
        for (Sach s : ds) {
            if (s.namXB >= 2020) moi.add(s);
        }
        ghiFile("SachMoi.txt", moi);

        System.out.println("\nCau 3: Sap xep giam dan theo nam xuat ban");
        ds.sort((a, b) -> b.namXB - a.namXB);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach moi nhat can hien thi (n): ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < Math.min(n, ds.size()); i++) {
            System.out.println(ds.get(i));
        }

        System.out.println("\nCau 4: Tim kiem theo tu khoa trong ten sach");
        System.out.print("Nhap tu khoa: ");
        String tuKhoa = sc.nextLine().toLowerCase();
        for (Sach s : ds) {
            if (s.tenSach.toLowerCase().contains(tuKhoa)) {
                System.out.println(s);
            }
        }
    }

    public static List<Sach> docFile(String tenFile) throws Exception {
        List<Sach> ds = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(tenFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] t = line.split(",");
            Sach s = new Sach(t[0], t[1], Integer.parseInt(t[2]),
                              Integer.parseInt(t[3]), Integer.parseInt(t[4]));
            ds.add(s);
        }
        br.close();
        return ds;
    }

    public static void ghiFile(String tenFile, List<Sach> ds) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile));
        for (Sach s : ds) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }
}
