import java.util.*;

public class Parking {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        ParkingManager parkingManager = new ParkingManager();

        List<Car> inputCars = fileHandler.readFromFile("cars.txt");

        System.out.println("Уншсан мэдээлэл:");
        for (Car car : inputCars) {
            System.out.println(car);
        }
        System.out.println();

        parkingManager.processCars(inputCars);

        System.out.println("Үйлдлийн үр дүн:");
        for (String line : parkingManager.getOutputLines()) {
            System.out.println(line);
        }

        parkingManager.printGarageStatus();

        fileHandler.writeToFile("output.txt", parkingManager.getOutputLines());
        System.out.println("\nГаралтыг output.txt файлд хадгаллаа.");
    }
}