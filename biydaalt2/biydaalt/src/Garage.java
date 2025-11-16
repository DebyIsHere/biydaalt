import java.util.*;

public class Garage {
    private static final int MAX_CAPACITY = 10;
    private Stack<Car> garageStack;

    public Garage() {
        this.garageStack = new Stack<>();
    }

    public boolean addCar(Car car) {
        if (garageStack.size() < MAX_CAPACITY) {
            garageStack.push(car);
            return true;
        }
        return false;
    }

    public int removeCar(String licensePlate) {
        Stack<Car> tempStack = new Stack<>();
        int movedCars = 0;
        boolean carFound = false;

        while (!garageStack.isEmpty()) {
            Car currentCar = garageStack.pop();
            if (currentCar.getLicensePlate().equals(licensePlate)) {
                carFound = true;
                break;
            } else {
                tempStack.push(currentCar);
                movedCars++;
            }
        }

        while (!tempStack.isEmpty()) {
            garageStack.push(tempStack.pop());
        }

        return carFound ? movedCars : -1;
    }

    public boolean containsCar(String licensePlate) {
        for (Car car : garageStack) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return true;
            }
        }
        return false;
    }

    public int getCurrentSize() {
        return garageStack.size();
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public boolean isFull() {
        return garageStack.size() >= MAX_CAPACITY;
    }

    public boolean isEmpty() {
        return garageStack.isEmpty();
    }

    public List<String> getGarageStatus() {
        List<String> status = new ArrayList<>();
        for (Car car : garageStack) {
            status.add(car.getLicensePlate());
        }
        return status;
    }
}