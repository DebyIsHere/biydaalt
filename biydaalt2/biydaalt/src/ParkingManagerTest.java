import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ParkingManagerTest {

    @Test
    public void testArrivalSuccess() {
        ParkingManager pm = new ParkingManager();
        Car car = new Car("A", "AAA");

        pm.processCars(List.of(car));
        List<String> out = pm.getOutputLines();

        assertEquals("Arrival AAA -> There is room.", out.get(0));
    }

    @Test
    public void testArrivalGarageFull() {
        ParkingManager pm = new ParkingManager();

        for (int i = 0; i < 10; i++) {
            pm.processCars(List.of(new Car("A", "C" + i)));
        }

        pm.processCars(List.of(new Car("A", "FULL")));
        List<String> out = pm.getOutputLines();

        assertEquals("Arrival FULL -> Garage full, this car cannot enter.",
                out.get(out.size() - 1));
    }

    @Test
    public void testDepartureCarExists() {
        ParkingManager pm = new ParkingManager();

        pm.processCars(List.of(
                new Car("A", "111"),
                new Car("A", "222"),
                new Car("A", "333"),
                new Car("D", "222")
        ));

        List<String> out = pm.getOutputLines();
        assertEquals("Departure 222 -> 1 cars moved out.", out.get(3));
    }

    @Test
    public void testDepartureCarNotFound() {
        ParkingManager pm = new ParkingManager();

        pm.processCars(List.of(new Car("D", "XYZ")));
        List<String> out = pm.getOutputLines();

        assertEquals("Departure XYZ -> This car not in the garage.", out.get(0));
    }
}
