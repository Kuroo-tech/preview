public class Main {
    public static void main(String[] args) {
        // Duong dan file de test
        String filePath = "du_lieu.txt";
        
        // Nap du lieu tu file
        DatabaseHelper.importFromFile(filePath);

        // In ket qua thong ke
        DatabaseHelper.printStatistics();
    }
}
