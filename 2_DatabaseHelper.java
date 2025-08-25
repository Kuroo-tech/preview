import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseHelper {
    private static List<Person> people = new ArrayList<>();

    // Không dùng SQL, nen bo qua ham connect
    public static void insertPerson(Person person) {
        // Kiem tra ma trung
        if (person instanceof SinhVien) {
            String maSV = ((SinhVien) person).getMaSinhVien();
            boolean isMaTrung = people.stream()
                                      .filter(p -> p instanceof SinhVien)
                                      .anyMatch(p -> ((SinhVien) p).getMaSinhVien().equals(maSV));
            if (!isMaTrung) {
                people.add(person);
            } else {
                System.out.println("Ma sinh vien da ton tai: " + maSV);
            }
        } else if (person instanceof GiangVien) {
            String maGV = ((GiangVien) person).getMaGiangVien();
            boolean isMaTrung = people.stream()
                                      .filter(p -> p instanceof GiangVien)
                                      .anyMatch(p -> ((GiangVien) p).getMaGiangVien().equals(maGV));
            if (!isMaTrung) {
                people.add(person);
            } else {
                System.out.println("Ma giang vien da ton tai: " + maGV);
            }
        }
    }

    public static void importFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 6) {
                    String loai = parts[0];
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String email = parts[3];
                    String ma = parts[4];
                    String thuocVe = parts[5];

                    if (loai.equalsIgnoreCase("SV")) {
                        SinhVien sv = new SinhVien(id, name, email, ma, thuocVe);
                        insertPerson(sv);
                    } else if (loai.equalsIgnoreCase("GV")) {
                        GiangVien gv = new GiangVien(id, name, email, ma, thuocVe);
                        insertPerson(gv);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StatisticsResult getStatistics() {
        StatisticsResult result = new StatisticsResult();

        // Tong so sinh vien va giang vien
        result.setTongSoSinhVien((int) people.stream().filter(p -> p instanceof SinhVien).count());
        result.setTongSoGiangVien((int) people.stream().filter(p -> p instanceof GiangVien).count());

        // Thong ke sv theo khoa
        people.stream()
              .filter(p -> p instanceof SinhVien)
              .map(p -> ((SinhVien) p).getKhoa())
              .forEach(khoa -> result.getSvTheoKhoa().merge(khoa, 1, Integer::sum));

        // Thong ke gv theo bo mon
        people.stream()
              .filter(p -> p instanceof GiangVien)
              .map(p -> ((GiangVien) p).getBoMon())
              .forEach(boMon -> result.getGvTheoBoMon().merge(boMon, 1, Integer::sum));

        return result;
    }

    public static void printStatistics() {
        StatisticsResult stats = getStatistics();
        System.out.println("--- Thong ke ---");
        System.out.println("Tong so sinh vien: " + stats.getTongSoSinhVien());
        System.out.println("Tong so giang vien: " + stats.getTongSoGiangVien());

        System.out.println("\nSinh vien theo khoa:");
        stats.getSvTheoKhoa().forEach((khoa, count) -> System.out.println("  " + khoa + ": " + count));

        System.out.println("\nGiang vien theo bo mon:");
        stats.getGvTheoBoMon().forEach((boMon, count) -> System.out.println("  " + boMon + ": " + count));
    }
}
