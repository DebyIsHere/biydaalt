import java.io.*;
import java.util.*;

public class FileHandler {

    public List<Car> readFromFile(String filename) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 2) {
                    String action = parts[0];
                    String licensePlate = parts[1];
                    cars.add(new Car(action, licensePlate));
                }
            }
        } catch (IOException e) {
            System.out.println("Файл уншихад алдаа гарлаа: " + e.getMessage());
        }
        return cars;
    }

    public void writeToFile(String filename, List<String> outputLines) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (String line : outputLines) {
                pw.println(line);
            }
        } catch (IOException e) {
            System.out.println("Файлд бичихэд алдаа гарлаа: " + e.getMessage());
        }
    }
}