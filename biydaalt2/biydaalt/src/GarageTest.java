import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GarageTest {

    @Test
    public void testAddCar() {
        Garage garage = new Garage();
        assertTrue(garage.addCar(new Car("A", "111")));
        assertEquals(1, garage.getCurrentSize());
    }

    @Test
    public void testGarageFull() {
        Garage garage = new Garage();

        for (int i = 0; i < garage.getMaxCapacity(); i++) {
            assertTrue(garage.addCar(new Car("A", "C" + i)));
        }

        assertTrue(garage.isFull());
        assertFalse(garage.addCar(new Car("A", "OVER")));
    }

    @Test
    public void testRemoveCarExists() {
        Garage garage = new Garage();
        garage.addCar(new Car("A", "111"));
        garage.addCar(new Car("A", "222"));
        garage.addCar(new Car("A", "333"));

        int moved = garage.removeCar("222");

        assertEquals(1, moved);
        assertFalse(garage.containsCar("222"));
    }

    @Test
    public void testRemoveCarNotExists() {
        Garage garage = new Garage();
        garage.addCar(new Car("A", "111"));
        assertEquals(-1, garage.removeCar("ABC"));
    }

    @Test
    public void testGetGarageStatus() {
        Garage garage = new Garage();
        garage.addCar(new Car("A", "111"));
        garage.addCar(new Car("A", "222"));

        List<String> status = garage.getGarageStatus();

        assertEquals(2, status.size());
        assertTrue(status.contains("111"));
        assertTrue(status.contains("222"));
    }
}