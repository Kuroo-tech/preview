import java.util.HashMap;
import java.util.Map;

public class StatisticsResult {
    private int tongSoSinhVien;
    private int tongSoGiangVien;
    private Map<String, Integer> svTheoKhoa;
    private Map<String, Integer> gvTheoBoMon;

    public StatisticsResult() {
        this.svTheoKhoa = new HashMap<>();
        this.gvTheoBoMon = new HashMap<>();
    }

    public int getTongSoSinhVien() {
        return tongSoSinhVien;
    }

    public void setTongSoSinhVien(int tongSoSinhVien) {
        this.tongSoSinhVien = tongSoSinhVien;
    }

    public int getTongSoGiangVien() {
        return tongSoGiangVien;
    }

    public void setTongSoGiangVien(int tongSoGiangVien) {
        this.tongSoGiangVien = tongSoGiangVien;
    }

    public Map<String, Integer> getSvTheoKhoa() {
        return svTheoKhoa;
    }

    public void setSvTheoKhoa(Map<String, Integer> svTheoKhoa) {
        this.svTheoKhoa = svTheoKhoa;
    }

    public Map<String, Integer> getGvTheoBoMon() {
        return gvTheoBoMon;
    }

    public void setGvTheoBoMon(Map<String, Integer> gvTheoBoMon) {
        this.gvTheoBoMon = gvTheoBoMon;
    }
}
