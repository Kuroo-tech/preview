import java.io.*;
import java.util.*;

public class Chinh {
    public static void main(String[] args) throws Exception {
        List<NhanVien> nvList = new ArrayList<>();
        List<GiangVien> gvList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("ds.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] t = line.split(",");
            String ma = t[0];
            String hoTen = t[1];
            String loai = t[2];
            String loaiHD = t[3];
            int luong = Integer.parseInt(t[4]);

            if (loai.equalsIgnoreCase("nhanvien")) {
                nvList.add(new NhanVien(ma, hoTen, loaiHD, luong));
            } else if (loai.equalsIgnoreCase("giangvien")) {
                gvList.add(new GiangVien(ma, hoTen, loaiHD, luong));
            }
        }
        br.close();

        // Cau 2: in ketqua.txt (dong hop le)
        BufferedWriter bw = new BufferedWriter(new FileWriter("ketqua.txt"));
        for (NhanVien nv : nvList) {
            if (nv.loaiHD.equals("chinhthuc") || nv.loaiHD.equals("hopdong"))
                bw.write(nv.toString() + "\n");
        }
        for (GiangVien gv : gvList) {
            if (gv.loaiHD.equals("chinhthuc") || gv.loaiHD.equals("hopdong"))
                bw.write(gv.toString() + "\n");
        }
        bw.close();

        // Cau 3: doc ketqua.txt vao ArrayList
        List<CaNhan> ds = new ArrayList<>();
        br = new BufferedReader(new FileReader("ketqua.txt"));
        while ((line = br.readLine()) != null) {
            String[] t = line.split(",");
            if (t[0].startsWith("NV"))
                ds.add(new NhanVien(t[0], t[1], t[2], Integer.parseInt(t[3])));
            else
                ds.add(new GiangVien(t[0], t[1], t[2], Integer.parseInt(t[3])));
        }
        br.close();

        // Hien thi rieng biet
        System.out.println("Danh sach Nhan Vien:");
        for (CaNhan c : ds) {
            if (c instanceof NhanVien) System.out.println(c);
        }
        System.out.println("\nDanh sach Giang Vien:");
        for (CaNhan c : ds) {
            if (c instanceof GiangVien) System.out.println(c);
        }

        // Cau 5: dem theo loai hop dong cua nhan vien
        int ct = 0, hd = 0;
        for (CaNhan c : ds) {
            if (c instanceof NhanVien) {
                if (c.loaiHD.equals("chinhthuc")) ct++;
                else if (c.loaiHD.equals("hopdong")) hd++;
            }
        }
        System.out.println("\nSo NV chinh thuc: " + ct);
        System.out.println("So NV hop dong: " + hd);
    }
}
