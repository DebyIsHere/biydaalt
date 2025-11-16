import java.util.*;

public class ParkingManager {
    private Garage garage;
    private List<String> outputLines;

    public ParkingManager() {
        this.garage = new Garage();
        this.outputLines = new ArrayList<>();
    }

    public void processCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.getAction().equals("A")) {
                handleArrival(car);
            } else if (car.getAction().equals("D")) {
                handleDeparture(car);
            }
        }
    }

    private void handleArrival(Car car) {
        if (garage.addCar(car)) {
            outputLines.add("Arrival " + car.getLicensePlate() + " -> There is room.");
        } else {
            outputLines.add("Arrival " + car.getLicensePlate() + " -> Garage full, this car cannot enter.");
        }
    }

    private void handleDeparture(Car departingCar) {
        int movedCars = garage.removeCar(departingCar.getLicensePlate());
        if (movedCars != -1) {
            outputLines.add("Departure " + departingCar.getLicensePlate() + " -> " + movedCars + " cars moved out.");
        } else {
            outputLines.add("Departure " + departingCar.getLicensePlate() + " -> This car not in the garage.");
        }
    }

    public List<String> getOutputLines() {
        return new ArrayList<>(outputLines);
    }

    public Garage getGarage() {
        return garage;
    }

    public void printGarageStatus() {
        System.out.println("\nЗогсоолын төлөв:");
        System.out.println("Нийт багтаамж: " + garage.getMaxCapacity());
        System.out.println("Одоогийн тоо: " + garage.getCurrentSize());
        System.out.println("Чөлөөт байрнууд: " + (garage.getMaxCapacity() - garage.getCurrentSize()));

        List<String> carsInGarage = garage.getGarageStatus();
        if (!carsInGarage.isEmpty()) {
            System.out.println("Зогсоолд байгаа машинууд:");
            for (String licensePlate : carsInGarage) {
                System.out.println("- " + licensePlate);
            }
        } else {
            System.out.println("Зогсоолд машин байхгүй.");
        }
    }
}